package br.com.backend.universoInclusivo.controllers;

import br.com.backend.universoInclusivo.Repositories.ProfessorRepository;
import br.com.backend.universoInclusivo.dto.RequisicaoFormProfessor;
import br.com.backend.universoInclusivo.models.Professor;
import br.com.backend.universoInclusivo.models.StatusProfessor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;


    //GET - Listando um objeto view - Professores
//    @GetMapping("")
//    public ModelAndView index() {
//        List<Professor> professores = this.professorRepository.findAll();
//        ModelAndView mv = new ModelAndView("professores/index");
//        mv.addObject("professores", professores);
//        return mv;
//    }

    @GetMapping("")
    public ModelAndView index(@RequestParam(defaultValue = "0") int page) {
        // Configuração da páginação
        int pageSize = 10; // Número de itens por página
        PageRequest pageable = PageRequest.of(page, pageSize);

        // Obter a página de professores
        Page<Professor> professoresPage = this.professorRepository.findAll(pageable);

        ModelAndView mv = new ModelAndView("professores/index");
        mv.addObject("professores", professoresPage.getContent());
        mv.addObject("currentPage", page);
        mv.addObject("totalPages", professoresPage.getTotalPages());

        return mv;
    }

    //CREATE - Criando um novo - Professor
    @GetMapping("/new")
    public ModelAndView nnew() {
        ModelAndView mv = new ModelAndView("professores/new");
        mv.addObject("requisicaoFormProfessor", new RequisicaoFormProfessor());
        mv.addObject("listaStatusProfessor", StatusProfessor.values());
        return mv;
    }


    @PostMapping("")
    public ModelAndView create(@Valid RequisicaoFormProfessor req, BindingResult bindingResult) {
        System.out.println(req);
        if (bindingResult.hasErrors()) {
            System.out.println("\n************* TEM ERROS - Os campos não podem ser enviados vazios ***************\n");
            ModelAndView mv = new ModelAndView("professores/new");
            mv.addObject("listaStatusProfessor", StatusProfessor.values());
            return mv;
        } else {
            Professor professor = req.toProfessor();
            this.professorRepository.save(professor);

//            return new ModelAndView("redirect:/professores/new");
            return new ModelAndView("redirect:/professores");

        }

    }

    //Detalhes de - Professor
    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable Long id) {
        Optional<Professor> optional = this.professorRepository.findById(id);

        if (optional.isPresent()) {
            Professor professor = optional.get();

            ModelAndView mv = new ModelAndView("professores/show");
            mv.addObject("professor", professor);
            return mv;
        } else {
            System.out.println("*** Não achou o professor de ID " + id + "***");
            return new ModelAndView("redirect/professores");
        }

    }

    //Editar um - Professor
    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, RequisicaoFormProfessor req) {
        Optional<Professor> optional = this.professorRepository.findById(id);

        if (optional.isPresent()) {
            Professor professor = optional.get();
            req.fromProfessor(professor);

            ModelAndView mv = new ModelAndView("professores/edit");
            mv.addObject("professorId", professor.getId());
            mv.addObject("listaStatusProfessor", StatusProfessor.values());
            return mv;
        } else {
            System.out.println("*** Não achou o professor de ID " + id + "***");
            return new ModelAndView("redirect/professores");
        }
    }

    //Update Action para buscar os dados no banco de dados
    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable Long id, @Valid RequisicaoFormProfessor req, BindingResult bindingResult) {
        //Se tiver algum erro a página irá recarregar novamente
        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("professores/edit");
            mv.addObject("professorId", id);
            mv.addObject("listaStatusProfessor", StatusProfessor.values());
            return mv;
        } else {
            Optional<Professor> optional = this.professorRepository.findById(id);

            if (optional.isPresent()) {
                Professor professor = req.toProfessor(optional.get());
                this.professorRepository.save(professor);

                return new ModelAndView("redirect:/professores/" + professor.getId());
            } else {
                System.out.println("*** Não achou o professor de ID " + id + "***");
                return new ModelAndView("redirect/professores");

            }
        }

    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        try {
            this.professorRepository.deleteById(id);
            return "redirect:/professores";
        }
        catch (EmptyResultDataAccessException e) {
            System.out.println(e);
            return "redirect:/professores";
        }
    }
}

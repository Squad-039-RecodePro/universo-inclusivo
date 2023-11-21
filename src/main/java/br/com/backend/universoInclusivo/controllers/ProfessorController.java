package br.com.backend.universoInclusivo.controllers;

import br.com.backend.universoInclusivo.Repositories.ProfessorRepository;
import br.com.backend.universoInclusivo.dto.RequisicaoNovoProfessor;
import br.com.backend.universoInclusivo.models.Professor;
import br.com.backend.universoInclusivo.models.StatusProfessor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;


    //GET - Listando um objeto view - Professores
    @GetMapping("/professores")
    public ModelAndView index() {
        List<Professor> professores = this.professorRepository.findAll();
        ModelAndView mv = new ModelAndView("professores/index");
        mv.addObject("professores", professores);
        return mv;
    }

    //CREATE - Criando um novo - Professor
    @GetMapping("/professores/new")
    public ModelAndView nnew() {
        ModelAndView mv = new ModelAndView("professores/new");
        mv.addObject("requisicaoNovoProfessor", new RequisicaoNovoProfessor());
        mv.addObject("listaStatusProfessor", StatusProfessor.values());
        return mv;
    }


    @PostMapping("/professores")
    public ModelAndView create(@Valid RequisicaoNovoProfessor req, BindingResult bindingResult) {
        System.out.println(req);
        if (bindingResult.hasErrors()) {
            System.out.println("\n************* TEM ERROS ***************\n");
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

}

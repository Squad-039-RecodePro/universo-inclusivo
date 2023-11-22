package br.com.backend.universoInclusivo.dto;

import br.com.backend.universoInclusivo.models.Professor;
import br.com.backend.universoInclusivo.models.StatusProfessor;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

// Classe DTO auxiliar que recebe valores do forms para tratamento evitando manipulação do usuário
public class RequisicaoFormProfessor {
    @NotBlank
    @NotNull
    private String nome;
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal salario;
    private StatusProfessor statusProfessor;

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusProfessor getStatusProfessor() {
        return statusProfessor;
    }

    public void setStatusProfessor(StatusProfessor statusProfessor) {
        this.statusProfessor = statusProfessor;
    }

    public Professor toProfessor(){
        Professor professor = new Professor();
        professor.setNome(this.nome);
        professor.setSalario(this.salario);
        professor.setStatusProfessor(this.statusProfessor);
        return professor;
    }

    public void fromProfessor(Professor professor){
        this.nome = professor.getNome();
        this.salario = professor.getSalario();
        this.statusProfessor = professor.getStatusProfessor();
    }

    public Professor toProfessor(Professor professor){
        professor.setNome(this.nome);
        professor.setSalario(this.salario);
        professor.setStatusProfessor(this.statusProfessor);
        return professor;
    }

    @Override
    public String toString() {
        return "RequisicaoNovoProfessor{" +
                "nome='" + nome + '\'' +
                ", statusProfessor=" + statusProfessor +
                ", salario=" + salario +
                '}';
    }
}

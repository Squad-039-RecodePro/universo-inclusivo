package br.com.backend.universoInclusivo.Repositories;

import br.com.backend.universoInclusivo.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}

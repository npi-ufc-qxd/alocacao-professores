package ufc.quixada.npi.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufc.quixada.npi.ap.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
}

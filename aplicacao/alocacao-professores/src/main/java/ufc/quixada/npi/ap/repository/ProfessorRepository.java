package ufc.quixada.npi.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
	
	Professor findProfessorByPessoa(Pessoa pessoa);
	
	Professor findProfessorByPessoa_cpf(String cpf);

}
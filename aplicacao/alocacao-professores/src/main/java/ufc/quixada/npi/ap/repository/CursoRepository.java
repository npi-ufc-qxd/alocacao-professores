package ufc.quixada.npi.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Professor;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
	
	Curso findCursoByCoordenador(Professor coordenador);
	
}

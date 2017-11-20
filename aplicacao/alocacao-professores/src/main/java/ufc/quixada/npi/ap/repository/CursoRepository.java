package ufc.quixada.npi.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Professor;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

	Curso findByCoordenador(Professor coordenador);

	Curso findByViceCoordenador(Professor coordenador);

	Curso findBySigla(String sigla);

	@Query("SELECT o.turma.curso FROM Oferta o WHERE o.id = :idOferta")
	Curso findByOferta(@Param("idOferta") Integer idOferta);
}

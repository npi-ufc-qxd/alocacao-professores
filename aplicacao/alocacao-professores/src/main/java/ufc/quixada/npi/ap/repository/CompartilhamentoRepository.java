package ufc.quixada.npi.ap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Periodo;

public interface CompartilhamentoRepository extends JpaRepository<Compartilhamento, Integer> {

	@Query("SELECT c FROM Compartilhamento c WHERE c.turma.curso = :curso AND c.oferta.periodo = :periodo")
	List<Compartilhamento> findCompartilhamentosByPeriodoAndCurso(@Param("periodo") Periodo periodo, @Param("curso") Curso curso);

}

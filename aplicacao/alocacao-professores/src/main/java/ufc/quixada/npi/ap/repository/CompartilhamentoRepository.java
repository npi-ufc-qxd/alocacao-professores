package ufc.quixada.npi.ap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Turma;

public interface CompartilhamentoRepository extends JpaRepository<Compartilhamento, Integer> {

	@Query("SELECT c FROM Compartilhamento c WHERE c.turma.curso = :curso AND c.oferta.periodo = :periodo")
	List<Compartilhamento> findCompartilhamentosByPeriodoAndCurso(@Param("periodo") Periodo periodo, @Param("curso") Curso curso);
	
	@Query("SELECT c FROM Oferta AS o, Compartilhamento as c WHERE o.id = c.oferta.id AND o.turma.curso = :curso AND o.periodo = :periodo AND o.disciplina NOT IN "
			+ "(SELECT o.disciplina FROM Oferta AS o, Compartilhamento as C WHERE o.id = c.oferta.id AND o.turma = :turma AND o.periodo = :periodoAtivo)")
	List<Compartilhamento> findCompartilhamentosImportadosByPeriodoAndTurma(@Param("periodo") Periodo periodo, @Param("periodoAtivo") Periodo periodoAtivo, @Param("turma") Turma turma, @Param("curso") Curso curso);
}

package ufc.quixada.npi.ap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Periodo;

public interface CompartilhamentoRepository extends JpaRepository<Compartilhamento, Integer> {

	List<Compartilhamento> findCompartilhamentosByOferta_periodoAndTurma_curso(@Param("periodo") Periodo periodo, @Param("curso") Curso curso);
	
	@Query("SELECT c FROM Oferta AS o, Compartilhamento AS c WHERE o.id = c.oferta.id AND o.periodo = :periodo AND c.turma.curso = :curso AND (o.disciplina.id, c.turma.id) NOT IN "
			+ "(SELECT o.disciplina.id, o.turma.id FROM Oferta AS o WHERE o.turma.curso = :curso AND o.periodo = :periodoAtivo)")
	List<Compartilhamento> findCompartilhamentosNaoImportadosByPeriodoAndCurso(@Param("periodo") Periodo periodo, @Param("periodoAtivo") Periodo periodoAtivo, @Param("curso") Curso curso);
	
	@Query("SELECT c FROM Oferta AS o, Compartilhamento AS c WHERE o.id = c.oferta.id AND o.periodo = :periodo AND c.turma.curso = :curso AND (o.disciplina.id, c.turma.id) IN "
			+ "(SELECT o.disciplina.id, o.turma.id FROM Oferta AS o WHERE o.turma.curso = :curso AND o.periodo = :periodoAtivo)")
	List<Compartilhamento> findCompartilhamentosImportadosByPeriodoAndCurso(@Param("periodo") Periodo periodo, @Param("periodoAtivo") Periodo periodoAtivo, @Param("curso") Curso curso);
}

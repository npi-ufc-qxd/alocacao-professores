package ufc.quixada.npi.ap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Professor;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {

	List<Oferta> findByPeriodoAtivoTrue();
	
	List<Oferta> findOfertaByPeriodo(Periodo periodo);
	
	List<Oferta> findOfertasByPeriodoAndTurma_curso(Periodo periodo, Curso curso);
	
	List<Oferta> findOfertasByPeriodo_AtivoTrueAndProfessores(Professor professor);
	
	@Query("SELECT o FROM Oferta AS o, Compartilhamento AS c WHERE o.id = c.oferta.id AND o.periodo = :periodo AND c.turma.curso = :curso")
	List<Oferta> findOfertasCompartilhadasByPeriodoAndCurso(@Param("periodo") Periodo periodo, @Param("curso") Curso curso);
	
	@Query("SELECT o FROM Oferta AS o WHERE o.turma.curso = :curso AND o.periodo = :periodo AND (o.disciplina.id, o.turma.id) NOT IN "
			+ "(SELECT o.disciplina.id, o.turma.id FROM Oferta AS o WHERE o.turma.curso = :curso AND o.periodo = :periodoAtivo)")
	List<Oferta> findOfertasNaoImportadasByPeriodoAndCurso(@Param("periodo") Periodo periodo, @Param("periodoAtivo") Periodo periodoAtivo, @Param("curso") Curso curso);
	
	@Query("SELECT o FROM Oferta AS o WHERE o.turma.curso = :curso AND o.periodo = :periodo AND (o.disciplina.id, o.turma.id) IN "
			+ "(SELECT o.disciplina.id, o.turma.id FROM Oferta AS o WHERE o.turma.curso = :curso AND o.periodo = :periodoAtivo)")
	List<Oferta> findOfertasImportadasByPeriodoAndCurso(@Param("periodo") Periodo periodo, @Param("periodoAtivo") Periodo periodoAtivo, @Param("curso") Curso curso);
	
	@Query(value = "SELECT SUM(creditos) FROM disciplina AS d "
			+ "INNER JOIN oferta AS o "
			+ "ON d.id = o.disciplina_id "
			+ "WHERE o.periodo_id = :idPeriodo "
			+ "AND o.turma_id = :idTurma", nativeQuery = true)
	Integer getTotalCreditosTurmaPorPeriodo(@Param("idPeriodo") Integer idPeriodo, @Param("idTurma") Integer idTurma);
}
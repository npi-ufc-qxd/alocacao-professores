package ufc.quixada.npi.ap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {

	List<Oferta> findByPeriodoAtivoTrue();
	
	List<Oferta> findOfertaByPeriodo(Periodo periodo);
	
	List<Oferta> findOfertasByPeriodoAndTurma_curso(Periodo periodo, Curso curso);
	
	@Query("SELECT o FROM Oferta AS o WHERE o.turma.curso = :curso AND o.periodo = :periodo AND o.disciplina NOT IN "
			+ "(SELECT o.disciplina FROM Oferta AS o WHERE o.turma.curso = :curso AND o.periodo = :periodoAtivo)")
	List<Oferta> findOfertasNaoImportadasByPeriodoAndCurso(@Param("periodo") Periodo periodo, @Param("periodoAtivo") Periodo periodoAtivo, @Param("curso") Curso curso);
	
	@Query("SELECT o FROM Oferta AS o WHERE o.turma.curso = :curso AND o.periodo = :periodo AND o.disciplina IN "
			+ "(SELECT o.disciplina FROM Oferta AS o WHERE o.turma.curso = :curso AND o.periodo = :periodoAtivo)")
	List<Oferta> findOfertasImportadasByPeriodoAndCurso(@Param("periodo") Periodo periodo, @Param("periodoAtivo") Periodo periodoAtivo, @Param("curso") Curso curso);
}
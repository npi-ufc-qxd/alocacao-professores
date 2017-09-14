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
	
	@Query("SELECT o FROM Oferta AS o WHERE o.periodo = :periodo AND o.turma.curso = :curso")
	List<Oferta> findByPeriodoAndCurso(@Param("periodo") Periodo periodo, @Param("curso") Curso curso);
	
	@Query("SELECT o FROM Oferta AS o, Compartilhamento AS c WHERE o.id = c.oferta.id AND o.periodo = :periodo AND c.turma.curso = :curso")
	List<Oferta> findOfertasCompartilhadasByPeriodoAndCurso(@Param("periodo") Periodo periodo, @Param("curso") Curso curso);
	
}
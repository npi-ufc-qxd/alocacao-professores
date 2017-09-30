package ufc.quixada.npi.ap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ufc.quixada.npi.ap.model.Periodo;

@Repository
@Transactional
public interface PeriodoRepository extends JpaRepository<Periodo, Integer>{
	
	@Query("from Periodo WHERE ativo = true")
	Periodo periodoAtivo();
	
	@Query("FROM Periodo WHERE status = 'CONSOLIDADO' ")
	List<Periodo> periodosConsolidados();
}


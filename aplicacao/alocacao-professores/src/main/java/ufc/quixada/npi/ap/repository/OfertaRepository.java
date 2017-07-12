package ufc.quixada.npi.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;
import java.util.List;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {

	List<Oferta> findByPeriodo(Periodo periodo);
}
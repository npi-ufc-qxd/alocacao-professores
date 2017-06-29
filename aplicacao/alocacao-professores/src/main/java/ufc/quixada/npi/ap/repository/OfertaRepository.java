package ufc.quixada.npi.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.quixada.npi.ap.model.Oferta;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {

}
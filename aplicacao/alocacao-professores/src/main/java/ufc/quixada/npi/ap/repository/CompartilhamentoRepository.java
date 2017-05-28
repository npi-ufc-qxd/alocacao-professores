package ufc.quixada.npi.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufc.quixada.npi.ap.model.Compartilhamento;

public interface CompartilhamentoRepository extends JpaRepository<Compartilhamento, Integer> {
}
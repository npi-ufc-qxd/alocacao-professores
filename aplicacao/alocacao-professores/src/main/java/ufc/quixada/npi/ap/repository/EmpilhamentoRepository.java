package ufc.quixada.npi.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.quixada.npi.ap.model.RestricaoHorario;

@Repository
public interface EmpilhamentoRepository extends JpaRepository<RestricaoHorario, Integer> {

}

package ufc.quixada.npi.ap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.quixada.npi.ap.model.RestricaoHorario;
import ufc.quixada.npi.ap.model.RestricaoHorario.Tipo;

@Repository
public interface EmpilhamentoRepository extends JpaRepository<RestricaoHorario, Integer> {
	
	
	List<RestricaoHorario> findByTipo(Tipo tipo);

}

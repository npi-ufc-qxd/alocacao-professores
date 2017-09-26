package ufc.quixada.npi.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.quixada.npi.ap.model.Compartilhamento;

@Repository
public interface CompartilhamentoRepository extends JpaRepository<Compartilhamento, Integer> {
	
	//@Query("SELECT id FROM compartilhamento WHERE oferta_id = :idOferta AND turma_id = :idTurma")
	//List<Compartilhamento> buscaIdCompartilhamento(@Param("idOferta") int idOferta, @Param("idTurma") int idTurma);
	
}

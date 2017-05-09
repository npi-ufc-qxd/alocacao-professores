package ufc.quixada.npi.ap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ufc.quixada.npi.ap.model.Turma;

@Repository
public interface TurmaRespository extends CrudRepository<Turma, Integer> {

}

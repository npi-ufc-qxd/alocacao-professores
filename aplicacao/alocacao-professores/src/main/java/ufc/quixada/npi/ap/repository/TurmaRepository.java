package ufc.quixada.npi.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.quixada.npi.ap.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

}

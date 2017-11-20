package ufc.quixada.npi.ap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
	List<Turma> findTurmasByCurso(Curso curso);
}

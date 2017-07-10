package ufc.quixada.npi.ap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.quixada.npi.ap.model.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

	Disciplina findByNome(String nome);
	List<Disciplina> findByArquivadaFalse();
	Disciplina findById(Integer id);
	Disciplina findByCodigo(String codigo);
}

package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Disciplina;

public interface DisciplinaService {
	
	List<Disciplina> listar();
	List<Disciplina> listarNaoArquivada();
	boolean arquivarDisciplina(Integer id);
	
}

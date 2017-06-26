package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Disciplina;

public interface DisciplinaService {
	
	void salvar(Disciplina disciplina);
	public List<Disciplina> listar();
	public List<Disciplina> listarNaoArquivada();
	boolean arquivarDisciplina(Integer id);
}

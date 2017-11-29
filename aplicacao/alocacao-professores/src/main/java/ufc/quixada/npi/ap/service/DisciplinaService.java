package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.exception.AlocacaoProfessorException;
import ufc.quixada.npi.ap.model.Disciplina;

public interface DisciplinaService {

	public void salvar(Disciplina disciplina) throws AlocacaoProfessorException;
	
	public void editar(Disciplina disciplina);
	
	public Disciplina buscarDisciplina(Integer id);
	
	public List<Disciplina> buscarTodasDisciplinas();

	public List<Disciplina> buscarDisciplinasNaoArquivadas();
	
	boolean arquivarDisciplina(Integer id);
	
}
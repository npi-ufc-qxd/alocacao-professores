package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Empilhamento;

public interface EmpilhamentoService {

	public Empilhamento cadastarEmpilhamento(Integer idTurmaA, Integer idDisciplinaA, Integer idTurmaB, Integer idDisciplinaB);
	public List<Empilhamento> listarEmpilhamentos();
	public void excluirEmpilhamento(Integer idEmpilhamento);
	public Empilhamento visualizarEmpilhamento(Integer idEmpilhamento);
	
}

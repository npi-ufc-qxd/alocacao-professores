package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Empilhamento;

public interface EmpilhamentoService {

	public Empilhamento salvar(Empilhamento empilhamento);
	
	public void excluir(Integer idEmpilhamento);
	
	public Empilhamento buscarEmpilhamento(Integer idEmpilhamento);
	
	public List<Empilhamento> buscarTodosEmpilhamentos();
	
}

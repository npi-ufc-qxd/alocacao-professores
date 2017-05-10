package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Compartilhamento;

public interface CompartilhamentoService {
	public Compartilhamento findCompartilhamento(Integer id);
	
	public List<Compartilhamento> findAllCompartilhamentos();
	
	public void salvar(Compartilhamento compartilhamento);
	
}

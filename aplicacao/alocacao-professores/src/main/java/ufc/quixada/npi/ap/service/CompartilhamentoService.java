package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Compartilhamento;

public interface CompartilhamentoService {
	
	
	public void salvar(Compartilhamento compartilhamento);
	
	public List<Compartilhamento> findAllCompartilhamentos();
}

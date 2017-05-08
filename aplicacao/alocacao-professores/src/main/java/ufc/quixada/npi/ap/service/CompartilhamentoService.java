package ufc.quixada.npi.ap.service;

import ufc.quixada.npi.ap.model.Compartilhamento;

public interface CompartilhamentoService {
	public Compartilhamento findCompartilhamento(Integer id);
	
	public void salvar(Compartilhamento compartilhamento);
	
}

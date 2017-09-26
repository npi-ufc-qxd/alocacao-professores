package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Oferta;

public interface CompartilhamentoService {
	
	public void salvar(Compartilhamento compartilhamento);
	
	public Compartilhamento findCompartilhamento(Integer id);
	
	public List<Compartilhamento> findAllCompartilhamentos();
	
	public void excluir(Integer id);
	
	public List<Oferta> listarCompartilhamentoOfertas();
	
}
package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Oferta;

public interface OfertaService {

	public List<Oferta> findAllOfertas();

	public void excluir(Integer id);

	public Oferta salvarOferta(Oferta oferta);
	
	public Oferta visualizarOferta(Integer idOferta);
	
}


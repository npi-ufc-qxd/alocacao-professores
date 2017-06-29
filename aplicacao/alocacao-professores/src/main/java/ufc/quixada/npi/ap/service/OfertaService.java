package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Oferta;

public interface OfertaService {

	public Oferta salvar(Oferta oferta);

	public List<Oferta> listarOfertas();

	public void excluirOferta(Integer idOferta);

	public Oferta visualizarOferta(Integer idOferta);
}

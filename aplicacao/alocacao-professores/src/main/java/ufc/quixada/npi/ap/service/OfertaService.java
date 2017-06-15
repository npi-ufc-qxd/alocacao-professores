package ufc.quixada.npi.ap.service;

import ufc.quixada.npi.ap.model.Oferta;

public interface OfertaService {
	public void salvar(Oferta oferta);
	public Oferta findOferta(Integer id);
}

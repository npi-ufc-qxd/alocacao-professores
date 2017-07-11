package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.exception.AlocacaoProfessoresException;
import ufc.quixada.npi.ap.model.Oferta;

public interface OfertaService {

	public void salvar(Oferta oferta) throws AlocacaoProfessoresException;

	public Oferta findOferta(Integer id);

	public List<Oferta> findAllOfertas();

	public void excluir(Integer id);

	public Oferta visualizarOferta(Integer idOferta);

}
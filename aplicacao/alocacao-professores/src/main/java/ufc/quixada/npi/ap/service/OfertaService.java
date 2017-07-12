package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.exception.AlocacaoProfessoresException;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Pessoa;

public interface OfertaService {

	public void salvar(Oferta oferta) throws AlocacaoProfessoresException;

	public Oferta findOferta(Integer id);

	public List<Oferta> findAllOfertas();

	public void excluir(Integer id);

	public Oferta visualizarOferta(Integer idOferta);
	
	public List<Oferta> buscarPorPeriodoAndCurso(Periodo periodo, Pessoa coordenador);

}
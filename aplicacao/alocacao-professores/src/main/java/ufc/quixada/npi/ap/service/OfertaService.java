package ufc.quixada.npi.ap.service;

import java.util.List;
import java.util.Map;

import ufc.quixada.npi.ap.exception.AlocacaoProfessoresException;
import ufc.quixada.npi.ap.model.Curso;
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
	
	public List<Oferta> buscarPorPeriodoAndCurso(Periodo periodo, Curso curso);
	
	public List<Oferta> buscarOfertasCompartilhadasPorPeriodoAndCurso(Periodo periodo, Curso curso);
	
	public List<Oferta> buscarOfertasImportadasPorPeriodoAndCurso(Periodo periodo, Curso curso);
	
	public List<Oferta> buscarOfertasNaoImportadasPorPeriodoAndCurso(Periodo periodo, Curso curso);
	
	public Map<String, Object> importarOfertas(List<Integer> ofertas);
	
	public void substituirOferta(List<Integer> ofertas);

}
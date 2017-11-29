package ufc.quixada.npi.ap.service;

import java.util.List;
import java.util.Map;

import ufc.quixada.npi.ap.exception.AlocacaoProfessoresException;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Professor;

public interface OfertaService {
	
	public void salvarOfertaPeriodoAtivo(Oferta oferta);
	
	public void salvarOferta(Oferta oferta) throws AlocacaoProfessoresException;
	
	public void excluir(Integer id);

	public Oferta buscarOferta(Integer id);

	public List<Oferta> buscarOfertaPorPeriodo(Periodo periodo);
	
	public List<Oferta> buscarOfertasPeriodoAtivo();
	
	public List<Oferta> buscarOfertasPeriodoAtivoPorProfessor(Professor professor);
	
	public List<Oferta> buscarPorPeriodo(Periodo periodo);
	
	public List<Oferta> buscarPorPeriodoAndCurso(Periodo periodo, Curso curso);
	
	public List<Oferta> buscarOfertasImportadasPeriodoAtivoPorPeriodoAndCurso(Periodo periodo, Periodo periodoAtivo, Curso curso);
	
	public List<Oferta> buscarOfertasNaoImportadasPeriodoAtivoPorPeriodoAndCurso(Periodo periodo, Periodo periodoAtivo, Curso curso);
	
	public Map<String, Object> importarOfertas(List<Integer> ofertas, Periodo periodoAtivo);

	void substituirOferta(List<Integer> idOfertas);
	
}
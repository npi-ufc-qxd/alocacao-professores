package ufc.quixada.npi.ap.service;

import java.util.List;
import java.util.Map;

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Periodo;

public interface CompartilhamentoService {
	
	public void salvar(Compartilhamento compartilhamento);
	
	public void excluir(Integer id);
	
	public Compartilhamento buscarCompartilhamento(Integer id);
	
	public List<Compartilhamento> buscarTodosCompartilhamentos();
	
	public List<Compartilhamento> buscarCompartilhamentosPorPeriodoAndCurso(Periodo periodo, Curso curso);
	
	public List<Compartilhamento> buscarCompartilhamentosNaoImportadosPorPeriodoAndCurso(Periodo periodo, Periodo periodoAtivo, Curso curso);
	
	public List<Compartilhamento> buscarCompartilhamentosImportadosPorPeriodoAndCurso(Periodo periodo, Periodo periodoAtivo, Curso curso);
	
	public Map<String, Object> importarOfertasCompartilhadas(List<Integer> compartilhamentos, Periodo periodo, Curso cursoCoordenador);
	
}
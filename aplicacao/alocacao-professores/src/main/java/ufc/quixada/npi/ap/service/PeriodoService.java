package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Periodo;

public interface PeriodoService {

	void salvar(Periodo periodo);
	
	void excluir(Periodo periodo);
	
	public List<Periodo> buscarTodosPeriodos();
	
	public Periodo buscarPeriodo(Integer id);
	
	public Periodo buscarPeriodoAtivo();
	
	public List<Periodo> buscarPeriodosConsolidados();
	
}

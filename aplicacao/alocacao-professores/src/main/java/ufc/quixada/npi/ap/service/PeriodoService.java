package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Periodo;

public interface PeriodoService {

	void salvar(Periodo periodo);
	
	public List<Periodo> listaPeriodos();
	
	public Periodo getPeriodo(Integer id);
	
	void excluir(Periodo periodo);
	
	public Periodo periodoAtivo();
	
}

package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Periodo;

public interface PeriodoService {

	void salvar(Periodo periodo);
	List<Periodo> listaPeriodos();
	Periodo getPeriodo(Integer id);
	void excluir(Periodo periodo);
	Periodo editar(Periodo periodo);
}

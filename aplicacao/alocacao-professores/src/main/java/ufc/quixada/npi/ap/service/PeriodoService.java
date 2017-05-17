package ufc.quixada.npi.ap.service;

import ufc.quixada.npi.ap.model.Periodo;

public interface PeriodoService {

	Periodo editar(Periodo periodo);
	
	Periodo getPeriodo(Integer id);
}

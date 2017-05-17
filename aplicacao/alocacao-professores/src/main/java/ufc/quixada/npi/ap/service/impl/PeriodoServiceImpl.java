package ufc.quixada.npi.ap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.repository.PeriodoRepository;
import ufc.quixada.npi.ap.service.PeriodoService;


@Service
public class PeriodoServiceImpl implements PeriodoService {
	@Autowired
	PeriodoRepository periodoRepository;
	
	public Periodo editar(Periodo periodo){
		return periodoRepository.save(periodo);
	}
	
	public Periodo getPeriodo(Integer id){
		return periodoRepository.findOne(id);		
	}

}

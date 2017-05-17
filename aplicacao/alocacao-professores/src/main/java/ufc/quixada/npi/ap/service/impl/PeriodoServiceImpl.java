package ufc.quixada.npi.ap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.repository.PeriodoRepository;
import ufc.quixada.npi.ap.service.PeriodoService;

@Service
public class PeriodoServiceImpl implements PeriodoService{
	
	@Autowired
	PeriodoRepository periodoRepository;
	
	@Override
	public void salvar(Periodo periodo){
		periodoRepository.save(periodo);
	}
	
	public List<Periodo> listaPeriodos(){
		return periodoRepository.findAll();
	}
	
	public void excluir(Periodo periodo){
		periodoRepository.delete(periodo);
	}
	
	
}

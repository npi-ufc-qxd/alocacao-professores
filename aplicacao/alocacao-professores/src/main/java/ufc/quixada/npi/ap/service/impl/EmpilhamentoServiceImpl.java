package ufc.quixada.npi.ap.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.RestricaoHorario;
import ufc.quixada.npi.ap.model.RestricaoHorario.Tipo;
import ufc.quixada.npi.ap.repository.EmpilhamentoRepository;
import ufc.quixada.npi.ap.repository.PeriodoRepository;
import ufc.quixada.npi.ap.service.EmpilhamentoService;


@Service
public class EmpilhamentoServiceImpl implements EmpilhamentoService {

	@Autowired
	private EmpilhamentoRepository empilhamentoRepository;
	
	@Autowired
	PeriodoRepository periodoRepository;
	
	@Override
	public void salvarEmpilhamentoPeriodoAtivo(RestricaoHorario empilhamento){
		Periodo periodoAtivo = periodoRepository.periodoAtivo();
		
		if (periodoAtivo != null)
			empilhamento.setPeriodo(periodoAtivo);
			empilhamento.setTipo(Tipo.EMPILHAMENTO);
			empilhamentoRepository.save(empilhamento);
	}

	
	@Override
	public RestricaoHorario salvarEmpilhamento(RestricaoHorario empilhamento) {
		empilhamento.setTipo(Tipo.EMPILHAMENTO);
		return empilhamentoRepository.save(empilhamento);
	}

	@Override
	public List<RestricaoHorario> listarEmpilhamentos() {
		return empilhamentoRepository.findByTipo(Tipo.EMPILHAMENTO);
	}

	@Override
	public void excluirEmpilhamento(Integer idEmpilhamento) {
		empilhamentoRepository.delete(idEmpilhamento);
	}

	@Override
	public RestricaoHorario visualizarEmpilhamento(Integer idEmpilhamento) {
		return empilhamentoRepository.findOne(idEmpilhamento);
	}

}

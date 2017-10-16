package ufc.quixada.npi.ap.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.RestricaoHorario;
import ufc.quixada.npi.ap.model.RestricaoHorario.Tipo;
import ufc.quixada.npi.ap.repository.RestricaoHorarioRepository;
import ufc.quixada.npi.ap.service.RestricaoHorarioService;
import ufc.quixada.npi.ap.service.PeriodoService;


@Service
public class RestricaoHorarioServiceImpl implements RestricaoHorarioService {

	@Autowired
	private RestricaoHorarioRepository restricaoHorarioRepository;
	
	@Autowired
	private PeriodoService periodoService;
	
	@Override
	public void salvarRestricaoHorarioPeriodoAtivo(RestricaoHorario restricaoHorario){
		Periodo periodoAtivo = periodoService.buscarPeriodoAtivo();
		
		if (periodoAtivo != null)
			restricaoHorario.setPeriodo(periodoAtivo);
			restricaoHorario.setTipo(Tipo.EMPILHAMENTO);
			restricaoHorarioRepository.save(restricaoHorario);
	}
	
	@Override
	public RestricaoHorario salvarRestricaoHorario(RestricaoHorario restricaoHorario) {
		restricaoHorario.setTipo(Tipo.EMPILHAMENTO);
		return restricaoHorarioRepository.save(restricaoHorario);
	}

	@Override
	public List<RestricaoHorario> buscarTodasRestricoesHorario() {
		return restricaoHorarioRepository.findByTipo(Tipo.EMPILHAMENTO);
	}

	@Override
	public void excluir(Integer idRestricaoHorario) {
		restricaoHorarioRepository.delete(idRestricaoHorario);
	}

	@Override
	public RestricaoHorario buscarRestricaoHorario(Integer idRestricaoHorario) {
		return restricaoHorarioRepository.findOne(idRestricaoHorario);
	}

}

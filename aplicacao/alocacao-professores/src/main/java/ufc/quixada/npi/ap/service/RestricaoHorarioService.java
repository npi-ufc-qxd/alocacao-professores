package ufc.quixada.npi.ap.service;

import java.util.List;


import ufc.quixada.npi.ap.model.RestricaoHorario;

public interface RestricaoHorarioService {
	
	public RestricaoHorario salvarRestricaoHorario(RestricaoHorario restricaoHorario);
	
	public void salvarRestricaoHorarioPeriodoAtivo(RestricaoHorario restricaoHorario);
	
	public void excluir(Integer id);
	
	public RestricaoHorario buscarRestricaoHorario(Integer idRestricaoHorario);
	
	public List<RestricaoHorario> buscarTodasRestricoesHorario();
	
	boolean desabilitarEmpilhamento(Integer id);
	
}

package ufc.quixada.npi.ap.service;

import java.util.List;


import ufc.quixada.npi.ap.model.RestricaoHorario;

public interface EmpilhamentoService {
	
	public void salvarEmpilhamentoPeriodoAtivo(RestricaoHorario empilhamento);
	
	public RestricaoHorario salvarEmpilhamento(RestricaoHorario empilhamento);
	
	public List<RestricaoHorario> listarEmpilhamentos();
	
	public void excluirEmpilhamento(Integer idEmpilhamento);
	
	public RestricaoHorario visualizarEmpilhamento(Integer idEmpilhamento);
	
}

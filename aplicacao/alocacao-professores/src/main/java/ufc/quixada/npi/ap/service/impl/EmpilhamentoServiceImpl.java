package ufc.quixada.npi.ap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Empilhamento;
import ufc.quixada.npi.ap.repository.EmpilhamentoRepository;
import ufc.quixada.npi.ap.service.EmpilhamentoService;

@Service
public class EmpilhamentoServiceImpl implements EmpilhamentoService {

	@Autowired
	private EmpilhamentoRepository empilhamentoRepository;
	
	@Override
	public Empilhamento salvarEmpilhamento(Empilhamento empilhamento) {
		return empilhamentoRepository.save(empilhamento);
	}

	@Override
	public List<Empilhamento> listarEmpilhamentos() {
		return empilhamentoRepository.findAll();
	}

	@Override
	public void excluirEmpilhamento(Integer idEmpilhamento) {
		empilhamentoRepository.delete(idEmpilhamento);
	}

	@Override
	public Empilhamento visualizarEmpilhamento(Integer idEmpilhamento) {
		return empilhamentoRepository.findOne(idEmpilhamento);
	}

}

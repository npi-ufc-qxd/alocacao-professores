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
	public Empilhamento salvar(Empilhamento empilhamento) {
		return empilhamentoRepository.save(empilhamento);
	}

	@Override
	public List<Empilhamento> buscarTodosEmpilhamentos() {
		return empilhamentoRepository.findAll();
	}

	@Override
	public void excluir(Integer idEmpilhamento) {
		empilhamentoRepository.delete(idEmpilhamento);
	}

	@Override
	public Empilhamento buscarEmpilhamento(Integer idEmpilhamento) {
		return empilhamentoRepository.findOne(idEmpilhamento);
	}

}

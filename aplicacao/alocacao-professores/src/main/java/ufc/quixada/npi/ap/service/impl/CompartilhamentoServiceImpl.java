package ufc.quixada.npi.ap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.repository.CompartilhamentoRepository;
import ufc.quixada.npi.ap.service.CompartilhamentoService;

@Service
public class CompartilhamentoServiceImpl implements CompartilhamentoService {
	
	@Autowired
	private CompartilhamentoRepository compartilhamentoRepository;

	@Override
	public Compartilhamento findCompartilhamento(Integer id) {
		return compartilhamentoRepository.findOne(id);
	}
	
	@Override
	public void salvar(Compartilhamento compartilhamento) {
		compartilhamentoRepository.save(compartilhamento);
	}
}

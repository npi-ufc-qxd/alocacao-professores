package ufc.quixada.npi.ap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.repository.CompartilhamentoRepository;
import ufc.quixada.npi.ap.repository.OfertaRepository;
import ufc.quixada.npi.ap.service.CompartilhamentoService;

@Service
public class CompartilhamentoServiceImpl implements CompartilhamentoService {
	
	@Autowired
	private CompartilhamentoRepository compartilhamentoRepository;
	
	@Autowired
	private OfertaRepository ofertaRepository;
	
	@Override
	public void salvar(Compartilhamento compartilhamento) {
		compartilhamentoRepository.save(compartilhamento);
	}
	
	public Compartilhamento findCompartilhamento(Integer id){
		return compartilhamentoRepository.findOne(id);
	}
	
	@Override
	public List<Compartilhamento> findAllCompartilhamentos() {
		return compartilhamentoRepository.findAll();
	}
	
	@Override
	public void excluir(Integer id) {
		compartilhamentoRepository.delete(id);
	}
	
	@Override
	public List<Oferta> listarCompartilhamentoOfertas() {
		return ofertaRepository.findByPeriodoAtivoTrue();
	}

	@Override
	public List<Compartilhamento> buscarCompartilhamentosPorPeriodoAndCurso(Periodo periodo, Curso curso) {
		return compartilhamentoRepository.findCompartilhamentosByPeriodoAndCurso(periodo, curso);
	}
}
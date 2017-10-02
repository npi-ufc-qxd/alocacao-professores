package ufc.quixada.npi.ap.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Professor;
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
	
	@Override
	public List<Compartilhamento> buscarCompartilhamentosNaoImportadosPorPeriodoAndCurso(Periodo periodo, Periodo periodoAtivo, Curso curso) {
		return compartilhamentoRepository.findCompartilhamentosNaoImportadosByPeriodoAndCurso(periodo, periodoAtivo, curso);
	}
	
	@Override
	public List<Compartilhamento> buscarCompartilhamentosImportadosPorPeriodoAndCurso(Periodo periodo, Periodo periodoAtivo, Curso curso) {
		return compartilhamentoRepository.findCompartilhamentosImportadosByPeriodoAndCurso(periodo, periodoAtivo, curso);
	}
	
	@Override
	public Map<String, Object> importarOfertasCompartilhadas(List<Integer> compartilhamentos, Periodo periodo, Curso cursoCoordenador) {
		boolean contem;
		boolean adicionado = true;
		
		Map<String, Object> resultado = new HashMap<String, Object>();

		for (Integer id : compartilhamentos) {
			Compartilhamento compartilhamento = compartilhamentoRepository.findOne(id);
			
			if (compartilhamento != null) {
				contem = false;
				
				for (Oferta o : ofertaRepository.findOfertaByPeriodo(periodo)) {
					if (o.getDisciplina().equals(compartilhamento.getOferta().getDisciplina()) 
							&& o.getTurma().equals(compartilhamento.getTurma())) {
						contem = true;
						break;
					}
				}
				
				if (!contem) {
					Oferta novaOferta = this.clonarOfertaCompartilhada(compartilhamento);
					
					novaOferta.setPeriodo(periodo);
					
					ofertaRepository.save(novaOferta);
					
					if (adicionado)
						resultado.put("importada", true);
					
					adicionado = false;
				}
			}
		}
		
		if (adicionado) 
			resultado.put("importada", false);
		
		return resultado;
	}
	
	private Oferta clonarOfertaCompartilhada(Compartilhamento compartilhamento) {
		Oferta ofertaCompartilhada = compartilhamento.getOferta();
		
		Oferta oferta = new Oferta();
		oferta.setDisciplina(ofertaCompartilhada.getDisciplina());
		oferta.setTurno(ofertaCompartilhada.getTurno());
		oferta.setObservacao(ofertaCompartilhada.getObservacao());
		oferta.setTurma(compartilhamento.getTurma());
		oferta.setVagas(compartilhamento.getVagas());

		if (!ofertaCompartilhada.getProfessores().isEmpty()) {
			List<Professor> professores = new ArrayList<>();
			professores.addAll(ofertaCompartilhada.getProfessores());
			
			oferta.setProfessores(professores);
		}
		
		return oferta;
	}
}
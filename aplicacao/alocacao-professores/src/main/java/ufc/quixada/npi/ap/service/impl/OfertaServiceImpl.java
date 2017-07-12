package ufc.quixada.npi.ap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.repository.CursoRepository;
import ufc.quixada.npi.ap.repository.OfertaRepository;
import ufc.quixada.npi.ap.service.OfertaService;

@Service
public class OfertaServiceImpl implements OfertaService {

	@Autowired
	private OfertaRepository ofertaRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public void salvar(Oferta oferta) {
		ofertaRepository.save(oferta);
	}
	
	@Override
	public Oferta findOferta(Integer id) {
		return ofertaRepository.findOne(id);
	}
	
	@Override
	public List<Oferta> findAllOfertas() {
		return ofertaRepository.findAll();
	}

	@Override
	public void excluir(Integer id) {
		ofertaRepository.delete(id);
	}
	
	@Override
	public Oferta visualizarOferta(Integer idOferta) {
		return ofertaRepository.findOne(idOferta);
	}
	
	@Override
	public List<Oferta> findAllOfertasCurso(Pessoa pessoa) {
		if(pessoa != null) {
			Curso curso = cursoRepository.findByCoordenador(pessoa.getNome());
			return ofertaRepository.findByPeriodoAtivoTrueAndTurmaCursoSigla(curso.getSigla());
		}
		
		return null;
		
	}

}
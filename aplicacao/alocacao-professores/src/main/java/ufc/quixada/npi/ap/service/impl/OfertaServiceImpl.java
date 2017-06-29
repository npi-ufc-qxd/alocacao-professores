package ufc.quixada.npi.ap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.repository.OfertaRepository;
import ufc.quixada.npi.ap.service.OfertaService;

@Service
public class OfertaServiceImpl implements OfertaService {
	
	@Autowired
	private OfertaRepository ofertaRepository;

	@Override
	public List<Oferta> findAllOfertas() {
		return ofertaRepository.findAll();
	}
	
	@Override
	public void excluir(Integer id) {
		ofertaRepository.delete(id);
	}
	
	@Override
	public Oferta salvarOferta(Oferta oferta) {
		return ofertaRepository.save(oferta);
	}

	@Override
	public Oferta visualizarOferta(Integer idOferta) {
		return ofertaRepository.findOne(idOferta);
	}

}

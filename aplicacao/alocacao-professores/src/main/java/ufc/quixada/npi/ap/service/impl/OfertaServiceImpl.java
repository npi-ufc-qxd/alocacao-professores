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
	public List<Oferta> listar() {	
		
		return ofertaRepository.findAll();
		
	}
	
	
}



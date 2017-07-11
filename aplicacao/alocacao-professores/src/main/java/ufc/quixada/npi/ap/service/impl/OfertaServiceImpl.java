package ufc.quixada.npi.ap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.exception.AlocacaoProfessoresException;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.repository.OfertaRepository;
import ufc.quixada.npi.ap.repository.PeriodoRepository;
import ufc.quixada.npi.ap.service.OfertaService;
import static ufc.quixada.npi.ap.util.Constants.PERIODO_INVALIDO;

@Service
public class OfertaServiceImpl implements OfertaService {

	@Autowired
	private OfertaRepository ofertaRepository;

	@Autowired
	private PeriodoRepository periodoRepository;

	@Override
	public void salvar(Oferta oferta) throws AlocacaoProfessoresException{
		Periodo periodoAtivo = periodoRepository.pediodoAtivo();
		if (periodoAtivo != null) {
			oferta.setPeriodo(periodoAtivo);
			ofertaRepository.save(oferta);
		}else{
			throw new AlocacaoProfessoresException(PERIODO_INVALIDO);
		}
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

}
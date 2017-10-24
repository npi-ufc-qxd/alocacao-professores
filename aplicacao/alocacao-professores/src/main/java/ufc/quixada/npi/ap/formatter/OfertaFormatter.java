package ufc.quixada.npi.ap.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.service.OfertaService;

@Component
public class OfertaFormatter implements Formatter<Oferta> {
	
	@Autowired
	private OfertaService ofertaService;

	@Override
	public String print(Oferta oferta, Locale locale) {
		return oferta.getId().toString();
	}

	@Override
	public Oferta parse(String id, Locale locale) throws ParseException {
		return ofertaService.buscarOferta(Integer.parseInt(id));
	}

}

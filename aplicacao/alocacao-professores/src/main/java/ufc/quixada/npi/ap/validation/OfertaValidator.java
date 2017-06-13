package ufc.quixada.npi.ap.validation;

import javax.inject.Named;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ufc.quixada.npi.ap.model.Oferta;

@Named
public class OfertaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Oferta.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object objeto, Errors erros) {
		// TODO Auto-generated method stub
	}

}

package ufc.quixada.npi.validation;

import javax.inject.Named;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Oferta;

@Named
public class CompartilhamentoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Compartilhamento.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object objeto, Errors erros) {
		Compartilhamento compartilhamento = (Compartilhamento) objeto;
		
		validateOferta(erros, compartilhamento.getOferta(), "oferta.id", "O campo de oferta não pode ser nulo!");
	}
	
	private void validateOferta(Errors erros, Oferta oferta, String campo, String mensagem){
		if (oferta == null || oferta.getId() <= 0)
			erros.rejectValue(campo, mensagem);
	}
	
	void validateStrings(Errors erros, String string, String campo, String mensagem) {
		if (string.isEmpty())
			erros.rejectValue(campo, mensagem);
	}

	void validateNotNull(Errors erros, Object objeto, String campo, String mensagem) {
		if (objeto == null)
			erros.rejectValue(campo, mensagem);
	}

}

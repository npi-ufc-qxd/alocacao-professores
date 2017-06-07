package ufc.quixada.npi.ap.validation;

import javax.inject.Named;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ufc.quixada.npi.ap.model.Empilhamento;

@Named
public class EmpilhamentoValidator implements Validator {
	  
	@Override
	public boolean supports(Class<?> clazz) {
		return Empilhamento.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Empilhamento empilhamento = (Empilhamento) target;
		validateNotNull(errors, empilhamento.getPrimeiraDisciplina(), "primeiraDisciplina.id", "Campo obrigatório");
		validateNotNull(errors, empilhamento.getPrimeiraTurma(), "primeiraTurma.id", "Campo obrigatório");
		validateNotNull(errors, empilhamento.getSegundaDisciplina(), "segundaDisciplina.id", "Campo obrigatório");
		validateNotNull(errors, empilhamento.getSegundaTurma(), "segundaTurma.id", "Campo obrigatório");
	}

	void validateStrings(Errors erros, String object, String field, String message) {
		if (object.isEmpty()) {
			erros.rejectValue(field, field, message);
		}
	}

	void validateNotNull(Errors erros, Object object, String field, String message) {
		if (object == null) {
			erros.rejectValue(field, field, message);
		}
	}
	
}
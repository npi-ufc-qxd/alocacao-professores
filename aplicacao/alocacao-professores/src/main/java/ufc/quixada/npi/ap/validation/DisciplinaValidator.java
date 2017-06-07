package ufc.quixada.npi.ap.validation;

import javax.inject.Named;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ufc.quixada.npi.ap.model.Disciplina;

@Named
public class DisciplinaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Disciplina.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		Disciplina disciplina = (Disciplina) target;
		validateStrings(errors, disciplina.getNome(), "nome", "Preenchimento inválido");
		validateNotNull(errors, disciplina.getCargaHorariaPratica(), "cargaHorariaPratica", "Preenchimento inválido");
		validateNotNull(errors, disciplina.getCargaHorariaTeorica(), "cargaHorariaTeorica", "Preenchimento inválido");
		validateNotNull(errors, disciplina.getCreditos(), "creditos", "Preenchimento inválido");
	}

	void validateStrings(Errors erros, String object, String field, String message) {
		
		if (object.isEmpty() || 
		   
		    !object.matches("[^=+\\\\|\\[{\\]};:'\"<>/@#$%]*")) {
			erros.rejectValue(field, field, message);
		}
	}

	void validateNotNull(Errors erros, Integer object, String field, String message) {
		if (object <= 0 || object.toString().isEmpty()) {
			erros.rejectValue(field, field, message);
		}
	}

}

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
		validateNomeNull(errors, disciplina.getNome(), "nome", "Preenchimento inválido");
		validateNotNull(errors, disciplina.getCargaHorariaPratica(), "cargaHorariaPratica", "Preenchimento inválido");
		validateNotNull(errors, disciplina.getCargaHorariaTeorica(), "cargaHorariaTeorica", "Preenchimento inválido");
		validateNotNull(errors, disciplina.getCreditos(), "creditos", "Preenchimento inválido");
		validateCodigoInvalido(errors, disciplina.getCodigo(), "codigo", "codigoInvalid");
		validateCodigoNotNull(errors, disciplina.getCodigo(), "codigo", "codigoNotNull");
	}
	
	void validateCodigoInvalido(Errors erros, String codigo, String campo, String mensagem){
		if (!codigo.matches("^[A-Z]{3}\\d{4}$")){
			erros.rejectValue(campo, mensagem);
		}
	}
	
	void validateCodigoNotNull(Errors erros, String codigo, String campo, String mensagem){
		if (codigo == null || codigo.isEmpty() || codigo.equals("")){
			erros.rejectValue(campo, mensagem);
		}
	}

	void validateStrings(Errors erros, String object, String field, String message) {	
		if (object.isEmpty() || !object.matches("[^=+\\\\|\\[{\\]};:'\"<>/@#$%åæËÎÏÐðÑ×÷ØÝÞß]*")) {
			erros.rejectValue(field, field, message);
		}
	}

	void validateNotNull(Errors erros, Integer object, String field, String message) {
		if (object < 0 || object.toString().isEmpty()) {
			erros.rejectValue(field, field, message);
		}
	}
	
	void validateNomeNull(Errors erros, String object, String field, String message) {
		String nome = object.substring(0, 1);
		if(nome.equals(" ")) {
			erros.rejectValue(field, field, message);
		}
	}

}
package ufc.quixada.npi.ap.validation;

import javax.inject.Named;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.RestricaoHorario;
import ufc.quixada.npi.ap.model.Turma;

@Named
public class EmpilhamentoValidator implements Validator {
	  
	@Override
	public boolean supports(Class<?> clazz) {
		return RestricaoHorario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RestricaoHorario empilhamento = (RestricaoHorario) target;
		
		validateDisciplinaNotNull(errors, empilhamento.getPrimeiraOferta(), "primeiraOferta.id", "Campo obrigatório");
		validateDisciplinaNotNull(errors, empilhamento.getSegundaOferta(), "segundaOferta.id", "Campo obrigatório");
	
	}
	
	void validateDisciplinaNotNull(Errors erros, Oferta oferta, String field, String message) {
		if (oferta == null || oferta.getId() == null || oferta.getId() <= 0){
			erros.rejectValue(field, field, message);
		}
	}
	
	void validateTurmaNotNull(Errors erros, Turma object, String field, String message) {
		if (object == null || object.getId() == null || object.getId() <= 0) {
			erros.rejectValue(field, field, message);
		}
	}
	
}
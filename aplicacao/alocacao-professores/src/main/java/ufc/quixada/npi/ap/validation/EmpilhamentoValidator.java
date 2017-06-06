package ufc.quixada.npi.ap.validation;

import javax.inject.Named;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.model.Empilhamento;
import ufc.quixada.npi.ap.model.Turma;

@Named
public class EmpilhamentoValidator implements Validator {
	  
	@Override
	public boolean supports(Class<?> clazz) {
		return Empilhamento.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Empilhamento empilhamento = (Empilhamento) target;
		validateDisciplinaNotNull(errors, empilhamento.getPrimeiraDisciplina(), "primeiraDisciplina.id", "Campo obrigatório");
		validateTurmaNotNull(errors, empilhamento.getPrimeiraTurma(), "primeiraTurma.id", "Campo obrigatório");
		validateDisciplinaNotNull(errors, empilhamento.getSegundaDisciplina(), "segundaDisciplina.id", "Campo obrigatório");
		validateTurmaNotNull(errors, empilhamento.getSegundaTurma(), "segundaTurma.id", "Campo obrigatório");
	}

	void validateStrings(Errors erros, String object, String field, String message) {
		if (object.isEmpty() || object.equals("")) {
			erros.rejectValue(field, field, message);
		}
	}

	void validateDisciplinaNotNull(Errors erros, Disciplina object, String field, String message) {
		if (object == null || object.getId() == null || object.getId() <= 0){
			erros.rejectValue(field, field, message);
		}
	}
	
	void validateTurmaNotNull(Errors erros, Turma object, String field, String message) {
		if (object == null || object.getId() == null || object.getId() <= 0) {
			erros.rejectValue(field, field, message);
		}
	}
	
}
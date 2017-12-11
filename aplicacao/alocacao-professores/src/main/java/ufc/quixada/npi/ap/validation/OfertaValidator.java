package ufc.quixada.npi.ap.validation;

import java.util.List;

import javax.inject.Named;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.model.Turma;
import ufc.quixada.npi.ap.util.Constants;

@Named
public class OfertaValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Oferta.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object objeto, Errors erros) {
		Oferta oferta = (Oferta) objeto;
		
		validateTurma(erros, oferta.getTurma());
		validateDisciplina(erros, oferta.getDisciplina());
		validateVagas(erros, oferta.getVagas());
		validateAulasEmLaboratorio(erros, oferta.getAulasEmLaboratorio());
		validateProfessores(erros, oferta.getProfessores());
		validateNumeroProfessores(erros, oferta.getNumeroProfessores());
	}
	
	private void validateTurma(Errors erros, Turma turma){
		String campo = "turma";
		
		if (!erros.hasFieldErrors(campo)){
			if (turma == null)
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
		}
	}
	
	private void validateDisciplina(Errors erros, Disciplina disciplina){
		String campo = "disciplina";
		
		if(!erros.hasFieldErrors(campo)){
			if (disciplina == null)
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
		}
	}
	
	private void validateVagas(Errors erros, Integer vagas){
		String campo = "vagas";
		
		if (!erros.hasFieldErrors(campo)){
			if (vagas == null)
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
			else if(vagas <= 0)
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_INVALID);
		}
	}

	private void validateAulasEmLaboratorio(Errors erros, Integer aulasEmLaboratorio){
		String campo = "aulasEmLaboratorio";
		
		if (!erros.hasFieldErrors(campo)){
			if (aulasEmLaboratorio == null)
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
			else if (aulasEmLaboratorio < 0)
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_INVALID);
		}
	}
	
	private void validateProfessores(Errors erros, List<Professor> professores){
		String campo = "professores";
		
		if (!erros.hasFieldErrors(campo)){
			if (professores == null || professores.isEmpty())
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
		}
	}
	
	private void validateNumeroProfessores(Errors erros, Integer numeroProfessores){
		String campo = "numeroProfessores";
		if (!erros.hasFieldErrors(campo)){
			if (numeroProfessores == null)
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
			else if (numeroProfessores <= 0)
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_INVALID);
		}
	}
}
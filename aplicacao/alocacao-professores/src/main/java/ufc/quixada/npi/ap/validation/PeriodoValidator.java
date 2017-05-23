package ufc.quixada.npi.ap.validation;

import javax.inject.Named;
import javax.validation.Validator;

import org.springframework.validation.Errors;

import ufc.quixada.npi.ap.model.Periodo;


@Named
public class PeriodoValidator implements org.springframework.validation.Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Periodo.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object objeto, Errors error) {
		// TODO Auto-generated method stub
		Periodo periodo = (Periodo) objeto;
		validateAno(error, periodo.getAno(), "ano","anoNull");
		validateSemestre(error, periodo.getSemestre(), "semestre", "semestreNull");
		
	}
	public void validateAno(Errors error, String ano, String campo, String mensagem){
		if(ano == null || ano.isEmpty() || !ano.matches("\\d{4}"))
			error.rejectValue(campo, mensagem);
	}
	
	public void validateSemestre(Errors error, String semestre, String campo, String mensagem){
		if(semestre==null || semestre.isEmpty() || !semestre.matches("\\d{1}")|| !semestre.matches("[12]"))
			error.rejectValue(campo, mensagem);
		
	}
	
}

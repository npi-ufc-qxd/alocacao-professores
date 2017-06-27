package ufc.quixada.npi.ap.validation;

import java.util.Date;

import javax.inject.Named;
import org.springframework.validation.Errors;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Periodo.Status;


@Named
public class PeriodoValidator implements org.springframework.validation.Validator{

	@Override
	public boolean supports(Class<?> arg0) {		
		return Periodo.class.isAssignableFrom(arg0);
	}
	
	Date dataAtual = new Date();
	
	@Override
	public void validate(Object objeto, Errors error) {		
		Periodo periodo = (Periodo) objeto;
		validateAno(error, periodo.getAno(), "ano","anoNull");
		validateSemestre(error, periodo.getSemestre(), "semestre", "semestreNull");
		//validateStatus(error, periodo.getStatus(), "status", "statusNull");
		validateInicioPeriodoCoordenacao(error, periodo.getInicioPeriodoCoordenacao(), "inicioPeriodoCoordenacao", "dataNull");
		validateFimPeriodoCoordenacao(error,periodo, "fimPeriodoCoordenacao", "dataNull");
		validateInicioPeriodoDirecao(error, periodo, "inicioPeriodoDirecao", "dataNull");
		validateFimPeriodoDirecao(error, periodo, "fimPeriodoDirecao", "dataNull");
		validateInicioPeriodoAjuste(error, periodo, "inicioPeriodoAjuste", "dataNull");
		validateFimPeriodoAjuste(error, periodo, "fimPeriodoAjuste", "dataNull");
	}
	
	public void validateAno(Errors error, String ano, String campo, String mensagem){
		if(ano == null || ano.isEmpty() || !ano.matches("\\d{4}"))
			error.rejectValue(campo, mensagem);
	}
	
	public void validateSemestre(Errors error, String semestre, String campo, String mensagem){
		if(semestre==null || semestre.isEmpty() || !semestre.matches("\\d{1}")|| !semestre.matches("[12]"))
			error.rejectValue(campo, mensagem);		
	}
	
	public void validateStatus(Errors error, Status status, String campo, String mensagem){
		if(status==null || status.getDescricao().isEmpty())
			error.rejectValue(campo, mensagem);
	}
	
	public void validateInicioPeriodoCoordenacao(Errors error, Date data, String campo, String mensagem){		
		if(data == null || data.before(dataAtual))
			error.rejectValue(campo,mensagem);
	}
	public void validateFimPeriodoCoordenacao(Errors error, Periodo periodo, String campo, String mensagem){
		if(periodo.getFimPeriodoCoordenacao() == null ||periodo.getFimPeriodoCoordenacao().before(periodo.getInicioPeriodoCoordenacao()))
			error.rejectValue(campo,mensagem);
	}
	public void validateInicioPeriodoDirecao(Errors error,Periodo periodo, String campo, String mensagem){
		if(periodo.getInicioPeriodoDirecao() == null || periodo.getInicioPeriodoDirecao().before(periodo.getFimPeriodoCoordenacao()))
			error.rejectValue(campo,mensagem);
	}
	public void validateFimPeriodoDirecao(Errors error, Periodo periodo, String campo, String mensagem){
		if(periodo.getFimPeriodoDirecao() == null || periodo.getFimPeriodoDirecao().before(periodo.getInicioPeriodoDirecao()))
			error.rejectValue(campo,mensagem);
	}
	public void validateInicioPeriodoAjuste(Errors error, Periodo periodo, String campo, String mensagem){
		if(periodo.getInicioPeriodoAjuste() == null || periodo.getInicioPeriodoAjuste().before(periodo.getFimPeriodoDirecao()))
			error.rejectValue(campo,mensagem);
	}
	public void validateFimPeriodoAjuste(Errors error, Periodo periodo, String campo, String mensagem){
		if(periodo.getFimPeriodoAjuste() == null || periodo.getFimPeriodoAjuste().before(periodo.getInicioPeriodoAjuste()))
			error.rejectValue(campo,mensagem);
	}
}

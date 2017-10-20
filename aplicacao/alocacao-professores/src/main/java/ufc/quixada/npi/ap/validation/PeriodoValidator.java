package ufc.quixada.npi.ap.validation;

import java.util.Date;

import javax.inject.Named;
import org.springframework.validation.Errors;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Periodo.Semestre;
import ufc.quixada.npi.ap.util.Constants;


@Named
public class PeriodoValidator implements org.springframework.validation.Validator{
	
	private Date dataAtual = new Date();

	@Override
	public boolean supports(Class<?> arg0) {
		return Periodo.class.isAssignableFrom(arg0);
	}
	
	@Override
	public void validate(Object objeto, Errors error) {
		Periodo periodo = (Periodo) objeto;
		
		validateAno(error, periodo.getAno());
		validateSemestre(error, periodo.getSemestre());
		
		validateInicioPeriodoCoordenacao(error, periodo.getInicioPeriodoCoordenacao());
		validateFimPeriodoCoordenacao(error, periodo.getInicioPeriodoCoordenacao(), periodo.getFimPeriodoCoordenacao());
		
		validateInicioPeriodoDirecao(error, periodo.getFimPeriodoCoordenacao(), periodo.getInicioPeriodoDirecao());
		validateFimPeriodoDirecao(error, periodo.getInicioPeriodoDirecao(), periodo.getFimPeriodoDirecao());
		
		validateInicioPeriodoAjuste(error, periodo.getFimPeriodoDirecao(), periodo.getInicioPeriodoAjuste());
		validateFimPeriodoAjuste(error, periodo.getInicioPeriodoAjuste(), periodo.getFimPeriodoAjuste());
	}
	
	private void validateAno(Errors error, String ano){
		String campo = "ano";
		
		if(ano == null || ano.isEmpty())
			error.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
		else if (!ano.matches("\\d{4}"))
			error.rejectValue(campo, Constants.VALIDACAO_ERRO_INVALID);
	}
	
	private void validateSemestre(Errors error, Semestre semestre){
		String campo = "semestre";
		
		if (!error.hasFieldErrors(campo)){
			if(semestre == null)
				error.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);	
		}
	}
	
	private void validateInicioPeriodoCoordenacao(Errors error, Date inicioperiodoCoordenacao){
		String campo = "inicioPeriodoCoordenacao";
		
		if (!error.hasFieldErrors(campo)){
			if(inicioperiodoCoordenacao == null)
				error.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
			else if (inicioperiodoCoordenacao.before(dataAtual))
				error.rejectValue(campo, Constants.VALIDACAO_ERRO_INVALID);
		}
	}
	
	private void validateFimPeriodoCoordenacao(Errors error, Date inicioPeriodoCoordenacao, Date fimPeriodoCoordenacao){
		String campo = "fimPeriodoCoordenacao";
		
		if (!error.hasFieldErrors(campo)){
			if(fimPeriodoCoordenacao == null)
				error.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
			else if (inicioPeriodoCoordenacao != null && fimPeriodoCoordenacao.before(inicioPeriodoCoordenacao))
				error.rejectValue(campo, Constants.VALIDACAO_ERRO_INVALID);
		}
		
	}
	
	private void validateInicioPeriodoDirecao(Errors error, Date fimPeriodoCoordenacao, Date inicioPeriodoDirecao){
		String campo = "inicioPeriodoDirecao";
		
		if (!error.hasFieldErrors(campo)){
			if(inicioPeriodoDirecao == null)
				error.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
			else if (fimPeriodoCoordenacao != null && inicioPeriodoDirecao.before(fimPeriodoCoordenacao))
				error.rejectValue(campo, Constants.VALIDACAO_ERRO_INVALID);
		}
	}
	
	private void validateFimPeriodoDirecao(Errors error, Date inicioPeriodoDirecao, Date fimPeriodoDirecao){
		String campo = "fimPeriodoDirecao";
		
		if(!error.hasFieldErrors(campo)){
			if (fimPeriodoDirecao == null)
				error.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
			else if (inicioPeriodoDirecao != null && fimPeriodoDirecao.before(inicioPeriodoDirecao))
				error.rejectValue(campo, Constants.VALIDACAO_ERRO_INVALID);
		}
	}
	
	private void validateInicioPeriodoAjuste(Errors error, Date fimPeriodoDirecao, Date inicioPeriodoAjuste){
		String campo = "inicioPeriodoAjuste";
		
		if (!error.hasFieldErrors(campo)){
			if (inicioPeriodoAjuste == null)
				error.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
			else if (fimPeriodoDirecao != null && inicioPeriodoAjuste.before(fimPeriodoDirecao))
				error.rejectValue(campo, Constants.VALIDACAO_ERRO_INVALID);
		}
	}
	
	private void validateFimPeriodoAjuste(Errors error, Date inicioPeriodoAjuste, Date fimPeriodoAjuste){
		String campo = "fimPeriodoAjuste";
		
		if (!error.hasFieldErrors(campo)){
			if (fimPeriodoAjuste == null)
				error.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
			else if (inicioPeriodoAjuste != null && fimPeriodoAjuste.before(inicioPeriodoAjuste))
				error.rejectValue(campo, Constants.VALIDACAO_ERRO_INVALID);
		}
	}
}

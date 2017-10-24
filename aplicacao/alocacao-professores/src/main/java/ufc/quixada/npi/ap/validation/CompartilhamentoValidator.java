package ufc.quixada.npi.ap.validation;

import java.util.Map;

import javax.inject.Named;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Turma;
import ufc.quixada.npi.ap.util.Constants;

@Named
public class CompartilhamentoValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Compartilhamento.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object objeto, Errors erros) {
		Map<?,?> mapa = (Map<?,?>) objeto;
		
		Compartilhamento compartilhamento = (Compartilhamento) mapa.get("compartilhamento");
		Curso cursoCoordenador = (Curso) mapa.get("cursoCoordenador");
		
		validateTurma(erros, compartilhamento.getTurma(), cursoCoordenador);
		validateOferta(erros, compartilhamento.getOferta());
		validateVagas(erros, compartilhamento.getVagas());
	}
	
	private void validateTurma(Errors erros, Turma turma, Curso cursoCoordenador){
		String campo = "turma";
		
		if(!erros.hasFieldErrors(campo)){
			if (turma == null)
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
			else if (!cursoCoordenador.getTurmas().contains(turma))
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_INVALID);
		}
	}
	
	private void validateOferta(Errors erros, Oferta oferta){
		String campo = "oferta";
		
		if (!erros.hasFieldErrors(campo)){
			if (oferta == null)
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
		}
	}
	
	private void validateVagas(Errors erros, Integer vagas){
		String campo = "vagas";
		
		if (!erros.hasFieldErrors(campo)){
			if (vagas == null)
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
			else if (vagas <= 0)
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_INVALID);
		}
	}
}
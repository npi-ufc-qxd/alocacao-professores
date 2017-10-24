package ufc.quixada.npi.ap.validation;

import static ufc.quixada.npi.ap.util.Constants.VALIDACAO_ERRO_INVALID;
import static ufc.quixada.npi.ap.util.Constants.VALIDACAO_ERRO_NULL;

import java.util.Arrays;
import java.util.List;

import javax.inject.Named;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.util.Constants;

@Named
public class DisciplinaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Disciplina.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object objeto, Errors errors) {
		Disciplina disciplina = (Disciplina) objeto;
		
		validateCodigo(errors, disciplina.getCodigo());
		validateNome(errors, disciplina.getNome());
		validateCreditos(errors, disciplina.getCreditos());
		validateCargaHoraria(errors, disciplina.getCargaHorariaTeorica(), "cargaHorariaTeorica");
		validateCargaHoraria(errors, disciplina.getCargaHorariaPratica(), "cargaHorariaPratica");
	}
	
	private void validateCodigo(Errors erros, String codigo){
		String campo = "codigo";
		
		if (!erros.hasFieldErrors(campo)){
			if (codigo == null || codigo.isEmpty() || codigo.trim().isEmpty())
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
			else if (!codigo.matches("^[A-Z]{3}\\d{4}$"))
				erros.reject(campo, Constants.VALIDACAO_ERRO_INVALID);
		}
	}
	
	private void validateNome(Errors erros, String nome) {
		String campo = "nome";
		
		if(!erros.hasFieldErrors(campo)){
			if(nome == null || nome.isEmpty() || nome.trim().isEmpty())
				erros.rejectValue(campo, VALIDACAO_ERRO_NULL);
			else if (nome.startsWith(" ") || !nome.matches("[a-zA-Zà-úÀ-Ú ]+$"))
				erros.rejectValue(campo, VALIDACAO_ERRO_INVALID);
		}
	}
	
	private void validateCreditos(Errors erros, Integer creditos) {
		String campo = "creditos";
		List<Integer> valoresValidos = Arrays.asList(2, 4, 6, 10);
		
		if (!erros.hasFieldErrors(campo)){
			if (creditos == null)
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_NULL);
			else if (!valoresValidos.contains(creditos))
				erros.rejectValue(campo, Constants.VALIDACAO_ERRO_INVALID);
		}
	}
	
	private void validateCargaHoraria(Errors erros, Integer cargaHoraria, String campo){
		if (!erros.hasFieldErrors(campo)){
			if (cargaHoraria == null)
				erros.rejectValue(campo, VALIDACAO_ERRO_NULL);
			else if (cargaHoraria < 0)
				erros.rejectValue(campo, VALIDACAO_ERRO_INVALID);
		}
	}
}
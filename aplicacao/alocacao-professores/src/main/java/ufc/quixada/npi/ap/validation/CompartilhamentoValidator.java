package ufc.quixada.npi.ap.validation;

import javax.inject.Named;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Turma;

@Named
public class CompartilhamentoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Compartilhamento.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object objeto, Errors erros) {
		Compartilhamento compartilhamento = (Compartilhamento) objeto;
		
		validateTurma(erros, compartilhamento.getTurma(), "turma.id", "turmaNull");
		validateOferta(erros, compartilhamento.getOferta(), "oferta.id", "ofertaNull");
		validateVagasNotNull(erros, compartilhamento.getVagas(), "vagas", "vagasNull");
		validateVagasValorInvalido(erros, compartilhamento.getVagas(), "vagas", "vagasInvalid");
	}
	
	private void validateTurma(Errors erros, Turma turma, String campo, String mensagem){
		if (turma == null || turma.getId() == null || turma.getId() <= 0)
			erros.rejectValue(campo, mensagem);
	}
	
	private void validateOferta(Errors erros, Oferta oferta, String campo, String mensagem){
		if (oferta == null || oferta.getId() == null || oferta.getId() <= 0)
			erros.rejectValue(campo, mensagem);
	}
	
	private void validateVagasNotNull(Errors erros, Integer vagas, String campo, String mensagem){
		if (vagas == null)
			erros.rejectValue(campo, mensagem);
	}
	
	private void validateVagasValorInvalido(Errors erros, Integer vagas, String campo, String mensagem){
		if (vagas != null && vagas <= 0)
			erros.rejectValue(campo, mensagem);
	}
}
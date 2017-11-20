package ufc.quixada.npi.ap.validation;

import java.util.List;

import javax.inject.Named;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Oferta.Turno;
import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.model.Turma;

@Named
public class OfertaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Oferta.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object objeto, Errors erros) {
		Oferta oferta = (Oferta) objeto;
		
		validateProfessoresNotNull(erros, oferta.getProfessores(), "professores", "professoresNull");
		validateTurma(erros, oferta.getTurma(), "turma", "turmaNull");
		validateDisciplina(erros, oferta.getDisciplina(), "disciplina", "disciplinaNull");
		validateTurno(erros, oferta.getTurno(), "turno", "turnoNull");
		validateVagasValorInvalido(erros, oferta.getVagas(), "vagas", "vagasInvalid");
	}
	
	private void validateProfessoresNotNull(Errors erros, List<Professor> professores, String campo, String mensagem){
		if (professores == null || professores.isEmpty())
			erros.rejectValue(campo, mensagem);
	}
	
	private void validateTurma(Errors erros, Turma turma, String campo, String mensagem){
		if (turma == null || turma.getId() == null || turma.getId() <= 0)
			erros.rejectValue(campo, mensagem);
	}
	
	private void validateDisciplina(Errors erros, Disciplina disciplina, String campo, String mensagem){
		if (disciplina == null || disciplina.getId() == null || disciplina.getId() <= 0)
			erros.rejectValue(campo, mensagem);
	}
	
	private void validateTurno(Errors erros, Turno turno, String campo, String mensagem){
		if (turno == null)
			erros.rejectValue(campo, mensagem);
	}
	
	private void validateVagasValorInvalido(Errors erros, Integer vagas, String campo, String mensagem){
		if (vagas != null && vagas < 0)
			erros.rejectValue(campo, mensagem);
	}
}
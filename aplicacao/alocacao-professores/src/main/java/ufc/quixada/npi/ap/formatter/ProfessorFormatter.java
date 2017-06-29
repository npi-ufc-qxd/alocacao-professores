package ufc.quixada.npi.ap.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.service.ProfessorService;

@Component
public class ProfessorFormatter implements Formatter<Professor>{
	
	@Autowired
	private ProfessorService professorService;
	
	@Override
	public String print(Professor professor, Locale locale) {
		return professor.getId().toString();
	}

	@Override
	public Professor parse(String id, Locale locale) throws ParseException {
		return professorService.findProfessor(Integer.parseInt(id));
	}
	
}

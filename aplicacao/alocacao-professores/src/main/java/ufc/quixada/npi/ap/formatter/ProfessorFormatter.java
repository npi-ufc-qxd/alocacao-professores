package ufc.quixada.npi.ap.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import ufc.quixada.npi.ap.model.Professor;

public class ProfessorFormatter implements Formatter<Professor>{

	@Override
	public String print(Professor professor, Locale locale) {
		return professor.getId().toString();
	}

	@Override
	public Professor parse(String id, Locale locale) throws ParseException {
		Professor professor = new Professor();
		professor.setId(Integer.parseInt(id));
		
		return professor;
	}

}

package ufc.quixada.npi.ap.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.service.DisciplinaService;

@Component
public class DisciplinaFormatter implements Formatter<Disciplina> {
	
	@Autowired
	private DisciplinaService disciplinaService;

	@Override
	public String print(Disciplina disciplina, Locale locale) {
		return disciplina.getId().toString();
	}

	@Override
	public Disciplina parse(String id, Locale locale) throws ParseException {
		return disciplinaService.findDisciplina(Integer.parseInt(id));
	}

}

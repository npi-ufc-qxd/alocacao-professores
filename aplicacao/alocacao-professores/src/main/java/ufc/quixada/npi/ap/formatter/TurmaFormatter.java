package ufc.quixada.npi.ap.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import ufc.quixada.npi.ap.model.Turma;
import ufc.quixada.npi.ap.service.TurmaService;

@Component
public class TurmaFormatter implements Formatter<Turma> {

	@Autowired
	private TurmaService turmaService;
	
	@Override
	public String print(Turma turma, Locale locale) {
		return turma.getId().toString();
	}

	@Override
	public Turma parse(String id, Locale locale) throws ParseException {
		return turmaService.buscarTurma(Integer.parseInt(id));
	}

}
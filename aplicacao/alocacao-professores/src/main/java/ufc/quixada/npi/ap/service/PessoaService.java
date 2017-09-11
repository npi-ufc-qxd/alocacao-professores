package ufc.quixada.npi.ap.service;

import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.model.Servidor;

public interface PessoaService {

	public Servidor findServidor(String cpf);
	
	public Pessoa salvar(Pessoa pessoa);
	
}
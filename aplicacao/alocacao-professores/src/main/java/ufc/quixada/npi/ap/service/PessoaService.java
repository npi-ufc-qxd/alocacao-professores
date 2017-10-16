package ufc.quixada.npi.ap.service;

import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.model.Servidor;

public interface PessoaService {
	
	public Pessoa salvar(Pessoa pessoa);

	public Servidor buscarServidor(String cpf);
	
	public Professor buscarProfessor(String cpf);

}
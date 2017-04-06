package ufc.quixada.npi.ap.service;

import ufc.quixada.npi.ap.model.Servidor;

public interface PessoaService {

	Servidor findServidor(String cpf);
	
}
package ufc.quixada.npi.ap.repository;

import org.springframework.data.repository.CrudRepository;

import ufc.quixada.npi.ap.model.Servidor;

public interface ServidorRepository extends CrudRepository<Servidor, Integer>{
	
	Servidor findByPessoa_cpf(String cpf);
	
}

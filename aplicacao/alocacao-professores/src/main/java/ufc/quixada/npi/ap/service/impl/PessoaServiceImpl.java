package ufc.quixada.npi.ap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.model.Servidor;
import ufc.quixada.npi.ap.repository.PessoaRepository;
import ufc.quixada.npi.ap.repository.ProfessorRepository;
import ufc.quixada.npi.ap.repository.ServidorRepository;
import ufc.quixada.npi.ap.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private ServidorRepository servidorRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public Servidor findServidor(String cpf) {
		return servidorRepository.findByPessoa_cpf(cpf);
	}
	
	@Override
	public Professor findProfessor(String cpf) {
		return professorRepository.findByPessoa_cpf(cpf);
	}

	@Override
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
}

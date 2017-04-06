package ufc.quixada.npi.ap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Servidor;
import ufc.quixada.npi.ap.repository.ServidorRepository;
import ufc.quixada.npi.ap.service.PessoaService;

@Service
public class PessoaServiceImpl  implements PessoaService {

    @Autowired
    private ServidorRepository servidorRepository;

    @Override
    public Servidor findServidor(String cpf) {
        return servidorRepository.findByPessoa_cpf(cpf);
    }
}

package ufc.quixada.npi.ap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/compartilhamentos")
public class CompartilhamentoController {
	
	@RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
	public String listarCompartilhamentos(){
		return "compartilhamento/listar-compartilhamento";
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.GET)
	public String cadastrarCompartilhamentos(){
		return "compartilhamento/cadastrar-compartilhamento";
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.POST)
	public ModelAndView cadastrarCompartilhamento(Integer turma, Integer oferta, Integer vagas){
		ModelAndView model = new ModelAndView("redirect:/compartilhamentos/");
		
		String mensagem = "Cadastro realizado com sucesso!";
		
		model.addObject("mensagem", mensagem);
		
		return model;
	}
}

package ufc.quixada.npi.ap.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.service.PeriodoService;

@Aspect
@Component
public class RestricaoDePeriodoAspect {

	@Autowired
	private PeriodoService periodoService;
	
	@Around("@annotation(RestricaoDePeriodo)")
	public ModelAndView restringirPeriodo(ProceedingJoinPoint joinPoint) throws Throwable {
		Periodo periodoAtivo = periodoService.periodoAtivo();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Pessoa pessoa = (Pessoa) auth.getPrincipal();
		ModelAndView view = new ModelAndView();
		
		System.out.println("MÉTODO INTERCEPTADO");
		
		if( pessoa.isCoordenacao() && !(periodoAtivo.isCoordenacao() || periodoAtivo.isAjuste()) ) {
			view.setViewName("redirect:/ofertas");
			return view;
		}
		
		if( pessoa.isDirecao() && !(periodoAtivo.isDirecao() || periodoAtivo.isAjuste()) ) {
			view.setViewName("redirect:/periodos");
			return view;
		}
		
		ModelAndView proceed = (ModelAndView) joinPoint.proceed();
		
		return proceed;
	}
}

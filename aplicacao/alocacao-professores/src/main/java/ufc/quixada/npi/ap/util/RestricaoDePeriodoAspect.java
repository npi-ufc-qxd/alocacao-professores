package ufc.quixada.npi.ap.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.service.PeriodoService;

@Aspect
@Component
public class RestricaoDePeriodoAspect {

	@Autowired
	private PeriodoService periodoService;
	
	@Around(value = "@annotation(restricaoPeriodo)")
	public ModelAndView restringirPeriodo(ProceedingJoinPoint joinPoint, RestricaoDePeriodo restricaoPeriodo) throws Throwable {
		if ( !permitido() ) {
			ModelAndView view = new ModelAndView(restricaoPeriodo.value());
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = requestAttributes.getRequest();
			HttpServletResponse response = requestAttributes.getResponse();
			FlashMap flashMap = new FlashMap();
			FlashMapManager flashMapManager = RequestContextUtils.getFlashMapManager(request);
			flashMap.put(Constants.STATUS_ERROR, Constants.RESTRICAO_PERIODO);
			flashMapManager.saveOutputFlashMap(flashMap, request, response);
			return view;
		}
		return (ModelAndView) joinPoint.proceed();
	}
	
	@Around(value = "@annotation(RestricaoDePeriodoAjax)")
	public boolean restringirPeriodoAjax(ProceedingJoinPoint joinPoint) throws Throwable {
		if( !permitido() )
			return false;
		
		return (boolean) joinPoint.proceed();
	}
	
	private boolean permitido() {
		Periodo periodoAtivo = periodoService.periodoAtivo();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Pessoa pessoa = (Pessoa) auth.getPrincipal();
		
		if( pessoa.isCoordenacao() )
			return periodoAtivo.isCoordenacao() || periodoAtivo.isAjuste();
		if( pessoa.isDirecao() )
			return periodoAtivo.isDirecao() || periodoAtivo.isAjuste();
		
		return false;
	}
}

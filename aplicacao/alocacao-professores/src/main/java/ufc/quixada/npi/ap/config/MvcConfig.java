package ufc.quixada.npi.ap.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ufc.quixada.npi.ap.formatter.DisciplinaFormatter;
import ufc.quixada.npi.ap.formatter.ProfessorFormatter;
import ufc.quixada.npi.ap.formatter.TurmaFormatter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("login");
    }
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return (container ->
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"),
								new ErrorPage(HttpStatus.FORBIDDEN, "/403"),
								new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500")
								));
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new ProfessorFormatter());
		registry.addFormatter(new TurmaFormatter());
		registry.addFormatter(new DisciplinaFormatter());
	}
}

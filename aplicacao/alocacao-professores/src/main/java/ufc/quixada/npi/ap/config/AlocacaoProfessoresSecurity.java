package ufc.quixada.npi.ap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackages = { "br.ufc.quixada.npi.ldap" })
public class AlocacaoProfessoresSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("authenticationProviderAlocacaoProfessores")
	private AuthenticationProvider provider;
	
	private String login = "/login";
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").authenticated()
				.antMatchers("/js/**", "/css/**", "/img/**", "/plugins/**", "/bootstrap/**").permitAll()
				.antMatchers("/compartilhamentos/**").hasAnyAuthority("DIRECAO, COORDENACAO")
				.antMatchers("/empilhamentos/**").hasAnyAuthority("DIRECAO, COORDENACAO")
				.antMatchers("/periodos/**").hasAnyAuthority("DIRECAO, COORDENACAO")
				.antMatchers("/oferta-campus/**").hasAnyAuthority("DIRECAO, COORDENACAO")
				.antMatchers("/disciplinas/**").hasAnyAuthority("DIRECAO, COORDENACAO")
				.antMatchers("/professores/**").hasAnyAuthority("DIRECAO")
				.anyRequest().authenticated()
				.and().formLogin()
				.loginProcessingUrl(login).successHandler(new AuthenticationSuccessHandlerImpl()).loginPage(login).permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl(login);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider);
	}
	
}
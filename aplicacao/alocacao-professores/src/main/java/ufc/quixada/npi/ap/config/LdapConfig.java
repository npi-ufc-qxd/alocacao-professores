package ufc.quixada.npi.ap.config;

import static ufc.quixada.npi.ap.util.Constants.LDAP_BASE;
import static ufc.quixada.npi.ap.util.Constants.LDAP_OU;
import static ufc.quixada.npi.ap.util.Constants.LDAP_PASSWORD;
import static ufc.quixada.npi.ap.util.Constants.LDAP_URL;
import static ufc.quixada.npi.ap.util.Constants.LDAP_USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LdapConfig {

	@Autowired
	private Environment environment;

	@Bean
	public LdapContextSource contextSource() {
		LdapContextSource contextSource = new LdapContextSource();
		contextSource.setUrl(environment.getRequiredProperty(LDAP_URL));
		contextSource.setBase(environment.getRequiredProperty(LDAP_BASE));
		contextSource.setUserDn(environment.getRequiredProperty(LDAP_USER));
		contextSource.setPassword(environment.getRequiredProperty(LDAP_PASSWORD));
		return contextSource;
	}

	@Bean
	public LdapTemplate ldapTemplate() {
		return new LdapTemplate(contextSource());
	}

	@Bean(name = LDAP_URL)
	public String base() {
		return environment.getRequiredProperty(LDAP_OU);
	}

}

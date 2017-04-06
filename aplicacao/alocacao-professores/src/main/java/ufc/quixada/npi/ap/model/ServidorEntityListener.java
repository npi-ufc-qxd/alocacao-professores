package ufc.quixada.npi.ap.model;

import javax.persistence.PostLoad;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;

@Component
public class ServidorEntityListener implements ApplicationContextAware {
	private static ApplicationContext context;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostLoad
	public void loadServidor(Servidor servidor) {
		context.getAutowireCapableBeanFactory().autowireBean(this);
		Usuario usuario = usuarioService.getByCpf(servidor.getPessoa().getCpf());
		servidor.setSiape(usuario.getSiape());
		servidor.getPessoa().setEmail(usuario.getEmail());
	}
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		context = ctx;
	}
	public ApplicationContext getApplicationContext() {
        return context;
    }
}

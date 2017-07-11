package ufc.quixada.npi.ap.config;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Named
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy;
	
	public AuthenticationSuccessHandlerImpl() {
		redirectStrategy = new DefaultRedirectStrategy();
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		handle(request, response, authentication);
	}

	private void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		redirectStrategy.sendRedirect(request, response, determineUrl(authentication));
	}

	private String determineUrl(Authentication authentication) {
		String url = "/";

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		for (GrantedAuthority grantedAuthority : authorities) {
			String papel = grantedAuthority.getAuthority();

			switch (papel) {
				case "COORDENACAO":
					url = "/ofertas/";
					break;

				case "DIRECAO":
					url = "/compatilhamentos/";
					break;

				default:
					url = "/logout";
			}
		}
		
		return url;
	}
	
}
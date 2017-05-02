package ufc.quixada.npi.ap.util;

public class Constants {

	// LDAP
	public static final String LDAP_URL = "ldap.url";
	public static final String LDAP_BASE = "ldap.base";
	public static final String LDAP_USER = "ldap.user";
	public static final String LDAP_PASSWORD = "ldap.password";
	public static final String LDAP_OU = "ldap.ou";

	// Permissões
	public static final String PERMISSAO_COORDENACAO = "hasAuthority('COORDENACAO')";
	public static final String PERMISSAO_DIRECAO = "hasAuthority('DIRECAO')";
	public static final String PERMISSAO_DIRECAO_COORDENACAO = "hasAnyAuthority('DIRECAO,COORDENACAO')";

	// Mensagens
	public static final String MENSAGEM_PERMISSAO_NEGADA = "Permissão negada";
	public static final String LOGIN_INVALIDO = "Usuário e/ou senha inválidos";

	// Paginas
	public static final String PAGINA_ERRO_404 = "/error/404";
	public static final String PAGINA_ERRO_403 = "/error/403";
	public static final String PAGINA_ERRO_500 = "/error/500";

	// Periodo
	public static final String FORM_CADASTRAR_PERIODO = "/periodos/cadastrar-periodo";
	public static final String FORM_DETALHAR_PERIODO = "/periodos/detalhar-periodo";
	public static final String FORM_EDITAR_PERIODO = "/periodos/editar-periodo";
	public static final String EXCLUIR_PERIODO = "/periodos/excluir-periodo";
	public static final String INDEX_PERIODO  = "/periodos/index-periodo";
	

}
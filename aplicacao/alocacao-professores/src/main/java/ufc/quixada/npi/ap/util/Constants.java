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
	
	// Ofertas
	public static final String OFERTA_CADASTRAR = "/ofertas/cadastrar-oferta";
	public static final String OFERTA_EDITAR = "/ofertas/editar-oferta";
	public static final String OFERTA_LISTAR = "/ofertas/listar-oferta";
	public static final String OFERTA_DETALHAR = "/ofertas/detalhar-oferta";
	public static final String OFERTA_EXCLUIR = "/ofertas/excluir-oferta";
	
	// Compartilhamento
	public static final String COMPARTILHAMENTO_CADASTRAR = "compartilhamento/cadastrar-compartilhamento";
	public static final String COMPARTILHAMENTO_EDITAR = "compartilhamento/editar-compartilhamento";
	public static final String COMPARTILHAMENTO_LISTAR = "compartilhamento/listar-compartilhamento";
	public static final String COMPARTILHAMENTO_DETALHAR = "compartilhamento/detalhar-compartilhamento";
	public static final String COMPARTILHAMENTO_REDIRECT_LISTAR = "redirect:/compartilhamentos";

	// Periodo
	public static final String PERIODO_CADASTRAR = "/periodos/cadastrar-periodo";
	public static final String PERIODO_EDITAR = "/periodos/editar-periodo";
	public static final String PERIODO_LISTAR  = "/periodos/listar-periodo";
	public static final String PERIODO_DETALHAR = "/periodos/detalhar-periodo";
	public static final String PERIODO_EXCLUIR = "/periodos/excluir-periodo";
	public static final String PERIODO_REDIRECT_LISTAR = "redirect:/periodos/";
	
	// Disciplina
	public static final String DISCIPLINA_CADASTRAR_ = "disciplina/cadastrar-disciplina"; 
	public static final String DISCIPLINA_EDITAR = "disciplina/editar-disciplina";
	public static final String DISCIPLINA_LISTAR = "disciplina/listar-disciplinas";

	//Empilhamento
	public static final String EMPILHAMENTO_CADASTRAR = "empilhamento/cadastrar-empilhamento";
	public static final String EMPILHAMENTO_EDITAR = "empilhamento/editar-empilhamento";
	public static final String EMPILHAMENTO_LISTAR = "empilhamento/listar-empilhamento";
	public static final String EMPILHAMENTO_DETALHAR = "empilhamento/detalhar-empilhamento";
	public static final String EMPILHAMENTO_REDIRECT_PAGINA_LISTAR = "redirect:/empilhamentos";
	
}
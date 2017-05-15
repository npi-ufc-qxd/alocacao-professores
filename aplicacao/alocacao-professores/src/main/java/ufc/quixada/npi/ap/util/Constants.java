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
	public static final String FORM_CADASTRAR_OFERTA = "/ofertas/cadastrar-oferta";
	public static final String FORM_EDITAR_OFERTA = "/ofertas/editar-oferta";
	public static final String LISTAR_OFERTA = "/ofertas/listar-oferta";
	public static final String DETALHAR_OFERTA = "/ofertas/detalhar-oferta";
	public static final String EXCLUIR_OFERTA = "/ofertas/excluir-oferta";
	
	// Compartilhamento
	public static final String PAGINA_FORM_CADASTRAR_COMPARTILHAMENTO = "compartilhamento/cadastrar-compartilhamento";
	public static final String PAGINA_FORM_EDITAR_COMPARTILHAMENTO = "compartilhamento/editar-compartilhamento";
	public static final String PAGINA_LISTAR_COMPARTILHAMENTO = "compartilhamento/listar-compartilhamento";
	public static final String PAGINA_DETALHAR_COMPARTILHAMENTO = "compartilhamento/detalhar-compartilhamento";


	// Periodo
	public static final String FORM_CADASTRAR_PERIODO = "/periodos/cadastrar-periodo";
	public static final String FORM_DETALHAR_PERIODO = "/periodos/detalhar-periodo";
	public static final String FORM_EDITAR_PERIODO = "/periodos/editar-periodo";
	public static final String EXCLUIR_PERIODO = "/periodos/excluir-periodo";
	public static final String INDEX_PERIODO  = "/periodos/index-periodo";
	

	// Paginas - Disciplina
	public static final String FORMULARIO_CADASTRAR_DISCIPLINA = "disciplina/cadastrar_disciplina"; 
	public static final String FORMULARIO_EDITAR_DISCIPLINA = "disciplina/editar_disciplina";
	public static final String LISTAR_DISCIPLINAS = "disciplina/listar_disciplinas";
	
	public static final String PAGINA_FORM_CADASTRAR_EMPILHAMENTO = "empilhamento/cadastrar-empilhamento";
	public static final String PAGINA_FORM_EDITAR_EMPILHAMENTO = "empilhamento/editar-empilhamento";
	public static final String PAGINA_LISTAR_EMPILHAMENTO = "empilhamento/listar-empilhamento";
	public static final String PAGINA_DETALHAR_EMPILHAMENTO = "empilhamento/detalhar-empilhamento";
	
	// Redirects
	public static final String REDIRECT_PAGINA_LISTAR_COMPARTILHAMENTO = "redirect:/compartilhamentos";
	public static final String REDIRECT_PAGINA_LISTAR_EMPILHAMENTO = "redirect:/empilhamentos";
}
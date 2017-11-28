package ufc.quixada.npi.ap.util;

public class Constants {

	// LDAP
	public static final String LDAP_URL = "ldap.url";
	public static final String LDAP_BASE = "ldap.base";
	public static final String LDAP_USER = "ldap.user";
	public static final String LDAP_PASSWORD = "ldap.password";
	public static final String LDAP_OU = "ldap.ou";
	
	// Afiliações
	public static final String AFFILIATION_DOCENTE = "DOCENTE";

	// Permissões
	public static final String PERMISSAO_COORDENACAO = "hasAuthority('COORDENACAO')";
	public static final String PERMISSAO_DIRECAO = "hasAuthority('DIRECAO')";
	public static final String PERMISSAO_DIRECAO_COORDENACAO = "hasAnyAuthority('DIRECAO,COORDENACAO')";

	// Mensagens
	public static final String MSG_PERMISSAO_NEGADA = "Permissão negada";
	public static final String MSG_LOGIN_INVALIDO = "Usuário e/ou senha inválidos";

	// Paginas
	public static final String PAGINA_ERRO_404 = "/error/404";
	public static final String PAGINA_ERRO_403 = "/error/403";
	public static final String PAGINA_ERRO_500 = "/error/500";
	
	// Ofertas
	public static final String OFERTA_CADASTRAR = "/ofertas/cadastrar-oferta";
	public static final String OFERTA_IMPORTAR= "/ofertas/importar-oferta";
	public static final String OFERTA_EDITAR = "/ofertas/editar-oferta";
	public static final String OFERTA_LISTAR = "/ofertas/listar-oferta";
	public static final String OFERTA_DETALHAR = "/ofertas/detalhar-oferta";
	public static final String OFERTA_EXCLUIR = "/ofertas/excluir-oferta";
	public static final String OFERTA_REDIRECT_LISTAR = "redirect:/ofertas";
	public static final String OFERTA_CAMPUS_REDIRECT_LISTAR = "redirect:/oferta-campus";
	public static final String OFERTA_REDIRECT_CADASTRO = "redirect:/ofertas/cadastrar";
	public static final String OFERTA_CADASTRADA = "Oferta cadastrada com sucesso!";
	public static final String EXPORTAR = "/ofertas/exportar";
	public static final String OFERTA_EDITAR_DIRECAO = "/ofertas/editar-oferta-direcao";
	public static final String OFERTA_REDIRECT_EDITAR_DIRECAO = "redirect:/editar-oferta/";
	
	// Compartilhamento
	public static final String COMPARTILHAMENTO_CADASTRAR = "compartilhamento/cadastrar-compartilhamento";
	public static final String COMPARTILHAMENTO_CADASTRAR_DIRECAO = "compartilhamento/cadastrar-compartilhamento-direcao";
	public static final String COMPARTILHAMENTO_EDITAR = "compartilhamento/editar-compartilhamento";
	public static final String COMPARTILHAMENTO_LISTAR = "compartilhamento/listar-compartilhamento";
	public static final String COMPARTILHAMENTO_DETALHAR = "compartilhamento/detalhar-compartilhamento";
	public static final String COMPARTILHAMENTO_REDIRECT_LISTAR = "redirect:/compartilhamentos";

	// Periodo
	public static final String PERIODO_CADASTRAR = "periodo/cadastrar-periodo";
	public static final String PERIODO_DETALHAR = "periodo/detalhar-periodo";
	public static final String PERIODO_EDITAR = "periodo/editar-periodo";
	public static final String PERIODO_EXCLUIR = "periodo/excluir-periodo";
	public static final String PERIODO_LISTAR  = "periodo/listar-periodo";
	public static final String PERIODO_REDIRECT_LISTAR = "redirect:/periodos";
	
	// Disciplina
	public static final String DISCIPLINA_CADASTRAR = "disciplina/cadastrar-disciplina"; 
	public static final String DISCIPLINA_EDITAR = "disciplina/editar-disciplina";
	public static final String DISCIPLINA_LISTAR = "disciplina/listar-disciplinas";
	public static final String DISCIPLINA_REDIRECT_LISTAR = "redirect:/disciplinas";
	public static final String DISCIPLINA_REDIRECT_CADASTRAR = "redirect:/disciplinas/cadastrar";

	//Empilhamento
	public static final String EMPILHAMENTO_CADASTRAR = "empilhamento/cadastrar-empilhamento";
	public static final String EMPILHAMENTO_EDITAR = "empilhamento/editar-empilhamento";
	public static final String EMPILHAMENTO_LISTAR = "empilhamento/listar-empilhamento";
	public static final String EMPILHAMENTO_DETALHAR = "empilhamento/detalhar-empilhamento";
	public static final String EMPILHAMENTO_REDIRECT_LISTAR = "redirect:/empilhamentos";
	public static final String EMPILHAMENTO_LISTAR_DIRECAO = "empilhamento/listar-empilhamento-direcao"; 
	
	// Professor
	public static final String PROFESSOR_LISTAR = "professor/listar-professores";
	public static final String PROFESSOR_REDIRECT_LISTAR = "redirect:/professores";
	public static final String PROFESSOR_EDITAR = "professor/editar-professor";
	public static final String PROFESSOR_RELATORIO_CARGA_HORARIA = "professor/gerar-relatorio-carga-horaria-professor";
	
	//Exceptions
	public static final String EXCEPTION_PERIODO_INVALIDO = "Não há um período válido disponível";
	
	//Mensagens Sucesso
	public static final String SWAL_STATUS_SUCCESS = "success";
	public static final String MSG_DISCIPLINA_CADASTRAR_TITULO_SUCCESS = "Disciplina cadastrada!";
	public static final String MSG_DISCIPLINA_CADASTRADA = "A disciplina foi cadastrada com sucesso!";
	public static final String MSG_DISCIPLINA_EDITAR_TITULO_SUCCESS = "Disciplina editada com sucesso!";
	public static final String MSG_DISCIPLINA_EDITADA = "A disciplina foi editada com sucesso!";
	public static final String MSG_OFERTA_CADASTRADA = "Oferta cadastrada com sucesso!";
	public static final String MSG_OFERTA_EDITADA = "Oferta editada com sucesso!";
	public static final String MSG_PROFESSOR_EDITADO = "Professor editado com sucesso!";
	public static final String MSG_COMPARTILHAMENTO_EDITADO = "Compartilhamento editado com sucesso!";
	public static final String MSG_COMPARTILHAMENTO_SOLICITADO = "Compartilhamento solicitado com sucesso!";
	
	//Mensagens Erros
	public static final String STATUS_ERROR = "error";
	public static final String DISCIPLINA_CADASTRAR_TITULO_ERROR = "Erro ao cadastrar a disciplina";
	public static final String DISCIPLINA_CADASTRAR_EXISTENTE = "Já existe uma disciplina com esse código!";
	public static final String RESTRICAO_PERIODO = "Esta operação é restrita por períodos. Por favor verifique as datas do período.";
	public static final String SWAL_STATUS_ERROR = "error";
	public static final String MSG_DISCIPLINA_CADASTRAR_TITULO_ERROR = "Erro ao cadastrar a disciplina";
	public static final String MSG_DISCIPLINA_CADASTRAR_EXISTENTE = "Já existe uma disciplina com esse código!";
	
	//Prefixos das mensagens de erro de validação
	public static final String VALIDACAO_ERRO_INVALID = "invalid";
	public static final String VALIDACAO_ERRO_NULL = "null";
}
//var getUrl = window.location;
//var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];

var _ctx = $("meta[name='ctx']").attr("content");
var protocol = _ctx.split('//')[0];
var host = _ctx.split('/')[2];
var baseUrl = protocol + '//' + host;

var siglaCursoCoordenador = $('input[name=cursoAtual]').val();
var idCursoCoordenador = $('input[name=idCursoAtual]').val();
var idCursoSelecionado = idCursoCoordenador;

var periodos = document.getElementById("periodo");
var periodo = periodos.options[periodos.selectedIndex].text;

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

var baseUrl = $("meta[name='baseUrl']").attr("content");
if(baseUrl == null){
    baseUrl = "";
}

$('#visulizar-outras-ofertas').on('change', function (event) {
	$("#ofertas").empty();
	idCursoSelecionado = $('#visulizar-outras-ofertas').val();
	$.get(baseUrl + '/ofertas/curso/' + idCursoSelecionado, function() {
	})
	.done(function(results) {
		organizarOfertas(results);
	});
});

//Função que faz a requisição da lista de ofertas e de compartilhamentos quando a página é carregada
//result = model(ofertas e compartilhamentos)
$(window).load(function() {
	$.get(baseUrl + "/ofertas/listar", function() {
	})
	.done(function(result) {
		console.log(result);
			organizarOfertas(result);
	});
});

//Função que organiza a lista de ofertas por semestre
function organizarOfertas(result) {
	semestres = ['PRIMEIRO', 'SEGUNDO', 'TERCEIRO', 'QUARTO', 'QUINTO', 'SEXTO', 'SETIMO', 'OITAVO', 'NONO', 'DECIMO'];
	for(var i = 0; i <= 9; i++) {
		var semestre = semestres[i];
		var numberSemestre = i+1;
		criarEstrutura(semestre, numberSemestre, result.ofertas[0].turma.curso.sigla);
		var existe = false;
		var newRow = 0;
		var idNewRow = '';
		
		$.each(result.ofertas, function(key, value) {
			var professores = listarProfessoresOferta(value.professores);

			if(value.turma.semestre == semestre) {
				if(newRow%4 === 0) {
					idNewRow = 'rowPanel'+newRow+semestre;
				}
				
				criarPanelsOferta(value.turma.curso.id, value.turma.curso.sigla, value.disciplina.codigo, value.disciplina.nome, value.vagas, value.turno, professores, semestre, numberSemestre, value.id, newRow, idNewRow);
				existe = true;
				newRow++;
				
			}
		});

		$.each(result.compartilhamentos, function(key, value) {
			var professores = listarProfessoresOferta(value.oferta.professores);

			if(value.turma.semestre == semestre) {
				if(newRow%4 === 0) {
					idNewRow = 'rowPanel'+newRow+semestre;
				}
				numeroDoSemestreOferta = semestres.indexOf(value.oferta.turma.semestre) + 1;
				
				criarPanelsCompartilhamento(value.oferta.turma.curso.id, value.oferta.turma.curso.sigla, value.oferta.disciplina.codigo, value.oferta.disciplina.nome, value.vagas, value.oferta.turno, professores, semestre, numeroDoSemestreOferta, newRow, idNewRow, value.id);
				existe = true;
				newRow++;
				
			}
		});
		
		criarInforme(semestre, existe);
		//chama tanto quando for oferta quanto compartilhamento, e identifica pela urlExluir
		$(".sa-btn-excluir").on("click", function(event){
			event.preventDefault();

			var botaoExcluir = $(event.currentTarget);
			var urlExcluir = botaoExcluir.attr("href");
			
			swal({
				title: "Tem certeza?",
				text: "Você não poderá desfazer essa operação posteriormente!",
				type: "warning",   
				showCancelButton: true,
				cancelButtonText: "Cancelar",
				confirmButtonColor: "#DD6B55",
				confirmButtonText: "Sim, desejo excluir!",
				closeOnConfirm: false
			}, function(isConfirm){
				if(isConfirm){
					var response = $.ajax({
						url: urlExcluir,
						type: 'GET',
						success: function(result){
							if (result === true){
								if(urlExcluir.includes("/ofertas/"))
									successSwalOferta();
								else if(urlExcluir.includes("/compartilhamentos/"))
									successSwalCompartilhamento();
							}
							else{
								if(urlExcluir.includes("/ofertas/"))
									errorSwalOferta();
								else if(urlExcluir.includes("/compartilhamentos/"))
									errorSwalCompartilhamento();
							}
							
						},
						error: function(status, error){
							errorSwal();
						}
					});
				}
			});
		});
	}
}
//monta a msg de sucesso quando for uma oferta
function successSwalOferta(){
	swal({
		title: "Oferta excluída!",
		text: "A oferta foi excluída.",
		type: "success",
		showcancelButton: false,
		confirmButtonText: "Ok!",
		closeOnConfirm: true
	}, function(isConfirm){
		location.reload();
	});
}
//monta a msg de sucesso quando for um compartilhamento
function successSwalCompartilhamento(){
	swal({
		title: "Compartilhamento excluído!",
		text: "O compartilhamento foi excluído.", 
		type: "success",
		showcancelButton: false,
		confirmButtonText: "Ok!",
		closeOnConfirm: true
	}, function(isConfirm){
		location.reload();
	});
}

function errorSwalOferta(){
	swal({
		title: "Erro ao excluir",
		text: "A oferta foi excluída.",
		type: "error",
		showcancelButton: false,
		confirmButtonText: "Ok",
		closeOnConfirm: true
	});	
}

function errorSwalCompartilhamento(){
	swal({
		title: "Erro ao excluir",
		text: "O compartilhamento foi excluído.",
		type: "error",
		showcancelButton: false,
		confirmButtonText: "Ok",
		closeOnConfirm: true
	});	
}

//Função que cria a estrtura por semestre
function criarEstrutura(semestre, numberSemestre, sigla) {
	//var divContainer = document.createElement('div');
	//divContainer.setAttribute('class', 'container');
	
	var divRow = document.createElement('div');
	divRow.setAttribute('class', 'row');
	
	divRow.id = semestre;

	var div = document.createElement('div');
	div.setAttribute('class', 'col-md-12');
	var h5 = document.createElement('h5');
	h5.setAttribute('style', 'text-align: center');
	var b = document.createElement('b');
	b.appendChild(document.createTextNode(sigla+' - '+numberSemestre));
	var hr = document.createElement('hr');

	h5.appendChild(b);
	div.appendChild(h5);
	div.appendChild(hr);
	
	divRow.appendChild(div);
	
	$('#ofertas').append(divRow);
	
	if(sigla !== 'EC') {
		$('#NONO').hide();
		$('#DECIMO').hide();
	}
}

//Função que divide as ofertas em linhas com quatro ofertas
function criarRowsPanel(panel, semestre, newRow, idNewRow) {
	if(newRow%4 === 0) {
		var divRow = document.createElement('div');
		console.log(idNewRow);
		divRow.id = idNewRow;	
		divRow.setAttribute('class', 'row');
		
		divRow.appendChild(panel);
		$('#'+semestre).append(divRow);
	} else {
		$('#'+idNewRow).append(panel);
		$('#'+semestre).append($('#'+idNewRow));
	}
}


//Função que cria o panel para cada oferta
function criarPanelsOferta(idCurso, sigla, codigoDisciplina, nomeDisciplina, vagas, turno, professores, semestre, numberSemestre, idOferta, newRow, idNewRow){
	//Elementos html criados via Javascript
	var divCol = document.createElement('div');
	divCol.setAttribute('class', 'col-lg-4 col-md-4 col-sm-4 col-xs-12 panel-margin');
	
	var divPanel = document.createElement('div');
	
	var divRibbon = document.createElement('div');
	divRibbon.setAttribute('class', 'ribbon ribbon-vertical-r ribbon-success');
	var iconeRibbon = document.createElement('i');
	iconeRibbon .setAttribute('class', 'fa fa-share-alt');
	divRibbon.appendChild(iconeRibbon);

	var divPanelHeading = document.createElement('div');
	divPanelHeading.setAttribute('class', 'panel-heading');
	
	var label = document.createElement('label');
	var bold = document.createElement('b');
	
	bold.appendChild(document.createTextNode(sigla+numberSemestre + 
								' - ' + codigoDisciplina + ' - ' + nomeDisciplina));
	label.appendChild(bold);
	
	var divPanelAction = document.createElement('div');
	divPanelAction.setAttribute('class', 'panel-action');
	
	var divPanelWrapper = document.createElement('div');
	divPanelWrapper.setAttribute('class', 'panel-wrapper collapse in');
	
	var divPanelBody = document.createElement('div');
	divPanelBody.setAttribute('class', 'panel-body');
	
	var pVagas = document.createElement('p');
	var pTurno = document.createElement('p');
	var pProfessores = document.createElement('p');

	divPanel.setAttribute('class', 'panel panel-default');
	pVagas.appendChild(document.createTextNode("Vagas: " + vagas));
	
	var divPanelFooter = document.createElement('div');
	divPanelFooter.setAttribute('class', 'panel-footer');
	
	var divRowButton = document.createElement('div');
	divRowButton.setAttribute('class', 'row');
	
	var divColButton = document.createElement('div');
	divColButton.setAttribute('class', 'col-sm-12');
	
	var divButton = document.createElement('div');
	divButton.setAttribute('class', 'pull-right');
	
	if(idCursoSelecionado == idCursoCoordenador) {
		
		var iconeEditar = document.createElement('i');
		iconeEditar.setAttribute('class', 'fa fa-pencil');
		var buttonEditar = document.createElement('a');
		buttonEditar.href = baseUrl + '/ofertas/'+ idOferta + '/editar';
		buttonEditar.setAttribute('class', 'btn btn-info btn-acoes');
		buttonEditar.appendChild(iconeEditar);
		divButton.appendChild(buttonEditar);
			
		var iconeExcluir = document.createElement('i');
		iconeExcluir.setAttribute('class', 'fa fa-close');
		var buttonExcluir = document.createElement('a');
		buttonExcluir.href = baseUrl + '/ofertas/'+ idOferta + '/excluir';
		buttonExcluir.setAttribute('class', 'btn btn-danger btn-acoes sa-btn-excluir');
		buttonExcluir.appendChild(iconeExcluir);
		divButton.appendChild(buttonExcluir);
	} 
	else if(siglaCursoCoordenador != sigla) {
		var iconeShare = document.createElement('i');
		iconeShare.setAttribute('class', 'fa fa-share-alt');
		var buttonSolicitarCompartilhamento = document.createElement('a');
		buttonSolicitarCompartilhamento.href = baseUrl + '/ofertas/'+ idOferta + '/solicitar-compartilhamento';
		buttonSolicitarCompartilhamento.setAttribute('class', 'btn btn-inverse btn-acoes');
		buttonSolicitarCompartilhamento.appendChild(iconeShare);
		divButton.appendChild(buttonSolicitarCompartilhamento);
	}

	pTurno.appendChild(document.createTextNode("Turno: " + turno));
	pProfessores.appendChild(document.createTextNode("Professores: " + professores));

	divPanelBody.appendChild(pVagas);
	divPanelBody.appendChild(pTurno);
	divPanelBody.appendChild(pProfessores);
	
	divColButton.appendChild(divButton);
	
	divRowButton.appendChild(divColButton)
	
	divPanelFooter.appendChild(divRowButton);
	
	divPanelWrapper.appendChild(divPanelBody);
	divPanelWrapper.appendChild(divPanelFooter);
	
	divPanelHeading.appendChild(label);
	divPanelHeading.appendChild(divPanelAction);
	
	divPanel.appendChild(divPanelHeading);
	divPanel.appendChild(divPanelWrapper);
	
	
	divCol.appendChild(divPanel);
	criarRowsPanel(divCol, semestre, newRow, idNewRow);	
}

//Função que cria o panel para cada compartilhamento
function criarPanelsCompartilhamento(idCurso, sigla, codigoDisciplina, nomeDisciplina, vagas, turno, professores, semestre, numberSemestre, newRow, idNewRow, idCompartilhamento){

	var divCol = document.createElement('div');
	divCol.setAttribute('class', 'col-lg-4 col-md-4 col-sm-4 col-xs-12 panel-margin');
	
	var divPanel = document.createElement('div');
	
	var divRibbon = document.createElement('div');
	divRibbon.setAttribute('class', 'ribbon ribbon-vertical-r ribbon-success');
	var iconeRibbon = document.createElement('i');
	iconeRibbon .setAttribute('class', 'fa fa-share-alt');
	divRibbon.appendChild(iconeRibbon);

	var divPanelHeading = document.createElement('div');
	divPanelHeading.setAttribute('class', 'panel-heading');
	
	var label = document.createElement('label');
	var bold = document.createElement('b');
	
	bold.appendChild(document.createTextNode(sigla+numberSemestre + 
								' - ' + codigoDisciplina + ' - ' + nomeDisciplina));
	label.appendChild(bold);
	
	var divPanelAction = document.createElement('div');
	divPanelAction.setAttribute('class', 'panel-action');
	
	var divPanelWrapper = document.createElement('div');
	divPanelWrapper.setAttribute('class', 'panel-wrapper collapse in');
	
	var divPanelBody = document.createElement('div');
	divPanelBody.setAttribute('class', 'panel-body');
	
	var pVagas = document.createElement('p');
	var pTurno = document.createElement('p');
	var pProfessores = document.createElement('p');
	
	divPanel.setAttribute('class', 'panel panel-inverse');
	pVagas.appendChild(document.createTextNode("Vagas Solicitadas: " + vagas));
	
	var divPanelFooter = document.createElement('div');
	divPanelFooter.setAttribute('class', 'panel-footer');
	
	var divRowButton = document.createElement('div');
	divRowButton.setAttribute('class', 'row');
	
	var divColButton = document.createElement('div');
	divColButton.setAttribute('class', 'col-sm-12');
	
	var divButton = document.createElement('div');
	divButton.setAttribute('class', 'pull-right');

	var iconeEditar = document.createElement('i');
	iconeEditar.setAttribute('class', 'fa fa-pencil');
	var buttonEditar = document.createElement('a');
	buttonEditar.href = baseUrl + '/compartilhamentos/' + idCompartilhamento + '/editar';
	buttonEditar.setAttribute('class', 'btn btn-info btn-acoes');
	buttonEditar.appendChild(iconeEditar);
	divButton.appendChild(buttonEditar);

	var iconeExcluir = document.createElement('i');
	iconeExcluir.setAttribute('class', 'fa fa-close');
	var buttonExcluir = document.createElement('a');
	buttonExcluir.href = baseUrl + '/compartilhamentos/' + idCompartilhamento + '/excluir';
	buttonExcluir.setAttribute('class', 'btn btn-danger btn-acoes sa-btn-excluir');
	buttonExcluir.appendChild(iconeExcluir);
	divButton.appendChild(buttonExcluir);

	pTurno.appendChild(document.createTextNode("Turno: " + turno));
	pProfessores.appendChild(document.createTextNode("Professores: " + professores));

	divPanelBody.appendChild(pVagas);
	divPanelBody.appendChild(pTurno);
	divPanelBody.appendChild(pProfessores);
	
	divColButton.appendChild(divButton);
	
	divRowButton.appendChild(divColButton)
	
	divPanelFooter.appendChild(divRowButton);
	
	divPanelWrapper.appendChild(divPanelBody);
	divPanelWrapper.appendChild(divPanelFooter);
	
	divPanelHeading.appendChild(label);
	divPanelHeading.appendChild(divPanelAction);
	
	divPanel.appendChild(divPanelHeading);
	divPanel.appendChild(divPanelWrapper);
	
	
	divCol.appendChild(divPanel);
	criarRowsPanel(divCol, semestre, newRow, idNewRow);	
}

//Função que cria o panel de informe quando não há nenhuma oferta para determinado semestre
function criarInforme(semestre, existe) {
	if(existe === false) { 
		var divCol = document.createElement('div');
		divCol.setAttribute('class', 'col-md-12 panel-informe');
		
		var divPanel = document.createElement('div');
		divPanel.setAttribute('class', 'panel panel-default');
		
		var divPanelHeading = document.createElement('div');
		divPanelHeading.setAttribute('class', 'panel-heading');
		
		var label = document.createElement('p');
		var bold = document.createElement('b');
		label.setAttribute('class', 'text-center');
		
		bold.appendChild(document.createTextNode("As ofertas serão exibidas aqui"));
		label.appendChild(bold);
		
		divPanelHeading.appendChild(label);
		divPanel.appendChild(divPanelHeading);
		divCol.appendChild(divPanel);
		
		$('#'+semestre).append(divCol);
	}
}

//Função que transforma em string a lista de professores de uma oferta
function listarProfessoresOferta(professores) {
	var professorList = '';
	
	if(professores.length > 0) {
		$.each(professores, function(key, value) {
			professorList += ' : ' + value.pessoa.nome;	
		});
	} else {
		professorList = 'Não há professores para essa oferta.';
	}

	return professorList;
}


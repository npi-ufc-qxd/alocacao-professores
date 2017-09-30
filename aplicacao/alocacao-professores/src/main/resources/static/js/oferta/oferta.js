//var getUrl = window.location;
//var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];

var _ctx = $("meta[name='ctx']").attr("content");
var protocol = _ctx.split('//')[0];
var host = _ctx.split('/')[2];
var baseUrl = protocol + '//' + host;

var siglaCursoCoordenador = $('input[name=cursoAtual]').val();
var idCursoCoordenador = $('input[name=idCursoAtual]').val();
var idCursoSelecionado = idCursoCoordenador;

$('#btn-modal-importar-ofertas').on('click', function (event) {
	$('#resultado-ofertas-1').empty();
	$('#resultado-ofertas-2').empty();
	$('#sem-resultado-ofertas').empty();
	$('#modal-importar-ofertas').modal('show');
	
});

$('#visulizar-outras-ofertas').on('change', function (event) {
	$("#ofertas").empty();
	idCursoSelecionado = $('#visulizar-outras-ofertas').val();
	$.get(baseUrl + '/ofertas/curso/' + idCursoSelecionado, function() {
	})
	.done(function(results) {
		organizarOfertas(results);
	});
});

$('#btn-importar-ofertas').on('click', function (event) {
	importarOfertas();
});

var periodos = document.getElementById("periodo");
var periodo = periodos.options[periodos.selectedIndex].text;

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

var baseUrl = $("meta[name='baseUrl']").attr("content");
if(baseUrl == null){
    baseUrl = "";
}

function importarOfertas(){
	var disciplinas = $("input[name=ofertas]:checked").map(function() {
		return this.value;
	}).get().join(",");
	
	if(disciplinas.length > 0){
		alert(disciplinas)
		$.get(baseUrl + "/ofertas/importar", {disciplinas : disciplinas}, function() {
		})
		.done(function(retorno) {
			if(retorno === true){
				$('#modal-importar-ofertas').modal('toggle');
				importacaoRealizada();
			}
		});
	}
}

$('#btn-exibir-ofertas').click(function() {
	var periodo = document.getElementById("periodo").selectedIndex;
	var periodos = document.getElementById("periodo").options;
	var id = periodos[periodo].value;
	
	if(id > 0){
		$.get(baseUrl + "/ofertas/buscar-ofertas/" + id, function() {
			
		})
		.done(function(ofertas) {
			$('#resultado-ofertas-1').empty();
			$('#resultado-ofertas-2').empty();
			$('#sem-resultado-ofertas').empty();
			var index = 2;
			if(ofertas.length > 0){
				$.each(ofertas, function(key, value) {
					adicionarResultado(value.disciplina.id, "ofertas", '#resultado-ofertas-1', '#resultado-ofertas-2', value.disciplina.nome, "ofertas", index);	
					index++;
				});
			}else{
				adicionarMensagemSemResultado('#sem-resultado-ofertas');
			}
		});
	}
	
});

function adicionarMensagemSemResultado(coluna){
	var label = document.createElement('p');
    label.setAttribute('class','text-center');
    label.appendChild(document.createTextNode("Não foi encontrado resultado para a sua busca."));
    $(coluna).append(label);
}

function adicionarResultado(id, name, coluna1, coluna2, nome, classe, index){
	
	var checkbox = document.createElement('input');
	checkbox.className = classe;
	checkbox.type = "checkbox";
	checkbox.name = name;
	checkbox.value = id;
	checkbox.id = id;
	checkbox.setAttribute("nome", nome);
	
	var label = document.createElement('label')
	label.htmlFor = id;
	label.appendChild(document.createTextNode(nome));
	
	var lista1 = document.createElement('ul');
	lista1.id = 'resultado-disciplinas-1';
	lista1.setAttribute('class','list-unstyled');
	
	var lista2 = document.createElement('ul');
	lista2.id = 'resultado-disciplinas-2';
	lista2.setAttribute('class','list-unstyled');
	
	
	$(coluna1).append(lista1);
	$(coluna2).append(lista2);
	
	
	var ul1 = document.getElementById('resultado-disciplinas-1');
	var ul2 = document.getElementById('resultado-disciplinas-2');
	
	var li = document.createElement('li');
    li.appendChild(checkbox);
    li.appendChild(label);
    li.setAttribute('class', 'checkbox checkbox-success');
    
	
	if(index % 2 == 0){
		ul1.appendChild(li); 
	}else{
		ul2.appendChild(li);
	}
	
}

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
						successSwal();
					}
					else{
						errorSwal();
					}
					
				},
				error: function(status, error){
					errorSwal();
				}
			});
		}
	});
});

function importacaoRealizada(){
	swal({
		title: "Oferta(as) importadas!",
		text: "As oferta(as) selecionadas foram importadas.", 
		type: "success",
		showcancelButton: false,
		confirmButtonText: "Ok!",
		closeOnConfirm: true
	}, function(isConfirm){
		location.reload();
	});
}

function successSwal(){
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

function errorSwal(){
	swal({
		title: "Erro ao excluir",
		text: "A oferta não foi excluída.", 
		type: "error",
		showcancelButton: false,
		confirmButtonText: "Ok",
		closeOnConfirm: true
	});	
}

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
				
				criarPanelsOferta(value.turma.curso.id, value.turma.curso.sigla, value.disciplina.codigo, value.disciplina.nome, value.vagas, value.turno, professores, semestre, numberSemestre, value.id, newRow, idNewRow, -1);
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
				
				criarPanelsOferta(value.oferta.turma.curso.id, value.oferta.turma.curso.sigla, value.oferta.disciplina.codigo, value.oferta.disciplina.nome, value.vagas, value.oferta.turno, professores, semestre, numeroDoSemestreOferta, value.oferta.id, newRow, idNewRow, value.id);
				existe = true;
				newRow++;
				
			}
		});
		
		criarInforme(semestre, existe);
		
		$(".sa-btn-excluir-oferta").on("click", function(event){
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
								successSwal();
							}
							else{
								errorSwal();
							}
							
						},
						error: function(status, error){
							errorSwal();
						}
					});
				}
			});
		});
		//deve existir uma maneira melhor para não fazer este ctrl+c ctrl+v mas ainda encontrei
		$(".sa-btn-excluir-compartilhamento").on("click", function(event){
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
								successSwalC();
							}
							else{
								errorSwalC();
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
function criarPanelsOferta(idCurso, sigla, codigoDisciplina, nomeDisciplina, vagas, turno, professores, semestre, numberSemestre, idOferta, newRow, idNewRow, idCompartilhamento){
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
	
	bold.appendChild(document.createTextNode(sigla+numberSemestre + ' - ' + codigoDisciplina + ' - ' + nomeDisciplina));
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
	
	if(idCompartilhamento != -1){
		divPanel.setAttribute('class', 'panel panel-inverse');
		pVagas.appendChild(document.createTextNode("Vagas Solicitadas: " + vagas));

	} else {
		divPanel.setAttribute('class', 'panel panel-default');
		pVagas.appendChild(document.createTextNode("Vagas: " + vagas));
	}
	
	
	var divPanelFooter = document.createElement('div');
	divPanelFooter.setAttribute('class', 'panel-footer');
	
	var divRowButton = document.createElement('div');
	divRowButton.setAttribute('class', 'row');
	
	var divColButton = document.createElement('div');
	divColButton.setAttribute('class', 'col-sm-12');
	
	var divButton = document.createElement('div');
	divButton.setAttribute('class', 'pull-right');
	
	if(idCursoSelecionado == idCursoCoordenador) {

		if(siglaCursoCoordenador == sigla) {
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
			buttonExcluir.setAttribute('class', 'btn btn-danger btn-acoes sa-btn-excluir-oferta');
			buttonExcluir.appendChild(iconeExcluir);
			divButton.appendChild(buttonExcluir);
			
		} else {
//			divPanel.appendChild(divRibbon);
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
			buttonExcluir.setAttribute('class', 'btn btn-danger btn-acoes sa-btn-excluir-compartilhamento');
			buttonExcluir.appendChild(iconeExcluir);
			divButton.appendChild(buttonExcluir);
		
		}
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

	//Inserindo elementos filhos nos elementos pai
	//pVagas.appendChild(document.createTextNode("Vagas: " + vagas));
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

//$('#btn-modal-importar-ofertas').on('click', function (event) {
//	limparResultadosImportacao();
//	$('#modal-importar-ofertas').modal('show');
//	
//});

$('#btn-importar-ofertas').on('click', function (event) {
	importarOfertas();
});


$('#btn-substituir-ofertas').on('click', function (event) {
	substituirOfertas();
});

var periodos = document.getElementById("periodo");
var periodo = periodos.options[periodos.selectedIndex].text;

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

var baseUrl = $("meta[name='baseUrl']").attr("content");
if(baseUrl == null){
    baseUrl = "";
}

function limparResultadosImportacao(){
	$('#resultado-ofertas-1').empty();
	$('#resultado-ofertas-2').empty();
	$('#sem-resultado-ofertas').empty();
	$('#resultado-substituicao-ofertas-1').empty();
	$('#resultado-substituicao-ofertas-2').empty();
}

function substituirOfertas(){
	var ofertas = $("input[name=ofertas]:checked").map(function() {
		return this.value;
	}).get().join(",");
	console.log(ofertas);
	if(ofertas.length > 0){
		$.get(baseUrl + "/ofertas/substituicao-ofertas", {ofertas : ofertas}, function() {
		})
		.done(function(resultado) {
			if(resultado === true){
				$('#modal-substituir-ofertas').modal('toggle');
				importacaoRealizada(true, false);
			}else{
				errorSubstituirOferta();
			}
		});
	}
}

function importarOfertas(){
	var ofertas = $("input[name=ofertas]:checked").map(function() {
		return this.value;
	}).get().join(",");
	
	if(ofertas.length > 0){
		$.get(baseUrl + "/ofertas/importar", {ofertas : ofertas}, function() {
		})
		.done(function(ofertas) {
				importacaoRealizada(ofertas.importada, ofertas.substituir);
				$('#modal-importar-ofertas').modal('toggle');
				limparResultadosImportacao();
				console.log(ofertas);
				var index = 2;
				$.each(ofertas.contidas, function(key, value) {
					adicionarResultado(value.id, "ofertas", '#resultado-substituicao-ofertas-1', '#resultado-substituicao-ofertas-2', value.disciplina.nome, "ofertas", index);	
					index++;
				});
			
		});
	}
}



$('#btn-exibir-ofertas').click(function() {
	var periodo = document.getElementById("periodo").selectedIndex;
	var periodos = document.getElementById("periodo").options;
	var id = periodos[periodo].value;
	
	if(id > 0){
		$.get(baseUrl + "/ofertas/buscar-ofertas/" + id, function() {
			
		})
		.done(function(ofertas) {
			limparResultadosImportacao();
			var index = 2;
			if(ofertas.length > 0){
				$.each(ofertas, function(key, value) {
					adicionarResultado(value.id, "ofertas", '#resultado-ofertas-1', '#resultado-ofertas-2', value.disciplina.nome, "ofertas", index);	
					index++;
				});
			}else{
				adicionarMensagemSemResultado('#sem-resultado-ofertas');
			}
		});
	}
	
});

function adicionarMensagemSemResultado(coluna){
	var label = document.createElement('p');
    label.setAttribute('class','text-center');
    label.appendChild(document.createTextNode("Não foi encontrado resultado para a sua busca."));
    $(coluna).append(label);
}

function adicionarResultado(id, name, coluna1, coluna2, nome, classe, index){
	
	var checkbox = document.createElement('input');
	checkbox.className = classe;
	checkbox.type = "checkbox";
	checkbox.name = name;
	checkbox.value = id;
	checkbox.id = id;
	checkbox.setAttribute("nome", nome);
	
	
	var label = document.createElement('label')
	label.htmlFor = id;
	label.appendChild(document.createTextNode(nome));
	
	if(index === 2){
	
		var lista1 = document.createElement('ul');
		lista1.id = 'resultado-disciplinas-1';
		lista1.setAttribute('class','list-unstyled');
	
		var lista2 = document.createElement('ul');
		lista2.id = 'resultado-disciplinas-2';
		lista2.setAttribute('class','list-unstyled');
	
	
		$(coluna1).append(lista1);
		$(coluna2).append(lista2);
	}
	
	var ul1 = document.getElementById('resultado-disciplinas-1');
	var ul2 = document.getElementById('resultado-disciplinas-2');
	
	var li = document.createElement('li');
    li.appendChild(checkbox);
    li.appendChild(label);
    li.setAttribute('class', 'checkbox checkbox-success');
    
	
	if(index % 2 == 0){
		ul1.appendChild(li); 
	}else{
		ul2.appendChild(li);
	}
	
}


function importacaoRealizada(importada, substituir) {
//	if (importada && !substituir) {
//		swal({
//			title : "Oferta(as) importadas!",
//			text : "As oferta(as) selecionadas foram importadas.",
//			type : "success",
//			showcancelButton : false,
//			confirmButtonText : "Ok!",
//			closeOnConfirm : true
//		}, function(isConfirm) {
//			$('#modal-substituir-ofertas').modal('show');
//		});
//	}else 
	if(!importada && substituir){
		$('#modal-substituir-ofertas').modal('show');
	}else if(importada && !substituir){
		swal({
			title : "Oferta(as) importadas!",
			text : "As oferta(as) selecionadas foram importadas.",
			type : "success",
			showcancelButton : false,
			confirmButtonText : "Ok!",
			closeOnConfirm : true
		}, function(isConfirm) {
			location.reload();
		});
	}
}

function successSwalC(){
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

function errorSubstituirOferta(){
	swal({
		title: "Erro ao substituir",
		text: "A(s) oferta(s) não foi(ram) substituída(s).", 
		type: "error",
		showcancelButton: false,
		confirmButtonText: "Ok",
		closeOnConfirm: true
	});	
}

function errorSwalC(){
	swal({
		title: "Erro ao excluir",
		text: "O compartilhamento não foi excluído.", 
		type: "error",
		showcancelButton: false,
		confirmButtonText: "Ok",
		closeOnConfirm: true
	});	
}

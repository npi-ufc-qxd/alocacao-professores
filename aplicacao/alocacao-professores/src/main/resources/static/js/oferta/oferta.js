$('#btn-modal-importar-ofertas').on('click', function (event) {
	$('#resultado-ofertas-1').empty();
	$('#resultado-ofertas-2').empty();
	$('#sem-resultado-ofertas').empty();
	$('#modal-importar-ofertas').modal('show');
	
});

$('#btn-importar-ofertas').on('click', function (event) {
	importarOfertas();
});

var periodos = document.getElementById("periodo");
var periodo = periodos.options[periodos.selectedIndex].text;

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

var _context = $("meta[name='_context']").attr("content");
if(_context == null){
    _context = "";
}

function importarOfertas(){
	var disciplinas = $("input[name=ofertas]:checked").map(function() {
		return this.value;
	}).get().join(",");
	
	if(disciplinas.length > 0){
		$.get(_context + "/ofertas/importar", {disciplinas : disciplinas}, function() {
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
		$.get(_context + "/ofertas/buscar-ofertas/" + id, function() {
			
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

//Função que faz a requisição da lista de ofertas quando a página é carregada
$(window).load(function() {
	$.get(_context + "/ofertas/listar", function() {
	})
	.done(function(ofertas) {
		console.log(ofertas)
		if(ofertas.length > 0){
			organizarOfertas(ofertas);
		}
	});
});

//Função que organiza a lista de ofertas por semestre
function organizarOfertas(ofertas) {
	semestres = ['PRIMEIRO', 'SEGUNDO', 'TERCEIRO', 'QUARTO', 'QUINTO', 'SEXTO', 'SETIMO', 'OITAVO', 'NONO', 'DECIMO'];
	for(var i = 0; i <= 9; i++) {
		var semestre = semestres[i];
		var numberSemestre = i+1;
		criarEstrutura(semestre, ofertas[0].turma.curso.sigla);
		var existe = false;
		var newRow = 0;
		var idNewRow = '';
		
		$.each(ofertas, function(key, value) {
			var professores = listarProfessoresOferta(value.professores);
			if(value.turma.semestre == semestre) {
				if(newRow%4 === 0) {
					idNewRow = 'rowPanel'+newRow+semestre;
				}
				
				criarPanelsOferta(value.turma.curso.sigla, value.disciplina.codigo, value.disciplina.nome, value.vagas, value.turno, professores, semestre, numberSemestre, newRow, idNewRow);
				existe = true;
				newRow++;
				
			} 
		});
		
		criarInforme(semestre, existe);
	}
}


//Função que cria a estrtura por semestre
function criarEstrutura(semestre, sigla) {
	//var divContainer = document.createElement('div');
	//divContainer.setAttribute('class', 'container');
	
	var divRow = document.createElement('div');
	divRow.setAttribute('class', 'row');
	
	divRow.id = semestre;
	
	var b = document.createElement('b');
	b.setAttribute('class', 'col-md-12');
	b.appendChild(document.createTextNode(semestre));
	
	divRow.appendChild(b);
	//divContainer.appendChild(divRow);
	
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
function criarPanelsOferta(sigla, codigoDisciplina, nomeDisciplina, vagas, turno, professores, semestre, numberSemestre, newRow, idNewRow){
	//Elementos html criados via Javascript
	var divCol = document.createElement('div');
	divCol.setAttribute('class', 'col-lg-4 col-md-4 col-sm-4 col-xs-12 panel-margin');
	
	var divPanel = document.createElement('div');
	divPanel.setAttribute('class', 'panel panel-default');
	
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
	
	var divPanelFooter = document.createElement('div');
	divPanelFooter.setAttribute('class', 'panel-footer');
	
	var divRowButton = document.createElement('div');
	divRowButton.setAttribute('class', 'row');
	
	var divColButton = document.createElement('div');
	divColButton.setAttribute('class', 'col-sm-12');
	
	var divButton = document.createElement('div');
	divButton.setAttribute('class', 'pull-right');
	
	var buttonEditar = document.createElement('a');
	buttonEditar.href = '#';
	buttonEditar.appendChild(document.createTextNode("Editar"));
	buttonEditar.setAttribute('class', 'btn btn-info btn-acoes');
	
	var buttonExcluir = document.createElement('a');
	buttonExcluir.href = '#';
	buttonExcluir.appendChild(document.createTextNode("Excluir"));
	buttonExcluir.setAttribute('class', 'btn btn-danger btn-acoes');
	
	//Inserindo elementos filhos nos elementos pai
	pVagas.appendChild(document.createTextNode("Vagas: " + vagas));
	pTurno.appendChild(document.createTextNode("Turno: " + turno));
	pProfessores.appendChild(document.createTextNode("Professores: " + professores));

	divPanelBody.appendChild(pVagas);
	divPanelBody.appendChild(pTurno);
	divPanelBody.appendChild(pProfessores);
	
	divButton.appendChild(buttonEditar);
	divButton.appendChild(buttonExcluir);
	
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

var _context = $("meta[name='_context']").attr("content");
if(_context == null){
    _context = "";
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
		$.get(_context + "/ofertas/substituicao-ofertas", {ofertas : ofertas}, function() {
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
		$.get(_context + "/ofertas/importar", {ofertas : ofertas}, function() {
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
		$.get(_context + "/ofertas/buscar-ofertas/" + id, function() {
			
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

function importacaoRealizada(importada, substituir) {
	if (importada && substituir) {
		swal({
			title : "Oferta(as) importadas!",
			text : "As oferta(as) selecionadas foram importadas.",
			type : "success",
			showcancelButton : false,
			confirmButtonText : "Ok!",
			closeOnConfirm : true
		}, function(isConfirm) {
			$('#modal-substituir-ofertas').modal('show');
		});
	}else if(!importada && substituir){
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

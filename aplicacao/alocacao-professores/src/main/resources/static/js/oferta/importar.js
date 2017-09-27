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
	.done(function(ofertas) {
		console.log(ofertas)
		if(ofertas.length > 0){
			organizarOfertas(ofertas);
		}
	});
});

$('#btn-exibir-ofertas').click(function() {
	var periodo = document.getElementById("periodo").selectedIndex;
	var periodos = document.getElementById("periodo").options;
	var id = periodos[periodo].value;
	
	if(id > 0){
		$.get(baseUrl + "/ofertas/buscar-ofertas/" + id, function() {
			
		})
		.done(function(ofertas) {
			limparResultadosImportacao();
			$('#sem-resultado-ofertas').empty();
			
			if(ofertas.length > 0){
				$.each(ofertas, function(key, oferta) {
					adicionarResultadoTabela(oferta.id, "ofertas", '#resultado-ofertas', oferta.disciplina.nome, oferta.vagas, oferta.turma.curso.sigla, oferta.turma.semestre, oferta.turno, "ofertas");	
				});
			}else{
				adicionarMensagemSemResultado('#sem-resultado-ofertas');
			}
		});
	}
	
});

$('#btn-limpar-ofertas').on('click', function (event) {
	limparResultadosImportacao();
});

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

function adicionarMensagemSemResultado(coluna){
	var label = document.createElement('p');
    label.setAttribute('class','text-center');
    label.appendChild(document.createTextNode("Não foi encontrado resultado para a sua busca."));
    $(coluna).append(label);
}

function adicionarResultadoTabela(id, inputName, idTabela, nomeDisciplina, vagas, siglaCurso, semestre, turno, classe){
	var semestres = ['PRIMEIRO', 'SEGUNDO', 'TERCEIRO', 'QUARTO', 'QUINTO', 'SEXTO', 'SETIMO', 'OITAVO', 'NONO', 'DECIMO'];
	
	var checkbox = document.createElement('input');
	checkbox.className = classe;
	checkbox.type = "checkbox";
	checkbox.name = inputName;
	checkbox.value = id;
	checkbox.id = id;
	checkbox.setAttribute("nome", nomeDisciplina);
	
	var label = document.createElement('label')
	label.htmlFor = id;
	label.appendChild(document.createTextNode(nomeDisciplina));
	
	var tabela = $(idTabela);	
	var divTabela = tabela.parent();
	var corpoTabela = tabela.find('tbody');
	
	var linha = document.createElement('tr');
	
	var colunaNome = document.createElement('td');
	var colunaVagas = document.createElement('td');
	var colunaTurma = document.createElement('td');
	var colunaTurno = document.createElement('td');
	
	var ul = document.createElement('ul');
	
	var li = document.createElement('li');
	li.appendChild(checkbox);
	li.appendChild(label);
	li.setAttribute('class', 'checkbox checkbox-success');
	
	ul.id = 'lista-ofertas';
	ul.setAttribute('class','list-unstyled');
	ul.appendChild(li);
	
	colunaNome.appendChild(ul);
	
	colunaVagas.appendChild(document.createTextNode(vagas));
	
	colunaTurno.appendChild(document.createTextNode(turno));
	
	colunaTurma.appendChild(document.createTextNode(siglaCurso + '-' + (semestres.indexOf(semestre) + 1)));
	
	linha.appendChild(colunaNome);
	linha.appendChild(colunaTurma);
	linha.appendChild(colunaTurno);
	linha.appendChild(colunaVagas);
	
	corpoTabela.append(linha);
	
	divTabela.removeClass('hidden');
}

var periodos = document.getElementById("periodo");
var periodo = periodos.options[periodos.selectedIndex].text;

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

var baseUrl = $("meta[name='baseUrl']").attr("content");
if(baseUrl == null){
    baseUrl = "";
}

function limparResultadosImportacao(){
	var tabela = $('#resultado-ofertas');
	var divTabela = tabela.parent();
	var corpoTabela = tabela.find('tbody');
	
	divTabela.addClass('hidden');
	corpoTabela.empty();
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
		$.get(baseUrl + "/ofertas/importar-2", {ofertas : ofertas}, function() {
		})
		.done(function(retorno) {
			if(retorno)
				importacaoRealizada(retorno.importada, retorno.substituir);
		});
	}
}

function importacaoRealizada(importada, substituir) {
	if(!importada && substituir){
		swal({
			title : "Erro ao importar oferta(s)",
			text : "As oferta(as) selecionadas não foram importadas.",
			type : "error",
			showcancelButton : false,
			confirmButtonText : "Ok!",
			closeOnConfirm : true
		}, function(isConfirm) {
		});

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

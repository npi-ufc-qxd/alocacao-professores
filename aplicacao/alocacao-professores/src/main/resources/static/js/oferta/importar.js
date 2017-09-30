//var token = $("meta[name='_csrf']").attr("content");
//var header = $("meta[name='_csrf_header']").attr("content");

var _ctx = $("meta[name='ctx']").attr("content");
var protocol = _ctx.split('//')[0];
var host = _ctx.split('/')[2];
var baseUrl = protocol + '//' + host;

var baseUrl = $("meta[name='baseUrl']").attr("content");
if (baseUrl == null) {
	baseUrl = "";
}

$('#btn-exibir-ofertas').click(function() {
	exibirOfertas();
});

$('#btn-limpar-ofertas').on('click', function (event) {
	limparResultadosImportacao();
});

$('#btn-importar-ofertas').on('click', function (event) {
	importarOfertas();
});

$('#btn-importar-ofertas-compartilhadas').on('click', function (event) {
	importarOfertasCompartilhadas();
});

function exibirOfertas() {
	var periodoSelecionado = document.getElementById("periodo").selectedIndex;
	var periodos = document.getElementById("periodo").options;
	var idPeriodo = periodos[periodoSelecionado].value;
	
	if(idPeriodo > 0){
		$.get(baseUrl + "/ofertas/buscar-ofertas/" + idPeriodo, function() {
		})
		.done(function(retorno) {
			var ofertas = retorno.ofertas;
			var ofertasCompartilhadas = retorno.ofertasCompartilhadas;
			var ofertasImportadas = retorno.ofertasImportadas;
			
			limparResultadosImportacao();
			
			if (ofertas.length > 0)
				adicionarResultadoTabela(ofertas, 'ofertas', 'ofertas', '#resultado-ofertas');
			
			if (ofertasCompartilhadas.length > 0)
				adicionarResultadoTabelaCompartilhadas(ofertasCompartilhadas, 'ofertas-compartilhadas', 'ofertas-compartilhadas', '#resultado-ofertas-compartilhadas');
			
			if (ofertasImportadas.length > 0)
				adicionarResultadoTabelaImportadas(ofertasImportadas, '#resultado-ofertas-importadas');
		});
	}
}

function criarCheckboxOferta(idOferta, inputName, className, value) {
	var checkbox = document.createElement('input');
	checkbox.type = "checkbox";
	checkbox.id = idOferta
	checkbox.name = inputName;
	checkbox.className = className;
	checkbox.value = idOferta;
	
	return checkbox;
}

function criarLabelOferta(idInput, text) {
	var label = document.createElement('label')
	label.htmlFor = idInput;
	label.appendChild(document.createTextNode(text));
	
	return label;
}


function criarListaOferta(inputName, checkbox, label) {
	var li = document.createElement('li');
	li.setAttribute('class', 'checkbox checkbox-success');
	li.appendChild(checkbox);
	li.appendChild(label);
	
	var ul = document.createElement('ul');	
	ul.id = inputName;
	ul.setAttribute('class','list-unstyled');
	ul.appendChild(li);
	
	return ul;
}

function criarLinhaTabela(colunas) {
	var linha = document.createElement('tr');
	
	$.each(colunas, function(key, coluna) {
		adicionarColunaTabela(linha, coluna);
	});
	
	return linha;
}

function getNumeroSemestre(semestre){
	var semestres = ['PRIMEIRO', 'SEGUNDO', 'TERCEIRO', 'QUARTO', 'QUINTO', 'SEXTO', 'SETIMO', 'OITAVO', 'NONO', 'DECIMO'];
	return semestres.indexOf(semestre) + 1;
}

function adicionarResultadoTabelaCompartilhadas(compartilhamentos, inputName, classe, idTabela){
	$.each(compartilhamentos, function(key, compartilhamento){
		var oferta = compartilhamento.oferta;
		
		var tabela = $(idTabela);
		var divTabela = tabela.parent();
		var corpoTabela = $(tabela).find('tbody');
		
		var checkbox = criarCheckboxOferta(compartilhamento.id, inputName, classe, compartilhamento.id);
		var label = criarLabelOferta(compartilhamento.id, oferta.disciplina.nome);

		var colNome = criarListaOferta('lista-' + inputName, checkbox, label);
		var colTurmaOriginal = document.createTextNode(oferta.turma.curso.sigla + '-' + getNumeroSemestre(oferta.turma.semestre));
		var colTurmaCurso = document.createTextNode(compartilhamento.turma.curso.sigla + '-' + getNumeroSemestre(compartilhamento.turma.semestre));
		var colTurno = document.createTextNode(oferta.turno);
		var colVagas = document.createTextNode(oferta.vagas);
		
		var colunas = [colNome, colTurmaOriginal, colTurmaCurso, colTurno, colVagas];
		var linha = criarLinhaTabela(colunas);
		
		corpoTabela.append(linha);
		
		divTabela.removeClass('hidden');
	});
}

function adicionarResultadoTabela(ofertas, inputName, classe, idTabela){
	$.each(ofertas, function(key, oferta){
		var tabela = $(idTabela);
		var divTabela = tabela.parent();
		var corpoTabela = $(tabela).find('tbody');
		
		var checkbox = criarCheckboxOferta(oferta.id, inputName, classe, oferta.id);
		var label = criarLabelOferta(oferta.id, oferta.disciplina.nome);
		
		var colNome = criarListaOferta('lista-' + inputName, checkbox, label);
		var colTurma = document.createTextNode(oferta.turma.curso.sigla + '-' + getNumeroSemestre(oferta.turma.semestre));
		var colTurno = document.createTextNode(oferta.turno);
		var colVagas = document.createTextNode(oferta.vagas);
		
		var colunas = [colNome, colTurma, colTurno, colVagas];
		var linha = criarLinhaTabela(colunas);
		
		corpoTabela.append(linha);
		
		divTabela.removeClass('hidden');
	});
}

function adicionarColunaTabela(linha, conteudo){
	var coluna = document.createElement('td');
	coluna.appendChild(conteudo);
	
	linha.appendChild(coluna);
}

function adicionarResultadoTabelaImportadas(ofertas, idTabela){
	$.each(ofertas, function(key, oferta) {
		var label = criarLabelOferta(undefined, oferta.disciplina.nome);
		
		var tabela = $(idTabela);
		var divTabela = tabela.parent();
		var corpoTabela = tabela.find('tbody');
		
		var colNome = label;
		var colTurma = document.createTextNode(oferta.turma.curso.sigla + '-' + getNumeroSemestre(oferta.turma.semestre));
		var colTurno = document.createTextNode(oferta.turno);
		var colVagas = document.createTextNode(oferta.vagas);
		
		var colunas = [colNome, colTurma, colTurno, colVagas];
		var linha = criarLinhaTabela(colunas);
		
		corpoTabela.append(linha);
		
		divTabela.removeClass('hidden');
	})
}

function adicionarMensagemSemResultado(elemento){
	$(elemento).removeClass('hidden');
}

function limparTabela(idTabela) {
	var tabela = $(idTabela);
	var corpoTabela = tabela.find('tbody');
	var divTabela = tabela.parent();
	
	divTabela.addClass('hidden');
	corpoTabela.empty();
}

function limparResultadosImportacao() {
	var semResultadosOfertas = $('#sem-resultado-ofertas');
	
	limparTabela('#resultado-ofertas');
	limparTabela('#resultado-ofertas-compartilhadas');
	limparTabela('#resultado-ofertas-importadas');
	
	semResultadosOfertas.addClass('hidden');
}

function getOfertasSelecionadas(inputName) {
	var ofertas = $("input[name=" + inputName + "]:checked").map(function() {
		return this.value;
	}).get().join(",");
	
	return ofertas;
}

function importarOfertas(){
	var ofertas = getOfertasSelecionadas("ofertas");
	
	if(ofertas.length > 0) {
		$.get(baseUrl + "/ofertas/importar-ofertas", {ofertas : ofertas}, function() {
		})
		.done(function(retorno) {
			if(retorno)
				resultadoImportacao(retorno.importada);
		});
	}
}

function importarOfertasCompartilhadas(inputName){
	var compartilhamentos = getOfertasSelecionadas("ofertas-compartilhadas");
	
	if(compartilhamentos.length > 0) {
		$.get(baseUrl + "/ofertas/importar-ofertas-compartilhadas", {compartilhamentos : compartilhamentos}, function() {
		})
		.done(function(retorno) {
			if(retorno)
				resultadoImportacao(retorno.importada);
		});
	}
}

function resultadoImportacao(importada) {
	if(!importada)
		errorImportarOferta();
	else
		sucessImportarOferta();
}

function sucessImportarOferta() {
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

function errorImportarOferta() {
	swal({
		title : "Erro ao importar oferta(s)",
		text : "As oferta(as) selecionadas não foram importadas.",
		type : "error",
		showcancelButton : false,
		confirmButtonText : "Ok!",
		closeOnConfirm : true
	}, function(isConfirm) {
	});
}
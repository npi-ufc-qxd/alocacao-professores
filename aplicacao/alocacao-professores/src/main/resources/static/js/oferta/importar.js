var _ctx = $("meta[name='ctx']").attr("content");
var protocol = _ctx.split('//')[0];
var host = _ctx.split('/')[2];
var baseUrl = protocol + '//' + host;

var baseUrl = $("meta[name='baseUrl']").attr("content");
if (baseUrl == null)
	baseUrl = "";

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
		limparResultadosImportacao();
		
		$.get(baseUrl + "/ofertas/buscar-ofertas/" + idPeriodo, function() {
		})
		.done(function(retorno) {
			var ofertas = retorno.ofertas;
			var ofertasCompartilhadas = retorno.ofertasCompartilhadas;
			var ofertasImportadas = retorno.ofertasImportadas;
			var ofertasCompartilhadasImportadas = retorno.ofertasCompartilhadasImportadas;
			
			var divResultados = $('#resultados');
			
			if (ofertas.length > 0)
				adicionarResultadoOfertas(ofertas, 'ofertas', 'ofertas', '#resultado-ofertas');
			
			if (ofertasCompartilhadas.length > 0)
				adicionarResultadoOfertasCompartilhadas(ofertasCompartilhadas, 'ofertas-compartilhadas', 'ofertas-compartilhadas', '#resultado-ofertas-compartilhadas');
			
			if (ofertasImportadas.length > 0)
				adicionarResultadoOfertasImportadas(ofertasImportadas, '#resultado-ofertas-importadas');
			
			if (ofertasCompartilhadasImportadas.length > 0)
				adicionarResultadoOfertasCompartilhadasImportadas(ofertasCompartilhadasImportadas, 'ofertas-compartilhadas-importadas', 'ofertas-compartilhadas-importadas', '#resultado-ofertas-compartilhadas-importadas');
			
			divResultados.removeClass('hidden');
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

function criarColunaTabela(conteudo){
	var coluna = document.createElement('td');
	coluna.appendChild(conteudo);
	
	return coluna;
}

function criarLinhaTabela(colunas) {
	var linha = document.createElement('tr');
	
	$.each(colunas, function(key, coluna) {
		var coluna = criarColunaTabela(coluna);
		
		linha.appendChild(coluna);
	});
	
	return linha;
}

function criarListaOferta(inputName, checkbox, label) {
	var itemLista = document.createElement('li');
	itemLista.setAttribute('class', 'checkbox checkbox-success');
	itemLista.appendChild(checkbox);
	itemLista.appendChild(label);
	
	var lista = document.createElement('ul');	
	lista.id = inputName;
	lista.setAttribute('class','list-unstyled');
	lista.appendChild(itemLista);
	
	return lista;
}

function getNumeroSemestre(semestre){
	var semestres = ['PRIMEIRO', 'SEGUNDO', 'TERCEIRO', 'QUARTO', 'QUINTO', 'SEXTO', 'SETIMO', 'OITAVO', 'NONO', 'DECIMO'];
	return semestres.indexOf(semestre) + 1;
}

function adicionarResultadoOfertas(ofertas, inputName, classe, idTabela){
	var tabela = $(idTabela);
	var corpoTabela = $(tabela).find('tbody');
	
	$.each(ofertas, function(key, oferta){
		var checkbox = criarCheckboxOferta(oferta.id, inputName, classe, oferta.id);
		var label = criarLabelOferta(oferta.id, oferta.disciplina.nome);
		
		var colNome = criarListaOferta('lista-' + inputName, checkbox, label);
		var colTurma = document.createTextNode(oferta.turma.curso.sigla + '-' + getNumeroSemestre(oferta.turma.semestre));
		var colTurno = document.createTextNode(oferta.turno);
		var colVagas = document.createTextNode(oferta.vagas);
		
		var colunas = [colNome, colTurma, colTurno, colVagas];
		var linha = criarLinhaTabela(colunas);
		
		corpoTabela.append(linha);
	});
}

function adicionarResultadoOfertasCompartilhadas(compartilhamentos, inputName, classe, idTabela){
	var tabela = $(idTabela);
	var corpoTabela = $(tabela).find('tbody');
	
	$.each(compartilhamentos, function(key, compartilhamento){
		var oferta = compartilhamento.oferta;
		
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
	});
}

function adicionarResultadoOfertasImportadas(ofertas, idTabela){
	var tabela = $(idTabela);
	var corpoTabela = tabela.find('tbody');
	
	$.each(ofertas, function(key, oferta) {
		var label = criarLabelOferta(undefined, oferta.disciplina.nome);
		
		var colNome = label;
		var colTurma = document.createTextNode(oferta.turma.curso.sigla + '-' + getNumeroSemestre(oferta.turma.semestre));
		var colTurno = document.createTextNode(oferta.turno);
		var colVagas = document.createTextNode(oferta.vagas);
		
		var colunas = [colNome, colTurma, colTurno, colVagas];
		var linha = criarLinhaTabela(colunas);
		
		corpoTabela.append(linha);
	})
}

function adicionarResultadoOfertasCompartilhadasImportadas(compartilhamentos, inputName, classe, idTabela){
	var tabela = $(idTabela);
	var corpoTabela = $(tabela).find('tbody');
	
	$.each(compartilhamentos, function(key, compartilhamento){
		var oferta = compartilhamento.oferta;
		
		var label = criarLabelOferta(undefined, oferta.disciplina.nome);
		
		var colNome = label;
		var colTurmaOriginal = document.createTextNode(oferta.turma.curso.sigla + '-' + getNumeroSemestre(oferta.turma.semestre));
		var colTurmaCurso = document.createTextNode(compartilhamento.turma.curso.sigla + '-' + getNumeroSemestre(compartilhamento.turma.semestre));
		var colTurno = document.createTextNode(oferta.turno);
		var colVagas = document.createTextNode(oferta.vagas);
		
		var colunas = [colNome, colTurmaOriginal, colTurmaCurso, colTurno, colVagas];
		var linha = criarLinhaTabela(colunas);
		
		corpoTabela.append(linha);
	});
}

function adicionarMensagemSemResultado(elemento){
	$(elemento).removeClass('hidden');
}

function limparTabela(idTabela) {
	var tabela = $(idTabela);
	var corpoTabela = tabela.find('tbody');
	
	corpoTabela.empty();
}

function limparResultadosImportacao() {
	var semResultadosOfertas = $('#sem-resultado-ofertas');
	var divResultados = $('#resultados');
	
	limparTabela('#resultado-ofertas');
	limparTabela('#resultado-ofertas-compartilhadas');
	limparTabela('#resultado-ofertas-importadas');
	limparTabela('#resultado-ofertas-compartilhadas-importadas');
	
	semResultadosOfertas.addClass('hidden');
	divResultados.addClass('hidden');
}

function getOfertasSelecionadas(inputName) {
	var ofertas = $("input[name=" + inputName + "]:checked").map(function() {
		return this.value;
	}).get().join(",");
	
	return ofertas;
}

function resultadoImportacao(resultado) {
	var title, text, type, callbackFunction;
	
	if(resultado.importada){
		title = "Oferta(as) importadas!";
		text = "As oferta(as) selecionadas foram importadas.";
		type = "success";
		callbackFunction = function(isConfirm) {
			location.reload();
		}
	}
	else{
		title = 'Erro ao importar oferta(s)';
		text = "Algumas oferta(as) selecionadas não foram importadas.";
		type = "error";
		callbackFunction = function(isConfirm){}
	}
	
	swalMessage(title, text, type, callbackFunction)
}

function importarOfertas(){
	var ofertas = getOfertasSelecionadas("ofertas");
	
	if(ofertas.length > 0) {
		$.get(baseUrl + "/ofertas/importar-ofertas", {ofertas : ofertas}, function() {
		})
		.done(resultadoImportacao);
	}
}

function importarOfertasCompartilhadas(inputName){
	var compartilhamentos = getOfertasSelecionadas("ofertas-compartilhadas");
	if(compartilhamentos.length > 0) {
		$.get(baseUrl + "/ofertas/importar-ofertas-compartilhadas", {compartilhamentos : compartilhamentos}, function() {
		})
		.done(resultadoImportacao);
	}
}

function swalMessage(swalTitle, swalText, swalType, confirmCallbackFunction) {
	swal({
		title : swalTitle,
		text : swalText,
		type : swalType,
		showcancelButton : false,
		confirmButtonText : "Ok!",
		closeOnConfirm : true
	}, confirmCallbackFunction);
}
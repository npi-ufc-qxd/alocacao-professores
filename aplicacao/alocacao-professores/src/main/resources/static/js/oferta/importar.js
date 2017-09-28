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

function exibirOfertas() {
	var periodoSelecionado = document.getElementById("periodo").selectedIndex;
	var periodos = document.getElementById("periodo").options;
	var idPeriodo = periodos[periodoSelecionado].value;
	
	if(idPeriodo > 0){
		$.get(baseUrl + "/ofertas/buscar-ofertas/" + idPeriodo, function() {
		})
		.done(function(retorno) {
			var ofertas = retorno.ofertas;
			var compartilhamentos = retorno.compartilhamentos;
			var ofertasImportadas = retorno.ofertasImportadas;
			
			limparResultadosImportacao();
			
			if(ofertas.length > 0){
				$.each(ofertas, function(key, oferta) {
					adicionarResultadoTabela(oferta.id, "ofertas", "ofertas", '#resultado-ofertas', oferta.disciplina.nome, oferta.vagas, oferta.turma.curso.sigla, oferta.turma.semestre, oferta.turno);	
				});
			}else
				adicionarMensagemSemResultado('#sem-resultado-ofertas');
			
			if(compartilhamentos.length > 0){
				$.each(compartilhamentos, function(key, compartilhamento) {
					var oferta = compartilhamento.oferta;
					adicionarResultadoTabela(oferta.id, "compartilhamentos", "compartilhamentos", '#resultado-compartilhamentos', oferta.disciplina.nome, oferta.vagas, oferta.turma.curso.sigla, oferta.turma.semestre, oferta.turno);	
				});
			}
			
			if(ofertasImportadas.length > 0){
				$.each(ofertasImportadas, function(key, oferta) {
					adicionarResultadoTabelaImportadas(oferta.id, '#resultado-ofertas-importadas', oferta.disciplina.nome, oferta.vagas, oferta.turma.curso.sigla, oferta.turma.semestre, oferta.turno);	
				});
			}
		});
	}
}

function adicionarColunaTabela(linha, conteudo){
	var coluna = document.createElement('td');
	coluna.appendChild(conteudo);
	
	linha.appendChild(coluna);
}

function getNumeroSemestre(semestre){
	var semestres = ['PRIMEIRO', 'SEGUNDO', 'TERCEIRO', 'QUARTO', 'QUINTO', 'SEXTO', 'SETIMO', 'OITAVO', 'NONO', 'DECIMO'];
	return semestres.indexOf(semestre) + 1;
}

function adicionarResultadoTabelaImportadas(id, idTabela, nomeDisciplina, vagas, siglaCurso, semestre, turno){	
	var label = document.createElement('label')
	label.appendChild(document.createTextNode(nomeDisciplina));
	
	var tabela = $(idTabela);	
	var divTabela = tabela.parent();
	var corpoTabela = tabela.find('tbody');
	
	var linha = document.createElement('tr');
	
	adicionarColunaTabela(linha, label);
	adicionarColunaTabela(linha, document.createTextNode(siglaCurso + '-' + getNumeroSemestre(semestre)));
	adicionarColunaTabela(linha, document.createTextNode(turno));
	adicionarColunaTabela(linha, document.createTextNode(vagas));
	
	corpoTabela.append(linha);
	
	divTabela.removeClass('hidden');
}

function adicionarResultadoTabela(id, inputName, classe, idTabela, nomeDisciplina, vagas, siglaCurso, semestre, turno){	
	var checkbox = document.createElement('input');
	checkbox.type = "checkbox";
	checkbox.id = id;
	checkbox.name = inputName;
	checkbox.className = classe;
	checkbox.value = id;
	
	var label = document.createElement('label')
	label.htmlFor = id;
	label.appendChild(document.createTextNode(nomeDisciplina));
	
	var tabela = $(idTabela);	
	var divTabela = tabela.parent();
	var corpoTabela = tabela.find('tbody');
	
	var li = document.createElement('li');
	li.appendChild(checkbox);
	li.appendChild(label);
	li.setAttribute('class', 'checkbox checkbox-success');
	
	var ul = document.createElement('ul');	
	ul.id = 'lista-ofertas';
	ul.setAttribute('class','list-unstyled');
	ul.appendChild(li);
	
	var linha = document.createElement('tr');
	
	adicionarColunaTabela(linha, ul);
	adicionarColunaTabela(linha, document.createTextNode(siglaCurso + '-' + getNumeroSemestre(semestre)));
	adicionarColunaTabela(linha, document.createTextNode(turno));
	adicionarColunaTabela(linha, document.createTextNode(vagas));
	
	corpoTabela.append(linha);
	
	divTabela.removeClass('hidden');
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

function limparResultadosImportacao(){
	var semResultadosOfertas = $('#sem-resultado-ofertas');
	
	limparTabela('#resultado-ofertas');
	limparTabela('#resultado-compartilhamentos');
	
	semResultadosOfertas.addClass('hidden');
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
				resultadoImportacao(retorno.importada, retorno.substituir);
		});
	}
}

function resultadoImportacao(importada, substituir) {
	if(!importada && substituir)
		errorImportarOferta();
	else if(importada && !substituir)
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
var _ctx = $("meta[name='ctx']").attr("content");
var protocol = _ctx.split('//')[0];
var host = _ctx.split('/')[2];
var baseUrl = protocol + '//' + host;

var baseUrl = $("meta[name='baseUrl']").attr("content");
if (baseUrl == null)
	baseUrl = "";

//var idOferta = _ctx.split('/')[4];
//if (idOferta == null)
//	idOferta = -1;

//window.onload = function() {
//	$.get(baseUrl + '/ofertas/' + idOferta + '/buscar-compartilhamentos-oferta/', function(){
//	}).done(function(compartilhamentos){
//		$.each(compartilhamentos, function(key, compartilhamento){
//			exibirCompartilhamento(key, compartilhamento);
//		});
//	});
//}

$("#btn-editar-oferta").click(function() {
	editarOferta();
})

function getInputsByName(name) {
	return $("input[name='" + name + "']").map(function() {
		return this.value;
	}).get();
}

function getSelectsByName(name){
	return $("select[name='" + name + "']").map(function() {
		return this.options[this.selectedIndex].value;
	}).get();
}

function editarOferta() {
	var compartilhamentos = [];
	
	var idsCompartilhamentos = [];
//	var ofertasCompartilhamentos = [];
	var turmasCompartilhamentos = [];
	var vagasCompartilhamentos = [];
	
	idsCompartilhamentos = getInputsByName('compartilhamento.id');
//	ofertasCompartilhamentos = getInputsByName('compartilhamento.oferta');
	turmasCompartilhamentos = getSelectsByName('compartilhamento.turma');
	vagasCompartilhamentos = getInputsByName('compartilhamento.vagas');
	
//	for (var i = 0; i < idsCompartilhamentos.length; i++){
//		compartilhamentos.push([]);
//		compartilhamentos[i].id = idsCompartilhamentos[i];
////		compartilhamentos[i].oferta = ofertasCompartilhamentos[i];
//		compartilhamentos[i].turma = turmasCompartilhamentos[i];
//		compartilhamentos[i].vagas = vagasCompartilhamentos[i];
//	}
	
	idsCompartilhamentos = idsCompartilhamentos.join(",");
	idsTurmas = turmasCompartilhamentos.join(",");
	vagas = vagasCompartilhamentos.join(",");
	
	$.get(baseUrl + '/editar-compartilhamentos-oferta/', {idsCompartilhamentos : idsCompartilhamentos, idsTurmas : idsTurmas, vagas : vagas}, function(){
	}).done(resultadoEdicaoOferta);
}

function resultadoEdicaoOferta(retorno) {
	var title, text, type, callbackFunction;
	
	if (retorno){
		title = "Compartilhamentos editados!";
		text = "Os compartilhamentos foram editados.";
		type = "success";
		callBackFunction = function(isConfirm){}
	}else{
		title = "Erro ao editar os compartilhamentos!";
		text = "Os compartilhamentos não foram editados.";
		type = "error";
		callBackFunction = function(isConfirm){}
	}
	
	swalMessage(title, text, type, callbackFunction);
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

//function criarPanelHeading() {
//	var panelHeading = document.createElement('div');
//	panelHeading.className = 'panel-heading';
//	
//	return panelHeading;
//}
//
//function criarPanelBody() {
//	var panelBody = document.createElement('div');
//	panelBody.className = 'panel-body';
//	
//	return panelBody;
//}
//
//function criarRow() {
//	var rowDiv = document.createElement('div');
//	rowDiv.className = 'row';
//	
//	return rowDiv;
//}
//
//function criarCol(className) {
//	var colDiv = document.createElement('div');
//	colDiv.className = className;
//	
//	return colDiv;
//}
//
//function criarSpanNomeCurso(nomeCurso) {
//	var spanNomeCurso = document.createElement('span');
//	spanNomeCurso.innerHTML = nomeCurso;
//	
//	return spanNomeCurso;
//}
//
//function criarInputHidden(name, value) {
//	var inputHidden = document.createElement('input');
//	inputHidden.type = 'hidden';
//	inputHidden.name = name;
//	inputHidden.value = value;
//	inputHidden.required = 'required';
//	
//	return inputHidden;
//}
//
//function criarInputNumber(name, value) {
//	var inputNumber = document.createElement('input');
//	inputNumber.type = 'number';
//	inputNumber.name = name;
//	inputNumber.value = value;
//	inputNumber.className = 'form-control';
//	inputNumber.min = 1;
//	inputNumber.required = 'required';
//	
//	return inputNumber;
//}
//
//function criarSelect(name, curso, turmaSelecionada) {
//	var select = document.createElement('select');
//	select.name = name;
//	select.className = 'form-control';
//	select.required = 'required';
//	
//	$.get(baseUrl + '/buscar-turmas/' + curso.id + '/', function() {
//	}).done(function(turmas) {
//		$.each(turmas, function(key, turma){
//			var option = document.createElement('option');
//			option.innerHTML = turma.semestre + ' Semestre - ' + turma.curso.nome;
//			option.value = turma.id;
//			
//			if (turma.id == turmaSelecionada.id)
//				option.selected = 'selected';
//			
//			select.appendChild(option);
//		});
//	});
//	
//	return select;
//}
//
//function criarLabel(text) {
//	var label = document.createElement('label');
//	label.innerHTML = text;
//	
//	return label; 
//}

//function exibirCompartilhamento(index, compartilhamento) {
//	var formCompartilhamentos = $(".form-compartilhamentos");
//	
//	var nomeCurso = compartilhamento.turma.curso.nome;
//	
//	var panelHeading = criarPanelHeading();
//	var spanNomeCurso = criarSpanNomeCurso(nomeCurso);
//	var inputIdCompartilhamento = criarInputHidden('compartilhamento.id', compartilhamento.id);
////	var inputOfertaCompartilhamento = criarInputHidden('compartilhamento.oferta', compartilhamento.oferta);
//	
//	var labelSelectTurmas = criarLabel('Turmas');
//	var selectTurmas = criarSelect('compartilhamento.turma', compartilhamento.turma.curso, compartilhamento.turma);
//	
//	var labelVagas = criarLabel('Quantidade de vagas');
//	var inputVagas = criarInputNumber('compartilhamento.vagas', compartilhamento.vagas);
//	
//	var panelBody = criarPanelBody();
//	var panelBodyRow = criarRow();
//	var panelCol1 = criarCol('col-md-8');
//	var panelCol2 = criarCol('col-md-4');
//	
//	panelCol1.append(labelSelectTurmas);
//	panelCol1.append(selectTurmas);
//	
//	panelCol2.append(labelVagas);
//	panelCol2.append(inputVagas);
//	
//	panelHeading.append(spanNomeCurso);
//	panelHeading.append(inputIdCompartilhamento);
////	panelHeading.append(inputOfertaCompartilhamento);
//	
//	panelBody.append(panelCol1);
//	panelBody.append(panelCol2);
//	
//	formCompartilhamentos.append(panelHeading);
//	formCompartilhamentos.append(panelBody);
//}
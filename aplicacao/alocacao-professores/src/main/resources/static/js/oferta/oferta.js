var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

var _context = $("meta[name='_context']").attr("content");
if(_context == null){
    _context = "";
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


$('#button').click(function() {
	$.get(_context + "/ofertas/listar", function() {
	})
	.done(function(ofertas) {
		if(ofertas.length > 0){
			organizarOfertas(ofertas);
		}
	});
})

function organizarOfertas(ofertas) {	
	for(var i = 1; i <= 10; i++) {
		var semestre = i + '° Semestre';
		
		criarEstrutura(semestre);
		
		$.each(ofertas, function(key, value) {
			switch(semestre) {
				case '1° Semeste':
					criarPanelsOferta(value.disciplina.codigo, value.disciplina.nome, value.vagas, value.turno, semestre);
					break;
				case '2° Semeste':
					criarPanelsOferta(value.disciplina.codigo, value.disciplina.nome, value.vagas, value.turno, semestre);
					break;
				case '3° Semeste':
					criarPanelsOferta(value.disciplina.codigo, value.disciplina.nome, value.vagas, value.turno, semestre);
					break;
				case '4° Semeste':
					criarPanelsOferta(value.disciplina.codigo, value.disciplina.nome, value.vagas, value.turno, semestre);
					break;
				case '5° Semeste':
					criarPanelsOferta(value.disciplina.codigo, value.disciplina.nome, value.vagas, value.turno, semestre);
					break;
				case '6° Semeste':
					criarPanelsOferta(value.disciplina.codigo, value.disciplina.nome, value.vagas, value.turno, semestre);
					break;
				case '7° Semeste':
					criarPanelsOferta(value.disciplina.codigo, value.disciplina.nome, value.vagas, value.turno, semestre);
					break;
				case '8° Semeste':
					criarPanelsOferta(value.disciplina.codigo, value.disciplina.nome, value.vagas, value.turno, semestre);
					break;
				case '9° Semeste':
					criarPanelsOferta(value.disciplina.codigo, value.disciplina.nome, value.vagas, value.turno, semestre);
					break;
				case '10° Semeste':
					criarPanelsOferta(value.disciplina.codigo, value.disciplina.nome, value.vagas, value.turno, semestre);
					break;
			}
		});
	}
}

function criarEstrutura(semestre, panel) {
	var divRow = document.createElement('div');
	divRow.setAttribute('class', 'row');
	
	var divCol = document.createElement('div');
	divCol.id = semestre;
	divCol.setAttribute('class', 'col-md-12');
	
	var h5 = document.createElement('h5');
	h5.appendChild(document.createTextNode(semestre));
	
	divCol.appendChild(h5)
	divRow.appendChild(divCol);
	
	$('#ofertas').append(divRow);
}

function criarPanelsOferta(codigoDisciplina, nomeDisciplina, vagas, turno, semestre){
	
	var divPanel = document.createElement('div');
	divPanel.setAttribute('class', 'panel panel-default');
	
	var divPanelHeading = document.createElement('div');
	divPanelHeading.setAttribute('class', 'panel-heading');
	
	var label = document.createElement('label');
	var bold = document.createElement('b');
	
	bold.appendChild(document.createTextNode(codigoDisciplina + ' - ' + nomeDisciplina));
	label.appendChild(bold);
	
	var divPanelAction = document.createElement('div');
	divPanelAction.setAttribute('class', 'panel-action');
	
	var divPanelWrapper = document.createElement('div');
	divPanelWrapper.setAttribute('class', 'panel-wrapper collapse in');
	
	var divPanelBody = document.createElement('div');
	divPanelBody.setAttribute('class', 'panel-body');
	
	var pVagas = document.createElement('p');
	var pTurno = document.createElement('p');
	
	pVagas.appendChild(document.createTextNode(vagas));
	pTurno.appendChild(document.createTextNode(turno));
			
	divPanelBody.appendChild(pVagas);
	divPanelBody.appendChild(pTurno);
	
	divPanelWrapper.appendChild(divPanelBody);
	
	divPanelHeading.appendChild(label);
	divPanelHeading.appendChild(divPanelAction);
	
	divPanel.appendChild(divPanelHeading);
	
	semestre = '#'+semestre;
	$(semestre).append(divPanel);
}



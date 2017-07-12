$('#btn-modal-importar-ofertas').on('click', function (event) {
	$('#resultado-ofertas').empty();
	$('#modal-importar-ofertas').modal('show');
});

var periodos = document.getElementById("periodo");
var periodo = periodos.options[periodos.selectedIndex].text;

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

var _context = $("meta[name='_context']").attr("content");
if(_context == null){
    _context = "";
}

$('#btn-exibir-ofertas').click(function() {
	var periodo = document.getElementById("periodo").selectedIndex;
	var periodos = document.getElementById("periodo").options;
	var id = periodos[periodo].value;
	
	if(id > 0){
		$.get(_context + "/ofertas/buscar-ofertas/" + id, function() {
			
		})
		.done(function(ofertas) {
			console.log(ofertas);
			$('#resultado-ofertas').empty();
			$.each(ofertas, function(key, value) {
					adicionarResultado(value.disciplina.id, "ofertas", '#resultado-ofertas', value.disciplina.nome, "ofertas");	
			});
		});
	}
	
});

function adicionarResultado(id, name, coluna, nome, classe){
	
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
	
	var lista = document.createElement('ul');
	lista.id = 'resultado-disciplinas';
	$(coluna).append(lista);	
	
	
	var ul = document.getElementById('resultado-disciplinas');
    var li = document.createElement('li');
    li.appendChild(checkbox);
    li.appendChild(label);
    
    ul.appendChild(li); 
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
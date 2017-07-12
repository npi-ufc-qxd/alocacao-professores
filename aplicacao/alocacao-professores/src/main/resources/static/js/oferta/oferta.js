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
				$('#modal-importar-ofertas').modal('hidde');
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
$('#btn-modal-importar-ofertas').on('click', function (event) {
	limparResultadosImportacao();
	$('#modal-importar-ofertas').modal('show');
	
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
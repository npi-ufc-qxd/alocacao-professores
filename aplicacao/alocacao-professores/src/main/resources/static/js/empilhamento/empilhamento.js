$(".sa-emp-btn-excluir").on("click", function(event){
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
					console.log(urlExcluir);
					if (result === true){
						successSwal();
					}
					else{
						errorSwal();
					}
					
				},
				error: function(status, error){
					console.log(status);
					console.log(error);
					errorSwal();
				}
			});
		}
	});
});

function successSwal(){
	swal({
		title: "Empilhamento excluído!",
		text: "O empilhamento foi excluído.", 
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
		text: "O empilhamento não foi excluído.", 
		type: "error",
		showcancelButton: false,
		confirmButtonText: "Ok",
		closeOnConfirm: true
	});	
}

$(".sa-emp-btn-desabilitar").on("click", function(event){
	event.preventDefault();

	var botaoDesabilitar = $(event.currentTarget);
	var urlDesabilitar = botaoDesabilitar.attr("href");
	
	
	swal({
		title: "Tem certeza?",
		text: "Você não poderá desfazer essa operação posteriormente!",
		type: "warning",   
		showCancelButton: true,
		cancelButtonText: "Cancelar",
		confirmButtonColor: "#DD6B55",
		confirmButtonText: "Sim, desejo desabilitar!",
		closeOnConfirm: false
	}, function(isConfirm){
		if(isConfirm){
			var response = $.ajax({
				url: urlDesabilitar,
				type: 'GET',
				success: function(result){
					console.log(urlDesabilitar);
					if (result === true){
						successSwalDesabilitar();
					}
					else{
						errorSwalDesabilitar();
					}
					
				},
				error: function(status, error){
					console.log(status);
					console.log(error);
					errorSwalDesabilitar();
				}
			});
		}
	});
});

function successSwalDesabilitar(){
	swal({
		title: "Empilhamento desabilitado!",
		text: "O empilhamento foi desabilitado.", 
		type: "success",
		showcancelButton: false,
		confirmButtonText: "Ok!",
		closeOnConfirm: true
	}, function(isConfirm){
		location.reload();
	});
}

function errorSwalDesabilitar(){
	swal({
		title: "Erro ao desabilitar",
		text: "O empilhamento não foi desabilitado.", 
		type: "error",
		showcancelButton: false,
		confirmButtonText: "Ok",
		closeOnConfirm: true
	});	
}
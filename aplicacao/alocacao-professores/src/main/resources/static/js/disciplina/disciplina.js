$(".sa-btn-arquivar").on("click", function(event) {
	event.preventDefault();

	var botaoArquivada = $(event.currentTarget); 
	var urlArquivar = botaoArquivada.attr("href");
	
	
	swal({   
        title: "Tem Certeza ?",   
        text: "Você poderá desfazer essa operação posteriormente, se desejar!",   
        type: "warning",   
        showCancelButton: true,   
        cancelButtonText: "Cancelar",
        confirmButtonColor: "#DD6B55",   
        confirmButtonText: "Sim, desejo arquivar!",   
        closeOnConfirm: false
	}, function(isConfirm){
		if(isConfirm){
			var response = $.ajax({
			    url: urlArquivar,
			    type: 'GET'
			});
			
			swal({				 
				title: "Disciplina Arquivada!",   
		        text: "A Disciplina foi arquivada.",   
		        type: "success",   
		        showCancelButton: false,   
		        cancelButtonText: "",
		        confirmButtonColor: "#32CD32",   
		        confirmButtonText: "Ok",   
		        closeOnConfirm: false
			}, function(isConfirm){
				if(isConfirm){
					window.location.href="/disciplinas";
				}
			});
			
			
			
		}
	}
	);

    response.done(function(resultadoArquivar){               		        	
    });
    

});

$(".gp-btn-arquivar").on("click", function(event) {
	event.preventDefault();
	
	var botaoArquivada = $(event.currentTarget); 
	var urlArquivar = botaoArquivada.attr("href");
	
	var response = $.ajax({
	    url: urlArquivar,
	    type: 'GET'
	});
	

    response.done(function(arquivada) {
    	if(arquivada) {
    		swal("Disciplina Arquivada!", "A Disciplina foi arquivada.", "success");
    	}
    	else {
        	swal("Opss!", "Disciplina não existente.", "error");
    	}

    	botaoArquivada.hide();
    });

    response.fail(function(e) {
    	swal("Opss!", "Fale com o administrador do sistema.", "error");
    });

});

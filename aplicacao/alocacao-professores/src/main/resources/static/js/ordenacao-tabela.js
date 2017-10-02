$(document).ready(function(){
	$('table').DataTable({
		"iDisplayLength": 25,
        "language": {
            "emptyTable":     "Nenhum registro encontrado",
            "info":           "Mostrando de _START_ até _END_ de _TOTAL_ registros",
            "infoEmpty":      "Mostrando 0 até 0 de 0 registros",
            "infoFiltered":   "(Filtrados de _MAX_ registros)",
            "infoPostFix":    "",
            "thousands":      ".",
            "lengthMenu":     "Mostrar _MENU_ resultados por página",
            "loadingRecords": "Carregando...",
            "processing":     "Processando...",
            "search":         "Pesquisar:",
            "zeroRecords":    "Nenhum registro encontrado",
            "paginate": {
                "first":      "Primeiro",
                "last":       "Último",
                "next":       "Próximo",
                "previous":   "Anterior"
            },
            "aria": {
                "sortAscending":  ": Ordenar colunas de forma crescente",
                "sortDescending": ": Ordenar colunas de forma descrescente"
            }
        }
    });
});
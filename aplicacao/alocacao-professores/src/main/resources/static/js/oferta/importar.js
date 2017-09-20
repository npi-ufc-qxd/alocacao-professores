
function criarEstrutura(semestre, numberSemestre, sigla) {
		
	var divRow = document.createElement('div');
	divRow.setAttribute('class', 'row');
	
	divRow.id = semestre;

	var div = document.createElement('div');
	div.setAttribute('class', 'col-md-12');
	var h5 = document.createElement('h5');
	h5.setAttribute('style', 'text-align: center');
	var b = document.createElement('b');
	b.appendChild(document.createTextNode(sigla+' - '+numberSemestre));
	var hr = document.createElement('hr');

	h5.appendChild(b);
	div.appendChild(h5);
	div.appendChild(hr);
	
	divRow.appendChild(div);
	
	$('#ofertas').append(divRow);
	
	if(sigla !== 'EC') {
		$('#NONO').hide();
		$('#DECIMO').hide();
	}
}

$('#btn-exibir-ofertas').click(function() {
	var periodo = document.getElementById("periodo").selectedIndex;
	var periodos = document.getElementById("periodo").options;
	var id = periodos[periodo].value;
	
	if(id > 0){
		$.get(baseUrl + "/ofertas/buscar-ofertas/" + id, function() {
			
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

$('#btn-importar-ofertas').on('click', function (event) {
	importarOfertas();
});

var periodos = document.getElementById("periodo");
var periodo = periodos.options[periodos.selectedIndex].text;

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

var baseUrl = $("meta[name='baseUrl']").attr("content");
if(baseUrl == null){
    baseUrl = "";
}

function importarOfertas(){
	var disciplinas = $("input[name=ofertas]:checked").map(function() {
		return this.value;
	}).get().join(",");
	
	if(disciplinas.length > 0){
		alert(disciplinas)
		$.get(baseUrl + "/ofertas/importar", {disciplinas : disciplinas}, function() {
		})
		.done(function(retorno) {
			if(retorno === true){
				importacaoRealizada();
			}
		});
	}
}

document.addEventListener("DOMContentLoaded", function() {
	var pokemonTypes = document.querySelectorAll('.pokemon-types');

	pokemonTypes.forEach(function(element) {
		var tipo = element.textContent;
		var color = getColorByType(tipo.toLowerCase());

		// Limpiar el contenido existente
		element.innerHTML = '';

		// Crear un nuevo elemento span para el tipo
		var tipoElement = document.createElement('span');
		tipoElement.textContent = tipo;
		tipoElement.style.backgroundColor = color;
		tipoElement.style.borderRadius = '15px';
		tipoElement.style.padding = '5px';
		tipoElement.style.margin = '5px';
		tipoElement.classList.add('type-container');

		// Agregar el nuevo elemento span al contenedor
		element.appendChild(tipoElement);
	});

	function getColorByType(tipo) {
		switch (tipo) {
			case 'planta':
				return '#78C850';
			case 'fuego':
				return '#F08030';
			case 'agua':
				return '#6890F0';
			case 'bicho':
				return '#A8B820';
			case 'veneno':
				return '#A040A0';
			case 'normal':
				return '#A8A878';
			case 'volador':
				return '#A890F0';
			case 'eléctrico':
				return '#F8D030';
			case 'hada':
				return '#EE99AC';
			case 'lucha':
				return '#C03028';
			case 'roca':
				return '#B8A038';
			case 'psíquico':
				return '#F85888';
			case 'acero':
				return '#B8B8D0';
			case 'tierra':
				return '#E0C068';
			case 'hielo':
				return '#98D8D8';
			case 'fantasma':
				return '#705898';
			case 'dragón':
				return '#7038F8';
			case 'siniestro':
				return '#705848';
			default:
				return 'transparent';
		}
	}
});

document.addEventListener("DOMContentLoaded", function() {
	var numeros = document.querySelectorAll('.valor');

	numeros.forEach(function(element) {
		var numero = element.textContent;
		var color = getNumberColor(numero.toLowerCase());

		// Limpiar el contenido existente
		element.innerHTML = '';

		// Crear un nuevo elemento span para el tipo
		var numeroElement = document.createElement('span');
		numeroElement.textContent = numero;
		numeroElement.style.backgroundColor = color;
		numeroElement.style.borderRadius = '100px';
		numeroElement.classList.add('number-container');

		// Agregar el nuevo elemento span al contenedor
		element.appendChild(numeroElement);
	});

	function getNumberColor(number) {
		switch (number) {
			case '0.0':
				return '#404040';
			case '0.5':
				return '#f2d071';
			case '1.0':
				return 'transparent';
			case '2.0':
				return '#69b24b';
			default:
				return 'transparent';
		}
	}
});
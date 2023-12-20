package com.teamversus.logic;

public class Tabla {

	/* Tipos actuales de pokemon */
	public static String[] tiposPokemon = { "ACERO", "AGUA", "BICHO", "DRAGÓN", "ELÉCTRICO", "FANTASMA", "FUEGO",
			"HADA", "HIELO", "LUCHA", "NORMAL", "PLANTA", "PSÍQUICO", "ROCA", "SINIESTRO", "TIERRA", "VENENO",
			"VOLADOR" };

	/* Mensaje segun la eficacia */
	public static String[] MENSAJES_EFICACIAS = { "NO ES MUY EFICAZ", "NEUTRO", "ES MUY EFICAZ", "NO AFECTA",
			"DOBLEMENTE EFICAZ", "DOBLEMENTE NO MUY EFICAZ" };

	/*
	 * INDICES de los mensaje anteriores Asi no debes recordar en que posicion esta
	 * cada uno
	 */

	public static int INDICE_NME = 0;
	public static int INDICE_NEUTRO = 1;
	public static int INDICE_EME = 2;
	public static int INDICE_NA = 3;
	public static int INDICE_DE = 4;
	public static int INDICE_DNE = 5;

	/* Eficiacias */

	public static double EFICACIA_DE = 4; /* DOBLEMENTE EFICAZ */
	public static double EFICACIA_EME = 2; /* ES MUY EFICAZ */
	public static double EFICACIA_NEUTRO = 1;
	public static double EFICACIA_NME = 0.5; /* NO ES MUY EFICAZ */
	public static double EFICACIA_DNE = 0.25; /* DOBLEMENTE NO ES EFICAZ */
	public static double EFICACIA_NA = 0; /* NO AFECTA */

	/*
	 * FILAS = Pokemon atacante COLUMNAS = Pokemon que recibe el ataque
	 * 
	 * Significados de los números: - 0.5: el atacante hace la mitad de daño al
	 * oponente (No es muy eficaz) - 1: el atacante hace un daño neutro al oponente
	 * (No se da información pero diremos neutro) - 2: el atacante hace el doble de
	 * daño al oponente (Es muy eficaz) - 0: el atacante hace un daño nulo al
	 * oponente (No afecta)
	 * 
	 */
	public static double[][] efectividadesPokemon = {

			/*
			 * ACERO AGUA BICHO DRAGON ELÉC FANT FUEGO HADA HIELO LUCHA NORMAL PLANTA PSI
			 * ROCA SINIE TIERRA VENENO VOLADOR
			 */

			{ 0.5, 0.5, 1, 1, 0.5, 1, 0.5, 2, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1 }, // ACERO
			{ 1, 0.5, 1, 0.5, 1, 1, 2, 1, 1, 1, 1, 0.5, 1, 2, 1, 2, 1, 1 }, // AGUA
			{ 0.5, 1, 1, 1, 1, 0.5, 0.5, 0.5, 1, 0.5, 1, 2, 2, 1, 2, 1, 0.5, 0.5 }, // BICHO
			{ 0.5, 1, 1, 2, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, // DRAGÓN
			{ 1, 2, 1, 0.5, 0.5, 1, 1, 1, 1, 1, 1, 0.5, 1, 1, 1, 0, 1, 2 }, // ELÉCTRICO
			{ 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0, 1, 2, 1, 0.5, 1, 1, 1 }, // FANTASMA
			{ 2, 0.5, 2, 0.5, 1, 1, 0.5, 1, 2, 1, 1, 2, 1, 0.5, 1, 1, 1, 1 }, // FUEGO
			{ 0.5, 1, 1, 2, 1, 1, 0.5, 1, 1, 2, 1, 1, 1, 1, 2, 1, 0.5, 1 }, // HADA
			{ 0.5, 0.5, 1, 2, 1, 1, 0.5, 1, 0.5, 1, 1, 2, 1, 1, 1, 2, 1, 2 }, // HIELO
			{ 2, 1, 0.5, 1, 1, 0, 1, 0.5, 2, 1, 2, 1, 0.5, 2, 2, 1, 0.5, 0.5 }, // LUCHA
			{ 0.5, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0.5, 1, 1, 1, 1 }, // NORMAL
			{ 0.5, 2, 0.5, 0.5, 1, 1, 0.5, 1, 1, 1, 1, 0.5, 1, 2, 1, 2, 0.5, 0.5 }, // PLANTA
			{ 0.5, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 0.5, 1, 0, 1, 2, 1 }, // PSÍQUICO
			{ 0.5, 1, 2, 1, 1, 1, 2, 1, 2, 0.5, 1, 1, 1, 1, 1, 0.5, 1, 2 }, // ROCA
			{ 1, 1, 1, 1, 1, 2, 1, 0.5, 1, 0.5, 1, 1, 2, 1, 0.5, 1, 1, 1 }, // SINIESTRO
			{ 2, 1, 0.5, 1, 2, 1, 2, 1, 1, 1, 1, 0.5, 1, 2, 1, 1, 2, 0 }, // TIERRA
			{ 0, 1, 1, 1, 1, 0.5, 1, 2, 1, 1, 1, 2, 1, 0.5, 1, 0.5, 0.5, 1 }, // VENENO
			{ 0.5, 1, 2, 1, 0.5, 1, 1, 1, 1, 2, 1, 2, 1, 0.5, 1, 1, 1, 1 } // VOLADOR
	};

	public static int encontrarIndiceTipo(String nombreTipo) {
		for (int i = 0; i < tiposPokemon.length; i++) {
			if (tiposPokemon[i].equals(nombreTipo)) {
				return i;
			}
		}
		return -1; // Devuelve -1 si no se encuentra el elemento en el array
	}

	/**
	 * Muestra el mensaje asociado a la eficacia
	 *
	 * @param eficacia
	 * @return
	 */
	public static String mostrarEficacia(double eficacia) {

		String mensaje;

		if (eficacia == Tabla.EFICACIA_DE) {
			mensaje = Tabla.MENSAJES_EFICACIAS[Tabla.INDICE_DE];
		} else if (eficacia == Tabla.EFICACIA_EME) {
			mensaje = Tabla.MENSAJES_EFICACIAS[Tabla.INDICE_EME];
		} else if (eficacia == Tabla.EFICACIA_NEUTRO) {
			mensaje = Tabla.MENSAJES_EFICACIAS[Tabla.INDICE_NEUTRO];
		} else if (eficacia == Tabla.EFICACIA_NME) {
			mensaje = Tabla.MENSAJES_EFICACIAS[Tabla.INDICE_NME];
		} else if (eficacia == Tabla.EFICACIA_DNE) {
			mensaje = Tabla.MENSAJES_EFICACIAS[Tabla.INDICE_DNE];
		} else {
			mensaje = Tabla.MENSAJES_EFICACIAS[Tabla.INDICE_NA];
		}

		return mensaje;

	}

	/**
	 * Muestra la eficacia (con palabras) de un tipo a otro tipo
	 *
	 * @param tipoAtacante
	 * @param tipoOponente
	 */
	public static void mostrarEficaciaTipo(int tipoAtacante, int tipoOponente) {
		System.out.println(Tabla.efectividadesPokemon[tipoAtacante][tipoOponente]);
		System.out.println(mostrarEficacia(Tabla.efectividadesPokemon[tipoAtacante][tipoOponente]));
	}

	public static double obtenerEficaciaTipo(int tipoAtacante, int tipoOponente) {
		return (Tabla.efectividadesPokemon[tipoAtacante][tipoOponente]);
	}

	/**
	 * Muestra la eficacia (con palabras) de un tipo a un pokemon con dos tipos
	 *
	 * @param tipoAtacante
	 * @param tipo1Oponente
	 * @param tipo2Oponente
	 */
	public static void mostrarEficaciaTipo(int tipoAtacante, int tipo1Oponente, int tipo2Oponente) {
		// multiplico las efectivadades
		double efectividad = Tabla.efectividadesPokemon[tipoAtacante][tipo1Oponente]
				* Tabla.efectividadesPokemon[tipoAtacante][tipo2Oponente];
		System.out.println(efectividad);
		System.out.println(mostrarEficacia(efectividad));
	}

	public static double obtenerEficaciaTipo(int tipoAtacante, int tipo1Oponente, int tipo2Oponente) {
		// multiplico las efectivadades
		double efectividad = Tabla.efectividadesPokemon[tipoAtacante][tipo1Oponente]
				* Tabla.efectividadesPokemon[tipoAtacante][tipo2Oponente];
		return efectividad;
	}

	/**
	 * Muestra la eficacia (con palabras) de un pokemon con dos tipos a un pokemon
	 * con uno
	 *
	 * @param tipo1Atacante
	 * @param tipo2Atacante
	 * @param tipoOponente
	 */
	public static void mostrarEficaciaTipos(int tipo1Atacante, int tipo2Atacante, int tipoOponente) {
		// multiplico las efectivadades
		double efectividad = Tabla.efectividadesPokemon[tipo1Atacante][tipoOponente]
				* Tabla.efectividadesPokemon[tipo2Atacante][tipoOponente];
		System.out.println(efectividad);
		System.out.println(mostrarEficacia(efectividad));
	}

	public static double obtenerEficaciaTipos(int tipo1Atacante, int tipo2Atacante, int tipoOponente) {
		// multiplico las efectivadades
		double efectividad = Tabla.efectividadesPokemon[tipo1Atacante][tipoOponente]
				* Tabla.efectividadesPokemon[tipo2Atacante][tipoOponente];
		return efectividad;
	}

	/**
	 * Muestra la eficacia (con palabras) de un pokemon con dos tipos a un pokemon
	 * con dos tipos
	 *
	 * @param tipo1Atacante
	 * @param tipo2Atacante
	 * @param tipo1Oponente
	 * @param tipo2Oponente
	 */
	public static void mostrarEficaciaTipo(int tipo1Atacante, int tipo2Atacante, int tipo1Oponente, int tipo2Oponente) {
		// multiplico las efectivadades
		double efectividad1 = Tabla.efectividadesPokemon[tipo1Atacante][tipo1Oponente]
				* Tabla.efectividadesPokemon[tipo1Atacante][tipo2Oponente];
		double efectividad2 = Tabla.efectividadesPokemon[tipo2Atacante][tipo1Oponente]
				* Tabla.efectividadesPokemon[tipo2Atacante][tipo2Oponente];
		double efectividad = efectividad1 * efectividad2;
		System.out.println(Tabla.efectividadesPokemon[tipo1Atacante][tipo1Oponente] + "  "
				+ Tabla.efectividadesPokemon[tipo1Atacante][tipo2Oponente]);
		System.out.println(Tabla.efectividadesPokemon[tipo2Atacante][tipo1Oponente] + "  "
				+ Tabla.efectividadesPokemon[tipo2Atacante][tipo2Oponente]);
		System.out.println(efectividad1 + "   " + efectividad2 + "   " + efectividad);
		System.out.println(mostrarEficacia(efectividad));
	}

	public static double obtenerEficaciaTipo(int tipo1Atacante, int tipo2Atacante, int tipo1Oponente,
			int tipo2Oponente) {
		// multiplico las efectivadades
		double efectividad1 = Tabla.efectividadesPokemon[tipo1Atacante][tipo1Oponente]
				* Tabla.efectividadesPokemon[tipo1Atacante][tipo2Oponente];
		double efectividad2 = Tabla.efectividadesPokemon[tipo2Atacante][tipo1Oponente]
				* Tabla.efectividadesPokemon[tipo2Atacante][tipo2Oponente];
		double efectividad = efectividad1 * efectividad2;
		return efectividad;
	}
}

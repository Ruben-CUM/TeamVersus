package com.teamversus.service;

import java.util.ArrayList;

import com.teamversus.logic.DatosCombate;
import com.teamversus.model.Combate;
import com.teamversus.model.Pokemon;
import com.teamversus.model.Teamversus;

public interface CombateService {
	public void createCombate();

	public ArrayList<Pokemon> createEquipoRival(Teamversus teamversus);

	public void addCombate(Teamversus teamversus, Combate combate);

	public Combate findUltimoCombate();

	public DatosCombate procesarTurno(int indiceJugador, int indiceRival);

	public DatosCombate recalcularEfectividad(DatosCombate datosCombate);

	DatosCombate establecerGanador(DatosCombate datosCombate);
}

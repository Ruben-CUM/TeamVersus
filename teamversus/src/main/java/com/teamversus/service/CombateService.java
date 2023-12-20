package com.teamversus.service;

import java.util.ArrayList;
import java.util.List;

import com.teamversus.model.Combate;
import com.teamversus.model.Pokemon;
import com.teamversus.model.Teamversus;

public interface CombateService {

	public void createCombate();

	public ArrayList<Pokemon> createEquipoRival(Teamversus teamversus);
	
	public void addCombate(Teamversus teamversus, Combate combate);
	
	public Combate findUltimoCombate();

	public int[] procesarTurno(int indiceJugador, int indiceRival);
}

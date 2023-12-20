package com.teamversus.service;

import java.util.ArrayList;
import java.util.List;

import com.teamversus.model.Combate;
import com.teamversus.model.Pokemon;

public interface TeamversusService {
	
//	public void createTeamversus (Teamversus teamversus);
	
	public List<Pokemon> findListaPokemon();
	
	public List<Pokemon> findEquipo();
	
	public List<Combate> findCombates();
	
	public Pokemon findPokemonById (int pokemonId);
	
	public void addPokemon (int pokemonId);
	
	public void deletePokemonById (int pokemonId);
	
	public void addEquipoJugador (ArrayList<Pokemon> equipoJugador);
	
	public void addEquipoRival (ArrayList<Pokemon> equipoRival);
	
}

package com.teamversus.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamversus.model.Combate;
import com.teamversus.model.Pokemon;
import com.teamversus.model.Teamversus;
import com.teamversus.repository.TeamversusRepository;

@Service
public class TeamversusServiceImpl implements TeamversusService {

	private final TeamversusRepository teamversusRepository;

	@Autowired
	public TeamversusServiceImpl(TeamversusRepository teamversusRepository) {
		this.teamversusRepository = teamversusRepository;
	}

	@Override
	public void eliminarEquipo() {
		Teamversus teamversus = teamversusRepository.findById(1);
		teamversus.setEquipo(new ArrayList<Pokemon>(6));
		teamversus = teamversusRepository.save(teamversus);
	}

	@Override
	public List<Pokemon> findListaPokemon() {
		return teamversusRepository.findListaPokemon();
	}

	@Override
	public Pokemon findPokemonById(int pokemonId) {
		return teamversusRepository.findPokemonById(pokemonId);
	}

	@Override
	public List<Pokemon> findEquipo() {
		return teamversusRepository.findEquipo();
	}

	@Override
	public List<Combate> findCombates() {
		return teamversusRepository.findCombates();
	}

	@Override
	public void addPokemon(int pokemonId) {
		Pokemon pokemon = findPokemonById(pokemonId);
		Teamversus teamversus = teamversusRepository.findById(1);
		List<Pokemon> equipo = teamversus.getEquipo();
		if (!equipo.contains(pokemon) && equipo.size() < 6) {
			equipo.add(pokemon);
			teamversus.setEquipo(equipo);
			teamversus = teamversusRepository.save(teamversus);
		}
	}

	@Override
	public void deletePokemonById(int pokemonId) {
		Pokemon pokemon = findPokemonById(pokemonId);
		Teamversus teamversus = teamversusRepository.findById(1);
		List<Pokemon> equipo = teamversus.getEquipo();
		equipo.remove(pokemon);
		teamversus.setEquipo(equipo);
		teamversus = teamversusRepository.save(teamversus);
	}
}

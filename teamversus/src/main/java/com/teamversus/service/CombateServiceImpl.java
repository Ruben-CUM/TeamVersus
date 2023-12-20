package com.teamversus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamversus.logic.Tabla;
import com.teamversus.model.Combate;
import com.teamversus.model.Pokemon;
import com.teamversus.model.Teamversus;
import com.teamversus.repository.CombateRepository;
import com.teamversus.repository.TeamversusRepository;

@Service
public class CombateServiceImpl implements CombateService {

	private final TeamversusRepository teamversusRepository;
	private final CombateRepository combateRepository;

	@Autowired
	public CombateServiceImpl(TeamversusRepository teamversusRepository, CombateRepository combateRepository) {
		this.teamversusRepository = teamversusRepository;
		this.combateRepository = combateRepository;
	}

	@Override
	public void createCombate() {
		Combate combate = new Combate();
//		if (combateRepository.findById(combate.getId()).isPresent()) {
//			combateRepository.deleteEquipoJugador(combate.getId());
//			combateRepository.deleteEquipoRival(combate.getId());
//			combate = combateRepository.save(combate);
//		}

		Teamversus teamversus = teamversusRepository.findById(1);
		ArrayList<Pokemon> equipoJugador = (ArrayList<Pokemon>) teamversusRepository.findEquipo();
		ArrayList<Pokemon> equipoRival = createEquipoRival(teamversus);

		combate.setTeamversus(teamversus);
		combate.setEquipoJugador(equipoJugador);
		combate.setEquipoRival(equipoRival);
		combate = combateRepository.save(combate);

		addCombate(teamversus, combate);
	}

	@Override
	public ArrayList<Pokemon> createEquipoRival(Teamversus teamversus) {
		ArrayList<Pokemon> equipoAleatorio = new ArrayList<>();
		Random random = new Random();
		List<Integer> indicesUsados = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			int indiceAleatorio = random.nextInt(teamversus.getListaPokemon().size());
			while (indicesUsados.contains(indiceAleatorio)) {
				indiceAleatorio = random.nextInt(teamversus.getListaPokemon().size());
			}
			indicesUsados.add(indiceAleatorio);
			equipoAleatorio.add(teamversusRepository.findPokemonById(indiceAleatorio + 1));
		}

		return equipoAleatorio;
	}

	@Override
	public void addCombate(Teamversus teamversus, Combate combate) {
		List<Combate> listaCombates = new ArrayList<Combate>();

		listaCombates.add(combate);
		teamversus.setCombates(listaCombates);

		teamversus = teamversusRepository.save(teamversus);
		combate = combateRepository.save(combate);
	}

	@Override
	public Combate findUltimoCombate() {
		return combateRepository.findFirstByOrderByIdDesc();
	}

	@Override
	public int[] procesarTurno(int indiceJugador, int indiceRival) {
		int[] indices = {-1, -1};
		Combate combate = findUltimoCombate();
		ArrayList<Pokemon> equipoJugador = (ArrayList<Pokemon>) combateRepository
				.findEquipoJugadorByCombateId(combate.getId());
		ArrayList<Pokemon> equipoRival = (ArrayList<Pokemon>) combateRepository
				.findEquipoRivalByCombateId(combate.getId());
		System.out.println(indices[0]+ " "+indices[1]);
		if (indiceJugador < 5 && indiceRival < 5) {
			Pokemon pokemonJugador = equipoJugador.get(indiceJugador);
			Pokemon pokemonRival = equipoRival.get(indiceRival);
			double efectividadJugador = obtenerEfectividad(pokemonJugador, pokemonRival);
			double efectividadRival = obtenerEfectividad(pokemonRival, pokemonJugador);
			
			if (efectividadJugador > efectividadRival) {
				indices[0] = indiceJugador;
				indices[1] = indiceRival+1;
			} else if (efectividadJugador < efectividadRival) {
				indices[0] = indiceJugador+1;
				indices[1] = indiceRival;
			} else {
				Random random = new Random();
				int numeroAleatorio = random.nextInt(2);
				if (numeroAleatorio == 0) {
					indices[0] = indiceJugador;
					indices[1] = indiceRival+1;
				} else {
					indices[0] = indiceJugador+1;
					indices[1] = indiceRival;
				}
			}
		} if (indiceJugador == 5) {
			indices[0] = -1;
			indices[1] = 10;
		} else if (indiceRival == 5) {
			indices[0] = -1;
			indices[1] = 10;
		}

		System.out.println(indices[0]+ " "+indices[1]);
		
		return indices;
	}
	
	public double obtenerEfectividad (Pokemon pokemonJugador, Pokemon pokemonRival) {
		double efectividad = -1.0;
		if (pokemonJugador.getTipo2() == null) {
			if (pokemonRival.getTipo2() == null) {
				efectividad = Tabla.obtenerEficaciaTipo(Tabla.encontrarIndiceTipo(pokemonJugador.getTipo1()),
						Tabla.encontrarIndiceTipo(pokemonRival.getTipo1()));
			} else {
				efectividad = Tabla.obtenerEficaciaTipo(Tabla.encontrarIndiceTipo(pokemonJugador.getTipo1()),
						Tabla.encontrarIndiceTipo(pokemonRival.getTipo1()),
						Tabla.encontrarIndiceTipo(pokemonRival.getTipo2()));
			}
		} else {
			if (pokemonRival.getTipo2() == null) {
				efectividad = Tabla.obtenerEficaciaTipos(
						Tabla.encontrarIndiceTipo(pokemonJugador.getTipo1()),
						Tabla.encontrarIndiceTipo(pokemonJugador.getTipo2()),
						Tabla.encontrarIndiceTipo(pokemonRival.getTipo1()));
			} else {
				efectividad = Tabla.obtenerEficaciaTipo(Tabla.encontrarIndiceTipo(pokemonJugador.getTipo1()),
						Tabla.encontrarIndiceTipo(pokemonJugador.getTipo2()),
						Tabla.encontrarIndiceTipo(pokemonRival.getTipo1()),
						Tabla.encontrarIndiceTipo(pokemonRival.getTipo2()));
			}
		}
		return efectividad;
	}

}

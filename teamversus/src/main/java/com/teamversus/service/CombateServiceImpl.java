package com.teamversus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamversus.logic.DatosCombate;
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
		if (findUltimoCombate() != null) {
			combateRepository.deleteById(findUltimoCombate().getId());
		}
		Combate combate = new Combate();
		Teamversus teamversus = teamversusRepository.findById(1);
		combate.setTeamversus(teamversus);
		combate = combateRepository.save(combate);

		combate = findUltimoCombate();
		ArrayList<Pokemon> equipoJugador = (ArrayList<Pokemon>) teamversusRepository.findEquipo();
		ArrayList<Pokemon> equipoRival = createEquipoRival(teamversus);

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
	public DatosCombate procesarTurno(int indiceJugador, int indiceRival) {
		int[] indices = { -1, -1 };
		Combate combate = findUltimoCombate();
		ArrayList<Pokemon> equipoJugador = (ArrayList<Pokemon>) combateRepository
				.findEquipoJugadorByCombateId(combate.getId());
		ArrayList<Pokemon> equipoRival = (ArrayList<Pokemon>) combateRepository
				.findEquipoRivalByCombateId(combate.getId());
		double efectividadJugador = -1.0;
		double efectividadRival = -1.0;
		Pokemon ganador = new Pokemon();

		if (indiceJugador <= 5 && indiceRival <= 5) {
			Pokemon pokemonJugador = equipoJugador.get(indiceJugador);
			Pokemon pokemonRival = equipoRival.get(indiceRival);
			efectividadJugador = obtenerEfectividad(pokemonJugador, pokemonRival);
			efectividadRival = obtenerEfectividad(pokemonRival, pokemonJugador);

			if (efectividadJugador > efectividadRival) {
				ganador = pokemonJugador;
				indices[0] = indiceJugador;
				indices[1] = indiceRival + 1;
			} else if (efectividadJugador < efectividadRival) {
				ganador = pokemonRival;
				indices[0] = indiceJugador + 1;
				indices[1] = indiceRival;
			} else {
				Random random = new Random();
				int numeroAleatorio = random.nextInt(2);
				if (numeroAleatorio == 0) {
					ganador = pokemonJugador;
					indices[0] = indiceJugador;
					indices[1] = indiceRival + 1;
				} else {
					ganador = pokemonRival;
					indices[0] = indiceJugador + 1;
					indices[1] = indiceRival;
				}
			}
		}

		DatosCombate datosCombate = new DatosCombate(indices, efectividadJugador, efectividadRival, ganador);

		if (indiceJugador > 5 || indiceRival > 5 || indices[0] == -1 || indices[1] == -1 || indices[0] == 6
				|| indices[1] == 6) {
			datosCombate.setFin(true);
		}

		return datosCombate;
	}

	@Override
	public DatosCombate recalcularEfectividad(DatosCombate datosCombate) {
		Combate combate = findUltimoCombate();
		ArrayList<Pokemon> equipoJugador = (ArrayList<Pokemon>) combateRepository
				.findEquipoJugadorByCombateId(combate.getId());
		ArrayList<Pokemon> equipoRival = (ArrayList<Pokemon>) combateRepository
				.findEquipoRivalByCombateId(combate.getId());
		Pokemon pokemonJugador = equipoJugador.get(datosCombate.getIndices()[0]);
		Pokemon pokemonRival = equipoRival.get(datosCombate.getIndices()[1]);
		double efectividadJugador = obtenerEfectividad(pokemonJugador, pokemonRival);
		double efectividadRival = obtenerEfectividad(pokemonRival, pokemonJugador);
		datosCombate.setEficaciaJugador(efectividadJugador);
		datosCombate.setEficaciaRival(efectividadRival);

		if (efectividadJugador > efectividadRival) {
			datosCombate.setGanador(pokemonJugador);
		} else if (efectividadJugador < efectividadRival) {
			datosCombate.setGanador(pokemonRival);
		} else {
			Random random = new Random();
			int numeroAleatorio = random.nextInt(2);
			if (numeroAleatorio == 0) {
				datosCombate.setGanador(pokemonJugador);
			} else {
				datosCombate.setGanador(pokemonRival);
			}
		}

		return datosCombate;
	}

	@Override
	public DatosCombate establecerGanador(DatosCombate datosCombate) {
		datosCombate.setFin(true);
		if (datosCombate.getIndices()[0] > 5) {
			datosCombate.setEquipoGanador(1);
		} else if (datosCombate.getIndices()[1] > 5) {
			datosCombate.setEquipoGanador(0);
		}
		return datosCombate;
	}

	public double obtenerEfectividad(Pokemon pokemonJugador, Pokemon pokemonRival) {
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
				efectividad = Tabla.obtenerEficaciaTipos(Tabla.encontrarIndiceTipo(pokemonJugador.getTipo1()),
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

package com.example.data;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.data.model.Pokemon;
import com.example.data.model.Teamversus;
import com.example.data.repository.PokemonRepository;
import com.example.data.repository.TeamversusRepository;
import com.example.logic.Tabla;

@SpringBootTest
class TeamversusApplicationTests {

	@Autowired
	private TeamversusRepository teamversusRepository;

	@Autowired
	private PokemonRepository pokemonRepository;

	@Test
	void test() {
		System.out.println();
		testInicial();
		System.out.println();
	}

	public void testInicial() {

		System.out.println("Crear objeto principal Teamversus");

		Teamversus teamversus = new Teamversus();
		teamversus = teamversusRepository.save(teamversus);

		System.out.println("------------------------------");

		System.out.println("Crear Pokemon");

		Pokemon venusaur = new Pokemon("Venusaur", "PLANTA", "VENENO");
		Pokemon charizard = new Pokemon("Charizard", "FUEGO", "VOLADOR");
		Pokemon blastoise = new Pokemon("Blastoise", "AGUA", null);
		Pokemon pidgeot = new Pokemon("Pidgeot", "NORMAL", "VOLADOR");
		Pokemon fearow = new Pokemon("Fearow", "NORMAL", "VOLADOR");
		Pokemon raichu = new Pokemon("Raichu", "ELÉCTRICO", null);
		Pokemon sandslash = new Pokemon("Sandslash", "TIERRA", null);
		Pokemon nidoqueen = new Pokemon("Nidoqueen", "VENENO", "TIERRA");
		Pokemon nidoking = new Pokemon("Nidoking", "VENENO", "TIERRA");
		Pokemon clefable = new Pokemon("Clefable", "HADA", null);
		Pokemon ninetales = new Pokemon("Ninetales", "FUEGO", null);
		Pokemon wigglytuff = new Pokemon("Wigglytuff", "NORMAL", "HADA");
		Pokemon vileplume = new Pokemon("Vileplume", "PLANTA", "VENENO");
		Pokemon dugtrio = new Pokemon("Dugtrio", "TIERRA", null);
		Pokemon venomoth = new Pokemon("Venomoth", "BICHO", "VENENO");
		Pokemon muk = new Pokemon("Muk", "VENENO", null);
		Pokemon cloyster = new Pokemon("Cloyster", "AGUA", "HIELO");
		Pokemon gengar = new Pokemon("Gengar", "FANTASMA", "VENENO");
		Pokemon golem = new Pokemon("Golem", "ROCA", "TIERRA");
		Pokemon rapidash = new Pokemon("Rapidash", "FUEGO", null);
		Pokemon slowbro = new Pokemon("Slowbro", "AGUA", "PSÍQUICO");
		Pokemon magneton = new Pokemon("Magneton", "ELÉCTRICO", "ACERO");
		Pokemon dewgong = new Pokemon("Dewgong", "AGUA", "HIELO");
		Pokemon mewtwo = new Pokemon("Mewtwo", "PSÍQUICO", null);
		Pokemon articuno = new Pokemon("Articuno", "HIELO", "VOLADOR");
		Pokemon zapdos = new Pokemon("Zapdos", "ELÉCTRICO", "VOLADOR");
		Pokemon moltres = new Pokemon("Moltres", "FUEGO", "VOLADOR");
		Pokemon dragonite = new Pokemon("Dragonite", "DRAGÓN", "VOLADOR");

//		venusaur.setTeamversus(teamversus);
//		charizard.setTeamversus(teamversus);
//		blastoise.setTeamversus(teamversus);
//		pidgeot.setTeamversus(teamversus);
//		fearow.setTeamversus(teamversus);
//		raichu.setTeamversus(teamversus);
//		sandslash.setTeamversus(teamversus);
//		nidoqueen.setTeamversus(teamversus);
//		nidoking.setTeamversus(teamversus);
//		clefable.setTeamversus(teamversus);
//		ninetales.setTeamversus(teamversus);
//		wigglytuff.setTeamversus(teamversus);
//		vileplume.setTeamversus(teamversus);
//		dugtrio.setTeamversus(teamversus);
//		venomoth.setTeamversus(teamversus);
//		muk.setTeamversus(teamversus);
//		cloyster.setTeamversus(teamversus);
//		gengar.setTeamversus(teamversus);
//		golem.setTeamversus(teamversus);
//		rapidash.setTeamversus(teamversus);
//		slowbro.setTeamversus(teamversus);
//		magneton.setTeamversus(teamversus);
//		dewgong.setTeamversus(teamversus);
//		mewtwo.setTeamversus(teamversus);
//		articuno.setTeamversus(teamversus);
//		zapdos.setTeamversus(teamversus);
//		moltres.setTeamversus(teamversus);
//		dragonite.setTeamversus(teamversus);

		venusaur = pokemonRepository.save(venusaur);
		charizard = pokemonRepository.save(charizard);
		blastoise = pokemonRepository.save(blastoise);
		pidgeot = pokemonRepository.save(pidgeot);
		fearow = pokemonRepository.save(fearow);
		raichu = pokemonRepository.save(raichu);
		sandslash = pokemonRepository.save(sandslash);
		nidoqueen = pokemonRepository.save(nidoqueen);
		nidoking = pokemonRepository.save(nidoking);
		clefable = pokemonRepository.save(clefable);
		ninetales = pokemonRepository.save(ninetales);
		wigglytuff = pokemonRepository.save(wigglytuff);
		vileplume = pokemonRepository.save(vileplume);
		dugtrio = pokemonRepository.save(dugtrio);
		venomoth = pokemonRepository.save(venomoth);
		muk = pokemonRepository.save(muk);
		cloyster = pokemonRepository.save(cloyster);
		gengar = pokemonRepository.save(gengar);
		golem = pokemonRepository.save(golem);
		rapidash = pokemonRepository.save(rapidash);
		slowbro = pokemonRepository.save(slowbro);
		magneton = pokemonRepository.save(magneton);
		dewgong = pokemonRepository.save(dewgong);
		mewtwo = pokemonRepository.save(mewtwo);
		articuno = pokemonRepository.save(articuno);
		zapdos = pokemonRepository.save(zapdos);
		moltres = pokemonRepository.save(moltres);
		dragonite = pokemonRepository.save(dragonite);

		System.out.println("------------------------------");

		System.out.println("Añadir Pokemon a la lista de teamversus");

		List<Pokemon> listaPokemon = new ArrayList<Pokemon>();
		listaPokemon.add(venusaur);
		listaPokemon.add(charizard);
		listaPokemon.add(blastoise);
		listaPokemon.add(pidgeot);
		listaPokemon.add(fearow);
		listaPokemon.add(raichu);
		listaPokemon.add(sandslash);
		listaPokemon.add(nidoqueen);
		listaPokemon.add(nidoking);
		listaPokemon.add(clefable);
		listaPokemon.add(ninetales);
		listaPokemon.add(wigglytuff);
		listaPokemon.add(vileplume);
		listaPokemon.add(dugtrio);
		listaPokemon.add(venomoth);
		listaPokemon.add(muk);
		listaPokemon.add(cloyster);
		listaPokemon.add(gengar);
		listaPokemon.add(golem);
		listaPokemon.add(rapidash);
		listaPokemon.add(slowbro);
		listaPokemon.add(magneton);
		listaPokemon.add(dewgong);
		listaPokemon.add(mewtwo);
		listaPokemon.add(articuno);
		listaPokemon.add(zapdos);
		listaPokemon.add(moltres);
		listaPokemon.add(dragonite);
		teamversus.setListaPokemon(listaPokemon);
		
		
		teamversus = teamversusRepository.save(teamversus);
		System.out.println("------------------------------");

		System.out.println("Recuperar la lista de Pokemon y mostrarla");

		teamversus = teamversusRepository.findById(1);

		listaPokemon = (List<Pokemon>) pokemonRepository.findAll();
		teamversus.setListaPokemon(listaPokemon);

		System.out.println(teamversus.toString());

		Iterator<Pokemon> iterator = teamversus.getListaPokemon().iterator();
		while (iterator.hasNext()) {
			Pokemon pokemon = (Pokemon) iterator.next();
			System.out.println(pokemon.toString());
		}

		System.out.println("------------------------------");

		System.out.println("Buscar pokemon por id y por nombre");

		Pokemon buscarMewtwoId = pokemonRepository.findPokemonById(24);
		System.out.println(buscarMewtwoId.toString());
		Pokemon buscarMewtwoNombre = pokemonRepository.findPokemonByNombre("Mewtwo");
		System.out.println(buscarMewtwoNombre.toString());

		System.out.println("------------------------------");

		System.out.println("Dos equipos aleatorio de 6 pokemon");

		List<Pokemon> equipoAleatorio = new ArrayList<>();
		Random random = new Random();
		List<Integer> indicesUsados = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			int indiceAleatorio = random.nextInt(teamversus.getListaPokemon().size());
			while (indicesUsados.contains(indiceAleatorio)) {
				indiceAleatorio = random.nextInt(teamversus.getListaPokemon().size());
			}
			indicesUsados.add(indiceAleatorio);
			equipoAleatorio.add(teamversus.getListaPokemon().get(indiceAleatorio));
		}

		System.out.println("Equipo1");
		for (Pokemon pokemon : equipoAleatorio) {
			System.out.println(pokemon.toString());
		}

		System.out.println("------------------------------");

		List<Pokemon> equipoAleatorio2 = new ArrayList<>();
		random = new Random();
		indicesUsados = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			int indiceAleatorio = random.nextInt(teamversus.getListaPokemon().size());
			while (indicesUsados.contains(indiceAleatorio)) {
				indiceAleatorio = random.nextInt(teamversus.getListaPokemon().size());
			}
			indicesUsados.add(indiceAleatorio);
			equipoAleatorio2.add(pokemonRepository.findPokemonById(indiceAleatorio + 1));
		}

		System.out.println("Equipo 2");
		for (Pokemon pokemon : equipoAleatorio2) {
			System.out.println(pokemon.toString());
		}

		System.out.println("Primera versión de enfrentamiento entre equipos");

		for (int i = 0; i < equipoAleatorio.size(); i++) {
			System.out.println("Enfrentamiento " + (i + 1) + ":");
			Pokemon pokemonPropio = equipoAleatorio.get(i);
			Pokemon pokemonRival = equipoAleatorio2.get(i);
			System.out.println(pokemonPropio.toString());
			System.out.println("------VS.------");
			System.out.println(pokemonRival.toString());
			if (pokemonPropio.getTipo2() == null) {
				if (pokemonRival.getTipo2() == null) {
					Tabla.mostrarEficaciaTipo(Tabla.encontrarIndiceTipo(pokemonPropio.getTipo1()),
							Tabla.encontrarIndiceTipo(pokemonRival.getTipo1()));
				} else {
					Tabla.mostrarEficaciaTipo(Tabla.encontrarIndiceTipo(pokemonPropio.getTipo1()),
							Tabla.encontrarIndiceTipo(pokemonRival.getTipo1()),
							Tabla.encontrarIndiceTipo(pokemonRival.getTipo2()));
				}
			} else {
				if (pokemonRival.getTipo2() == null) {
					Tabla.mostrarEficaciaTipos(Tabla.encontrarIndiceTipo(pokemonPropio.getTipo1()),
							Tabla.encontrarIndiceTipo(pokemonPropio.getTipo2()),
							Tabla.encontrarIndiceTipo(pokemonRival.getTipo1()));
				} else {
					Tabla.mostrarEficaciaTipo(Tabla.encontrarIndiceTipo(pokemonPropio.getTipo1()),
							Tabla.encontrarIndiceTipo(pokemonPropio.getTipo2()),
							Tabla.encontrarIndiceTipo(pokemonPropio.getTipo2()),
							Tabla.encontrarIndiceTipo(pokemonRival.getTipo2()));
				}
			}
		}

		System.out.println("------------------------------");

		teamversusRepository.findAll();
		
		System.out.println("------------------------------");

		System.out.println("Buscar pokemon por id y por nombre");

		buscarMewtwoId = teamversusRepository.findPokemonById(24);
		System.out.println(buscarMewtwoId.toString());
		buscarMewtwoNombre = teamversusRepository.findPokemonByNombre("Mewtwo");
		System.out.println(buscarMewtwoNombre.toString());

		System.out.println("------------------------------");
	}

}

package com.teamversus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamversus.logic.Tabla;
import com.teamversus.model.Combate;
import com.teamversus.model.Pokemon;
import com.teamversus.model.Teamversus;
import com.teamversus.repository.CombateRepository;
import com.teamversus.repository.PokemonRepository;
import com.teamversus.repository.TeamversusRepository;

@SpringBootTest
class TeamversusApplicationTests {

	@Autowired
	private TeamversusRepository teamversusRepository;

	@Autowired
	private PokemonRepository pokemonRepository;

	@Autowired
	private CombateRepository combateRepository;

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

		Pokemon venusaur = new Pokemon("Venusaur", "PLANTA", "VENENO", "/images/venusaur.gif", "/images/venusaur_back.gif");
		Pokemon charizard = new Pokemon("Charizard", "FUEGO", "VOLADOR", "/images/charizard.gif", "/images/charizard_back.gif");
		Pokemon blastoise = new Pokemon("Blastoise", "AGUA", null, "/images/blastoise.gif", "/images/blastoise_back.gif");
		Pokemon pidgeot = new Pokemon("Pidgeot", "NORMAL", "VOLADOR", "/images/pidgeot.gif", "/images/pidgeot_back.gif");
		Pokemon fearow = new Pokemon("Fearow", "NORMAL", "VOLADOR", "/images/fearow.gif", "/images/fearow_back.gif");
		Pokemon raichu = new Pokemon("Raichu", "ELÉCTRICO", null, "/images/raichu.gif", "/images/raichu_back.gif");
		Pokemon sandslash = new Pokemon("Sandslash", "TIERRA", null, "/images/sandslash.gif", "/images/sandslash_back.gif");
		Pokemon nidoqueen = new Pokemon("Nidoqueen", "VENENO", "TIERRA", "/images/nidoqueen.gif", "/images/nidoqueen_back.gif");
		Pokemon nidoking = new Pokemon("Nidoking", "VENENO", "TIERRA", "/images/nidoking.gif", "/images/nidoking_back.gif");
		Pokemon clefable = new Pokemon("Clefable", "HADA", null, "/images/clefable.gif", "/images/clefable_back.gif");
		Pokemon ninetales = new Pokemon("Ninetales", "FUEGO", null, "/images/ninetales.gif", "/images/ninetales_back.gif");
		Pokemon wigglytuff = new Pokemon("Wigglytuff", "NORMAL", "HADA", "/images/wigglytuff.gif", "/images/wigglytuff_back.gif");
		Pokemon vileplume = new Pokemon("Vileplume", "PLANTA", "VENENO", "/images/vileplume.gif", "/images/vileplume_back.gif");
		Pokemon dugtrio = new Pokemon("Dugtrio", "TIERRA", null, "/images/dugtrio.gif", "/images/dugtrio_back.gif");
		Pokemon venomoth = new Pokemon("Venomoth", "BICHO", "VENENO", "/images/venomoth.gif", "/images/venomoth_back.gif");
		Pokemon muk = new Pokemon("Muk", "VENENO", null, "/images/muk.gif", "/images/muk_back.gif");
		Pokemon cloyster = new Pokemon("Cloyster", "AGUA", "HIELO", "/images/cloyster.gif", "/images/cloyster_back.gif");
		Pokemon gengar = new Pokemon("Gengar", "FANTASMA", "VENENO", "/images/gengar.gif", "/images/gengar_back.gif");
		Pokemon golem = new Pokemon("Golem", "ROCA", "TIERRA", "/images/golem.gif", "/images/golem_back.gif");
		Pokemon rapidash = new Pokemon("Rapidash", "FUEGO", null, "/images/rapidash.gif", "/images/rapidash_back.gif");
		Pokemon slowbro = new Pokemon("Slowbro", "AGUA", "PSÍQUICO", "/images/slowbro.gif", "/images/slowbro_back.gif");
		Pokemon magneton = new Pokemon("Magneton", "ELÉCTRICO", "ACERO", "/images/magneton.gif", "/images/magneton_back.gif");
		Pokemon dewgong = new Pokemon("Dewgong", "AGUA", "HIELO", "/images/dewgong.gif", "/images/dewgong_back.gif");
		Pokemon gyarados = new Pokemon("Gyarados", "AGUA", "VOLADOR", "/images/gyarados.gif", "/images/gyarados_back.gif");
		Pokemon lapras = new Pokemon("Lapras", "AGUA", "HIELO", "/images/lapras.gif", "/images/lapras_back.gif");
		Pokemon vaporeon = new Pokemon("Vaporeon", "AGUA", null, "/images/vaporeon.gif", "/images/vaporeon_back.gif");
		Pokemon jolteon = new Pokemon("Jolteon", "ELÉCTRICO", null, "/images/jolteon.gif", "/images/jolteon_back.gif");
		Pokemon flareon = new Pokemon("Flareon", "FUEGO", null, "/images/flareon.gif", "/images/flareon_back.gif");
		Pokemon arcanine = new Pokemon("Arcanine", "FUEGO", null, "/images/arcanine.gif", "/images/arcanine_back.gif");
		Pokemon snorlax = new Pokemon("Snorlax", "NORMAL", null, "/images/snorlax.gif", "/images/snorlax_back.gif");
		Pokemon mewtwo = new Pokemon("Mewtwo", "PSÍQUICO", null, "/images/mewtwo.gif", "/images/mewtwo_back.gif");
		Pokemon articuno = new Pokemon("Articuno", "HIELO", "VOLADOR", "/images/articuno.gif", "/images/articuno_back.gif");
		Pokemon zapdos = new Pokemon("Zapdos", "ELÉCTRICO", "VOLADOR", "/images/zapdos.gif", "/images/zapdos_back.gif");
		Pokemon moltres = new Pokemon("Moltres", "FUEGO", "VOLADOR", "/images/moltres.gif", "/images/moltres_back.gif");
		Pokemon dragonite = new Pokemon("Dragonite", "DRAGÓN", "VOLADOR", "/images/dragonite.gif", "/images/dragonite_back.gif");


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
		gyarados = pokemonRepository.save(gyarados);
		lapras = pokemonRepository.save(lapras);
		vaporeon = pokemonRepository.save(vaporeon);
		jolteon = pokemonRepository.save(jolteon);
		flareon = pokemonRepository.save(flareon);
		arcanine = pokemonRepository.save(arcanine);
		snorlax = pokemonRepository.save(snorlax);
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
		listaPokemon.add(gyarados);
		listaPokemon.add(lapras);
		listaPokemon.add(vaporeon);
		listaPokemon.add(jolteon);
		listaPokemon.add(flareon);
		listaPokemon.add(arcanine);
		listaPokemon.add(snorlax);
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

//		System.out.println("Buscar pokemon por id y por nombre");
//
//		Pokemon buscarMewtwoId = pokemonRepository.findPokemonById(24);
//		System.out.println(buscarMewtwoId.toString());
//		Pokemon buscarMewtwoNombre = pokemonRepository.findPokemonByNombre("Mewtwo");
//		System.out.println(buscarMewtwoNombre.toString());
//
//		System.out.println("------------------------------");

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

		System.out.println("------------------------------");

		System.out.println("EntidadCombate");

		Combate combate = new Combate();

		combate.setTeamversus(teamversus);
		combate.setEquipoJugador(equipoAleatorio);
		combate.setEquipoRival(equipoAleatorio2);

		combate = combateRepository.save(combate);

		System.out.println(combate.toString());

		System.out.println("------------------------------");

		System.out.println("Añadir Combate a la lista de teamversus");

		List<Combate> listaCombates = new ArrayList<Combate>();

		listaCombates.add(combate);
		teamversus.setCombates(listaCombates);

		teamversus = teamversusRepository.save(teamversus);
		combate = combateRepository.save(combate);

		System.out.println(teamversus.toString());

		System.out.println("------------------------------");

		System.out.println("Recuperar la lista de combates y mostrarla");

		teamversus = teamversusRepository.findById(1);

//		listaCombates = (List<Combate>) combateRepository.findAll();
//		teamversus.setCombates(listaCombates);
//
//		System.out.println(teamversus.toString());
//
//		Iterator<Combate> iteratorCombate = teamversus.getCombates().iterator();
//		while (iteratorCombate.hasNext()) {
//			Combate combateAux = (Combate) iteratorCombate.next();
//			
//			List<Pokemon> equipo = (List<Pokemon>) combateRepository.findEquipoJugadorByCombateId(combateAux.getId());
//			combateAux.setEquipojugador(equipo);
//
//			Iterator<Pokemon> iteratorPokemon = combateAux.getEquipojugador().iterator();
//			while (iteratorPokemon.hasNext()) {
//				Pokemon pokemon = (Pokemon) iteratorPokemon.next();
//				//System.out.println(pokemon.toString());
//			}
//			
//			equipo = (List<Pokemon>) combateRepository.findEquipoRivalByCombateId(combateAux.getId());
//			combateAux.setEquiporival(equipo);
//
//			iteratorPokemon = combateAux.getEquiporival().iterator();
//			while (iteratorPokemon.hasNext()) {
//				Pokemon pokemon = (Pokemon) iteratorPokemon.next();
//				//System.out.println(pokemon.toString());
//			}
//			
//			System.out.println(combateAux.toString());
//			
//		}

		teamversus = teamversusRepository.findById(1);
		listaCombates = (List<Combate>) combateRepository.findAll();
		teamversus.setCombates(listaCombates);

		for (Combate combateAux : teamversus.getCombates()) {
			combateAux.setEquipoJugador(combateRepository.findEquipoJugadorByCombateId(combateAux.getId()));
			combateAux.setEquipoRival(combateRepository.findEquipoRivalByCombateId(combateAux.getId()));
			System.out.println(combateAux.toString());
		}

		System.out.println("------------------------------");

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
							Tabla.encontrarIndiceTipo(pokemonRival.getTipo1()),
							Tabla.encontrarIndiceTipo(pokemonRival.getTipo2()));
				}
			}

			System.out.println("NUEVO (Al revés)");
			pokemonPropio = equipoAleatorio2.get(i);
			pokemonRival = equipoAleatorio.get(i);
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
							Tabla.encontrarIndiceTipo(pokemonRival.getTipo1()),
							Tabla.encontrarIndiceTipo(pokemonRival.getTipo2()));
				}
			}
		}

		System.out.println("------------------------------");

		teamversusRepository.findAll();

		System.out.println("------------------------------");

		System.out.println("Buscar pokemon por id y por nombre");

		Pokemon buscarMewtwoId = teamversusRepository.findPokemonById(24);
		System.out.println(buscarMewtwoId.toString());
		Pokemon buscarMewtwoNombre = teamversusRepository.findPokemonByNombre("Mewtwo");
		System.out.println(buscarMewtwoNombre.toString());

		System.out.println("------------------------------");
		
		System.out.println("Metodo para obtener la lista");

		listaPokemon = teamversusRepository.findListaPokemon();

		System.out.println(teamversus.toString());

		for (Pokemon pokemon : listaPokemon) {
			System.out.println(pokemon.toString());
		}
		
		System.out.println("------------------------------");

	}

}

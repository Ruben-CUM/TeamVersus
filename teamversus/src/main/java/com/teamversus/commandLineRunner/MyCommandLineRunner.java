package com.teamversus.commandLineRunner;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.teamversus.model.Pokemon;
import com.teamversus.model.Teamversus;
import com.teamversus.repository.PokemonRepository;
import com.teamversus.repository.TeamversusRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	private final PokemonRepository pokemonRepository;
	private final TeamversusRepository teamversusRepository;

	private static final Logger logger = LoggerFactory.getLogger(MyCommandLineRunner.class);

	public MyCommandLineRunner(PokemonRepository pokemonRepository, TeamversusRepository teamversusRepository) {
		this.pokemonRepository = pokemonRepository;
		this.teamversusRepository = teamversusRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\t MyCommandLineRunner lanzado ");
		poblarBD();
	}

	private void poblarBD() {
		
		//1. Crear objeto principal Teamversus
		
		Teamversus teamversus = new Teamversus();
		teamversus = teamversusRepository.save(teamversus);
		
		//2. Crear Pokemon (poblar tabla Pokemon)
		
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
		Pokemon umbreon = new Pokemon("Umbreon", "SINIESTRO", null, "/images/umbreon.gif", "/images/umbreon_back.gif");
		Pokemon machamp = new Pokemon("Machamp", "LUCHA", null, "/images/machamp.gif", "/images/machamp_back.gif");
		Pokemon arcanine = new Pokemon("Arcanine", "FUEGO", null, "/images/arcanine.gif", "/images/arcanine_back.gif");
		Pokemon snorlax = new Pokemon("Snorlax", "NORMAL", null, "/images/snorlax.gif", "/images/snorlax_back.gif");
		Pokemon mewtwo = new Pokemon("Mewtwo", "PSÍQUICO", null, "/images/mewtwo.gif", "/images/mewtwo_back.gif");
		Pokemon articuno = new Pokemon("Articuno", "HIELO", "VOLADOR", "/images/articuno.gif", "/images/articuno_back.gif");
		Pokemon zapdos = new Pokemon("Zapdos", "ELÉCTRICO", "VOLADOR", "/images/zapdos.gif", "/images/zapdos_back.gif");
		Pokemon moltres = new Pokemon("Moltres", "FUEGO", "VOLADOR", "/images/moltres.gif", "/images/moltres_back.gif");
		Pokemon dragonite = new Pokemon("Dragonite", "DRAGÓN", "VOLADOR", "/images/dragonite.gif", "/images/dragonite_back.gif");
		
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
		umbreon = pokemonRepository.save(umbreon);
		machamp = pokemonRepository.save(machamp);
		arcanine = pokemonRepository.save(arcanine);
		snorlax = pokemonRepository.save(snorlax);
		mewtwo = pokemonRepository.save(mewtwo);
		articuno = pokemonRepository.save(articuno);
		zapdos = pokemonRepository.save(zapdos);
		moltres = pokemonRepository.save(moltres);
		dragonite = pokemonRepository.save(dragonite);
		
		// 3. Añadir Pokemon a la lista de teamversus
		
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
		listaPokemon.add(umbreon);
		listaPokemon.add(machamp);
		listaPokemon.add(arcanine);
		listaPokemon.add(snorlax);
		listaPokemon.add(mewtwo);
		listaPokemon.add(articuno);
		listaPokemon.add(zapdos);
		listaPokemon.add(moltres);
		listaPokemon.add(dragonite);
		teamversus.setListaPokemon(listaPokemon);
		
		// 4. Guardar de nuevo teamversus con la lista añadida

		teamversus = teamversusRepository.save(teamversus);

		// 5. Registar en el logger el contenido de los pokemon guardados y mostrarlos.
		teamversusRepository.findListaPokemon().forEach((pokemon) -> {
			logger.info("{}", pokemon.toString());
		});
		
	}
}

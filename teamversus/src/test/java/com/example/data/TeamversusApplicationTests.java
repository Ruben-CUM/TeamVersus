package com.example.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.data.model.Pokemon;
import com.example.data.model.Teamversus;
import com.example.data.repository.TeamversusRepository;

@SpringBootTest
class TeamversusApplicationTests {
	
	@Autowired
	private TeamversusRepository teamversusRepository;

	@Test
	void test() {
		System.out.println("Crear objeto principal Teamversus");
		Teamversus teamversus = new Teamversus();
		teamversus = teamversusRepository.save(teamversus);
		String[] pokemonArray = {
			    "Pikachu Electric",
			    "Charizard Fire Flying",
			    "Bulbasaur Grass Poison",
			    "Squirtle Water",
			    "Jigglypuff Normal Fairy"
			};
		Pokemon p1 = new Pokemon("Pikachu", "ELÉCTRICO", null);
		Pokemon p2 = new Pokemon("Charizard", "FUEGO", "VOLADOR");
		
		
		List<Pokemon> listaPokemon = new ArrayList<Pokemon>();
		listaPokemon.add(p1);
		
	}

}

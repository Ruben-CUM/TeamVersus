package com.example.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
	}

}

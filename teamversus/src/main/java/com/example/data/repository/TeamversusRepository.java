package com.example.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.data.model.Pokemon;
import com.example.data.model.Teamversus;

@Repository
public interface TeamversusRepository extends CrudRepository<Teamversus, Integer> {
	
	Teamversus findById(int id);
	
	@Query("SELECT p FROM Teamversus t JOIN t.listaPokemon p WHERE p.id = :id")
	Pokemon findPokemonById(@Param("id") int id);

	@Query("SELECT p FROM Teamversus t JOIN t.listaPokemon p WHERE p.nombre = :nombre")
	Pokemon findPokemonByNombre(@Param("nombre") String nombre);
}

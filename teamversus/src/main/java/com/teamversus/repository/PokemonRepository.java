package com.teamversus.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teamversus.model.Pokemon;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
	@Query("SELECT p FROM Pokemon p WHERE p.id = :id")
	Pokemon findPokemonById(@Param("id") int id);

	@Query("SELECT p FROM Pokemon p WHERE p.nombre = :nombre")
	Pokemon findPokemonByNombre(@Param("nombre") String nombre);
}

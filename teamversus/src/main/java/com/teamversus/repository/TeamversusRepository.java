package com.teamversus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teamversus.model.Combate;
import com.teamversus.model.Pokemon;
import com.teamversus.model.Teamversus;

@Repository
public interface TeamversusRepository extends CrudRepository<Teamversus, Integer> {
	
	Teamversus findById(int id);
	
	@Query("SELECT p FROM Teamversus t JOIN t.listaPokemon p")
    List<Pokemon> findListaPokemon();
	
	@Query("SELECT p FROM Teamversus t JOIN t.equipo p")
	List<Pokemon> findEquipo();
	
	@Query("SELECT p FROM Teamversus t JOIN t.combates p")
	List<Combate> findCombates();
	
	@Query("SELECT p FROM Teamversus t JOIN t.listaPokemon p WHERE p.id = :id")
	Pokemon findPokemonById(@Param("id") int id);

	@Query("SELECT p FROM Teamversus t JOIN t.listaPokemon p WHERE p.nombre = :nombre")
	Pokemon findPokemonByNombre(@Param("nombre") String nombre);
}

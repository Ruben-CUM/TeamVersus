package com.example.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.data.model.Pokemon;
import com.example.data.model.Teamversus;

@Repository
public interface TeamversusRepository extends CrudRepository<Teamversus, Integer>{
	Pokemon findByListaPokemonId(Long id);
    Pokemon findByListaPokemonNombre(String nombre);
}

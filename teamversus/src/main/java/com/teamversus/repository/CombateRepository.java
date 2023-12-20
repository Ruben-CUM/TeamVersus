package com.teamversus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teamversus.model.Combate;
import com.teamversus.model.Pokemon;

@Repository
public interface CombateRepository extends CrudRepository<Combate, Integer> {
	@Query("SELECT c.equipoJugador FROM Combate c WHERE c.id = :combateId")
	List<Pokemon> findEquipoJugadorByCombateId(@Param("combateId") int combateId);

	@Query("SELECT c.equipoRival FROM Combate c WHERE c.id = :combateId")
	List<Pokemon> findEquipoRivalByCombateId(@Param("combateId") int combateId);

	Combate findFirstByOrderByIdDesc();

	void deleteById(int id);
}

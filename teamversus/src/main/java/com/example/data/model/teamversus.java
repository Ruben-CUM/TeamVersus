package com.example.data.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Teamversus {
	
	//Interfaz base batalla
	//https://aprenderaprogramar.com/foros/index.php?topic=7889.0
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany
	private List<Pokemon> listaPokemon = new ArrayList<Pokemon>();

	public Teamversus() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Pokemon> getListaPokemon() {
		return listaPokemon;
	}

	public void setListaPokemon(List<Pokemon> listaPokemon) {
		this.listaPokemon = listaPokemon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, listaPokemon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teamversus other = (Teamversus) obj;
		return id == other.id && Objects.equals(listaPokemon, other.listaPokemon);
	}

	@Override
	public String toString() {
		return "Teamversus [id=" + id + "]";
	}
	
}

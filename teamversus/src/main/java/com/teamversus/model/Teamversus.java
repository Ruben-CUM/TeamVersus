package com.teamversus.model;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Teamversus{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany
	private List<Pokemon> listaPokemon;
	
	@OneToMany
	private List<Pokemon> equipo = new ArrayList<Pokemon>(6);
	
	@OneToMany (mappedBy = "teamversus")
	private List<Combate> combates;
	
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

	public List<Pokemon> getEquipo() {
		return equipo;
	}

	public void setEquipo(List<Pokemon> equipo) {
		this.equipo = equipo;
	}

	public List<Combate> getCombates() {
		return combates;
	}

	public void setCombates(List<Combate> combates) {
		this.combates = combates;
	}

	@Override
	public String toString() {
		return "Teamversus [id=" + id + "]";
	}
}
package com.teamversus.model;

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany
	private List<Pokemon> listaPokemon;

	@OneToMany
	private List<Pokemon> equipo = new ArrayList<Pokemon>(6);

	@OneToMany(mappedBy = "teamversus")
	private List<Combate> combates;

	public Teamversus() {
	}

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
	public int hashCode() {
		return Objects.hash(combates, equipo, id, listaPokemon);
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
		return Objects.equals(combates, other.combates) && Objects.equals(equipo, other.equipo) && id == other.id
				&& Objects.equals(listaPokemon, other.listaPokemon);
	}

	@Override
	public String toString() {
		return "Teamversus [id=" + id + "]";
	}
}
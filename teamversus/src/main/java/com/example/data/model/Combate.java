package com.example.data.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
public class Combate {
	
	private List<Pokemon> equipo1 = new ArrayList<Pokemon>();
	
	private List<Pokemon> equipo2 = new ArrayList<Pokemon>();
	
	public Combate() {}

	public Combate(List<Pokemon> equipo1) {
		super();
		this.equipo1 = equipo1;
	}

	public List<Pokemon> getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(List<Pokemon> equipo1) {
		this.equipo1 = equipo1;
	}

	public List<Pokemon> getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(List<Pokemon> equipo2) {
		this.equipo2 = equipo2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipo1, equipo2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combate other = (Combate) obj;
		return Objects.equals(equipo1, other.equipo1) && Objects.equals(equipo2, other.equipo2);
	}

	@Override
	public String toString() {
		return "Combate [equipo1=" + equipo1 + ", equipo2=" + equipo2 + "]";
	}
	
}

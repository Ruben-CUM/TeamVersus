package com.teamversus.model;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Combate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Teamversus teamversus;

	@OneToMany
	private List<Pokemon> equipoJugador = new ArrayList<Pokemon>();

	@OneToMany
	private List<Pokemon> equipoRival = new ArrayList<Pokemon>();

	public Combate() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teamversus getTeamversus() {
		return teamversus;
	}

	public void setTeamversus(Teamversus teamversus) {
		this.teamversus = teamversus;
	}

	public List<Pokemon> getEquipoJugador() {
		return equipoJugador;
	}

	public void setEquipoJugador(List<Pokemon> equipojugador) {
		this.equipoJugador = equipojugador;
	}

	public List<Pokemon> getEquipoRival() {
		return equipoRival;
	}

	public void setEquipoRival(List<Pokemon> equiporival) {
		this.equipoRival = equiporival;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Combate [id=").append(id).append(", Teamversus=").append(teamversus.getId()).append("]\n");
		sb.append("Equipo del Jugador:\n");
		for (Pokemon pokemon : equipoJugador) {
			sb.append(pokemon).append("\n");
		}
		sb.append("Equipo del Rival:\n");
		for (Pokemon pokemon : equipoRival) {
			sb.append(pokemon).append("\n");
		}
		return sb.toString();
	}
}

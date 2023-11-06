package com.example.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pokemon {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private String tipo1;
	
	private String tipo2;
	
//	@ManyToOne
//	private Teamversus teamversus;
	
	public Pokemon() {}

	public Pokemon(String nombre, String tipo1, String tipo2) {
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo1() {
		return tipo1;
	}

	public void setTipo1(String tipo1) {
		this.tipo1 = tipo1;
	}

	public String getTipo2() {
		return tipo2;
	}

	public void setTipo2(String tipo2) {
		this.tipo2 = tipo2;
	}

//	public Teamversus getTeamversus() {
//		return teamversus;
//	}
//
//	public void setTeamversus(Teamversus teamversus) {
//		this.teamversus = teamversus;
//	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nombre=" + nombre + ", tipo1=" + tipo1 + ", tipo2=" + tipo2 + /*", teamversus="
				+ teamversus.toString() +*/ "]";
	}
	
}

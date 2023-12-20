package com.teamversus.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pokemon {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private String tipo1;
	
	private String tipo2;
	
	private String spriteFront;
	
	private String spriteBack;
	
	public Pokemon() {}

	public Pokemon(String nombre, String tipo1, String tipo2, String spriteFront, String spriteBack) {
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.spriteFront = spriteFront;
		this.spriteBack = spriteBack;
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

	public String getSpriteFront() {
		return spriteFront;
	}

	public void setSpriteFront(String spriteFront) {
		this.spriteFront = spriteFront;
	}

	public String getSpriteBack() {
		return spriteBack;
	}

	public void setSpriteBack(String spriteBack) {
		this.spriteBack = spriteBack;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, spriteBack, spriteFront, tipo1, tipo2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return id == other.id && Objects.equals(nombre, other.nombre) && Objects.equals(spriteBack, other.spriteBack)
				&& Objects.equals(spriteFront, other.spriteFront) && Objects.equals(tipo1, other.tipo1)
				&& Objects.equals(tipo2, other.tipo2);
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nombre=" + nombre + ", tipo1=" + tipo1 + ", tipo2=" + tipo2 + ", spriteFront="
				+ spriteFront + ", spriteBack=" + spriteBack + "]";
	}
	
}

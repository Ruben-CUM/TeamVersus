package com.teamversus.logic;

import java.util.Arrays;
import java.util.Objects;

import com.teamversus.model.Pokemon;

public class DatosCombate {

	public int[] indices;
	public double eficaciaJugador;
	public double eficaciaRival;
	public Pokemon ganador;
	public boolean fin;
	public int equipoGanador;

	public DatosCombate() {
	}

	public DatosCombate(int[] indices, double eficaciaJugador, double eficaciaRival, Pokemon ganador) {
		this.indices = indices;
		this.eficaciaJugador = eficaciaJugador;
		this.eficaciaRival = eficaciaRival;
		this.ganador = ganador;
		this.fin = false;
		this.equipoGanador = -1;
	}

	public int[] getIndices() {
		return indices;
	}

	public void setIndices(int[] indices) {
		this.indices = indices;
	}

	public double getEficaciaJugador() {
		return eficaciaJugador;
	}

	public void setEficaciaJugador(double eficaciaJugador) {
		this.eficaciaJugador = eficaciaJugador;
	}

	public double getEficaciaRival() {
		return eficaciaRival;
	}

	public void setEficaciaRival(double eficaciaRival) {
		this.eficaciaRival = eficaciaRival;
	}

	public Pokemon getGanador() {
		return ganador;
	}

	public void setGanador(Pokemon ganador) {
		this.ganador = ganador;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public int getEquipoGanador() {
		return equipoGanador;
	}

	public void setEquipoGanador(int equipoGanador) {
		this.equipoGanador = equipoGanador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(indices);
		result = prime * result + Objects.hash(eficaciaJugador, eficaciaRival, equipoGanador, fin, ganador);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DatosCombate other = (DatosCombate) obj;
		return Double.doubleToLongBits(eficaciaJugador) == Double.doubleToLongBits(other.eficaciaJugador)
				&& Double.doubleToLongBits(eficaciaRival) == Double.doubleToLongBits(other.eficaciaRival)
				&& equipoGanador == other.equipoGanador && fin == other.fin && Objects.equals(ganador, other.ganador)
				&& Arrays.equals(indices, other.indices);
	}

	@Override
	public String toString() {
		return "DatosCombate [indices=" + Arrays.toString(indices) + ", eficaciaJugador=" + eficaciaJugador
				+ ", eficaciaRival=" + eficaciaRival + ", ganador=" + ganador + ", fin=" + fin + ", equipoGanador="
				+ equipoGanador + "]";
	}

}

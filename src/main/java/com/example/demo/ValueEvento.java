package com.example.demo;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class ValueEvento {
   
	 public String titulo, contenido, categoria;
	 public Date dia_semana, notif_tiempo;
	 
	 //@DateTimeFormat(pattern = "dd/mm/yyyy")
	 public String fechaInicio;
	 
	
	 //@DateTimeFormat(pattern = "dd/mm/yyyy")
	 public String fechaFin;
	 
	 public Timestamp horaInicio, horaFin;
	 public int seRepite;
	   
	 public ValueEvento() {
		   
	 }

	public String getTitulo() {
		return titulo;
	}

	
	
   
	public Date getDia_semana() {
		return dia_semana;
	}

	public void setDia_semana(Date dia_semana) {
		this.dia_semana = dia_semana;
	}

	public Date getNotif_tiempo() {
		return notif_tiempo;
	}

	public void setNotif_tiempo(Date notif_tiempo) {
		this.notif_tiempo = notif_tiempo;
	}

	public Timestamp getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Timestamp horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Timestamp getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Timestamp horaFin) {
		this.horaFin = horaFin;
	}

	public int getSeRepite() {
		return seRepite;
	}

	public void setSeRepite(int seRepite) {
		this.seRepite = seRepite;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}

package com.minici.covid.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpaciente")
	public Long id;
	
	@NotNull
	private String nombre;
	@NotNull
	private String apellido;
	
	//private String nacionalidad;
	//private Integer dni;
	@NotNull
	private char genero;
	private Integer edad;
	
	@Transient
	private ArrayList<ListaSintomas> Sintomas = new ArrayList<ListaSintomas>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	@NotNull
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@NotNull
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
/*	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}*/
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	@Transient
	public ArrayList<ListaSintomas> getSintomas() {
		return Sintomas;
	}
	
	@Transient
	public void setSintomas(ArrayList<ListaSintomas> sintomas) {
		Sintomas = sintomas;
	}
	
}

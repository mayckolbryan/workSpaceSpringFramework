/**
 * 
 */
package com.mitocode.model;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author BRYAN
 *
 */
public class Persona {
	
	@Value("1")
	private int id;
	@Value("Steven")
	private String nombres;
	@Value("King")
	private String apellidos;
	
//	public Persona(int id, String nombres, String apellidos) {
//		super();
//		this.id = id;
//		this.nombres = nombres;
//		this.apellidos = apellidos;
//	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombres=" + nombres + ", apellidos="
				+ apellidos + "]";
	}
}

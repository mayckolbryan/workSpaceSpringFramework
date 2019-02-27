/**
 * 
 */
package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Persona;

/**
 * @author BRYAN
 *
 */
public class PersonaServiceImpl implements IPersonaService{

	@Override
	public void crear() {
		System.out.println("Persona creada.");
		
	}

	@Override
	public List<Persona> listar() {
		return null;
	}

}

/**
 * 
 */
package com.mitocode.dao;

import java.util.List;

import com.mitocode.model.Persona;

/**
 * @author BRYAN
 *
 */
public interface IPersonaDAO {
	void create(Persona persona);
	void update(Persona persona);
	List<Persona> listAll();
	Persona find(Integer id);
	void delete(Integer id);
}

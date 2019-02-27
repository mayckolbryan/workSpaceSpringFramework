/**
 * 
 */
package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Persona;

/**
 * @author BRYAN
 *
 */
//@Service es un estereotipo que le indica a spring que es una clase de representacion de una lógica. (Esteoritipo Service)
@Service
public class PersonaServiceImpl implements IPersonaService{
	
	//@Autowired busca e inyecta la instancia a la variable, la busqueda lo hace dentro del core container.
	//@Qualifier("...") te permite indicar a que implementacion vas a instanciar, esto es necesaio en caso de haber varias implementaciones que implementan la misma interfaz.
	@Autowired
	private IPersonaDAO dao;
	
	@Override
	public void create(Persona persona) {
		dao.create(persona);
	}

	@Override
	public void update(Persona persona) {
		dao.update(persona);
	}

	@Override
	public List<Persona> listAll() {
		return dao.listAll();
	}

	@Override
	public Persona find(Integer id) {
		return dao.find(id);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

}

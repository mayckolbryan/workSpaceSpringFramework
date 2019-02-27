/**
 * 
 */
package com.mitocode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.PersonaServiceImpl;

/**
 * @author BRYAN
 *
 */
// @Configuration indica que este archivo sera el reemplazo del archivo beans.xml pero en anotacion
// @ComponentScan se encarga de escanear las clases que se podran usar en este archivo, pero siempre y cuando esten dentro del paquete amenos que se le indique, ejemplo: todo lo que este dentro de com.mitocode incluyendo model y service
@Configuration
@ComponentScan
public class AppConfig {
	
	@Bean(name="personaService")
	public IPersonaService personaService(){
		return new PersonaServiceImpl();
	}
	
	@Bean(name="persona")
	public Persona persona(){
		return new Persona();
	}
}

package com.mitocode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.PersonaServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        IPersonaService service = context.getBean(PersonaServiceImpl.class);
        
        Persona persona = new Persona();
        persona.setId(1);
        persona.setNombres("Juan");
        persona.setApellidos("Perla");
        
        service.create(persona);
        
        for (Persona fila : service.listAll()) {
			System.out.println(fila);
		}
    }
}

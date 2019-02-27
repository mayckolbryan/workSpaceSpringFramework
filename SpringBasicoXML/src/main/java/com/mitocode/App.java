package com.mitocode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        IPersonaService service = new PersonaServiceImpl();
//        service.crear();
        
    	//Instancia con el beans.xml, que es donde spring maneja las intancias de clase por el core container(DI)
    	//Singleton
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        IPersonaService service = (IPersonaService)context.getBean("personaService");
        service.crear();
        
        Persona persona = (Persona)context.getBean("persona");
//        persona.setId(1);
//        persona.setNombres("Robert");
//        persona.setApellidos("Junior");
        System.out.println(persona);
        
        //Cierra el contexto
        ((ConfigurableApplicationContext)context).close();
    }
}

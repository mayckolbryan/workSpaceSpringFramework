package com.mitocode;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

/**
 * Hello world!
 *
 */
//JavaBased
public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IPersonaService service = (IPersonaService)context.getBean("personaService");
        service.crear();
        
        Persona persona = (Persona)context.getBean("persona");
//        persona.setId(1);
//        persona.setNombres("Robert");
//        persona.setApellidos("Junior");
        System.out.println(persona);
        ((ConfigurableApplicationContext)context).close();
    }
}

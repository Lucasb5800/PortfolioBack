package com.MiAplicacion.PrimerProyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.MiAplicacion.PrimerProyecto.Repository")
public class PrimerProyectoApplication 
{
    public static void main(String[] args) 
    {
	SpringApplication.run(PrimerProyectoApplication.class, args);
    }
}

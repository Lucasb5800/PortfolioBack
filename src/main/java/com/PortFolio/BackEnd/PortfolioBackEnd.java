package com.PortFolio.BackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.PortFolio.BackEnd.Repository")
public class PortfolioBackEnd 
{
    public static void main(String[] args) 
    {
	SpringApplication.run(PortfolioBackEnd.class, args);
    }
}

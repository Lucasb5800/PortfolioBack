/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiAplicacion.PrimerProyecto.Entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/**
 *
 * @author Lucas5800
 */
@Getter @Setter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String nombre;
    private String apellido;
    
    public Cliente(Long pID, String pNombre, String pApellido)
    { 
        id =  pID ;
        nombre = pNombre;
        apellido = pApellido;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Long getID(){
        return id;
    }
    
    public String getApellido(){
        return apellido;
    }
}

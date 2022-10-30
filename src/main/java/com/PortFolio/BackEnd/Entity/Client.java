/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author Lucas5800
 */
@Getter @Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank
    @Size(min = 1, max = 70, message = "Es demasiado corto o demasiado largo.")
    private String lastName;
    
    @NotBlank
    @Size(min = 1, max = 70, message = "Es demasiado corto o demasiado largo.")
    private String firstName;
    
    @NotNull
    @Size(min = 1, max = 200, message = "Es demasiado corto o demasiado largo.")
    private String profileImg;
}

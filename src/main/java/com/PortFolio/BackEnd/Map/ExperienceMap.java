/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Map;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Lucas5800
 */

@Getter @Setter
public class ExperienceMap {
    
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public ExperienceMap() {
    }

    public ExperienceMap(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

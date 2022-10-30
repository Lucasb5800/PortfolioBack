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
public class EducationMap {
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public EducationMap() {
    }

    public EducationMap(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
}

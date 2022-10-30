/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Map;

import javax.validation.constraints.NotBlank;
/**
 *
 * @author @author Lucas5800
 */
public class SkillsMap {
    
    @NotBlank
    private String name;
    @NotBlank
    private int percentage;

    public SkillsMap() {
    }

    public SkillsMap(String name, int percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
    
}

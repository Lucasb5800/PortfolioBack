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
public class HeaderMap {
    @NotBlank
    private String urlProfileImg;

    public HeaderMap() {
    }

    public HeaderMap(String urlProfileImg) {
        this.urlProfileImg = urlProfileImg;
    }  
}

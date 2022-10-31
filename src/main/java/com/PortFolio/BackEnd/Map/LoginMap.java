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
public class LoginMap {
    @NotBlank
    private String userName;
    private String password;

    public LoginMap() {
    }

    public LoginMap(String userName,String password) {
        this.userName = userName;
        this.password = password;
    }  

    public String userName() {
        return this.userName;
    }
    
    public String password() {
        return this.password;
    }
    
}

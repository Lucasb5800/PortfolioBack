/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Lucas5800
 */

@Getter @Setter
@Entity
public class Login {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;

    public Login() {
    }

    public Login(String userName,String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public String getUserName(){
        return this.userName;
    }
    
    public String getPassword(){
        return this.password ;
    }
    
    public boolean getOAUTH(String userName,String password){
        return (( userName.equals(this.userName) ) && ( password.equals(this.password) ));
    }
}

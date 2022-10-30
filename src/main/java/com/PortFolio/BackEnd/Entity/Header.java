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
public class Header {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String urlProfileImg;

    public Header() {
    }

    public Header(String urlProfileImg) {
        this.urlProfileImg = urlProfileImg;
    }
    
    public void setUrlProfileImg(String urlProfileImg){
        this.urlProfileImg = urlProfileImg;
    }
    
}

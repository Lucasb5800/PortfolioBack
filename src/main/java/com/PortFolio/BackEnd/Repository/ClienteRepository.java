/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PortFolio.BackEnd.Repository;

import com.PortFolio.BackEnd.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lucas5800
 */
@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {
    
}
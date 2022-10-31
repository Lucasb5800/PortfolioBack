/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Repository;

import com.PortFolio.BackEnd.Entity.Login;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lucas5800
 */

public interface LoginRepository extends JpaRepository <Login, Integer>{
    public Optional<Login> findByUserName(String userName);
    public boolean existsByUserName(String userName); 
    public Optional<Login> findByPassword(String password);
    public boolean existsByPassword(String password);
}

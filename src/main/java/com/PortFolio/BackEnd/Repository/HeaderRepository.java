/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Repository;


import com.PortFolio.BackEnd.Entity.Header;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Lucas5800
 */

@Repository
public interface HeaderRepository extends JpaRepository <Header, Integer>{
    public Optional<Header> findByUrlimg(String urlimg);
    public boolean existsByUrlimg(String urlimg);
    
}

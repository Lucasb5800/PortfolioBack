/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Service;

import com.PortFolio.BackEnd.Entity.Education;
import com.PortFolio.BackEnd.Repository.EducationRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas5800
 */

@Service
@Transactional
public class EducationService {
    
    @Autowired
    EducationRepository eduRep;
    
    public List<Education> list(){
        return eduRep.findAll();
    }
    
    public Optional<Education> getOne(int id){
        return eduRep.findById(id);
    }
    
    public Optional<Education> getByName(String name){
        return eduRep.findByName(name);
    }
    
    public void save(Education educacion){
        eduRep.save(educacion);
    }
    
    public void delete(int id){
        eduRep.deleteById(id);
    }
    
    public boolean existsById(int id){
        return eduRep.existsById(id);
    }
    
    public boolean existsByName(String name){
        return eduRep.existsByName(name);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Service;

import com.PortFolio.BackEnd.Entity.Experience;
import com.PortFolio.BackEnd.Repository.ExperienceRepository;
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
public class ExperienceService {
    @Autowired
     ExperienceRepository expRepo;
     
     public List<Experience> list(){
         return expRepo.findAll();
     }
     
     public Optional<Experience> getOne(int id){
         return expRepo.findById(id);
     }
     
     public Optional<Experience> getByName(String name){
         return expRepo.findByName(name);
     }
     
     public void save(Experience exp){
         expRepo.save(exp);
     }
     
     public void delete(int id){
         expRepo.deleteById(id);
     }
     
     public boolean existsById(int id){
         return expRepo.existsById(id);
     }
     
     public boolean existsByName(String name){
         return expRepo.existsByName(name);
     }
    
}

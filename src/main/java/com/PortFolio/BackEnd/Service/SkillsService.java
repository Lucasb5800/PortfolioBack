/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Service;

import com.PortFolio.BackEnd.Entity.Skills;
import com.PortFolio.BackEnd.Repository.SkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Lucas5800
 */

@Transactional
@Service
public class SkillsService {
    @Autowired
    SkillsRepository skillRepo;
    
    public List<Skills> list(){
        return skillRepo.findAll();
    }
    
    public Optional<Skills> getOne(int id){
        return skillRepo.findById(id);
    }
    
    public Optional<Skills> getByName(String name){
        return skillRepo.findByName(name);
    }
    
    public void save(Skills skills){
        skillRepo.save(skills);
    }
    
    public void delete(int id){
        skillRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return skillRepo.existsById(id);
    }
    
    public boolean existsByName(String name){
        return skillRepo.existsByName(name);
    }
}

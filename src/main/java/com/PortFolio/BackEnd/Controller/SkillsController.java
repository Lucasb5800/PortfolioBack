/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Controller;

import com.PortFolio.BackEnd.Map.SkillsMap;
import com.PortFolio.BackEnd.Entity.Skills;
import com.PortFolio.BackEnd.Service.SkillsService;
import com.PortFolio.BackEnd.Controller.MessageController;
import java.util.List;
import java.lang.Integer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas5800
 */

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {
    @Autowired
    SkillsService skillServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = skillServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!skillServ.existsById(id))
            return new ResponseEntity(new MessageController("Esta skill no existe."), HttpStatus.NOT_FOUND);
        Skills skills = skillServ.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillServ.existsById(id)) {
            return new ResponseEntity(new MessageController("La skill que buscaste no existe."), HttpStatus.NOT_FOUND);
        }
        skillServ.delete(id);
        return new ResponseEntity(new MessageController("Skill eliminada correctamente."), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SkillsMap skillsMap){      
        if(StringUtils.isBlank(skillsMap.getName()))
            return new ResponseEntity(new MessageController("El name es obligatorio."), HttpStatus.BAD_REQUEST);
        if(skillServ.existsByName(skillsMap.getName()))
            return new ResponseEntity(new MessageController("Esta skill ya existe."), HttpStatus.BAD_REQUEST);
        
        Skills skills = new Skills(skillsMap.getName(), skillsMap.getPercentage());
        skillServ.save(skills);
        
        return new ResponseEntity(new MessageController("Skill agregada satisfactoriamente."), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SkillsMap skillsMap){
        
        Integer percentage = skillsMap.getPercentage();

        if(!skillServ.existsById(id))
            return new ResponseEntity(new MessageController("Este ID no existe."), HttpStatus.BAD_REQUEST);

        if(skillServ.existsByName(skillsMap.getName()) && skillServ.getByName(skillsMap.getName()).get().getId() != id)
            return new ResponseEntity(new MessageController("Esta skill ya existe."), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(skillsMap.getName()))
            return new ResponseEntity(new MessageController("El name es obligatorio."), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(percentage.toString()))
            return new ResponseEntity(new MessageController("El porcentaje es obligatorio."), HttpStatus.BAD_REQUEST);
        
        Skills skills = skillServ.getOne(id).get();
        skills.setName(skillsMap.getName());
        skills.setPercentage(skillsMap.getPercentage());
        
        skillServ.save(skills);
        return new ResponseEntity(new MessageController("Skill actualizada satisfactoriamente."), HttpStatus.OK);
             
    }
}

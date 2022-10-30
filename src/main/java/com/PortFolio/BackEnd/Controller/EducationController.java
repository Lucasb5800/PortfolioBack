/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Controller;

import com.PortFolio.BackEnd.Map.EducationMap;
import com.PortFolio.BackEnd.Entity.Education;
import com.PortFolio.BackEnd.Controller.MessageController;
import com.PortFolio.BackEnd.Service.EducationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/education")
@CrossOrigin(origins = "http://localhost:4200")
public class EducationController {
    
    @Autowired
    EducationService eduServ;
    
    @GetMapping("/list")
    public ResponseEntity<List<Education>> list(){
        List<Education> list = eduServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id")int id){
        if(!eduServ.existsById(id)){
            return new ResponseEntity(new MessageController("Este ID no existe."), HttpStatus.BAD_REQUEST);
        }
        
        Education education = eduServ.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!eduServ.existsById(id)){
            return new ResponseEntity(new MessageController("Este ID no existe."), HttpStatus.NOT_FOUND);
        }
        eduServ.delete(id);
        return new ResponseEntity(new MessageController("Educación eliminada correctamente."), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducationMap eduMap){
        if(StringUtils.isBlank(eduMap.getName())){
            return new ResponseEntity(new MessageController("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if(eduServ.existsByName(eduMap.getName())){
            return new ResponseEntity(new MessageController("Este nombre ya existe."), HttpStatus.BAD_REQUEST);
        }
        
        Education educacion = new Education(
                eduMap.getName(), eduMap.getDescription()
            );
        eduServ.save(educacion);
        return new ResponseEntity(new MessageController("Educación agregada correctamente."), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducationMap eduMap){
        if(!eduServ.existsById(id)){
            return new ResponseEntity(new MessageController("Este ID no existe."), HttpStatus.NOT_FOUND);
        }
        if(eduServ.existsByName(eduMap.getName()) && eduServ.getByName(eduMap.getName()).get().getId() != id){
            return new ResponseEntity(new MessageController("Este nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(eduMap.getName())){
            return new ResponseEntity(new MessageController("Este campo no puede estar vacío."), HttpStatus.BAD_REQUEST);
        }
        
        Education education = eduServ.getOne(id).get();
        
        
        education.setName(eduMap.getName());
        education.setDescription(eduMap.getDescription());
        
        eduServ.save(education);
        
        return new ResponseEntity(new MessageController("Educación actualizada correctamente."), HttpStatus.OK);
    }
}

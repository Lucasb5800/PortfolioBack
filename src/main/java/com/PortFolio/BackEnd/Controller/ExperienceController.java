/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Controller;

import com.PortFolio.BackEnd.Map.ExperienceMap;
import com.PortFolio.BackEnd.Entity.Experience;
import com.PortFolio.BackEnd.Controller.MessageController;
import com.PortFolio.BackEnd.Service.ExperienceService;
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
@RequestMapping("/experience")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {
    
    @Autowired
    ExperienceService expServ;
    
    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list(){
        List<Experience> list = expServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id){
        if(!expServ.existsById(id))
            return new ResponseEntity(new MessageController("La experiencia no existe."), HttpStatus.NOT_FOUND);
        Experience experiencia = expServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!expServ.existsById(id)) {
            return new ResponseEntity(new MessageController("La experiencia que buscaste no existe."), HttpStatus.NOT_FOUND);
        }
        expServ.delete(id);
        return new ResponseEntity(new MessageController("Experience eliminada correctamente."), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienceMap expMap){      
        if(StringUtils.isBlank(expMap.getName()))
            return new ResponseEntity(new MessageController("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        if(expServ.existsByName(expMap.getName()))
            return new ResponseEntity(new MessageController("Esta experiencia ya existe."), HttpStatus.BAD_REQUEST);
        
        Experience experiencia = new Experience(expMap.getName(), expMap.getDescription());
        expServ.save(experiencia);
        
        return new ResponseEntity(new MessageController("Experience agregada satisfactoriamente."), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienceMap expMap){

        if(!expServ.existsById(id))
            return new ResponseEntity(new MessageController("Este ID no existe."), HttpStatus.BAD_REQUEST);

        if(expServ.existsByName(expMap.getName()) && expServ.getByName(expMap.getName()).get().getId() != id)
            return new ResponseEntity(new MessageController("Esta experiencia ya existe."), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(expMap.getName()))
            return new ResponseEntity(new MessageController("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        
        Experience experiencia = expServ.getOne(id).get();
        experiencia.setName(expMap.getName());
        experiencia.setDescription((expMap.getDescription()));
        
        expServ.save(experiencia);
        return new ResponseEntity(new MessageController("Experience actualizada satisfactoriamente."), HttpStatus.OK);
             
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Controller;

import com.PortFolio.BackEnd.Map.HeaderMap;
import com.PortFolio.BackEnd.Entity.Header;
import com.portfolio.BackEnd.Service.ServiceHeader;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Lucas5800
 */

@RestController
@RequestMapping("/header")
@CrossOrigin(origins = "http://localhost:4200")
public class HeaderController {
    @Autowired
    ServiceHeader servHeader;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Banner>> list(){
        List<Banner> list = servHeader.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Banner> getById(@PathVariable("id")int id){
        if(!servHeader.existsById(id)){
            return new ResponseEntity(new Mensaje("Este ID no existe."), HttpStatus.BAD_REQUEST);
        }
        
        Banner banner = servHeader.getOne(id).get();
        return new ResponseEntity(banner, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoBanner dtobanner){
        if(!servHeader.existsById(id)){
            return new ResponseEntity(new Mensaje("Este ID no existe."), HttpStatus.NOT_FOUND);
        }
        if(servHeader.existsByUrlimg(dtobanner.getUrlimg()) && servHeader.getByUrlimg(dtobanner.getUrlimg()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Este nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtobanner.getUrlimg())){
            return new ResponseEntity(new Mensaje("Este campo no puede estar vacío."), HttpStatus.BAD_REQUEST);
        }
        
        Banner banner = servHeader.getOne(id).get();
        
        banner.setUrlimg(dtobanner.getUrlimg());
        
        servHeader.save(banner);
        
        return new ResponseEntity(new Mensaje("Banner actualizado correctamente."), HttpStatus.OK);
    }
}
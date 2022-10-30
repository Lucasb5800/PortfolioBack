/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Controller;

import com.PortFolio.BackEnd.Map.HeaderMap;
import com.PortFolio.BackEnd.Entity.Header;
import com.PortFolio.BackEnd.Service.HeaderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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
    HeaderService servHeader;
    
    @GetMapping("/list")
    public ResponseEntity<List<Header>> list(){
        List<Header> list = servHeader.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Header> getById(@PathVariable("id")int id){
        if(!servHeader.existsById(id)){
            return new ResponseEntity(new MessageController("Este ID no existe."), HttpStatus.BAD_REQUEST);
        }
        
        Header header = servHeader.getOne(id).get();
        return new ResponseEntity(header, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HeaderMap headerMap){
        if(!servHeader.existsById(id)){
            return new ResponseEntity(new MessageController("Este ID no existe."), HttpStatus.NOT_FOUND);
        }
        if(servHeader.existsByUrlProfileImg(headerMap.urlProfileImg()) && servHeader.getByUrlProfileImg(headerMap.urlProfileImg()).get().getId() != id){
            return new ResponseEntity(new MessageController("Este nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(headerMap.urlProfileImg())){
            return new ResponseEntity(new MessageController("Este campo no puede estar vacío."), HttpStatus.BAD_REQUEST);
        } else {
        }
        
        Header header = servHeader.getOne(id).get();
        
        header.setUrlProfileImg(HeaderMap.urlProfileImg());
        
        servHeader.save(header);
        
        return new ResponseEntity(new MessageController("Header actualizado correctamente."), HttpStatus.OK);
    }
}
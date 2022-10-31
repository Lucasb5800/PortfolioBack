/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Controller;

import com.PortFolio.BackEnd.Map.LoginMap;
import com.PortFolio.BackEnd.Entity.Login;
import com.PortFolio.BackEnd.Service.LoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
    
    @Autowired
    LoginService servLogin;
    
    @GetMapping("/list")
    public ResponseEntity<List<Login>> list(){
        List<Login> list = servLogin.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Login> getById(@PathVariable("id")int id){
        if(!servLogin.existsById(id)){
            return new ResponseEntity(new MessageController("Este ID no existe."), HttpStatus.BAD_REQUEST);
        }
        
        Login login = servLogin.getOne(id).get();
        return new ResponseEntity(login, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody LoginMap loginMap){
        if(!servLogin.existsById(id)){
            return new ResponseEntity(new MessageController("Este ID no existe."), HttpStatus.NOT_FOUND);
        }
        if(servLogin.existsByUserName(loginMap.userName()) && servLogin.getByUserName(loginMap.userName()).get().getId() != id){
            return new ResponseEntity(new MessageController("Este nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(loginMap.userName())){
            return new ResponseEntity(new MessageController("Este campo no puede estar vacío."), HttpStatus.BAD_REQUEST);
        } else {
        }
        
        Login login = servLogin.getOne(id).get();
        
        login.setUserName(loginMap.userName());
        
        servLogin.save(login);
        
        return new ResponseEntity(new MessageController("Login actualizado correctamente."), HttpStatus.OK);
    }
    
}

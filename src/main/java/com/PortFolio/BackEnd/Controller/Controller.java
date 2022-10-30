/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Controller;
//NOTA: No usar HTTPS solo HTTP
import com.PortFolio.BackEnd.Entity.Client;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

//Para mapear las variables a usar en la request GET
import org.springframework.web.bind.annotation.GetMapping;

//Para pasar las variables por Path en la URL de la request GET
import org.springframework.web.bind.annotation.PathVariable;

//Para pasar la variables como Parametros de la request GET
import org.springframework.web.bind.annotation.RequestParam;

//Para mapear las variables a usar en la request POST
import org.springframework.web.bind.annotation.PostMapping;

//Para pasar las variables por el Body de la request POST
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.PortFolio.BackEnd.Service.IClientService;
/**
 * @author Lucas5800
 */
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    
    //Este fragmento de codigo es para implementar la inyeccion de dependencias
    @Autowired IClientService clienteService;
    
    @PostMapping ("/new/client")
    public void saveClient(@RequestBody Client cli){
        clienteService.saveClient(cli);
    }    
    
    @GetMapping ("/get/client")
    @ResponseBody 
    public List <Client> getClients(){
        
        return clienteService.getClients();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void deleteClient(@PathVariable Integer id)
    {
        clienteService.deleteClient(id);
    }
   
}

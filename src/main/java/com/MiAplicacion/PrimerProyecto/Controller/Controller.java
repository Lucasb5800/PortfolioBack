/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiAplicacion.PrimerProyecto.Controller;
//NOTA: No usar HTTPS solo HTTP
import com.MiAplicacion.PrimerProyecto.Entity.Cliente;
import com.MiAplicacion.PrimerProyecto.Service.IClienteService;
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
/**
 * @author Lucas5800
 */
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    
    //Este fragmento de codigo es para implementar la inyeccion de dependencias
    @Autowired IClienteService clienteService;
    
    @PostMapping ("/new/cliente")
    public void nuevoCliente(@RequestBody Cliente cli){
        clienteService.nuevoCliente(cli);
    }    
    
    @GetMapping ("/traer/cliente")
    @ResponseBody 
    public List <Cliente> traerClientes(){
        
        return clienteService.traerClientes();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarCliente(@PathVariable Long id)
    {
        clienteService.borrarCliente(id);
    }
    
////    Todo el codigo Comentado es el mismo proceso de arriba pero hecho
////     a mano sin inyecciones de dependencias
//    
//    
//    //Para variables en el path
//    @GetMapping ("/hola/{nombre}/{edad}/{profesion}")
//    public String decirHola2(
//            @PathVariable String nombre,
//            @PathVariable int edad,
//            @PathVariable String profesion)
//    {
//        return ("Hello World!!. Tu nombre es " + nombre +
//                "tu edad es " + edad + "y tu profesion es " + profesion);
//    }
//    
//    
//    //Para variables en parametros
//    @GetMapping ("/hola")    
//    public String decirHola(
//            @RequestParam String nombre,
//            @RequestParam int edad,
//            @RequestParam String profesion)   
//    {
//        return ("Hello World!!. Tu nombre es " + nombre +
//                " tu edad es " + edad + " y tu profesion es " + profesion);
//    }
//    
//    //Para Post
//    @PostMapping ("/cliente")
//    public void nuevoCliente(@RequestBody Cliente cli){
//        System.out.println("Datos cliente: " + cli.getNombre() + 
//                "Apellido: " + cli.getApellido());
//    }
//    
//    //Para responder con listas
//    @GetMapping ("/cliente/traer")
//    @ResponseBody      
//    public List <Cliente> traerClientes(){
//        
//        List <Cliente> listaClientes = new ArrayList<Cliente>();
//        listaClientes.add(new Cliente(1L,"Zlatan","Ibrahimovic"));
//        listaClientes.add(new Cliente(2L,"Cristiano","Ronaldo"));
//        listaClientes.add(new Cliente(3L,"Lionel","Messi"));
//        return listaClientes;
//    }
//    
//    //Para responder con entidades
//    @GetMapping ("/pruebaresponse")    
//    public ResponseEntity<String> traerRespuesta(){
//        
//        return new ResponseEntity<>("Esto es un mensaje Response Entity", HttpStatus.OK);
//    }
    
    
}

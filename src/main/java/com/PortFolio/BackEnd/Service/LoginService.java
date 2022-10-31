/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Service;

import com.PortFolio.BackEnd.Entity.Login;
import com.PortFolio.BackEnd.Repository.LoginRepository;
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
public class LoginService {
    
    @Autowired
    LoginRepository loginRep;
    
    public List<Login> list(){
        return loginRep.findAll();
    }
    
    public Optional<Login> getOne(int id){
        return loginRep.findById(id);
    }
    
    public Optional<Login> getByUserName(String userName){
        return loginRep.findByUserName(userName);
    }
    
    public void save(Login login){
        loginRep.save(login);
    }
    
    public void delete(int id){
        loginRep.deleteById(id);
    }
    
    public boolean existsById(int id){
        return loginRep.existsById(id);
    }
    
    public boolean existsByUserName(String userName){
        return loginRep.existsByUserName(userName);
    }
    
    public boolean getOAUTH(String userName, String password){
        return((loginRep.existsByUserName(userName))&&(loginRep.existsByPassword(password)));
    }
}

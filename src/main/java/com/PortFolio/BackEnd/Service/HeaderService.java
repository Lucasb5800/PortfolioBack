/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Service;

import com.PortFolio.BackEnd.Entity.Header;
import com.PortFolio.BackEnd.Repository.HeaderRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *  @author Lucas5800
 */

@Service
@Transactional
public class HeaderService {
    @Autowired
    HeaderRepository headerRepository;
    
    public List<Header> list(){
        return headerRepository.findAll();
    }
    
    public Optional<Header> getOne(int id){
        return headerRepository.findById(id);
    }
    
    public Optional<Header> getByUrlProfileImg(String urlProfileImg){
        return headerRepository.findByUrlimg(urlProfileImg);
    }
    
    public void save(Header header){
        headerRepository.save(header);
    }
    
    public void delete(int id){
        headerRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return headerRepository.existsById(id);
    }
    
    public boolean existsByUrlProfileImg(String urlProfileImg){
        return headerRepository.existsByUrlimg(urlProfileImg);
    }
}

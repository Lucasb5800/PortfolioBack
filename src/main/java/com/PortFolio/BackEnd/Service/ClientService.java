/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Service;

import com.PortFolio.BackEnd.Entity.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PortFolio.BackEnd.Repository.ClientRepository;

/**
 *
 * @author Lucas5800
 */
@Service
public class ClientService implements IClientService {

    @Autowired ClientRepository cliRepo;
            
    @Override
    public List<Client> getClients() {
        List<Client> Client = cliRepo.findAll();
        return Client;
    }

    @Override
    public void saveClient(Client cli) {
        cliRepo.save(cli);
    }

    @Override
    public void deleteClient(Integer id) {
        cliRepo.deleteById(id);
    }

    @Override
    public Client findClient(Integer id) {
        Client client = cliRepo.findById(id).orElse(null);
        return client;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PortFolio.BackEnd.Service;

import com.PortFolio.BackEnd.Entity.Client;
import java.util.List;

/**
 *
 * @author Lucas5800
 */
public interface IClientService {
    
    public List<Client> getClients();
    public void saveClient(Client cli);
    public void deleteClient(Integer id);
    public Client findClient(Integer id);
}

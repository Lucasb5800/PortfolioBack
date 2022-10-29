/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortFolio.BackEnd.Service;

import com.PortFolio.BackEnd.Entity.Cliente;
import com.PortFolio.BackEnd.Repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas5800
 */
@Service
public class ClientService implements IClienteService {

    @Autowired ClienteRepository cliRepo;
            
    @Override
    public List<Cliente> traerClientes() {
        List<Cliente> Clientes = cliRepo.findAll();
        return Clientes;
    }

    @Override
    public void nuevoCliente(Cliente cli) {
        cliRepo.save(cli);
    }

    @Override
    public void borrarCliente(Long id) {
        cliRepo.deleteById(id);
    }

    @Override
    public Cliente buscarCliente(Long id) {
        Cliente cliente = cliRepo.findById(id).orElse(null);
        return cliente;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MiAplicacion.PrimerProyecto.Service;

import com.MiAplicacion.PrimerProyecto.Entity.Cliente;
import java.util.List;

/**
 *
 * @author Lucas5800
 */
public interface IClienteService {
    
    public List<Cliente> traerClientes();
    public void nuevoCliente(Cliente cli);
    public void borrarCliente(Long id);
    public Cliente buscarCliente(Long id);
}

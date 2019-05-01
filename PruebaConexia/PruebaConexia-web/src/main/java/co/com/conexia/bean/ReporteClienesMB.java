/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.bean;

import co.com.conexia.dao.ClienteComprasDto;
import co.com.conexia.persistencia.ClienteEntityManager;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author jeisson
 */
@Named(value = "reporteClienes")
@RequestScoped
public class ReporteClienesMB {

    private ClienteEntityManager cl;
    
    private List<ClienteComprasDto> listaClientes;
    public ReporteClienesMB() {
    }
    
    @PostConstruct
    public void init(){
        cl = new ClienteEntityManager();
        listaClientes = cl.filtrarMejoresClientes();
    }

    public List<ClienteComprasDto> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<ClienteComprasDto> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    
}

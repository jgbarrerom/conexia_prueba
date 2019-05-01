/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.bean;

import co.com.conexia.entity.Factura;
import co.com.conexia.persistencia.FacturaEntityManager;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author jeisson
 */
@Named(value = "registroFactura")
@RequestScoped
public class RegistroFacturaMB {
    
    private List<Factura> listaFactura;
    private FacturaEntityManager em;

    /**
     * Creates a new instance of RegistroFactura
     */
    public RegistroFacturaMB() {
    }
    
    @PostConstruct
    public void init(){
        em = new FacturaEntityManager();
        listaFactura = em.obtenerTodos();
    }

    public List<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }
    
}

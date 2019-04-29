/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.dao;

import co.com.conexia.entity.Factura;
import java.io.Serializable;

/**
 *
 * @author jeisson
 */
public class FacturaDAO extends GeneralDAO<Factura> implements Serializable{
    
    public void guardarFactura(Factura factura){
        if(factura != null){
            this.guardar(factura);
        }else{
            throw new RuntimeException("La factura no tiene datos para almacenar");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.dao;

import co.com.conexia.entity.DetalleFactura;

/**
 *
 * @author jeisson
 */
public class DetalleFacturaDAO extends GeneralDAO<DetalleFactura>{
    
    public void guardarDetalle(DetalleFactura detFact){
        if(detFact != null){
            this.guardar(detFact);
        }else{
            throw new RuntimeException("La factura no tiene detalle");
        }
    }
}

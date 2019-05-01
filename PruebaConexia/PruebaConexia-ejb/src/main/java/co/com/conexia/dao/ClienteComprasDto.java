/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.dao;

import java.math.BigInteger;

/**
 *
 * @author jeisson
 */
public class ClienteComprasDto {
    private String nombreCl;
    private String apellido1Cl;
    private String apellido2Cl;
    private BigInteger totalCl;

    public ClienteComprasDto(String nombreCl, String apellido1Cl, String apellido2Cl, BigInteger totalCl) {
        this.nombreCl = nombreCl;
        this.apellido1Cl = apellido1Cl;
        this.apellido2Cl = apellido2Cl;
        this.totalCl = totalCl;
    }
    
    
    
    public String getNombreCl() {
        return nombreCl;
    }

    public void setNombreCl(String nombreCl) {
        this.nombreCl = nombreCl;
    }

    public String getApellido1Cl() {
        return apellido1Cl;
    }

    public void setApellido1Cl(String apellido1Cl) {
        this.apellido1Cl = apellido1Cl;
    }

    public String getApellido2Cl() {
        return apellido2Cl;
    }

    public void setApellido2Cl(String apellido2Cl) {
        this.apellido2Cl = apellido2Cl;
    }

    public BigInteger getTotalCl() {
        return totalCl;
    }

    public void setTotalCl(BigInteger totalCl) {
        this.totalCl = totalCl;
    }
    
    
}

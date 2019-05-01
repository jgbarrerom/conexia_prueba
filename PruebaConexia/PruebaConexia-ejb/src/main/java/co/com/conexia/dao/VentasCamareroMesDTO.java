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
public class VentasCamareroMesDTO {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private BigInteger totalVenta;
    private Integer mesVenta;

    public VentasCamareroMesDTO(String nombre, String apellido1, String apellido2, BigInteger totalVenta, Integer mesVenta) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.totalVenta = totalVenta;
        this.mesVenta = mesVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public BigInteger getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigInteger totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Integer getMesVenta() {
        return mesVenta;
    }

    public void setMesVenta(Integer mesVenta) {
        this.mesVenta = mesVenta;
    }

}

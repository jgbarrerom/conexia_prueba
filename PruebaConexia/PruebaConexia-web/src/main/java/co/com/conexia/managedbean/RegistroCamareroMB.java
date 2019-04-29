/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.managedbean;

import co.com.conexia.dao.CamareroDAO;
import co.com.conexia.dao.FacturaDAO;
import co.com.conexia.entity.Camarero;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author jeisson
 */
@ManagedBean(name = "registroCamarero")
@RequestScoped
public class RegistroCamareroMB {

    private String nombreCamarero;
    private String apellidoPatCamarero;
    private String apellidoMatCamarero;
    private List<Camarero> listCamareros;
    
    private CamareroDAO camareroDao;
    
    public RegistroCamareroMB() {
        camareroDao = new CamareroDAO();
        listCamareros = camareroDao.listaCamareros();
    }
    
    public void agregar(){
        
    }

    public String getNombreCamarero() {
        return nombreCamarero;
    }

    public void setNombreCamarero(String nombreCamarero) {
        this.nombreCamarero = nombreCamarero;
    }

    public String getApellidoPatCamarero() {
        return apellidoPatCamarero;
    }

    public void setApellidoPatCamarero(String apellidoPatCamarero) {
        this.apellidoPatCamarero = apellidoPatCamarero;
    }

    public String getApellidoMatCamarero() {
        return apellidoMatCamarero;
    }

    public void setApellidoMatCamarero(String apellidoMatCamarero) {
        this.apellidoMatCamarero = apellidoMatCamarero;
    }

    public List<Camarero> getListCamareros() {
        return listCamareros;
    }

    public void setListCamareros(List<Camarero> listCamareros) {
        this.listCamareros = listCamareros;
    }
    
}

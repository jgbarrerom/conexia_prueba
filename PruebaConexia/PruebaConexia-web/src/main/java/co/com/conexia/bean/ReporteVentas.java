/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.bean;

import co.com.conexia.persistencia.FacturaEntityManager;
import co.com.conexia.dao.VentasCamareroMesDTO;
import java.text.DateFormatSymbols;
import java.util.List;
import java.util.Locale;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author jeisson
 */
@Named(value = "reporteVentas")
@RequestScoped
public class ReporteVentas {

    private FacturaEntityManager fe;
    private List<VentasCamareroMesDTO> listaVentas;

    /**
     * Creates a new instance of ReporteVentas
     */
    public ReporteVentas() {
        fe = new FacturaEntityManager();
        listaVentas = fe.consultarVentasMes();
    }
    
    public String getNombreMes(Integer numeroMes){
        return new DateFormatSymbols(new Locale("es", "co")).getMonths()[numeroMes];
    }

    public List<VentasCamareroMesDTO> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<VentasCamareroMesDTO> listaVentas) {
        this.listaVentas = listaVentas;
    }

}

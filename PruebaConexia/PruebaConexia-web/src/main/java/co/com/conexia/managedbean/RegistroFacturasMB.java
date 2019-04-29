/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.managedbean;

import co.com.conexia.dao.CamareroDAO;
import co.com.conexia.dao.ClienteDAO;
import co.com.conexia.dao.DetalleFacturaDAO;
import co.com.conexia.dao.FacturaDAO;
import co.com.conexia.dao.MesaDAO;
import co.com.conexia.dao.PlatoDAO;
import co.com.conexia.entity.Camarero;
import co.com.conexia.entity.Cliente;
import co.com.conexia.entity.DetalleFactura;
import co.com.conexia.entity.Factura;
import co.com.conexia.entity.Mesa;
import co.com.conexia.entity.Plato;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author jeisson
 */
@Named(value = "registroFacturas")
@RequestScoped
public class RegistroFacturasMB {
    
    private List<Cliente> listClientes;
    private List<Camarero> listCamarero;
    private List<Mesa> listaMesa;
    private List<Plato> listaPlatos;
    private Integer cantidadPlatos;
    
    private Cliente cliSelect;
    private Camarero camareroSelect;
    private Mesa mesaSelect;
    private Plato platoSelect;
    
    private FacturaDAO facDao;
    private DetalleFacturaDAO detFacDao;
    private CamareroDAO camDao;
    private ClienteDAO cliDao;
    private PlatoDAO platoDao;
    private MesaDAO mesaDao;
    
    public RegistroFacturasMB() {
        facDao = new FacturaDAO();
        camDao = new CamareroDAO();
        cliDao = new ClienteDAO();
        platoDao = new PlatoDAO();
        mesaDao = new MesaDAO();
        detFacDao = new DetalleFacturaDAO();
        
        listCamarero = camDao.listaCamareros();
        listClientes = cliDao.findAll();
        listaPlatos = platoDao.allPlatos();
        listaMesa = mesaDao.allMesa();
    }

    public List<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public List<Camarero> getListCamarero() {
        return listCamarero;
    }

    public void setListCamarero(List<Camarero> listCamarero) {
        this.listCamarero = listCamarero;
    }

    public List<Mesa> getListaMesa() {
        return listaMesa;
    }

    public void setListaMesa(List<Mesa> listaMesa) {
        this.listaMesa = listaMesa;
    }

    public Cliente getCliSelect() {
        return cliSelect;
    }

    public void setCliSelect(Cliente cliSelect) {
        this.cliSelect = cliSelect;
    }

    public Camarero getCamareroSelect() {
        return camareroSelect;
    }

    public void setCamareroSelect(Camarero camareroSelect) {
        this.camareroSelect = camareroSelect;
    }

    public Mesa getMesaSelect() {
        return mesaSelect;
    }

    public void setMesaSelect(Mesa mesaSelect) {
        this.mesaSelect = mesaSelect;
    }

    public List<Plato> getListaPlatos() {
        return listaPlatos;
    }

    public void setListaPlatos(List<Plato> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }

    public Integer getCantidadPlatos() {
        return cantidadPlatos;
    }

    public void setCantidadPlatos(Integer cantidadPlatos) {
        this.cantidadPlatos = cantidadPlatos;
    }

    public Plato getPlatoSelect() {
        return platoSelect;
    }

    public void setPlatoSelect(Plato platoSelect) {
        this.platoSelect = platoSelect;
    }
    
    public void guardarFactura(){
        Factura fact = new Factura();
        fact.setIdCamarero(camareroSelect);
        fact.setIdCliente(cliSelect);
        fact.setIdMesa(mesaSelect);
        fact.setFechaFactura(Calendar.getInstance().getTime());
        facDao.guardarFactura(fact);
        DetalleFactura detFac = new DetalleFactura();
        //detFac.setIdCocinero();
        detFac.setIdFactura(fact);
        detFac.setIdPlato(platoSelect);
        detFac.setUnidadesPlato(cantidadPlatos);
        detFac.setSubtotalDetalle(platoSelect.getValorPlato().multiply(BigInteger.valueOf(cantidadPlatos.longValue())));
        detFacDao.guardarDetalle(detFac);
        System.out.println("sdsdjfsdjfk");
    }
    
}

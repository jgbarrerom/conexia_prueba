/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.bean;

import co.com.conexia.entity.Camarero;
import co.com.conexia.entity.Cliente;
import co.com.conexia.entity.Cocinero;
import co.com.conexia.entity.DetalleFactura;
import co.com.conexia.entity.Factura;
import co.com.conexia.entity.Mesa;
import co.com.conexia.entity.Plato;
import co.com.conexia.persistencia.CamareroEntityManager;
import co.com.conexia.persistencia.ClienteEntityManager;
import co.com.conexia.persistencia.CocineroEntityManager;
import co.com.conexia.persistencia.DetalleFacturaEntityManager;
import co.com.conexia.persistencia.FacturaEntityManager;
import co.com.conexia.persistencia.MesaEntityManager;
import co.com.conexia.persistencia.PlatoEntityManager;
import java.math.BigInteger;
import java.util.Calendar;
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
    private List<Cliente> listaCliente;
    private List<Plato> listaPlato;
    private List<Camarero> listaCamarero;
    private List<Mesa> listMesa;
    private List<Cocinero> listCocinero;
    private FacturaEntityManager facEm;
    private ClienteEntityManager clEm;
    private PlatoEntityManager platEm;
    private MesaEntityManager mesEm;
    private DetalleFacturaEntityManager detEm;
    private CamareroEntityManager camEm;
    private CocineroEntityManager cociEm;
    
    private Cliente clSelct;
    private Plato platoSelct;
    private Cocinero cociSelec;
    private Camarero camSelct;
    private Mesa mesaSelec;
    private Integer cantidad;
    

    /**
     * Creates a new instance of RegistroFactura
     */
    public RegistroFacturaMB() {
    }

    public String irClienteCompras(){
        return "clientesCompras.xhtml";
    }
    
    @PostConstruct
    public void init(){
        facEm = new FacturaEntityManager();
        clEm = new ClienteEntityManager();
        platEm = new PlatoEntityManager();
        mesEm = new MesaEntityManager();
        detEm = new DetalleFacturaEntityManager();
        camEm = new CamareroEntityManager();
        cociEm = new CocineroEntityManager();
        
        listaFactura = facEm.obtenerTodos();
        listaCliente = clEm.obtenerTodos();
        listaPlato = platEm.obtenerTodos();
        listaCamarero = camEm.obtenerTodos();
        listMesa = mesEm.obtenerTodos();
        listCocinero = cociEm.obtenerTodos();
    }
    
    public void guardarFactura(){
        Factura facNew = new Factura();
        facNew.setIdCamarero(camSelct);
        facNew.setIdCliente(clSelct);
        facNew.setIdMesa(mesaSelec);
        facNew.setFechaFactura(Calendar.getInstance().getTime());
        facEm.guardar(facNew);
        DetalleFactura det = new DetalleFactura();
        det.setIdFactura(facNew);
        det.setIdCocinero(cociSelec);
        det.setIdPlato(platoSelct);
        det.setUnidadesPlato(cantidad);
        det.setSubtotalDetalle(platoSelct.getValorPlato().multiply(BigInteger.valueOf(cantidad)));
        detEm.guardar(det);
    }

    public List<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public List<Plato> getListaPlato() {
        return listaPlato;
    }

    public void setListaPlato(List<Plato> listaPlato) {
        this.listaPlato = listaPlato;
    }

    public List<Camarero> getListaCamarero() {
        return listaCamarero;
    }

    public void setListaCamarero(List<Camarero> listaCamarero) {
        this.listaCamarero = listaCamarero;
    }

    public List<Mesa> getListMesa() {
        return listMesa;
    }

    public void setListMesa(List<Mesa> listMesa) {
        this.listMesa = listMesa;
    }

    public Cliente getClSelct() {
        return clSelct;
    }

    public void setClSelct(Cliente clSelct) {
        this.clSelct = clSelct;
    }

    public Plato getPlatoSelct() {
        return platoSelct;
    }

    public void setPlatoSelct(Plato platoSelct) {
        this.platoSelct = platoSelct;
    }

    public Cocinero getCociSelec() {
        return cociSelec;
    }

    public void setCociSelec(Cocinero cociSelec) {
        this.cociSelec = cociSelec;
    }

    public Camarero getCamSelct() {
        return camSelct;
    }

    public void setCamSelct(Camarero camSelct) {
        this.camSelct = camSelct;
    }

    public Mesa getMesaSelec() {
        return mesaSelec;
    }

    public void setMesaSelec(Mesa mesaSelec) {
        this.mesaSelec = mesaSelec;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<Cocinero> getListCocinero() {
        return listCocinero;
    }

    public void setListCocinero(List<Cocinero> listCocinero) {
        this.listCocinero = listCocinero;
    }
    
}

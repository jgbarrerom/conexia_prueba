/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jeisson
 */
@Entity
@Table(name = "DETALLE_FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d")
    , @NamedQuery(name = "DetalleFactura.findByIdDetalle", query = "SELECT d FROM DetalleFactura d WHERE d.idDetalle = :idDetalle")
    , @NamedQuery(name = "DetalleFactura.findByUnidadesPlato", query = "SELECT d FROM DetalleFactura d WHERE d.unidadesPlato = :unidadesPlato")
    , @NamedQuery(name = "DetalleFactura.findBySubtotalDetalle", query = "SELECT d FROM DetalleFactura d WHERE d.subtotalDetalle = :subtotalDetalle")})
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE")
    private Integer idDetalle;
    @Column(name = "UNIDADES_PLATO")
    private Integer unidadesPlato;
    @Column(name = "SUBTOTAL_DETALLE")
    private BigInteger subtotalDetalle;
    @JoinColumn(name = "ID_PLATO", referencedColumnName = "ID_PLATO")
    @ManyToOne(optional = false)
    private Plato idPlato;
    @JoinColumn(name = "ID_FACTURA", referencedColumnName = "ID_FACTURA")
    @ManyToOne(optional = false)
    private Factura idFactura;
    @JoinColumn(name = "ID_COCINERO", referencedColumnName = "ID_COCINERO")
    @ManyToOne(optional = false)
    private Cocinero idCocinero;

    public DetalleFactura() {
    }

    public DetalleFactura(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getUnidadesPlato() {
        return unidadesPlato;
    }

    public void setUnidadesPlato(Integer unidadesPlato) {
        this.unidadesPlato = unidadesPlato;
    }

    public BigInteger getSubtotalDetalle() {
        return subtotalDetalle;
    }

    public void setSubtotalDetalle(BigInteger subtotalDetalle) {
        this.subtotalDetalle = subtotalDetalle;
    }

    public Plato getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Plato idPlato) {
        this.idPlato = idPlato;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    public Cocinero getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(Cocinero idCocinero) {
        this.idCocinero = idCocinero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.conexia.entity.DetalleFactura[ idDetalle=" + idDetalle + " ]";
    }
    
}

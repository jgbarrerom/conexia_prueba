/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jeisson
 */
@Entity
@Table(name = "COCINERO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cocinero.findAll", query = "SELECT c FROM Cocinero c")
    , @NamedQuery(name = "Cocinero.findByIdCocinero", query = "SELECT c FROM Cocinero c WHERE c.idCocinero = :idCocinero")
    , @NamedQuery(name = "Cocinero.findByNombre", query = "SELECT c FROM Cocinero c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cocinero.findByApellidoPaternoCliente", query = "SELECT c FROM Cocinero c WHERE c.apellidoPaternoCliente = :apellidoPaternoCliente")
    , @NamedQuery(name = "Cocinero.findByApellidoMaternoCocinero", query = "SELECT c FROM Cocinero c WHERE c.apellidoMaternoCocinero = :apellidoMaternoCocinero")})
public class Cocinero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COCINERO")
    private Integer idCocinero;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 30)
    @Column(name = "APELLIDO_PATERNO_CLIENTE")
    private String apellidoPaternoCliente;
    @Size(max = 30)
    @Column(name = "APELLIDO_MATERNO_COCINERO")
    private String apellidoMaternoCocinero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCocinero")
    private List<DetalleFactura> detalleFacturaList;

    public Cocinero() {
    }

    public Cocinero(Integer idCocinero) {
        this.idCocinero = idCocinero;
    }

    public Integer getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(Integer idCocinero) {
        this.idCocinero = idCocinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaternoCliente() {
        return apellidoPaternoCliente;
    }

    public void setApellidoPaternoCliente(String apellidoPaternoCliente) {
        this.apellidoPaternoCliente = apellidoPaternoCliente;
    }

    public String getApellidoMaternoCocinero() {
        return apellidoMaternoCocinero;
    }

    public void setApellidoMaternoCocinero(String apellidoMaternoCocinero) {
        this.apellidoMaternoCocinero = apellidoMaternoCocinero;
    }

    @XmlTransient
    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCocinero != null ? idCocinero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cocinero)) {
            return false;
        }
        Cocinero other = (Cocinero) object;
        if ((this.idCocinero == null && other.idCocinero != null) || (this.idCocinero != null && !this.idCocinero.equals(other.idCocinero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.conexia.entity.Cocinero[ idCocinero=" + idCocinero + " ]";
    }
    
}

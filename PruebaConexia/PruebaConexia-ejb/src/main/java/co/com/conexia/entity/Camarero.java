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
@Table(name = "CAMARERO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camarero.findAll", query = "SELECT c FROM Camarero c")
    , @NamedQuery(name = "Camarero.findByIdCamarero", query = "SELECT c FROM Camarero c WHERE c.idCamarero = :idCamarero")
    , @NamedQuery(name = "Camarero.findByNombreCamarero", query = "SELECT c FROM Camarero c WHERE c.nombreCamarero = :nombreCamarero")
    , @NamedQuery(name = "Camarero.findByApellidoPaternoCamarero", query = "SELECT c FROM Camarero c WHERE c.apellidoPaternoCamarero = :apellidoPaternoCamarero")
    , @NamedQuery(name = "Camarero.findByApellidoMaternoCamarero", query = "SELECT c FROM Camarero c WHERE c.apellidoMaternoCamarero = :apellidoMaternoCamarero")})
public class Camarero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CAMARERO")
    private Integer idCamarero;
    @Size(max = 30)
    @Column(name = "NOMBRE_CAMARERO")
    private String nombreCamarero;
    @Size(max = 30)
    @Column(name = "APELLIDO_PATERNO_CAMARERO")
    private String apellidoPaternoCamarero;
    @Size(max = 30)
    @Column(name = "APELLIDO_MATERNO_CAMARERO")
    private String apellidoMaternoCamarero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCamarero")
    private List<Factura> facturaList;

    public Camarero() {
    }

    public Camarero(Integer idCamarero) {
        this.idCamarero = idCamarero;
    }

    public Integer getIdCamarero() {
        return idCamarero;
    }

    public void setIdCamarero(Integer idCamarero) {
        this.idCamarero = idCamarero;
    }

    public String getNombreCamarero() {
        return nombreCamarero;
    }

    public void setNombreCamarero(String nombreCamarero) {
        this.nombreCamarero = nombreCamarero;
    }

    public String getApellidoPaternoCamarero() {
        return apellidoPaternoCamarero;
    }

    public void setApellidoPaternoCamarero(String apellidoPaternoCamarero) {
        this.apellidoPaternoCamarero = apellidoPaternoCamarero;
    }

    public String getApellidoMaternoCamarero() {
        return apellidoMaternoCamarero;
    }

    public void setApellidoMaternoCamarero(String apellidoMaternoCamarero) {
        this.apellidoMaternoCamarero = apellidoMaternoCamarero;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCamarero != null ? idCamarero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camarero)) {
            return false;
        }
        Camarero other = (Camarero) object;
        if ((this.idCamarero == null && other.idCamarero != null) || (this.idCamarero != null && !this.idCamarero.equals(other.idCamarero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.conexia.entity.Camarero[ idCamarero=" + idCamarero + " ]";
    }
    
}

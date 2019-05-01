/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "PLATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p")
    , @NamedQuery(name = "Plato.findByIdPlato", query = "SELECT p FROM Plato p WHERE p.idPlato = :idPlato")
    , @NamedQuery(name = "Plato.findByNombrePlato", query = "SELECT p FROM Plato p WHERE p.nombrePlato = :nombrePlato")
    , @NamedQuery(name = "Plato.findByValorPlato", query = "SELECT p FROM Plato p WHERE p.valorPlato = :valorPlato")
    , @NamedQuery(name = "Plato.findByDetallePlato", query = "SELECT p FROM Plato p WHERE p.detallePlato = :detallePlato")})
public class Plato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PLATO")
    private Integer idPlato;
    @Size(max = 30)
    @Column(name = "NOMBRE_PLATO")
    private String nombrePlato;
    @Column(name = "VALOR_PLATO")
    private BigInteger valorPlato;
    @Size(max = 100)
    @Column(name = "DETALLE_PLATO")
    private String detallePlato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlato")
    private List<DetalleFactura> detalleFacturaList;

    public Plato() {
    }

    public Plato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public BigInteger getValorPlato() {
        return valorPlato;
    }

    public void setValorPlato(BigInteger valorPlato) {
        this.valorPlato = valorPlato;
    }

    public String getDetallePlato() {
        return detallePlato;
    }

    public void setDetallePlato(String detallePlato) {
        this.detallePlato = detallePlato;
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
        hash += (idPlato != null ? idPlato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plato)) {
            return false;
        }
        Plato other = (Plato) object;
        if ((this.idPlato == null && other.idPlato != null) || (this.idPlato != null && !this.idPlato.equals(other.idPlato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.conexia.entity.Plato[ idPlato=" + idPlato + " ]";
    }
    
}

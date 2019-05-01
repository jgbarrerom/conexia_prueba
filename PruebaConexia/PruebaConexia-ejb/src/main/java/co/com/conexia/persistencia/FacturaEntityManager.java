/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.persistencia;

import co.com.conexia.entity.Factura;
import co.com.conexia.dao.VentasCamareroMesDTO;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author jeisson
 */
public class FacturaEntityManager extends PersistenceEntityManager<Factura> {

    public List<VentasCamareroMesDTO> consultarVentasMes() {
        try {
            Session se = HibernateUtil.getSessionFac().openSession();
            Query qr = se.createQuery("SELECT new co.com.conexia.dao.VentasCamareroMesDTO(c.nombreCamarero,c.apellidoPaternoCamarero,c.apellidoMaternoCamarero,SUM(d.subtotalDetalle),MONTH(f.fechaFactura)) FROM Camarero c LEFT JOIN c.facturaList as f LEFT JOIN f.detalleFacturaList AS d GROUP BY c.idCamarero, MONTH(f.fechaFactura)");
            return qr.getResultList();
        } catch (HibernateException he) {
            throw new HibernateException("Ocurrio un error en la consulta" + he);
        } finally {
            HibernateUtil.cerrarSessionFac();
        }
    }
}

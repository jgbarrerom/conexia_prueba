/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.persistencia;

import co.com.conexia.entity.Cliente;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author jeisson
 */
public class ClienteEntityManager extends PersistenceEntityManager<Cliente> {

    public List<Cliente> filtrarMejoresClientes() {
        try {
            Session se = HibernateUtil.getSessionFac().openSession();
            Query qr = se.createQuery("SELECT c.nombreCliente,c.apellidoPaternoCliente,c.apellidoMaternoCliente,SUM(d.subtotalDetalle) FROM Cliente c INNER JOIN c.facturaList AS f INNER JOIN f.detalleFacturaList AS d GROUP BY c.nombreCliente,c.apellidoPaternoCliente,c.apellidoMaternoCliente HAVING SUM(d.subtotalDetalle) > 100000");
            return qr.getResultList();
        } catch (HibernateException he) {
            throw new HibernateException("Ocurrio un error en la consulta " + he.getMessage());
        } finally {

        }
    }
}

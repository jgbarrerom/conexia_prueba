/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.persistencia;

import co.com.conexia.dao.ClienteComprasDto;
import co.com.conexia.entity.Cliente;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author jeisson
 */
public class ClienteEntityManager extends PersistenceEntityManager<Cliente> {

    public List<ClienteComprasDto> filtrarMejoresClientes() {
        try {
            Session se = HibernateUtil.getSessionFac().openSession();
            Query qr = se.createQuery("SELECT c.nombreCliente,c.apellidoPaternoCliente,c.apellidoMaternoCliente,SUM(d.subtotalDetalle) FROM Cliente c INNER JOIN c.facturaList AS f INNER JOIN f.detalleFacturaList AS d GROUP BY c.nombreCliente,c.apellidoPaternoCliente,c.apellidoMaternoCliente HAVING SUM(d.subtotalDetalle) > 100000");
            return mapeoCliente(qr.getResultList());
        } catch (HibernateException he) {
            throw new HibernateException("Ocurrio un error en la consulta " + he.getMessage());
        } 
    }
    
    private List<ClienteComprasDto> mapeoCliente(List<Object[]> lista){
        List<ClienteComprasDto> resMapeo = new ArrayList<>();
        for(Object[] tupla : lista){
            resMapeo.add(new ClienteComprasDto(tupla[0] != null ? (String)tupla[0] : "", 
                    tupla[1] != null ? (String)tupla[1] : "", 
                    tupla[2] != null ? (String)tupla[2] : "", 
                    tupla[3] != null ? (BigInteger)tupla[3] : BigInteger.ZERO));
        }
        return resMapeo;
    }
}

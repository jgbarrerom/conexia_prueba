/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.persistencia;

import co.com.conexia.entity.Factura;
import co.com.conexia.dao.VentasCamareroMesDTO;
import java.math.BigInteger;
import java.util.ArrayList;
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
            Query qr = se.createQuery("SELECT c.nombreCamarero,c.apellidoPaternoCamarero,c.apellidoMaternoCamarero,SUM(d.subtotalDetalle),MONTH(f.fechaFactura) FROM Camarero c LEFT JOIN c.facturaList as f LEFT JOIN f.detalleFacturaList AS d GROUP BY c.idCamarero, MONTH(f.fechaFactura)");
            return maparDtoVentaMes(qr.getResultList());
        } catch (HibernateException he) {
            throw new HibernateException("Ocurrio un error en la consulta" + he);
        } finally {
            //HibernateUtil.cerrarSessionFac();
        }
    }
    
    private List<VentasCamareroMesDTO> maparDtoVentaMes(List<Object[]> obj){
        List<VentasCamareroMesDTO> listMap = new ArrayList<>();
        for(Object[] tupla : obj){
            listMap.add(new VentasCamareroMesDTO(tupla[0] != null ? (String)tupla[0] : "", 
                    tupla[1] != null ? (String)tupla[1] : "", 
                    tupla[2] != null ? (String)tupla[2] : "", 
                    tupla[3] != null ? (BigInteger)tupla[3] : BigInteger.ZERO, 
                    tupla[4] != null ? (Integer)tupla[4] : null));
        }
        return listMap;
    }
}

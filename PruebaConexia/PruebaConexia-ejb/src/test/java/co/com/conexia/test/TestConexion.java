/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.test;

import co.com.conexia.entity.Camarero;
import co.com.conexia.entity.Factura;
import co.com.conexia.persistencia.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Test;

/**
 *
 * @author jeisson
 */
public class TestConexion {

    public TestConexion() {
    }

    @Test
    public void test() {
        Session session = null;
        Transaction txn = null;
        try {
            session = HibernateUtil.getSessionFac().openSession();
            if (session.find(Camarero.class, 1) == null) {
                throw new RuntimeException("Error en consulta");
            }

        } catch (RuntimeException e) {
            if (txn != null && txn.isActive()) {
                txn.rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

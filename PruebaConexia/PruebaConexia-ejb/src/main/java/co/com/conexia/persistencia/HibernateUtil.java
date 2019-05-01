/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author jeisson
 */
public class HibernateUtil {

    private static final SessionFactory sessionFac = crearSessionFactory();

    private static SessionFactory crearSessionFactory() {
        try {            
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable tr) {
            System.err.println("" + tr);
            throw new ExceptionInInitializerError(tr);
        }
    }

    public static SessionFactory getSessionFac() {
        return sessionFac;
    }

    public static void cerrarSessionFac() {
        if (sessionFac != null) {
            sessionFac.getCurrentSession();
        }
    }

}

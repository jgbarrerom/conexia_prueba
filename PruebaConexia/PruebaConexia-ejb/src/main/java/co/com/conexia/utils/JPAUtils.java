/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jeisson
 */
public class JPAUtils {
    private static final EntityManagerFactory factory;
    static{
        factory = Persistence.createEntityManagerFactory("connectionDA");
        System.out.println("se llamos");
    }
    
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
    
    public static void close(){
        factory.close();
    }
}

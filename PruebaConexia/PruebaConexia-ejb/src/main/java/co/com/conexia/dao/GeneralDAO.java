/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.dao;

import co.com.conexia.utils.JPAUtils;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author jeisson
 * @param <T>
 */
public abstract class GeneralDAO<T> implements Serializable{
    
    private Class<T> clazz = getDomainClass();
    
    protected List<T> obtenerTodos(){
        EntityManager em = JPAUtils.getEntityManager();
        Query qr = em.createQuery("SELECT c FROM " + clazz.getSimpleName() + " c", clazz);
        return qr.getResultList();
    }
    
    protected void actualizar(T t){
        EntityManager em = JPAUtils.getEntityManager();
        em.refresh(t);
        em.flush();
    }
    
    protected void guardar(T t){
        EntityManager em = JPAUtils.getEntityManager();
        em.persist(t);
        em.flush();
    } 
    
    
    public Class getDomainClass(){
        if(clazz == null){
            ParameterizedType tipo = (ParameterizedType) getClass().getGenericSuperclass();
            clazz = (Class) tipo.getActualTypeArguments()[0];
        }
        return clazz;
    }
}

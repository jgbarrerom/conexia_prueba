/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.persistencia;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author jeisson
 */
public abstract class PersistenceEntityManager<T> {
    
    protected Class clase = (Class)((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    private Logger log = Logger.getLogger(this.getClass());
    
    public Boolean guardar(T entidad) {
        try {
            Session sesion = HibernateUtil.getSessionFac().openSession();
            sesion.saveOrUpdate(entidad);
            sesion.flush();
            return sesion.getIdentifier(entidad) != null;
        } catch (HibernateException he) {
            log.error("Ocurrio un error al guardar en BD", he);
        } finally {
            HibernateUtil.cerrarSessionFac();
        }
        return Boolean.FALSE;
    }
    
    public List<T> obtenerTodos(){
        Session sesion = HibernateUtil.getSessionFac().openSession();
        Query qr = sesion.createQuery("FROM " + clase.getSimpleName());
        return qr.getResultList();
    }
}

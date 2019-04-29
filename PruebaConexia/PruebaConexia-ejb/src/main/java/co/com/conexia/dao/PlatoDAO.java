/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.dao;

import co.com.conexia.entity.Plato;
import java.util.List;

/**
 *
 * @author jeisson
 */
public class PlatoDAO extends GeneralDAO<Plato>{
    
    public List<Plato> allPlatos(){
        return this.obtenerTodos();
    }
}

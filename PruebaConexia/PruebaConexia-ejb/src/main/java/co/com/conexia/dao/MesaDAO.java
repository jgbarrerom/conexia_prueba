/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.conexia.dao;

import co.com.conexia.entity.Mesa;
import java.util.List;

/**
 *
 * @author jeisson
 */
public class MesaDAO extends GeneralDAO<Mesa>{
    
    public List<Mesa> allMesa(){
        return this.obtenerTodos();
    }
}

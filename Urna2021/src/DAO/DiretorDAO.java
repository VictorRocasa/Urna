/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author victorPC
 */
public class DiretorDAO implements InterfaceDAO{
    private static DiretorDAO instancia = null;
    private String sql;
    private Connection conn;
    
    private DiretorDAO(){}
    
    public static DiretorDAO getInstancia(){
        if(instancia == null)
            instancia = new DiretorDAO();
        return instancia;
    }


    @Override
    public boolean adiciona(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exclui(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean altera(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> consulta(Object obj, int nValorConsulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

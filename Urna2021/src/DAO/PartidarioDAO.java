/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Partidario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author victorPC
 */
public class PartidarioDAO implements InterfaceDAO{
    private static PartidarioDAO instancia = null;
    private String sql;
    private Connection conn;
    
    public static PartidarioDAO getInstancia(){
        if(instancia == null)
            instancia = new PartidarioDAO();
        return instancia;
    }

    @Override
    public boolean adiciona(Object obj) {
        Partidario partidario = (Partidario) obj;
        sql = "INSERT INTO partidario (id_eleitor, id_partido, cargo_no_partido) VALUES ("+partidario.getIdEleitor()+","+partidario.getIdPartido()+",'"+partidario.getCargoNoPartido()+"');";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        try{
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            Conexao.closeConn();
            return true;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ptdrD44-Não foi possível conectar ao banco de dados, tente novamente em breve.","Erro!", 0);     
            Conexao.closeConn();  
            return false;      
        }
    }

    @Override
    public boolean exclui(int id) {
        sql = "DELETE from partidario where id_partidario = "+id+";";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        try{
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Deletado com sucesso!","Sucesso!", 1);
            Conexao.closeConn();
            return true;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ptdrD63-Não foi possível conectar ao banco de dados, tente novamente em breve.","Erro!", 0);           
        }
        Conexao.closeConn();  
        return false;
    }

    @Override
    public boolean altera(Object obj) {
        Partidario partidario = (Partidario) obj;
        sql = "UPDATE partidario SET id_partido = "+partidario.getIdPartido()+", cargo_no_partido = '"+partidario.getCargoNoPartido()+"' where id_partidario = "+partidario.getIdPartidario()+";";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        try{
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            Conexao.closeConn();
            return true;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ptdrD82-Não foi possível conectar ao banco de dados, tente novamente em breve.","Erro!", 0);           
        }
        Conexao.closeConn();  
        return false;
    }

    @Override
    public ArrayList<Object> consulta(Object obj, int nValorConsulta) {
        Partidario partidario = (Partidario) obj;
        String valorConsulta;
        switch(nValorConsulta){
            case 1: valorConsulta = " WHERE id_partidario = "+partidario.getIdPartidario()+";"; break;//consulta por id do eleitor enviado
            case 2: valorConsulta =  " WHERE id_eleitor = "+partidario.getIdEleitor()+";"; break;//consulta por id_eleitor do partidario enviado
            case 3: valorConsulta =  " WHERE id_partido = "+partidario.getIdPartido()+";"; break;//consulta por id_partido do artidario enviado
            case 4: valorConsulta =  " WHERE cargo_no_partido LIKE '"+partidario.getCargoNoPartido()+"';"; break;//consulta por cargo do partidario enviado
            default: valorConsulta = ";"; break;
        }
        sql = "SELECT id_partidario,id_eleitor,id_partido,cargo_no_partido FROM partidario"+valorConsulta;
        ArrayList<Object> registros = new ArrayList();
        conn = Conexao.conectar();
        PreparedStatement stmt;
        try{
            stmt = conn.prepareStatement(sql);
            ResultSet retorno = stmt.executeQuery();    
            Partidario registro;
            while(retorno.next()){
               registro = new Partidario(); 
               registro.setIdPartidario(retorno.getInt(1));              
               registro.setIdEleitor(retorno.getInt(2));
               registro.setIdPartido(retorno.getInt(3));  
               registro.setCargoNoPartido(retorno.getString(4)); 
               registros.add(registro);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro priod1116-Não foi possível conectar ao banco de dados, tente novamente em breve.","Erro!", 0);
            Conexao.closeConn();  
            return null;
        }
        Conexao.closeConn();
        return registros;
    }  
    
}
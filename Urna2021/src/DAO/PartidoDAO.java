/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Partido;
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
public class PartidoDAO implements InterfaceDAO{
    private static PartidoDAO instancia = null;
    private String sql;
    private Connection conn;
    
    private PartidoDAO(){}
    
    public static PartidoDAO getInstancia(){
        if(instancia == null)
            instancia = new PartidoDAO();
        return instancia;
    }

    @Override
    public boolean adiciona(Object obj) {
        Partido partido = (Partido) obj;
        sql = "INSERT INTO partido (numero, nome) VALUES ("+partido.getNumero()+",'"+partido.getNome()+"');";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        try{
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            Conexao.closeConn();
            return true;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ptdD46-Não foi possível conectar ao banco de dados, tente novamente em breve.","Erro!", 0);
            Conexao.closeConn();       
            return false;      
        }
    }

    @Override
    public boolean exclui(int id) {
        sql = "DELETE from partido where id_partido = "+id+";";
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
            JOptionPane.showMessageDialog(null,"Erro elcD65-Não foi possível conectar ao banco de dados, tente novamente em breve.","Erro!", 0);           
        }
        Conexao.closeConn();  
        return false;
    }

    @Override
    public boolean altera(Object obj) {
        Partido partido = (Partido) obj;
        sql = "UPDATE partido SET numero = "+partido.getNumero()+", nome = '"+partido.getNome()+"' where id_partido = "+partido.getIdPartido()+";";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        try{
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            Conexao.closeConn();
            return true;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro elcD84-Não foi possível conectar ao banco de dados, tente novamente em breve.","Erro!", 0);           
        }
        Conexao.closeConn();  
        return false;
    }

    @Override
    public ArrayList<Object> consulta(Object obj, int nValorConsulta) {
        Partido partido = (Partido) obj;
        String valorConsulta;
        switch(nValorConsulta){
            case 1: valorConsulta = " WHERE id_partido = "+partido.getIdPartido()+";"; break;//consulta por id do partido enviado
            case 2: valorConsulta =  " WHERE numero = "+partido.getNumero()+";"; break;//consulta por numero do partido enviado
            case 3: valorConsulta =  " WHERE nome LIKE '"+partido.getNome()+"';"; break;//consulta por nome do partido enviado
            default: valorConsulta = ";"; break;
        }
        sql = "SELECT id_partido,numero,nome FROM partido"+valorConsulta;
        ArrayList<Object> registros = new ArrayList();
        conn = Conexao.conectar();
        PreparedStatement stmt;
        try{
            stmt = conn.prepareStatement(sql);
            ResultSet retorno = stmt.executeQuery();
            Partido registro;      
            while(retorno.next()){
               registro = new Partido(); 
               registro.setIdPartido(retorno.getInt(1));   
               registro.setNumero(retorno.getInt(2));           
               registro.setNome(retorno.getString(3));
               registros.add(registro);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ptd87-Não foi possível conectar ao banco de dados, tente novamente em breve.","Erro!", 0);  
            Conexao.closeConn();  
            return null;
        }
        Conexao.closeConn();  
        return registros;
    }
}   
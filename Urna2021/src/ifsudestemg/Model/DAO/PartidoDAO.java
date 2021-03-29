/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.model.DAO;

import ifsudestemg.Model.Partido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author victorPC
 */
public class PartidoDAO implements InterfaceDAO{
    private String sql;
    private Connection conn;

    @Override
    public void adiciona(Object obj) throws ClassNotFoundException, SQLException {
        Partido partido = (Partido) obj;
        sql = "INSERT INTO partido (numero, nome) VALUES ("+partido.getNumero()+",'"+partido.getNome()+"');";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }

    @Override
    public void exclui(int id) throws ClassNotFoundException, SQLException {
        sql = "DELETE from partido where id_partido = "+id+";";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }

    @Override
    public void altera(Object obj) throws ClassNotFoundException, SQLException {
        Partido partido = (Partido) obj;
        sql = "UPDATE partido SET numero = "+partido.getNumero()+", nome = '"+partido.getNome()+"' where id_partido = "+partido.getIdPartido()+";";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }

    @Override
    public ArrayList<Object> consulta(Object obj, int nValorConsulta) throws ClassNotFoundException, SQLException {
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
        Statement stmt = conn.createStatement();
        ResultSet retorno = stmt.executeQuery(sql);
        Partido registro;      
        while(retorno.next()){
           registro = new Partido(); 
           registro.setIdPartido(retorno.getInt(1));   
           registro.setNumero(retorno.getInt(2));           
           registro.setNome(retorno.getString(3));
           registros.add(registro);
        }
        Conexao.closeConn();  
        return registros;
    }
}   
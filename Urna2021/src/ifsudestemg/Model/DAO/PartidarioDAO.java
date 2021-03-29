/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.model.DAO;

import ifsudestemg.Model.Partidario;
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
public class PartidarioDAO implements InterfaceDAO{
    private String sql;
    private Connection conn;

    @Override
    public void adiciona(Object obj) throws ClassNotFoundException, SQLException {
        Partidario partidario = (Partidario) obj;
        sql = "INSERT INTO partidario (id_eleitor, id_partido, cargo_no_partido) VALUES ("+partidario.getIdEleitor()+","+partidario.getIdPartido()+",'"+partidario.getCargoNoPartido()+"');";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }

    @Override
    public void exclui(int id) throws ClassNotFoundException, SQLException {
        sql = "DELETE from partidario where id_partidario = "+id+";";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }

    @Override
    public void altera(Object obj) throws ClassNotFoundException, SQLException {
        Partidario partidario = (Partidario) obj;
        sql = "UPDATE partidario SET id_partido = "+partidario.getIdPartido()+", cargo_no_partido = '"+partidario.getCargoNoPartido()+"' where id_partidario = "+partidario.getIdPartidario()+";";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }

    @Override
    public ArrayList<Object> consulta(Object obj, int nValorConsulta) throws ClassNotFoundException, SQLException {
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
        Statement stmt = conn.createStatement();
        ResultSet retorno = stmt.executeQuery(sql);
        Partidario registro;
        while(retorno.next()){
           registro = new Partidario(); 
           registro.setIdPartidario(retorno.getInt(1));              
           registro.setIdEleitor(retorno.getInt(2));
           registro.setIdPartido(retorno.getInt(3));  
           registro.setCargoNoPartido(retorno.getString(4)); 
           registros.add(registro);
        }
        Conexao.closeConn();
        return registros;
    }  
    
    public ArrayList<Object[]> consulta() throws ClassNotFoundException, SQLException {
        sql = "SELECT partidario.id_partidario,eleitor.cpf,partido.numero,partidario.cargo_no_partido FROM partidario,eleitor,partido WHERE partidario.id_eleitor = eleitor.id_eleitor AND partidario.id_partido = partido.id_partido;";
        conn = Conexao.conectar();
        Statement stmt = conn.createStatement();
        ResultSet retorno = stmt.executeQuery(sql);
        ArrayList<Object[]> registros = new ArrayList();
        Object[] registro;
        while(retorno.next()){
           registro = new Object[4]; 
           registro[0] = retorno.getInt(1);              
           registro[1] = retorno.getString(2);
           registro[2] = retorno.getInt(3);  
           registro[3] = retorno.getString(4); 
           registros.add(registro);
        }
        Conexao.closeConn();
        return registros;
    }  
}
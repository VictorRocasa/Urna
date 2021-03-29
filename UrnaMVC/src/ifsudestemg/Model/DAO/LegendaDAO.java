/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.model.DAO;

import ifsudestemg.Model.Legenda;
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
public class LegendaDAO implements InterfaceDAO{
    private String sql;
    private Connection conn;

    @Override
    public void adiciona(Object obj) throws ClassNotFoundException, SQLException {
        Legenda legenda = (Legenda) obj;
        sql = "INSERT INTO legenda (id_partido,id_eleicao) VALUES ("+legenda.getIdPartido()+","+legenda.getIdEleicao()+");";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }

    @Override
    public void exclui(int id) throws ClassNotFoundException, SQLException {
        sql = "DELETE from legenda where id_legenda = "+id+";";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }

    @Override
    public void altera(Object obj) throws ClassNotFoundException, SQLException {
//        Legenda legenda = (Legenda) obj;
//        sql = "UPDATE legenda  SET votos_legenda;";
//        conn = Conexao.conectar();
//        PreparedStatement stmt;
//        stmt = conn.prepareStatement(sql);
//        stmt.executeUpdate();
//        Conexao.closeConn();
    }

    @Override
    public ArrayList<Object> consulta(Object obj, int nValorConsulta) throws ClassNotFoundException, SQLException{
        Legenda legenda = (Legenda) obj;
        String valorConsulta;
        switch(nValorConsulta){
            case 1: valorConsulta = " WHERE id_legenda  = "+legenda.getIdLegenda()+";"; break;//consulta por id da legenda enviada
            case 2: valorConsulta =  " WHERE id_partido  = "+legenda.getIdPartido()+";"; break;//consulta por cargo da legenda enviado
            case 3: valorConsulta =  " WHERE id_eleicao  = "+legenda.getIdEleicao()+";"; break;//consulta por regiao do legenda enviada
            case 4: valorConsulta =  " WHERE votos_legenda = "+legenda.getnVotos()+";"; break;//consulta por nVotos da legenda enviada
            case 5: valorConsulta =  " WHERE id_partido = "+legenda.getIdPartido()+" AND id_eleicao ="+legenda.getIdEleicao()+";"; break;//consulta por nVotos da legenda enviada
            default: valorConsulta = ";"; break;
        }
        sql = "SELECT id_legenda,id_partido,id_eleicao,votos_legenda FROM legenda"+valorConsulta;
        ArrayList<Object> registros = new ArrayList();
        conn = Conexao.conectar();
        Statement stmt = conn.createStatement();
        ResultSet retorno = stmt.executeQuery(sql); 
        Legenda registro;   
        while(retorno.next()){
           registro = new Legenda();
           registro.setIdLegenda(retorno.getInt(1));              
           registro.setIdPartido(retorno.getInt(2));
           registro.setIdEleicao(retorno.getInt(3));
           registro.setnVotos(retorno.getInt(4)); 
           registros.add(registro);
        }
        return registros;
    }
    
    
    public ArrayList<Object> consulta(int idEleicao) throws ClassNotFoundException, SQLException {
        sql = "SELECT legenda.id_legenda,partido.numero,partido.nome FROM partido,legenda WHERE partido.id_partido = legenda.id_partido and legenda.id_eleicao = "+idEleicao+";";
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.model.DAO;

import ifsudestemg.Model.Candidato;
import ifsudestemg.Model.Legenda;
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
public class CandidatoDAO implements InterfaceDAO{
    private String sql;
    private Connection conn;

    @Override
    public void adiciona(Object obj) throws ClassNotFoundException, SQLException {
        Candidato candidato = (Candidato) obj;
        sql = "INSERT INTO candidato (id_legenda,id_partidario,numero) VALUES ("+candidato.getIdLegenda()+","+candidato.getIdPartidario()+","+candidato.getNumero()+");";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }

    @Override
    public void exclui(int id) throws ClassNotFoundException, SQLException {
        sql = "DELETE from candidato where id_candidato = "+id+";";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }

    @Override
    public void altera(Object obj) throws ClassNotFoundException, SQLException {
//        Candidato candidato = (Candidato) obj;
//        sql = "UPDATE candidato  SET votos_candidato;";
//        conn = Conexao.conectar();
//        PreparedStatement stmt;
//        stmt = conn.prepareStatement(sql);
//        stmt.executeUpdate();
//        Conexao.closeConn();
    }

    @Override
    public ArrayList<Object> consulta(Object obj, int nValorConsulta) throws ClassNotFoundException, SQLException{
        Candidato candidato = (Candidato) obj;
        String valorConsulta;
        switch(nValorConsulta){
            case 1: valorConsulta = " WHERE id_candidato  = "+candidato.getIdCandidato()+";"; break;//consulta por id da candidato enviada
            case 2: valorConsulta =  " WHERE id_legenda  = "+candidato.getIdLegenda()+";"; break;//consulta por cargo da candidato enviado
            case 3: valorConsulta =  " WHERE id_partidario   = "+candidato.getIdPartidario()+";"; break;//consulta por regiao do candidato enviada
            case 4: valorConsulta =  " WHERE numero  = "+candidato.getNumero()+";"; break;//consulta por nVotos da candidato enviada
            case 5: valorConsulta =  " WHERE votos_candidato = "+candidato.getnVotos()+";"; break;//consulta por nVotos da candidato enviada
            case 6: valorConsulta =  " WHERE id_legenda = "+candidato.getIdLegenda()+" AND id_eleicao ="+candidato.getIdPartidario()+";"; break;//consulta por nVotos da candidato enviada
            default: valorConsulta = ";"; break;
        }
        sql = "SELECT id_candidato,id_legenda,id_eleicao,votos_candidato FROM candidato"+valorConsulta;
        ArrayList<Object> registros = new ArrayList();
        conn = Conexao.conectar();
        Statement stmt = conn.createStatement();
        ResultSet retorno = stmt.executeQuery(sql); 
        Candidato registro;   
        while(retorno.next()){
           registro = new Candidato();
           registro.setIdCandidato(retorno.getInt(1));              
           registro.setIdLegenda(retorno.getInt(2));
           registro.setIdPartidario(retorno.getInt(3));
           registro.setnVotos(retorno.getInt(4)); 
           registros.add(registro);
        }
        return registros;
    }
    
    public ArrayList<Object[]> consulta(int idLegenda) throws ClassNotFoundException, SQLException{
        sql = "SELECT partidario.id_partidario,eleitor.cpf,partidario.cargo_no_partido from partidario,partido,eleitor,legenda WHERE"
        + " legenda.id_legenda = "+idLegenda+" AND partido.id_partido = legenda.id_partido AND partido.id_partido = partidario.id_partido AND eleitor.id_eleitor = partidario.id_eleitor;";
        ArrayList<Object[]> registros = new ArrayList();
        conn = Conexao.conectar();
        Statement stmt = conn.createStatement();
        ResultSet retorno = stmt.executeQuery(sql); 
        Object[] registro;   
        while(retorno.next()){
           registro = new Object[3];
           registro[0] = (retorno.getInt(1));              
           registro[1] = (retorno.getString(2));
           registro[2] = (retorno.getString(3)); 
           registros.add(registro);
        }
        return registros;
    }
    
    public Candidato consulta(int idLegenda, int idPartidario) throws ClassNotFoundException, SQLException{
        sql = "SELECT id_candidato,numero from candidato WHERE id_legenda = "+idLegenda+" AND id_partidario = "+idPartidario+";";
        ArrayList<Object[]> registros = new ArrayList();
        conn = Conexao.conectar();
        Statement stmt = conn.createStatement();
        ResultSet retorno = stmt.executeQuery(sql);   
        Candidato candidato = new Candidato();
        candidato.setIdCandidato(-1);
        while(retorno.next()){
           candidato.setIdCandidato(retorno.getInt(1));
           candidato.setNumero(retorno.getInt(2));
        }
        return candidato;
    }
}
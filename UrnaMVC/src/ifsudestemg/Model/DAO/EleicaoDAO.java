/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.model.DAO;

import ifsudestemg.Model.Eleicao;
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
public class EleicaoDAO implements InterfaceDAO{
    private String sql;
    private Connection conn;

    @Override
    public void adiciona(Object obj) throws ClassNotFoundException, SQLException{
        Eleicao eleicao = (Eleicao) obj;
        sql = "INSERT INTO eleicao (cargo,regiao,data_da_eleicao,turno) VALUES ('"+eleicao.getCargo()+"','"+eleicao.getRegiao()+"','"+eleicao.getDataEleicao()+"','"+eleicao.getTurno()+"');";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }

    @Override
    public void exclui(int id) throws ClassNotFoundException, SQLException{
        sql = "DELETE from eleicao WHERE id_eleicao = "+id+";";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }

    @Override
    public void altera(Object obj) throws ClassNotFoundException, SQLException{
        Eleicao eleicao = (Eleicao) obj;
        sql = "UPDATE eleicao SET cargo = '"+eleicao.getCargo()+"', regiao = '"+eleicao.getRegiao()+"', data_da_eleicao = '"+eleicao.getDataEleicao()+"', turno = '"+eleicao.getTurno()+"' WHERE id_eleicao = "+eleicao.getIdEleicao()+";";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }

    @Override
    public ArrayList<Object> consulta(Object obj, int nValorConsulta) throws ClassNotFoundException, SQLException{
        Eleicao eleicao = (Eleicao) obj;
        String valorConsulta;
        switch(nValorConsulta){
            case 1: valorConsulta = " WHERE id_eleicao  = "+eleicao.getIdEleicao()+";"; break;//consulta por id da eleicao enviada
            case 2: valorConsulta =  " WHERE cargo LIKE '"+eleicao.getCargo()+"';"; break;//consulta por cargo da eleicao enviado
            case 3: valorConsulta =  " WHERE regiao LIKE '"+eleicao.getRegiao()+"';"; break;//consulta por regiao do eleicao enviada
            case 4: valorConsulta =  " WHERE data_da_eleicao LIKE '"+eleicao.getDataEleicao()+"';"; break;//consulta por data da eleicao enviada
            case 5: valorConsulta =  " WHERE turno LIKE '"+eleicao.getTurno()+"';"; break;//consulta por turno do eleicao enviada
            default: valorConsulta = ";"; break;
        }
        sql = "SELECT id_eleicao,cargo,regiao,data_da_eleicao,turno FROM eleicao"+valorConsulta;
        ArrayList<Object> registros = new ArrayList();
        conn = Conexao.conectar();
        Statement stmt = conn.createStatement();
        ResultSet retorno = stmt.executeQuery(sql); 
        Eleicao registro;   
        while(retorno.next()){
           registro = new Eleicao();
           registro.setIdEleicao(retorno.getInt(1));              
           registro.setCargo(retorno.getString(2));
           registro.setRegiao(retorno.getString(3));
           String[] partes = retorno.getString(4).split("-");
           registro.setDataEleicao(partes[2]+"/"+partes[1]+"/"+partes[0]);
           registro.setTurno(retorno.getString(5)); 
           registros.add(registro);
        }
        return registros;
    }  
    
}
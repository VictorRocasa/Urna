/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Eleicao;
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
public class EleicaoDAO implements InterfaceDAO{
    private static EleicaoDAO instancia = null;
    private String sql;
    private Connection conn;
    
    private EleicaoDAO(){}
    
    public static EleicaoDAO getInstancia(){
        if(instancia == null)
            instancia = new EleicaoDAO();
        return instancia;
    }

    @Override
    public boolean adiciona(Object obj) {
        Eleicao eleicao = (Eleicao) obj;
        sql = "INSERT INTO eleicao (cargo,regiao,data_da_eleicao,turno) VALUES ('"+eleicao.getCargo()+"','"+eleicao.getRegiao()+"','"+eleicao.getDataEleicao()+"','"+eleicao.getTurno()+"');";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        try{
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            Conexao.closeConn();
            return true;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro elcD46-Não foi possível conectar ao banco de dados, tente novamente em breve.","Erro!", 0);           
        }
        Conexao.closeConn();  
        return false;
    }

    @Override
    public boolean exclui(int id) {
        sql = "DELETE from eleicao where id_eleicao = "+id+";";
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
        Eleicao eleicao = (Eleicao) obj;
        sql = "UPDATE eleicao SET cargo = '"+eleicao.getCargo()+"', regiao = '"+eleicao.getRegiao()+"', data_da_eleicao = '"+eleicao.getDataEleicao()+"', turno = '"+eleicao.getTurno()+"' where id_eleicao = "+eleicao.getIdEleicao()+";";
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
        Eleicao eleicao = (Eleicao) obj;
        String valorConsulta;
        switch(nValorConsulta){
            case 1: valorConsulta = " WHERE id_eleicao  = "+eleicao.getIdEleicao()+"';"; break;//consulta por id da eleicao enviada
            case 2: valorConsulta =  " WHERE cargo LIKE '"+eleicao.getCargo()+"';"; break;//consulta por cargo da eleicao enviado
            case 3: valorConsulta =  " WHERE regiao LIKE '"+eleicao.getRegiao()+"';"; break;//consulta por regiao do eleicao enviada
            case 4: valorConsulta =  " WHERE data_da_eleicao LIKE '"+eleicao.getDataEleicao()+"';"; break;//consulta por data da eleicao enviada
            case 5: valorConsulta =  " WHERE turno LIKE '"+eleicao.getTurno()+"';"; break;//consulta por turno do eleicao enviada
            default: valorConsulta = ";"; break;
        }
        sql = "SELECT id_eleicao,cargo,regiao,data_da_eleicao,turno FROM eleicao"+valorConsulta;
        ArrayList<Object> registros = new ArrayList();
        conn = Conexao.conectar();
        PreparedStatement stmt;
        Eleicao registro;   
        try{
            stmt = conn.prepareStatement(sql);
            ResultSet retorno = stmt.executeQuery();    
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
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro etd124-Não foi possível conectar ao banco de dados, tente novamente em breve.","Erro!", 0);  
            Conexao.closeConn();  
            return null;
        }
        Conexao.closeConn();  
        return registros;
    }  
    
}
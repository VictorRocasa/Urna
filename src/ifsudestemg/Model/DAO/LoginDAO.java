/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.Model.DAO;

import ifsudestemg.Model.Login;
import ifsudestemg.model.DAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author victorPC
 */
public class LoginDAO {
    private String sql;
    private Connection conn;

    public void adiciona(Login login) throws ClassNotFoundException, SQLException{
        sql = "INSERT INTO login (id_eleitor,cpf,senha,tipo) VALUES ("+login.getidEleitor()+",'"+login.getCpf()+"','"+login.getSenha()+"', 0);";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }
    
    public void alterar(Login login) throws ClassNotFoundException, SQLException{
        sql = "UPDATE login SET tipo="+login.getTipo()+" WHERE login.idLogin = "+login.getIdLogin()+";";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }
    
    public void alterarSenha(Login login) throws ClassNotFoundException, SQLException{
        sql = "UPDATE login SET senha='"+login.getSenha()+"' WHERE id_eleitor = '"+login.getidEleitor()+"';";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();
    }
    
    public int logar(String cpf,String senha) throws ClassNotFoundException, SQLException{
        sql = "SELECT tipo FROM login WHERE cpf='"+cpf+"' AND senha = '"+senha+"';";
        conn = Conexao.conectar();
        Statement stmt = conn.createStatement();
        ResultSet retorno = stmt.executeQuery(sql);
        int tipo = -1;
        if(retorno.next())
            tipo = retorno.getInt(1);
        return tipo;
    }
    
    public String retornaSenha(int idEleitor) throws ClassNotFoundException, SQLException{
        sql = "SELECT senha FROM login WHERE id_eleitor="+idEleitor+";";
        conn = Conexao.conectar();
        Statement stmt = conn.createStatement();
        ResultSet retorno = stmt.executeQuery(sql);
        String senha = "";
        if(retorno.next())
            senha = retorno.getString(1);
        return senha;
    }
}

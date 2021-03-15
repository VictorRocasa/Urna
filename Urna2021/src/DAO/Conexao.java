/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author victorPC
 */
public class Conexao {
    private static Connection conn = null;
    
    private Conexao(){
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Urna", "postgres","123456");
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o driver especificado.","Erro!", 2);
            System.exit(1);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados, tente novamente em breve.","Erro!", 0);
            System.exit(1);         
        }
    }
    
    public static Connection conectar(){
        if(conn == null)
            new Conexao();
        return conn;
    }
    
    public static void closeConn(){
        try{
            conn.close();
            conn = null;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro crítico ao acessar o banco de dados.","Erro!", 2);
            System.exit(1);
        }
    }
}

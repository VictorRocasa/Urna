/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author victorPC
 */
public class Persistencia {
    private static Connection conn = null;
    
    private Persistencia(){
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Urna", "postgres","123456");
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o driver especificado.","Erro!", 2);
            System.exit(1);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.","Erro!", 2);
            System.exit(1);         
        }
    }
    
    public static Connection conexao(){
        if(conn == null)
            new Persistencia();
        return conn;
    }
}

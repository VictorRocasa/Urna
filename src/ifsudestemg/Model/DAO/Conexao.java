    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.model.DAO;
import java.sql.*;

/**
 *
 * @author victorPC
 */
public class Conexao {
    private static Connection conn = null;
    
    private Conexao() throws ClassNotFoundException, SQLException{
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Urna", "postgres","123456");
        }
        catch(ClassNotFoundException e){
            throw new ClassNotFoundException("Não foi possível encontrar o driver especificado.");
        }
        catch(SQLException ex){
            throw new SQLException("Não foi possível conectar ao banco de dados, tente novamente em breve.");
        }
    }
    
    public static Connection conectar() throws ClassNotFoundException, SQLException{
        if(conn == null)
            new Conexao();
        return conn;
    }
    
    public static void closeConn() throws ClassNotFoundException, SQLException{
        conn.close();
        conn = null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.model.DAO;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author victorPC
 */
public interface InterfaceDAO {
    public void adiciona(Object obj) throws ClassNotFoundException, SQLException;
    public void exclui(int id) throws ClassNotFoundException, SQLException;
    public void altera(Object obj) throws ClassNotFoundException, SQLException;
    public ArrayList<Object> consulta(Object obj, int nValorConsulta) throws ClassNotFoundException, SQLException;
}

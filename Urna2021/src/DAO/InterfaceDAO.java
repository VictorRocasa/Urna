/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.ArrayList;
/**
 *
 * @author victorPC
 */
public interface InterfaceDAO {
    public boolean adiciona(Object obj);
    public boolean exclui(int id);
    public boolean altera(Object obj);
    public ArrayList<Object> consulta(Object obj, int nValorConsulta);
}

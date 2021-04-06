/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.Controller;

import ifsudestemg.Model.Legenda;
import ifsudestemg.Model.Partido;
import ifsudestemg.model.DAO.LegendaDAO;
import ifsudestemg.model.DAO.PartidoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victorPC
 */
public class LegendaController {
    
    public Object[][] retornaDados(int idEleicao) throws ClassNotFoundException, SQLException{
        PartidoDAO partidoDAO = new PartidoDAO();
        ArrayList<Object> retorno = partidoDAO.consulta(null, 0);
        Object[][] dados = new Object[retorno.size()][5];
        LegendaDAO legendaDAO = new LegendaDAO();
        ArrayList<Object> retornoLegenda;
        Legenda legenda = new Legenda();
        for(int i = 0; i < retorno.size(); i++){
            dados[i][0] = ((Partido)retorno.get(i)).getIdPartido();
            dados[i][1] = ((Partido)retorno.get(i)).getNumero();
            dados[i][2] = ((Partido)retorno.get(i)).getNome();
            legenda.setIdPartido((int)dados[i][0]);
            legenda.setIdEleicao(idEleicao);
            retornoLegenda = legendaDAO.consulta(legenda, 5);
            if(retornoLegenda.isEmpty()){
                dados[i][3] = -1;
                dados[i][4] = "Não";
            }
            else{
                dados[i][3] = ((Legenda)retornoLegenda.get(0)).getIdLegenda();
                dados[i][4] = "Sim";
            }
        }
        return dados;
    }
    
    public Object[][] retornaLegendaEleicao(int idEleicao) throws ClassNotFoundException, SQLException{
        LegendaDAO legendaDAO = new LegendaDAO();
        ArrayList<Object[]> retorno = legendaDAO.consultaEleicao(idEleicao);
        Object[][] dados = new Object[retorno.size()][];
        for(int i = 0; i < retorno.size(); i++)
            dados[i] = retorno.get(i);
        return dados;        
    }
    
    public void excluirPorId(int id) throws ClassNotFoundException, SQLException{
        LegendaDAO legendaDAO = new LegendaDAO();
        legendaDAO.exclui(id);
    }
    
    public void adicionar(int idPartido, int idEleicao) throws ClassNotFoundException, SQLException{
        Legenda legenda = new Legenda();
        legenda.setIdPartido(idPartido);
        legenda.setIdEleicao(idEleicao);
        LegendaDAO legendaDAO = new LegendaDAO();
        legendaDAO.adiciona(legenda);
    }
         
}

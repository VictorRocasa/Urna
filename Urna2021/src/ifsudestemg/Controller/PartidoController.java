/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.Controller;

import ifsudestemg.Model.Partido;
import ifsudestemg.model.DAO.PartidoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victorPC
 */
public class PartidoController {
    
    public Object[][] retornaDados() throws ClassNotFoundException, SQLException{
        PartidoDAO partidoDAO = new PartidoDAO();
        ArrayList<Object> retorno = partidoDAO.consulta(null, 0);
        Object[][] dados = new Object[retorno.size()][3];
        for(int i = 0; i < retorno.size(); i++){
            dados[i][0] = ((Partido)retorno.get(i)).getIdPartido();
            dados[i][1] = ((Partido)retorno.get(i)).getNumero();
            dados[i][2] = ((Partido)retorno.get(i)).getNome();
        }
        return dados;
    }

    public void adicionar(int numero, String nome) throws ClassNotFoundException, SQLException {
        Partido partido = new Partido();
        partido.setNumero(numero);
        partido.setNome(nome);
        PartidoDAO partidoDAO = new PartidoDAO();
        if(!partidoDAO.consulta(partido, 2).isEmpty()){
            throw new NumberFormatException();
        }
        if(!partidoDAO.consulta(partido, 3).isEmpty()){
            throw new NegativeArraySizeException();
        }
        partidoDAO.adiciona(partido);
    }

    public void alterarPorId(int idEdicao, int numero, String nome) throws ClassNotFoundException, SQLException {
        Partido partido = new Partido();
        partido.setIdPartido(idEdicao);
        partido.setNumero(numero);
        partido.setNome(nome);
        PartidoDAO partidoDAO = new PartidoDAO();
        ArrayList<Object> partidoExistente = partidoDAO.consulta(partido, 2);
        if(!partidoExistente.isEmpty())
            if(((Partido)partidoExistente.get(0)).getIdPartido()!=idEdicao)
                throw new NumberFormatException();
        partidoExistente = partidoDAO.consulta(partido, 3);
        if(!partidoExistente.isEmpty())
            if(((Partido)partidoExistente.get(0)).getIdPartido()!=idEdicao){
                throw new NegativeArraySizeException();
        }
        partidoDAO.altera(partido);
    }

    public void excluirPorId(int id) throws ClassNotFoundException, SQLException {
        PartidoDAO partidoDAO = new PartidoDAO();
        partidoDAO.exclui(id);
    }
    
}

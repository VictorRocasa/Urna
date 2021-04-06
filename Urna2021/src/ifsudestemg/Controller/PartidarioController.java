/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.Controller;

import ifsudestemg.Model.Validacoes;
import ifsudestemg.Model.Eleitor;
import ifsudestemg.Model.Partidario;
import ifsudestemg.Model.Partido;
import ifsudestemg.model.DAO.EleitorDAO;
import ifsudestemg.model.DAO.PartidarioDAO;
import ifsudestemg.model.DAO.PartidoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victorPC
 */
public class PartidarioController {
    
    public boolean validarCPF(String cpf){
        return Validacoes.validarCPF(cpf);
    }
    
    public Object[][] retornaDados() throws ClassNotFoundException, SQLException{
        PartidarioDAO partidarioDAO = new PartidarioDAO();
        ArrayList<Object[]> retorno = partidarioDAO.consulta();
        Object[][] dados = new Object[retorno.size()][4];
        for(int i = 0; i < retorno.size(); i++)
            dados[i] = retorno.get(i);
        return dados;

    }
    
    public void excluirPorId(int id) throws ClassNotFoundException, SQLException{
        PartidarioDAO partidarioDAO = new PartidarioDAO();
        partidarioDAO.exclui(id);
    }
    
    public void adicionar(String cpf, int numero, String cargo) throws ClassNotFoundException, SQLException{
        Partidario partidario = new Partidario();
        partidario.setCargoNoPartido(cargo);
        EleitorDAO eleitorDAO = new EleitorDAO();
        Eleitor eleitor = new Eleitor();
        eleitor.setCpf(cpf);
        ArrayList<Object> registroExistente = eleitorDAO.consulta(eleitor, 4);
        if(registroExistente.isEmpty())
            throw new NumberFormatException();
        partidario.setIdEleitor(((Eleitor)registroExistente.get(0)).getidEleitorr());
        PartidarioDAO partidarioDAO = new PartidarioDAO();
        if(!partidarioDAO.consulta(partidario, 2).isEmpty())
            throw new NegativeArraySizeException();
        Partido partido = new Partido();
        partido.setNumero(numero);
        PartidoDAO partidoDAO = new PartidoDAO();
        registroExistente = partidoDAO.consulta(partido, 2);
        if(registroExistente.isEmpty())
            throw new ArithmeticException();
        partidario.setIdPartido(((Partido)registroExistente.get(0)).getIdPartido());
        partidarioDAO.adiciona(partidario);
    }
    
    public void alterarPorId(int idPartidario, int numero, String cargo) throws ClassNotFoundException, SQLException{
        Partidario partidario = new Partidario();       
        partidario.setIdPartidario(idPartidario);
        partidario.setCargoNoPartido(cargo);
        Partido partido = new Partido();
        partido.setNumero(numero);
        PartidoDAO partidoDAO = new PartidoDAO();
        ArrayList<Object> registroExistente = partidoDAO.consulta(partido, 2);
        if(registroExistente.isEmpty())
            throw new ArithmeticException();
        partidario.setIdPartido(((Partido)registroExistente.get(0)).getIdPartido());
        PartidarioDAO partidarioDAO = new PartidarioDAO(); 
        partidarioDAO.altera(partidario);
    }
}


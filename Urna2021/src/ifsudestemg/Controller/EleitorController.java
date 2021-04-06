/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.Controller;

import ifsudestemg.Model.DAO.LoginDAO;
import ifsudestemg.Model.Validacoes;
import ifsudestemg.Model.Eleitor;
import ifsudestemg.model.DAO.EleitorDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victorPC
 */
public class EleitorController {
    
    public boolean validarCPF(String cpf){
        return Validacoes.validarCPF(cpf);
    }

    public boolean validarTitulo(String titulo) {
        return Validacoes.validarTitulo(titulo);
    }

    public boolean validarNascimento(String data) {
        return Eleitor.verificaDataNascimento(data);
    }
    
    public void adicionar(String nome, String nascimento, String cpf, String titulo, String senha) throws ClassNotFoundException, SQLException{
        Eleitor eleitor = new Eleitor();
        eleitor.setNome(nome);
        eleitor.setNascimento(nascimento);
        eleitor.setCpf(cpf);
        eleitor.setTituloEleitor(titulo);
        EleitorDAO eleitorDAO = new EleitorDAO();
        if(!eleitorDAO.consulta(eleitor, 4).isEmpty())
            throw new NumberFormatException();
        if(!eleitorDAO.consulta(eleitor, 5).isEmpty())
            throw new NegativeArraySizeException();
        eleitorDAO.adiciona(eleitor);
        int idEleitor = eleitorDAO.consulta(cpf);
        LoginController.adicionar(idEleitor, cpf, senha);
    }
    
    public Object[] retornarEleitor(int idEleitor) throws ClassNotFoundException, SQLException{
        EleitorDAO eleitorDAO = new EleitorDAO();
        Eleitor eleitor = new Eleitor();
        eleitor.setidEleitor(idEleitor);
        eleitor = (Eleitor) eleitorDAO.consulta(eleitor,1).get(0);
        Object[] dado = new Object[6];
        dado[0] = eleitor.getidEleitorr();
        dado[1] = eleitor.getNome();
        dado[2] = eleitor.getNascimento();
        dado[3] = eleitor.getCpf();
        dado[4] = eleitor.getTituloEleitor();
        LoginDAO loginDAO = new LoginDAO();
        dado[5] = loginDAO.retornaSenha(idEleitor);
        return dado; 
        
    }

    public int consultarID(String cpf) throws ClassNotFoundException, SQLException {
        EleitorDAO eleitorDAO = new EleitorDAO();
        return eleitorDAO.consulta(cpf);
    }

    public void alterar(int idEleitor, String nome, String nascimento, String titulo, String senha) throws ClassNotFoundException, SQLException {
        EleitorDAO eleitorDAO = new EleitorDAO();
        Eleitor eleitor = new Eleitor();
        eleitor.setidEleitor(idEleitor);
        eleitor.setNome(nome);
        eleitor.setNascimento(nascimento);
        eleitor.setTituloEleitor(titulo);
        eleitorDAO.altera(eleitor);
        LoginController.alterar(idEleitor, senha);
    }
}

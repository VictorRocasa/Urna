/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.Controller;

import ifsudestemg.Model.DAO.Validacoes;
import ifsudestemg.Model.Eleitor;
import ifsudestemg.model.DAO.EleitorDAO;
import java.sql.SQLException;

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
    
    public void adicionar(String nome, String nascimento, String cpf, String titulo) throws ClassNotFoundException, SQLException{
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
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.Controller;

import ifsudestemg.Model.DAO.LoginDAO;
import ifsudestemg.Model.Login;
import java.sql.SQLException;

/**
 *
 * @author victorPC
 */
public class LoginController {
    public static int realizarLogin(String cpf, String senha) throws ClassNotFoundException, SQLException{
        LoginDAO loginDAO = new LoginDAO();
        return loginDAO.logar(cpf,senha);
    }
    
    public static void adicionar(int idEleitor, String cpf, String senha) throws ClassNotFoundException, SQLException{
        Login login = new Login();
        LoginDAO loginDAO = new LoginDAO();
        login.setidEleitor(idEleitor);
        login.setCpf(cpf);
        login.setSenha(senha);
        loginDAO.adiciona(login);
    }
    
    public static void alterar(int idEleitor, String senha) throws ClassNotFoundException, SQLException{
        Login login = new Login();
        LoginDAO loginDAO = new LoginDAO();
        login.setidEleitor(idEleitor);
        login.setSenha(senha);
        loginDAO.alterarSenha(login);
    }

}

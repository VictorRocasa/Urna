/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.Model;

/**
 *
 * @author victorPC
 */
public class Login {
    private int idLogin;
    private int idEleitor;
    private String cpf;
    private String senha;
    private int tipo;

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public int getidEleitor() {
        return idEleitor;
    }

    public void setidEleitor(int idEleitor) {
        this.idEleitor = idEleitor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
      
    
    
}

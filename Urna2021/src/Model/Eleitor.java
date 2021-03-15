/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author victorPC
 */
public class Eleitor {
    private int idEleitor;
    private String nome;
    private String nascimento;
    private String cpf;
    private String tituloEleitor;

    public int getidEleitorr() {
        return idEleitor;
    }

    public void setidEleitor(int id_eleitor) {
        this.idEleitor = id_eleitor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }
    
    
}

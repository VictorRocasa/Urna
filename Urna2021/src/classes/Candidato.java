/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author victorPC
 */
public class Candidato{
    private Eleitor indentidade;
    private Partido afiliacao;
    private String cargo;
    private int numero;

    public Eleitor getIndentidade() {
        return indentidade;
    }

    public void setIndentidade(Eleitor indentidade) {
        this.indentidade = indentidade;
    }

    public Partido getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(Partido afiliacao) {
        this.afiliacao = afiliacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}

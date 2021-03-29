/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.Model;

import java.util.Calendar;

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
    
    public static boolean verificaDataNascimento(String data){
        if(data.length()!=10)
            return false;
        String[] partes = data.split("/");  
        Calendar cal = Calendar.getInstance();
        int anoAtual = cal.get(Calendar.YEAR); 
        int ano = Integer.parseInt(partes[2]);
        if(ano < 1900 || ano > anoAtual-16)
            return false;
        int mes = Integer.parseInt(partes[1]);
        if(mes < 1 || mes > 12)
            return false;
        int dia = Integer.parseInt(partes[0]);
        if(dia < 1 || dia > 31)
            return false;
        if(mes == 4 || mes == 6 || mes == 9 || mes == 11)
            if(dia > 30)
                return false;
        if(mes == 2){
            if(dia > 29)
                return false;
            else if(dia == 29 )
                if(!((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))))
                    return false;
        }
        return true;
    }
    
}

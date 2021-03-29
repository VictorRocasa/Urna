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
public class Eleicao {
    private int idEleicao;
    private String cargo;
    private String regiao;
    private String dataEleicao;
    private String turno;

    public int getIdEleicao() {
        return idEleicao;
    }

    public void setIdEleicao(int idEleicao) {
        this.idEleicao = idEleicao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getDataEleicao() {
        return dataEleicao;
    }

    public void setDataEleicao(String dataEleicao) {
        this.dataEleicao = dataEleicao;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
        
    public static boolean verificaData(String data){
        if(data.length()!=10)
            return false;
        String[] partes = data.split("/");  
        Calendar cal = Calendar.getInstance();
        int anoAtual = cal.get(Calendar.YEAR); 
        int ano = Integer.parseInt(partes[2]);
        if(ano < anoAtual)
            return false;
        int mesAtual = cal.get(Calendar.MONTH)+1; 
        int mes = Integer.parseInt(partes[1]);
        if(mes < 1 || mes > 12)
            return false;
        if(ano == anoAtual && mes < mesAtual)
            return false;
        int dia = Integer.parseInt(partes[0]);
        int diaAtual = cal.get(Calendar.DATE);
        if(dia < 1 || dia > 31)
            return false;
        if(dia <= diaAtual && mes == mesAtual && ano == anoAtual)
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

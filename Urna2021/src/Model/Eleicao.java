/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    
}

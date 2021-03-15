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
public class Fiscal {
    private int idFiscal;
    private int idEleitor;
    private String expiracao_do_cargo;

    public int getId_fiscal() {
        return idFiscal;
    }

    public void setId_fiscal(int id_fiscal) {
        this.idFiscal = id_fiscal;
    }

    public int getId_eleitor() {
        return idEleitor;
    }

    public void setId_eleitor(int id_eleitor) {
        this.idEleitor = id_eleitor;
    }

    public String getExpiracao_do_cargo() {
        return expiracao_do_cargo;
    }

    public void setExpiracao_do_cargo(String expiracao_do_cargo) {
        this.expiracao_do_cargo = expiracao_do_cargo;
    }
}

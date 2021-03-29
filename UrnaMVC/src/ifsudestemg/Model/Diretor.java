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
public class Diretor {
    private int idDiretor;
    private int idPartidario;
    private String expiracaoCargo;
    
    public int getId_diretor() {
        return idDiretor;
    }

    public void setId_diretor(int id_diretor) {
        this.idDiretor = id_diretor;
    }

    public int getId_partidario() {
        return idPartidario;
    }

    public void setId_partidario(int id_partidario) {
        this.idPartidario = id_partidario;
    }

    public String getExpiracaoCargo() {
        return expiracaoCargo;
    }

    public void setExpiracaoCargo(String expiracaoCargo) {
        this.expiracaoCargo = expiracaoCargo;
    }
    
}

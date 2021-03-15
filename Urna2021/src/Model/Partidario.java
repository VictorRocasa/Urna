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
public class Partidario{
    private int idPartidario;
    private int idEleitor;
    private int idPartido;    
    private String cargoNoPartido;

    public int getIdPartidario() {
        return idPartidario;
    }

    public void setIdPartidario(int idPartidario) {
        this.idPartidario = idPartidario;
    }

    public int getIdEleitor() {
        return idEleitor;
    }

    public void setIdEleitor(int idEleitor) {
        this.idEleitor = idEleitor;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getCargoNoPartido() {
        return cargoNoPartido;
    }

    public void setCargoNoPartido(String cargoNoPartido) {
        this.cargoNoPartido = cargoNoPartido;
    }
    
}

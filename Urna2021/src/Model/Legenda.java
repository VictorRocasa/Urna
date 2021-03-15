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
public class Legenda {
    private int idLegenda;
    private int idPartido;
    private int idEleicao;
    private int nVotos;

    public int getId_legenda() {
        return idLegenda;
    }

    public void setId_legenda(int id_legenda) {
        this.idLegenda = id_legenda;
    }

    public int getId_partido() {
        return idPartido;
    }

    public void setId_partido(int id_partido) {
        this.idPartido = id_partido;
    }

    public int getId_eleicao() {
        return idEleicao;
    }

    public void setId_eleicao(int id_eleicao) {
        this.idEleicao = id_eleicao;
    }
    
}

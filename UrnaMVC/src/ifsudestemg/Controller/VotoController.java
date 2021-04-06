/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.Controller;

import ifsudestemg.Model.DAO.VotoDAO;
import ifsudestemg.Model.Voto;
import java.sql.SQLException;

/**
 *
 * @author victorPC
 */
public class VotoController {
    public void gerarVoto(int idEleitor, int idLegenda,int idCandidato) throws ClassNotFoundException, SQLException{
        VotoDAO votoDAO = new VotoDAO();
        Voto voto = new Voto();
        voto.setIdEleitor(idEleitor);
        voto.setIdLegenda(idLegenda);
        if(idCandidato!=0)
            voto.setIdCandidato(idCandidato);
        votoDAO.contabilizarVoto(voto);
    }
}

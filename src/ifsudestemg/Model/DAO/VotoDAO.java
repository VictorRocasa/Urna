/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.Model.DAO;

import ifsudestemg.Model.Voto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author victorPC
 */
public class VotoDAO {
    private String sql;
    private Connection conn;
    
    public void contabilizarVoto(Voto voto) throws ClassNotFoundException, SQLException{
        sql = "INSERT INTO voto (id_eleitor,id_legenda,id_candidato) VALUES ("+voto.getIdEleitor()+","+voto.getIdLegenda();
        if(voto.getIdCandidato()!=0)
            sql+=","+voto.getIdCandidato();
        else
            sql+=",null";
        sql+=");";
        conn = ifsudestemg.model.DAO.Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        ifsudestemg.model.DAO.Conexao.closeConn();
    }
}

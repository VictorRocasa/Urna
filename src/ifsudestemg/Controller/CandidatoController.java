/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.Controller;

import ifsudestemg.Model.Candidato;
import ifsudestemg.Model.Legenda;
import ifsudestemg.Model.Partido;
import ifsudestemg.model.DAO.CandidatoDAO;
import ifsudestemg.model.DAO.LegendaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victorPC
 */
public class CandidatoController {
    
    public ArrayList<Object[]> retornaDadosCandidato(int idLegenda) throws ClassNotFoundException, SQLException{
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        ArrayList<Object[]> retorno = candidatoDAO.consulta(idLegenda);
        Candidato candidato = new Candidato();
        candidato.setIdLegenda(idLegenda);
        ArrayList<Object[]> dados = new ArrayList();
        Object[] dadosAtualizados;
        for(int i = 0; i < retorno.size(); i++){
            dadosAtualizados = new Object[6];
            dadosAtualizados[0] = retorno.get(i)[0];
            dadosAtualizados[1] = retorno.get(i)[1];
            dadosAtualizados[3] = retorno.get(i)[2];
            candidato = candidatoDAO.consulta(idLegenda,(int) dadosAtualizados[0]);
            dadosAtualizados[4] = candidato.getIdCandidato();
            if(candidato.getIdCandidato() == -1){
                dadosAtualizados[5] = "Não";
                dadosAtualizados[2] = "  ";
            }
            else{
                dadosAtualizados[5] = "Sim";
                dadosAtualizados[2] = candidato.getNumero();
            }
            dados.add(dadosAtualizados);
        }
        return dados;
    }
    
    public Object[][] retornaCandidatosEleicao(int idLegenda) throws ClassNotFoundException, SQLException{
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        ArrayList<Object[]> retorno = candidatoDAO.consultaEleicao(idLegenda);
        Object[][] dados = new Object[retorno.size()][];
        for(int i = 0; i < retorno.size(); i++)
            dados[i] = retorno.get(i);
        return dados;        
    }
    
    public Object[][] retornaDadosLegenda(int idEleicao) throws ClassNotFoundException, SQLException{
        LegendaDAO legendaDAO = new LegendaDAO();
        ArrayList<Object> retorno = legendaDAO.consulta(idEleicao);
        Object[][] dados = new Object[retorno.size()][3];
        Legenda legenda = new Legenda();
        for(int i = 0; i < retorno.size(); i++){
            dados[i][0] = ((Partido)retorno.get(i)).getIdPartido();//idLegenda
            dados[i][1] = ((Partido)retorno.get(i)).getNumero();
            dados[i][2] = ((Partido)retorno.get(i)).getNome();
        }
        return dados;
    }
    
    public void excluirPorId(int id) throws ClassNotFoundException, SQLException{
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        candidatoDAO.exclui(id);
    }
    
    public void adicionar(int idLegenda, int idPartidario, int Numero) throws ClassNotFoundException, SQLException{
        Candidato candidato = new Candidato();
        candidato.setIdLegenda(idLegenda);
        candidato.setIdPartidario(idPartidario);
        candidato.setNumero(Numero);
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        candidatoDAO.adiciona(candidato);
    }
    
    public void alterarPorId(int idLegenda, int idPartido, int idEleicao, String dataLegenda, String turno) throws ClassNotFoundException, SQLException{
//        Legenda legenda = new Legenda();       
//        legenda.setIdLegenda(idLegenda);
//        legenda.setIdPartido(idPartido);
//        legenda.setIdEleicao(idEleicao);
//        LegendaDAO legendaDAO = new LegendaDAO(); 
//        legendaDAO.altera(legenda);
    }

}

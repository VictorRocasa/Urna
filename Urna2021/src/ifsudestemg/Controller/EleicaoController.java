/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.Controller;
import ifsudestemg.Model.Eleicao;
import ifsudestemg.model.DAO.EleicaoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victorPC
 */
public class EleicaoController {

    public boolean validarDataEleicao(String data) {
        return Eleicao.verificaData(data);
    }
    
    public Object[][] retornaDados() throws ClassNotFoundException, SQLException{
        EleicaoDAO eleicaoDAO = new EleicaoDAO();
        ArrayList<Object> retorno = eleicaoDAO.consulta(null, 0);
        Object[][] dados = new Object[retorno.size()][5];
        for(int i = 0; i < retorno.size(); i++){
            dados[i][0] = ((Eleicao)retorno.get(i)).getIdEleicao();
            dados[i][1] = ((Eleicao)retorno.get(i)).getCargo();
            dados[i][2] = ((Eleicao)retorno.get(i)).getRegiao();
            dados[i][3] = ((Eleicao)retorno.get(i)).getDataEleicao();
            dados[i][4] = ((Eleicao)retorno.get(i)).getTurno();
        }
        return dados;
    }
    
    public void excluirPorId(int id) throws ClassNotFoundException, SQLException{
        EleicaoDAO eleicaoDAO = new EleicaoDAO();
        eleicaoDAO.exclui(id);
    }
    
    public void adicionar(String cargo, String regiao, String dataEleicao, String turno) throws ClassNotFoundException, SQLException{
        Eleicao eleicao = new Eleicao();
        eleicao.setCargo(cargo);
        eleicao.setRegiao(regiao);
        eleicao.setDataEleicao(dataEleicao);
        eleicao.setTurno(turno);
        EleicaoDAO eleicaoDAO = new EleicaoDAO();
        eleicaoDAO.adiciona(eleicao);
    }
    
    public void alterarPorId(int idEleicao, String cargo, String regiao, String dataEleicao, String turno) throws ClassNotFoundException, SQLException{
        Eleicao eleicao = new Eleicao();       
        eleicao.setIdEleicao(idEleicao);
        eleicao.setCargo(cargo);
        eleicao.setRegiao(regiao);
        eleicao.setDataEleicao(dataEleicao);
        eleicao.setTurno(turno);
        EleicaoDAO eleicaoDAO = new EleicaoDAO(); 
        eleicaoDAO.altera(eleicao);
    }
    
}

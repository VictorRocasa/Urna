/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.model.DAO;

import ifsudestemg.Model.Eleitor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author victorPC
 */
public class EleitorDAO implements InterfaceDAO{
    private String sql;
    private Connection conn;

    @Override
    public void adiciona(Object obj) throws ClassNotFoundException, SQLException {
        Eleitor eleitor = (Eleitor) obj;
        sql = "INSERT INTO eleitor (nome, nascimento, cpf, titulo) VALUES ('"+eleitor.getNome()+"','"+eleitor.getNascimento()+"','"+eleitor.getCpf()+"','"+eleitor.getTituloEleitor()+"');";
        conn = Conexao.conectar();
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        Conexao.closeConn();  
    }

    @Override
    public void exclui(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altera(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> consulta(Object obj, int nValorConsulta) throws ClassNotFoundException, SQLException {
        Eleitor eleitor = (Eleitor) obj;
        String valorConsulta;
        switch(nValorConsulta){
            case 1: valorConsulta = " WHERE id_eleitor = "+eleitor.getidEleitorr()+";"; break;//consulta por id do eleitor enviado
            case 2: valorConsulta =  " WHERE nome LIKE '"+eleitor.getNome()+"';"; break;//consulta por nome do eleitor enviado
            case 3: valorConsulta =  " WHERE nascimento LIKE '"+eleitor.getNascimento()+"';"; break;//consulta por nascimento do eleitor enviado
            case 4: valorConsulta =  " WHERE cpf LIKE '"+eleitor.getCpf()+"';"; break;//consulta por cof do eleitor enviado
            case 5: valorConsulta =  " WHERE titulo LIKE '"+eleitor.getTituloEleitor()+"';"; break;//consulta por titulo do eleitor enviado
            default: valorConsulta = ";"; break;
        }
        sql = "SELECT id_eleitor,nome,nascimento,cpf,titulo FROM eleitor"+valorConsulta;
        ArrayList<Object> registros = new ArrayList();
        conn = Conexao.conectar();
        Statement stmt = conn.createStatement();
        ResultSet retorno = stmt.executeQuery(sql); 
        Eleitor registro;   
        while(retorno.next()){
           registro = new Eleitor();
           registro.setidEleitor(retorno.getInt(1));              
           registro.setNome(retorno.getString(2));
           String[] partes = retorno.getString(3).split("-");
           registro.setNascimento(partes[2]+"/"+partes[1]+"/"+partes[0]);  
           registro.setCpf(retorno.getString(4));
           registro.setTituloEleitor(retorno.getString(5)); 
           registros.add(registro);
        } 
        Conexao.closeConn();  
        return registros;
    }  
}

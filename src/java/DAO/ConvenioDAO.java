/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Convenio;

/**
 *
 * @author luiz_
 */
public class ConvenioDAO extends DAO{    
 
    private static ConvenioDAO instancia = new ConvenioDAO();
    public static ConvenioDAO getInstancia(){
        return instancia;
    }
    private ConvenioDAO(){}
    
     public List<Convenio> obterConvenio() throws ClassNotFoundException, SQLException{
         Connection conexao = null;
         Statement st = null;
         
         List<Convenio> convenios = new ArrayList<Convenio>();
         Convenio convenio = null;
         
         try {
             conexao = BD.getInstancia().getConexao();
             st = conexao.createStatement();
             ResultSet rs = st.executeQuery("select * from convenio");
             
             while(rs.next()){
                 convenio = instanciarConvenio(rs);
                 convenios.add(convenio);
             }
         } finally{
             fecharConexao(conexao, st);
         }
         return convenios;
        
     }
    
     public Convenio obterConvenios(int codConvenio) throws ClassNotFoundException, SQLException {
              
         Connection conexao = null;
         Statement st = null;
         
         Convenio convenio = null;
         
         try {
             conexao = BD.getInstancia().getConexao();
             st = conexao.createStatement();
             ResultSet rs = st.executeQuery("select * from convenio where id = " + codConvenio);
             rs.first();   
             convenio = instanciarConvenio(rs);
             
         } finally{
             fecharConexao(conexao, st);
         }
         return convenio;
        
     }
     
      public Convenio instanciarConvenio(ResultSet rs) throws SQLException{
       Convenio convenio = new Convenio(
               rs.getInt("id"),
               rs.getString("razao_social"),
               rs.getString("cnpj"),
               rs.getString("dt_inicio"),
               rs.getString("dt_termino"),
               rs.getString("email"),
               rs.getFloat("desconto"));
       return convenio;
      }
}

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
import model.Funcionario;

/**
 *
 * @author luiz_
 */
public class FuncionarioDAO extends DAO{
    
    private static FuncionarioDAO instancia = new FuncionarioDAO();
    public static FuncionarioDAO getInstancia(){
        return instancia;
    }
    private FuncionarioDAO(){}
    
     public List<Funcionario> obterFuncionarios() throws ClassNotFoundException, SQLException{
         Connection conexao = null;
         Statement st = null;
         
         List<Funcionario> funcionarios = new ArrayList<Funcionario>();
         Funcionario funcionario = null;
         
         try {
             conexao = BD.getInstancia().getConexao();
             st = conexao.createStatement();
             ResultSet rs = st.executeQuery("select * from funcionario");
             
             while(rs.next()){
                 funcionario = instanciarFuncionario(rs);
                 funcionarios.add(funcionario);
             }
         } finally{
             fecharConexao(conexao, st);
         }
         return funcionarios;
        
     }
     
      public Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException, SQLException{
         Connection conexao = null;
         Statement st = null;
         
         Funcionario funcionario = null;
         
         try {
             conexao = BD.getInstancia().getConexao();
             st = conexao.createStatement();
             ResultSet rs = st.executeQuery("select * from funcionario where id = " + codFuncionario);
             
             rs.first();
             
             funcionario = instanciarFuncionario(rs);
             
         } finally{
             fecharConexao(conexao, st);
         }
         return funcionario;
        
     }
  
     
      public Funcionario instanciarFuncionario(ResultSet rs) throws SQLException{
       Funcionario funcionario = new Funcionario(
               rs.getInt("id"),
               rs.getString("nome"),
               rs.getString("cpf"),
               rs.getString("email"),
               rs.getString("nivel_acesso"),
               rs.getString("senha"),                   
               rs.getString("telefone"),
               rs.getString("logradouro"),
               rs.getInt("numero"),
               rs.getString("complemento"),
               rs.getString("bairro"),
               rs.getString("estado"),
               rs.getString("cidade"),
               rs.getString("cep"));
       return funcionario;
      }
}

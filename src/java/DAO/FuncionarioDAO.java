/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Distribuidor;
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
    
    
    
    
    public void gravarFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException{
         Connection conexao = null;
         PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("INSERT INTO funcionario (id, nome, cpf, email, nivel_acesso, senha, telefone,"
                    + " logradouro, numero, complemento, bairro, estado, cidade, cep) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getNivelAcesso());
            stmt.setString(6, funcionario.getSenha());
            stmt.setString(7, funcionario.getTelefone());
            stmt.setString(8, funcionario.getLogradouro());
            stmt.setInt(9, funcionario.getNumero());
            stmt.setString(10, funcionario.getComplemento());
            stmt.setString(11, funcionario.getBairro());
            stmt.setString(12, funcionario.getEstado());
            stmt.setString(13, funcionario.getCidade());
            stmt.setString(14, funcionario.getCep());


            stmt.executeUpdate();

        } finally{
            fecharConexao(conexao, stmt);
        } 
    }
    
        
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
      
      
      public void alterar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("UPDATE funcionario SET nome=?, cpf=?, email=?, nivel_acesso=?, senha=?, telefone=?, logradouro=?, numero=?, complemento=?, bairro=?, estado=?, cidade=?, cep=? WHERE id = ?");
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getNivelAcesso());
            stmt.setString(5, funcionario.getSenha());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setString(7, funcionario.getLogradouro());
            stmt.setInt(8, funcionario.getNumero());
            stmt.setString(9, funcionario.getComplemento());
            stmt.setString(10, funcionario.getBairro());
            stmt.setString(11, funcionario.getEstado());
            stmt.setString(12, funcionario.getCidade());
            stmt.setString(13, funcionario.getCep());
          
            stmt.setInt(14, funcionario.getIdFuncionario());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }
      
      public void excluir(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("DELETE FROM funcionario WHERE id = ?");

            stmt.setInt(1, funcionario.getIdFuncionario());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }
}

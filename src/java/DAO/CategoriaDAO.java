/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Convenio;

/**
 *
 * @author winicius
 */
public class CategoriaDAO extends DAO{
    
    private static CategoriaDAO instancia = new CategoriaDAO();  
    private Statement stmt;
    
    private CategoriaDAO(){}
    
    public static CategoriaDAO getInstancia(){
        return instancia;
    }
    
    //cadastrando nova categoria
     public void gravarCategoria(Categoria categoria) throws SQLException, ClassNotFoundException{
         Connection conexao = null;
         PreparedStatement stmt = null;
         
        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("INSERT INTO categoria (id, descricao) VALUES (?,?)");
            stmt.setInt(1, categoria.getIdCategoria());
            stmt.setString(2, categoria.getDescricao());
            
            stmt.executeUpdate();  
        } finally{
            fecharConexao(conexao, stmt);
        } 
    }  
     
     //listando categorias
     public List<Categoria> obterCategorias() throws ClassNotFoundException, SQLException{
         Connection conexao = null;
         Statement st = null;
         
         List<Categoria> categorias = new ArrayList<Categoria>();
         Categoria categoria = null;
         
         try {
             conexao = BD.getInstancia().getConexao();
             st = conexao.createStatement();
             ResultSet rs = st.executeQuery("select * from categoria");
             
             while(rs.next()){
                 categoria = instanciarCategoria(rs);
                 categorias.add(categoria);
             }
         } finally{
             fecharConexao(conexao, stmt);
         }
         return categorias;
        
     }
     
     //listando categorias
     public Categoria obterCategoria(int codCategoria) throws ClassNotFoundException, SQLException{
         Connection conexao = null;
         Statement st = null;
         
         Categoria categoria = null;
         
         try {
             conexao = BD.getInstancia().getConexao();
             st = conexao.createStatement();
             ResultSet rs = st.executeQuery("select * from categoria where id =" + codCategoria);
             
             rs.first();
             categoria = instanciarCategoria(rs);
         } finally{
             fecharConexao(conexao, stmt);
         }
         return categoria;
        
     }
     
     
      public Categoria instanciarCategoria(ResultSet rs) throws SQLException{
       Categoria cat = new Categoria(rs.getInt("id"),
               rs.getString("descricao"));
       return cat;
   } 
      
      public void alterar(Categoria categoria)throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("UPDATE categoria SET descricao = ? WHERE id = ?");
            stmt.setString(1, categoria.getDescricao());                       
            stmt.setInt(2, categoria.getIdCategoria());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }
      
      public void excluir(Categoria categoria) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("DELETE FROM categoria WHERE id = ?");

            stmt.setInt(1, categoria.getIdCategoria());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }
      
      

}       


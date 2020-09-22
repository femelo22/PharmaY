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
     public void cadastrarCategoria(Categoria categoria) throws ClassNotFoundException{
         Connection conn = null;
         Statement st = null;
         
        try {
            conn = BD.getInstancia().getConexao();
            st = conn.createStatement();
            
            String sql = "INSERT INTO categoria (descricao)"
                    + " VALUES (?)";

            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao());
      
            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro" + erro);
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
      
}

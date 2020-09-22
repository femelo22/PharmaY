package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoDAO extends DAO{
    
    private static ProdutoDAO instancia = new ProdutoDAO();
    public static ProdutoDAO getInstancia(){
        return instancia;
    }
    private ProdutoDAO(){}
    
     public List<Produto> obterProdutos() throws ClassNotFoundException, SQLException{
         Connection conexao = null;
         Statement st = null;
         
         List<Produto> produtos = new ArrayList<Produto>();
         Produto produto = null;
         
         try {
             conexao = BD.getInstancia().getConexao();
             st = conexao.createStatement();
             ResultSet rs = st.executeQuery("select * from produto");
             
             while(rs.next()){
                 produto = instanciarProduto(rs);
                 produtos.add(produto);
             }
         } finally{
             fecharConexao(conexao, st);
         }
         return produtos;
        
     }
     
          public Produto obterProduto(int codProduto) throws ClassNotFoundException, SQLException{
         Connection conexao = null;
         Statement st = null;
         
         Produto produto = null;
         
         try {
             conexao = BD.getInstancia().getConexao();
             st = conexao.createStatement();
             ResultSet rs = st.executeQuery("select * from produto where id = " + codProduto);
             
             rs.first();
             produto = instanciarProduto(rs);
             
         } finally{
             fecharConexao(conexao, st);
         }
         return produto;
        
     }
     
     
     public Produto instanciarProduto(ResultSet rs) throws SQLException{
      Produto produto = new Produto(
               rs.getInt("id"),
               rs.getString("descricao"),
               rs.getFloat("preco_venda"),
               rs.getFloat("preco_custo"),
               rs.getString("obs"),
               rs.getInt("estoque_minimo"),
               rs.getInt("estoque_maximo"),                   
               rs.getString("data_validade"),
               rs.getString("lote"),
              rs.getInt("id_distribuidor"),
              rs.getInt("id_categoria"),
               null,
               null);
       return produto;
      }
}

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
import model.Produto;

public class ProdutoDAO extends DAO{
    
    private static ProdutoDAO instancia = new ProdutoDAO();
    public static ProdutoDAO getInstancia(){
        return instancia;
    }
    private ProdutoDAO(){}
    
    
    public void gravarProduto(Produto produto) throws SQLException, ClassNotFoundException{
         Connection conexao = null;
         PreparedStatement stmt = null;      
        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("INSERT INTO produto (id, descricao, preco_venda, preco_custo, obs,"
                    + " estoque_maximo, estoque_minimo, data_validade, lote, id_distribuidor, id_categoria)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?)");  
            stmt.setInt(1, produto.getIdProduto());
            stmt.setString(2, produto.getDescricao());
            stmt.setFloat(3, produto.getPrecoVenda());
            stmt.setFloat(4, produto.getPrecoCusto());
            stmt.setString(5, produto.getObs());
            stmt.setInt(6, produto.getEstoqueMaximo());
            stmt.setInt(7, produto.getEstoqueMinimo());
            stmt.setString(8, produto.getDataValidade());
            stmt.setString(9, produto.getLote());
     
            if(produto.getDistribuidor() == null){
                stmt.setNull(10, Types.INTEGER);
            }else{
                stmt.setInt(10, produto.getDistribuidor().getIdDistribuidor());
            }  
            
            if(produto.getCategoria() == null){
                stmt.setNull(11, Types.INTEGER);
            }else{
                stmt.setInt(11, produto.getCategoria().getIdCategoria());
            }  
            stmt.executeUpdate();
        } finally{
            fecharConexao(conexao, stmt);
        } 
    }  
    
    
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
     
     public void alterar(Produto produto)throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("UPDATE produto SET descricao = ?, preco_venda=?, preco_custo=?, obs=?, estoque_maximo=?, estoque_minimo=?, data_validade=?, lote=?, id_distribuidor=?, id_categoria=? WHERE id = ?");
            stmt.setString(1, produto.getDescricao());
            stmt.setFloat(2, produto.getPrecoVenda());
            stmt.setFloat(3, produto.getPrecoCusto());
            stmt.setString(4, produto.getObs());
            stmt.setInt(5, produto.getEstoqueMaximo());
            stmt.setInt(6, produto.getEstoqueMinimo());
            stmt.setString(7, produto.getDataValidade());
            stmt.setString(8, produto.getLote());
            stmt.setInt(9, produto.getIdDistribuidor());
            stmt.setInt(10, produto.getIdCategoria()); 
            
            stmt.setInt(11, produto.getIdProduto());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }
     
      public void excluir(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("DELETE FROM produto WHERE id = ?");

            stmt.setInt(1, produto.getIdProduto());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }
}

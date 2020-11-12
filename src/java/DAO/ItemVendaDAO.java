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
import model.Categoria;
import model.Cliente;
import model.ItemVenda;

/**
 *
 * @author luiz_
 */
public class ItemVendaDAO extends DAO{
    
    public static ItemVendaDAO instancia = new ItemVendaDAO();
    private Statement stmt;
    
    public static ItemVendaDAO getInstancia(){
        return instancia;
    }
    
    public void gravarItemVenda(ItemVenda itemVenda) throws SQLException, ClassNotFoundException{
         Connection conexao = null;
         PreparedStatement stmt = null;
         
        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("INSERT INTO item_venda (id_item_venda, quantidade, subtotal, id_produto) VALUES (?,?,?,?)");
            stmt.setInt(1, itemVenda.getIdItemVenda());
            stmt.setInt(2, itemVenda.getQuantidade());
            stmt.setFloat(3,itemVenda.getSubtotal());
            
            if(itemVenda.getProduto() == null){
                stmt.setNull(4, Types.INTEGER);
            }else{
                stmt.setInt(4, itemVenda.getProduto().getIdProduto());
            }          
            stmt.executeUpdate();
            
        } finally{
            fecharConexao(conexao, stmt);
        } 
    } 
    
   public List<ItemVenda> obterItensVenda() throws ClassNotFoundException, SQLException{
         Connection conexao = null;
         Statement st = null;
         
         List<ItemVenda> itensVenda = new ArrayList<ItemVenda>();
         ItemVenda itemVenda = null;
         
         try {
             conexao = BD.getInstancia().getConexao();
             st = conexao.createStatement();
             ResultSet rs = st.executeQuery("select * from item_venda");
             
             while(rs.next()){
                 itemVenda = instanciarItemVenda(rs);
                 itensVenda.add(itemVenda);
             }
         } finally{
             fecharConexao(conexao, stmt);
         }
         return itensVenda;    
     }
    
        public ItemVenda obterItensVendas(int codItemvenda) throws ClassNotFoundException, SQLException{
         Connection conexao = null;
         Statement st = null;
         
         ItemVenda itemVenda = null;
         
         try {
             conexao = BD.getInstancia().getConexao();
             st = conexao.createStatement();
             ResultSet rs = st.executeQuery("select * from item_venda where id_item_venda = " + codItemvenda);
             rs.first();
          
             itemVenda = instanciarItemVenda(rs);
         } finally{
             fecharConexao(conexao, stmt);
         }
         return itemVenda;    
     }
 
    public ItemVenda instanciarItemVenda(ResultSet rs) throws SQLException{
        ItemVenda item = new ItemVenda(
                rs.getInt("id_item_venda"),
                rs.getInt("quantidade"),
                rs.getFloat("subtotal"),    
                null,
                rs.getInt("id_produto")
        );     
        return item;
    }
    
    public void excluir(ItemVenda itemVenda) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("DELETE FROM item_venda WHERE id_item_venda = ?");

            stmt.setInt(1, itemVenda.getIdItemVenda());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }
    
    public void alterar(ItemVenda itemVenda)throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("UPDATE item_venda  SET quantidade=?, subtotal=?, id_produto=? WHERE id_item_venda = ?");
            stmt.setFloat(1, itemVenda.getQuantidade());
             stmt.setFloat(2, itemVenda.getSubtotal());
            stmt.setInt(3, itemVenda.getIdProduto());
            
            stmt.setInt(4, itemVenda.getIdItemVenda());


            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }
}

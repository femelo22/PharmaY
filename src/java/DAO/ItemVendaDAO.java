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
}

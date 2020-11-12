package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import model.Venda;

public class VendaDAO extends DAO{
    
    private static VendaDAO instance = new VendaDAO();  
    private Statement stmt;
    
    private VendaDAO(){}
    
    public static VendaDAO getInstance(){
        return instance;
    }
    
    
    
    public void gravarVenda(Venda venda) throws SQLException, ClassNotFoundException{
         Connection conexao = null;
         PreparedStatement stmt = null;      
        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("INSERT INTO venda (id, dt_venda, total, forma_pagamento, convenio_id, produto_id) VALUES(?,?,?,?,?,?)");  
            stmt.setInt(1, venda.getIdVenda());
            stmt.setString(2, venda.getDtVenda());
            stmt.setFloat(3, venda.getTotal());
            stmt.setString(4, venda.getFormaPagamento());
              
            if(venda.getConvenio() == null){
                stmt.setNull(5, Types.INTEGER);
            }else{
                stmt.setInt(5, venda.getConvenio().getIdConvenio());
            }  
            
            if(venda.getProduto() == null){
                stmt.setNull(6, Types.INTEGER);
            }else{
                stmt.setInt(6, venda.getProduto().getIdProduto());
            }  
            stmt.executeUpdate();
        } finally{
            fecharConexao(conexao, stmt);
        } 
    }  
    
    public List<Venda> obterVendas() throws ClassNotFoundException, SQLException{
         Connection conexao = null;
         Statement st = null;
         
         List<Venda> vendas = new ArrayList<Venda>();
         Venda venda = null;
         
         try {
             conexao = BD.getInstancia().getConexao();
             st = conexao.createStatement();
             ResultSet rs = st.executeQuery("select * from venda");
             
             while(rs.next()){
                 venda = instanciarVenda(rs);
                 vendas.add(venda);
             }
         } finally{
             fecharConexao(conexao, stmt);
         }
         return vendas;
    }
    
        public Venda obterVenda(int codVendas) throws ClassNotFoundException, SQLException{
         Connection conexao = null;
         Statement st = null;
         
         Venda venda = null;
         
         try {
             conexao = BD.getInstancia().getConexao();
             st = conexao.createStatement();
             ResultSet rs = st.executeQuery("select * from venda where id = " + codVendas);
             
             rs.first();
             
             venda = instanciarVenda(rs);
             
         } finally{
             fecharConexao(conexao, stmt);
         }
         return venda;
    }
    
         public Venda instanciarVenda(ResultSet rs) throws SQLException{
            Venda venda = new Venda(
               rs.getInt("id"),
               rs.getString("dt_Venda"),
               rs.getFloat("total"),
               rs.getString("forma_Pagamento"),
               null,
               null,
               rs.getInt("convenio_id"),
               rs.getInt("produto_id"));   
       return venda;
   }
         
         public void alterar(Venda venda)throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("UPDATE venda SET dt_venda=?, total=?, forma_pagamento=?, convenio_id=?, produto_id=? WHERE id = ?");
            stmt.setString(1, venda.getDtVenda());
            stmt.setFloat(2, venda.getTotal());
            stmt.setString(3, venda.getFormaPagamento());
            stmt.setInt(4, venda.getIdConvenio());
            stmt.setInt(5, venda.getIdProduto());
            stmt.setInt(6, venda.getIdVenda());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }
         
         public void excluir(Venda venda) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("DELETE FROM venda WHERE id = ?");

            stmt.setInt(1, venda.getIdProduto());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }
}

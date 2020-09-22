package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Venda;

public class VendaDAO extends DAO{
    
    private static VendaDAO instance = new VendaDAO();  
    private Statement stmt;
    
    private VendaDAO(){}
    
    public static VendaDAO getInstance(){
        return instance;
    }
    
    public List<Venda> obterVenda() throws ClassNotFoundException, SQLException{
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
    
        public Venda obterVendas(int codVendas) throws ClassNotFoundException, SQLException{
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
}

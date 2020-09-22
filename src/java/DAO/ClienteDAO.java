/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import model.Categoria;
import model.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Convenio;

/**
 *
 * @author luiz_
 */
public class ClienteDAO extends DAO{
    
    private static ClienteDAO instancia = new ClienteDAO();  
    private Statement stmt;
    
    private ClienteDAO(){}
    
    public static ClienteDAO getInstancia(){
        return instancia;
    }
    
    public List<Cliente> obterCliente() throws ClassNotFoundException, SQLException{
         Connection conexao = null;
         Statement st = null;
         
         List<Cliente> clientes = new ArrayList<Cliente>();
         Cliente cliente = null;
         
         try {
             conexao = BD.getInstancia().getConexao();
             st = conexao.createStatement();
             ResultSet rs = st.executeQuery("select * from clientes;");
             
             while(rs.next()){
                cliente = instanciarCliente(rs);
                clientes.add(cliente);
                 
             }
         } finally{
             fecharConexao(conexao, st);
         }
         return clientes;
     }
    
        public Cliente obterClientes(int codCliente) throws ClassNotFoundException, SQLException{
            
         Connection conexao = null;
         Statement st = null;
         
         Cliente cliente = null;
         
         try {
             conexao = BD.getInstancia().getConexao();
             st = conexao.createStatement();
             ResultSet rs = st.executeQuery("select * from clientes where id = " + codCliente);
             
             rs.first();
             cliente = instanciarCliente(rs);
         } finally{
             fecharConexao(conexao, st);
         }
         return cliente;
     }
                    
     public Cliente instanciarCliente(ResultSet rs) throws SQLException{
        Cliente c = new Cliente(rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("registro"),
                null,
                rs.getInt("id_convenio")
        );
       
        return c;
    }
       
}

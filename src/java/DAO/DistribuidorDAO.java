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
import model.Convenio;
import model.Distribuidor;

/**
 *
 * @author luiz_
 */
public class DistribuidorDAO extends DAO {

    private static DistribuidorDAO instance = new DistribuidorDAO();
    private Statement stmt;

    private DistribuidorDAO() {
    }

    public static DistribuidorDAO getInstancia() {
        return instance;
    }
    
    
   public void gravarDistribuidor(Distribuidor dt) throws SQLException, ClassNotFoundException {

         Connection conexao = null;
         PreparedStatement stmt = null;

         try {
             conexao = BD.getInstancia().getConexao();
             stmt = conexao.prepareStatement("insert into distribuidor (id, razao_social,cnpj,logradouro,complemento,numero,bairro,estado,cidade,cep) values (?,?,?,?,?,?,?,?,?,?)");
                stmt.setInt(1, dt.getIdDistribuidor());
                stmt.setString(2, dt.getRazaoSocial());
                stmt.setString(3, dt.getCnpj());
                stmt.setString(4, dt.getLogradouro());
                stmt.setString(5, dt.getComplemento());
                stmt.setInt(6, dt.getNumero());
                stmt.setString(7, dt.getBairro());
                stmt.setString(8, dt.getEstado());
                stmt.setString(9, dt.getCidade());
                stmt.setString(10, dt.getCep());

             stmt.executeUpdate();
         } finally {
             fecharConexao(conexao, stmt);
         }

     }

    public List<Distribuidor> obterDistribuidores() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement st = null;

        List<Distribuidor> Distribuidor = new ArrayList<Distribuidor>();
        Distribuidor distribuidor = null;

        try {
            conexao = BD.getInstancia().getConexao();
            st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from distribuidor");

            while (rs.next()) {
                distribuidor = instanciarDistribuidor(rs);
                Distribuidor.add(distribuidor);
            }
        } finally {
            fecharConexao(conexao, stmt);
        }
        return Distribuidor;
    }
    
        public Distribuidor obterDistribuidor(int codDistribuidor) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement st = null;

        Distribuidor distribuidor = null;

        try {
            conexao = BD.getInstancia().getConexao();
            st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from distribuidor where id = " + codDistribuidor);

            rs.first();
            
            distribuidor = instanciarDistribuidor(rs);
        } finally {
            fecharConexao(conexao, stmt);
        }
        return distribuidor;
    }

    public Distribuidor instanciarDistribuidor(ResultSet rs) throws SQLException {
        Distribuidor distribuidor = new Distribuidor(
                rs.getInt("id"),
                rs.getString("razao_social"),
                rs.getString("cnpj"),
                rs.getString("logradouro"),
                rs.getString("complemento"),
                rs.getInt("numero"),
                rs.getString("bairro"),
                rs.getString("estado"),
                rs.getString("cidade"),
                rs.getString("cep"));
        return distribuidor;
    }
    
     public void alterar(Distribuidor distribuidor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("UPDATE distribuidor SET razao_social=?, cnpj=?, logradouro=?, complemento=?, numero=?, bairro=?, estado=?, cidade=?, cep=? WHERE id = ?");
            stmt.setString(1, distribuidor.getRazaoSocial());
            stmt.setString(2, distribuidor.getCnpj());
            stmt.setString(3, distribuidor.getLogradouro());
            stmt.setString(4, distribuidor.getComplemento());
            stmt.setInt(5, distribuidor.getNumero());
            stmt.setString(6, distribuidor.getBairro());
            stmt.setString(7, distribuidor.getEstado());
            stmt.setString(8, distribuidor.getCidade());
            stmt.setString(9, distribuidor.getCep());
          
            stmt.setInt(10, distribuidor.getIdDistribuidor());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }
     
     public void excluir(Distribuidor distribuidor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("DELETE FROM distribuidor WHERE id = ?");

            stmt.setInt(1, distribuidor.getIdDistribuidor());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }

}

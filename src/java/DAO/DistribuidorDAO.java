/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

    public static DistribuidorDAO getInstance() {
        return instance;
    }

    public List<Distribuidor> obterDistribuidor() throws ClassNotFoundException, SQLException {
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
    
        public Distribuidor obterDistribuidores(int codDistribuidor) throws ClassNotFoundException, SQLException {
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

}

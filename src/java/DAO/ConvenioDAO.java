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
import model.Convenio;

/**
 *
 * @author luiz_
 */
public class ConvenioDAO extends DAO {

    private static ConvenioDAO instancia = new ConvenioDAO();

    public static ConvenioDAO getInstancia() {
        return instancia;
    }

    private ConvenioDAO() {
    }

    public void gravarConvenio(Convenio convenio) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("insert into convenio (id, razao_social,cnpj,dt_inicio,dt_termino,email,desconto) values (?,?,?,?,?,?,?)");
            stmt.setInt(1, convenio.getIdConvenio());
            stmt.setString(2, convenio.getRazaoSocial());
            stmt.setString(3, convenio.getCnpj());
            stmt.setString(4, convenio.getDtInicio());
            stmt.setString(5, convenio.getDtTermino());
            stmt.setString(6, convenio.getEmail());
            stmt.setFloat(7, convenio.getDesconto());

            stmt.executeUpdate();
        } finally {
            fecharConexao(conexao, stmt);
        }
    }

    public List<Convenio> obterConvenios() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement st = null;

        List<Convenio> convenios = new ArrayList<Convenio>();
        Convenio convenio = null;

        try {
            conexao = BD.getInstancia().getConexao();
            st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from convenio");

            while (rs.next()) {
                convenio = instanciarConvenio(rs);
                convenios.add(convenio);
            }
        } finally {
            fecharConexao(conexao, st);
        }
        return convenios;

    }

    public Convenio obterConvenio(int codConvenio) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement st = null;

        Convenio convenio = null;

        try {
            conexao = BD.getInstancia().getConexao();
            st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from convenio where id = " + codConvenio);
            rs.first();
            convenio = instanciarConvenio(rs);

        } finally {
            fecharConexao(conexao, st);
        }
        return convenio;

    }

    public Convenio instanciarConvenio(ResultSet rs) throws SQLException {
        Convenio convenio = new Convenio(
                rs.getInt("id"),
                rs.getString("razao_social"),
                rs.getString("cnpj"),
                rs.getString("dt_inicio"),
                rs.getString("dt_termino"),
                rs.getString("email"),
                rs.getFloat("desconto"));
        return convenio;
    }

    public void alterar(Convenio convenio) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("UPDATE convenio SET razao_social=?, cnpj=?, dt_inicio=?, dt_termino=?, email=?, desconto=? WHERE id = ?");
            stmt.setString(1, convenio.getRazaoSocial());
            stmt.setString(2, convenio.getCnpj());
            stmt.setString(3, convenio.getDtInicio());
            stmt.setString(4, convenio.getDtTermino());
            stmt.setString(5, convenio.getEmail());
            stmt.setFloat(6, convenio.getDesconto());

            stmt.setInt(7, convenio.getIdConvenio());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }

    public void excluir(Convenio convenio) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("DELETE FROM convenio WHERE id = ?");

            stmt.setInt(1, convenio.getIdConvenio());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }

}






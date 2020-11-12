/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Categoria;
import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Convenio;

/**
 *
 * @author luiz_
 */
public class ClienteDAO extends DAO {

    private static ClienteDAO instancia = new ClienteDAO();
    private Statement stmt;

    private ClienteDAO() {
    }

    public static ClienteDAO getInstancia() {
        return instancia;
    }

    public void gravarCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("INSERT INTO clientes (id, nome, cpf, registro, id_convenio) VALUES (?,?,?,?,?)");
            stmt.setInt(1, cliente.getIdCliente());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getRegistro());
            if (cliente.getConvenio() == null) {
                stmt.setNull(5, Types.INTEGER);
            } else {
                stmt.setInt(5, cliente.getConvenio().getIdConvenio());
            }
            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }

    public List<Cliente> obterCliente() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement st = null;

        List<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente = null;

        try {
            conexao = BD.getInstancia().getConexao();
            st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from clientes;");

            while (rs.next()) {
                cliente = instanciarCliente(rs);
                clientes.add(cliente);

            }
        } finally {
            fecharConexao(conexao, st);
        }
        return clientes;
    }

    public Cliente obterClientes(int codCliente) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement st = null;

        Cliente cliente = null;

        try {
            conexao = BD.getInstancia().getConexao();
            st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from clientes where id = " + codCliente);

            rs.first();
            cliente = instanciarCliente(rs);
        } finally {
            fecharConexao(conexao, st);
        }
        return cliente;
    }

    public Cliente instanciarCliente(ResultSet rs) throws SQLException {
        Cliente c = new Cliente(rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("registro"),
                null,
                rs.getInt("id_convenio")
        );
        return c;
    }

    public void alterar(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("UPDATE clientes SET nome=?, cpf=?, registro=?, id_convenio=? WHERE id = ?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRegistro());
            stmt.setInt(4, cliente.getIdConvenio());
            stmt.setInt(5, cliente.getIdCliente());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }

    public void excluir(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = BD.getInstancia().getConexao();
            stmt = conexao.prepareStatement("DELETE FROM clientes WHERE id = ?");

            stmt.setInt(1, cliente.getIdCliente());

            stmt.executeUpdate();

        } finally {
            fecharConexao(conexao, stmt);
        }
    }

}

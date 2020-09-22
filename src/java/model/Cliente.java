/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import DAO.ClienteDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author winicius
 */
public class Cliente {
    
    private int idCliente;
    private String nome;
    private String cpf;
    private String registro;    
    private Convenio convenio;
    private int idConvenio;

    public Cliente(int idCliente, String nome, String cpf, String registro, Convenio convenio, int idConvenio) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.registro = registro;
        this.convenio = convenio;
        this.idConvenio = idConvenio;
    }
   
    public int getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(int idConvenio) {
        this.idConvenio = idConvenio;
    }
  
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Convenio getConvenio() throws ClassNotFoundException, SQLException {
        
        if ((this.idConvenio != 0) && (this.convenio == null)) {
            this.convenio = Convenio.obterConvenio(this.idConvenio);
        }
        return this.convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }      
    
    public static Cliente obterCliente(int codCliente) throws ClassNotFoundException, SQLException {
        return ClienteDAO.getInstancia().obterClientes(codCliente);
    }
    
    public static List<Cliente> obterClientes() throws ClassNotFoundException, SQLException {
        return ClienteDAO.getInstancia().obterCliente();
    }
}

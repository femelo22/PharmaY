/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ConvenioDAO;
import DAO.DistribuidorDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author winicius
 */
public class Distribuidor {

    private int idDistribuidor;
    private String razaoSocial;
    private String cnpj;
    private String logradouro;
    private String complemento;
    private int numero;
    private String bairro;
    private String estado;
    private String cidade;
    private String cep;

    public Distribuidor(int idDistribuidor, String razaoSocial, String cnpj, String logradouro, String complemento, int numero, String bairro, String estado, String cidade, String cep) {
        this.idDistribuidor = idDistribuidor;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public static Distribuidor obterDistribuidor(int codDistribuidor) throws ClassNotFoundException, SQLException {
        return DistribuidorDAO.getInstancia().obterDistribuidor(codDistribuidor);
    }

    public static List<Distribuidor> obterDistribuidores() throws ClassNotFoundException, SQLException {
        return DistribuidorDAO.getInstancia().obterDistribuidores();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        DistribuidorDAO.getInstancia().gravarDistribuidor(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
      DistribuidorDAO.getInstancia().alterar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException {
      DistribuidorDAO.getInstancia().excluir(this);
    }
    

}

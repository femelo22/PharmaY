/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import DAO.DistribuidorDAO;
import DAO.FuncionarioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author winicius
 */
public class Funcionario {

    private int idFuncionario;
    private String nome;
    private String cpf;
    private String email;
    private String nivelAcesso;
    private String senha;
    private String telefone;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String estado;
    private String cidade;
    private String cep;

    public Funcionario(int idFuncionario, String nome, String cpf, String email, String nivelAcesso, String senha, String telefone, String logradouro, int numero,String complemento, String bairro, String estado, String cidade, String cep) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.nivelAcesso = nivelAcesso;
        this.senha = senha;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
    } 
    
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
    
    public static Funcionario obterFuncionarios(int codFuncionario) throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.getInstancia().obterFuncionario(codFuncionario);
    }
    
    public static List<Funcionario> obterFuncionario() throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.getInstancia().obterFuncionarios();
    }
    
}

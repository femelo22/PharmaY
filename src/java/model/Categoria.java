/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.CategoriaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author winicius
 */
public class Categoria {

    private int idCategoria;
    private String descricao;

    public Categoria(int idCategoria, String descricao) {
        this.idCategoria = idCategoria;
        this.descricao = descricao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
        public static Categoria obterCategoria(int codCategoria) throws ClassNotFoundException, SQLException {
           return CategoriaDAO.getInstancia().obterCategoria(codCategoria);
    }
    
    public static List<Categoria> obterCategorias() throws ClassNotFoundException, SQLException {
           return CategoriaDAO.getInstancia().obterCategorias();
    }

}

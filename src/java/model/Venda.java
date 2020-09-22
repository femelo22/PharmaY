/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import DAO.VendaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author winicius
 */
public class Venda {
    
    private int idVenda;
    private String dtVenda;
    private float total;
    private String formaPagamento;
    private int idConvenio;
    private int idProduto;
    
    private Convenio convenio;
    private Produto produto;

    public Venda(int idVenda, String dtVenda, float total, String formaPagamento, Convenio convenio, Produto produto, int idConvenio, int idProduto) {
        this.idVenda = idVenda;
        this.dtVenda = dtVenda;
        this.total = total;
        this.formaPagamento = formaPagamento;
        this.convenio = convenio;
        this.produto = produto;
        this.idConvenio = idConvenio;
        this.idProduto = idProduto;
    }

    public int getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(int idConvenio) {
        this.idConvenio = idConvenio;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(String dtVenda) {
        this.dtVenda = dtVenda;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
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

    public Produto getProduto() throws ClassNotFoundException, SQLException {
        
        if ((this.idProduto !=0 ) && (this.produto == null)) {
            this.produto = Produto.obterProdutos(this.idProduto);
        }
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
        public static Venda obterVendas(int codVenda) throws ClassNotFoundException, SQLException {
       return VendaDAO.getInstance().obterVendas(codVenda);

    }
    
    public static List<Venda> obterVenda() throws ClassNotFoundException, SQLException {
       return VendaDAO.getInstance().obterVenda();

    }
    
    
}

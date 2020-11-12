package model;

import DAO.ClienteDAO;
import DAO.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

public class Produto {

    private int idProduto;
    private String descricao;
    private float precoVenda;
    private float precoCusto;
    private String obs;
    private int estoqueMaximo;
    private int estoqueMinimo;
    private String dataValidade;
    private String lote;
    private int idDistribuidor;
    private int idCategoria;

    private Distribuidor distribuidor;
    private Categoria categoria;

    public Produto(int idProduto, String descricao, float precoVenda, float precoCusto, String obs, int estoqueMaximo, int estoqueMinimo, String dataValidade, String lote, int idDistribuidor, int idCategoria, Distribuidor distribuidor, Categoria categoria) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.precoCusto = precoCusto;
        this.obs = obs;
        this.estoqueMaximo = estoqueMaximo;
        this.estoqueMinimo = estoqueMinimo;
        this.dataValidade = dataValidade;
        this.lote = lote;
        this.distribuidor = distribuidor;
        this.categoria = categoria;
        this.idDistribuidor = idDistribuidor;
        this.idCategoria = idCategoria;
    }

    public int getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(int estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Distribuidor getDistribuidor() throws ClassNotFoundException, SQLException {

        if ((this.idDistribuidor != 0) && (this.distribuidor == null)) {
            this.distribuidor = Distribuidor.obterDistribuidor(this.idDistribuidor);
        }
        return this.distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }

    public Categoria getCategoria() throws ClassNotFoundException, SQLException {

        if ((this.idCategoria != 0) && (this.categoria == null)) {
            this.categoria = Categoria.obterCategoria(this.idCategoria);
        }
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public static Produto obterProduto(int codProduto) throws ClassNotFoundException, SQLException {
        return ProdutoDAO.getInstancia().obterProduto(codProduto);
    }

    public static List<Produto> obterProdutos() throws ClassNotFoundException, SQLException {
        return ProdutoDAO.getInstancia().obterProdutos();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        ProdutoDAO.getInstancia().gravarProduto(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ProdutoDAO.getInstancia().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ProdutoDAO.getInstancia().excluir(this);
    }

}

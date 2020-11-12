package model;

import DAO.ClienteDAO;
import DAO.ItemVendaDAO;
import java.sql.SQLException;
import java.util.List;

public class ItemVenda {

    private int idItemVenda;
    private int quantidade;
    private float subtotal;
    private int idProduto;

    private Produto produto;

    public ItemVenda(int idItemVenda, int quantidade, float subtotal, Produto produto, int idProduto) {
        this.idItemVenda = idItemVenda;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        this.produto = produto;
        this.idProduto = idProduto;
    }

    public ItemVenda(int idItemVenda, int quantidade, float subtotal, int idProduto) {
        this.idItemVenda = idItemVenda;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        this.idProduto = idProduto;
    }
    
    

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public Produto getProduto() throws ClassNotFoundException, SQLException {

        if ((this.idProduto != 0) && (this.produto == null)) {
            this.produto = Produto.obterProduto(this.idProduto);
        }

        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public static ItemVenda obterItemVenda(int codItemvenda) throws ClassNotFoundException, SQLException {
        return ItemVendaDAO.getInstancia().obterItensVendas(codItemvenda);
    }

    public static List<ItemVenda> obterItemVendas() throws ClassNotFoundException, SQLException {
        return ItemVendaDAO.getInstancia().obterItensVenda();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException{
        ItemVendaDAO.getInstancia().gravarItemVenda(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException{
        ItemVendaDAO.getInstancia().excluir(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException{
        ItemVendaDAO.getInstancia().alterar(this);
    }

}

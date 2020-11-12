/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.Distribuidor;
import model.Produto;

/**
 *
 * @author luiz_
 */
public class ManterProdutoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }
     
     private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
           String operacao = request.getParameter("operacao");
           request.setAttribute("operacao", operacao);
           request.setAttribute("distribuidores", Distribuidor.obterDistribuidores());
           request.setAttribute("categorias", Categoria.obterCategorias());
           if(!operacao.equals("Incluir")) {
               int idProduto = Integer.parseInt(request.getParameter("idProduto"));
               Produto produto = Produto.obterProduto(idProduto);
               request.setAttribute("produto", produto);//para puxar no items do JSP (parametro do select)
           }
           RequestDispatcher view = request.getRequestDispatcher("/views/inserirProduto.jsp");
           view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
        
    }

      public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
         String operacao = request.getParameter("operacao");
         
         int idProduto = Integer.parseInt(request.getParameter("txtCodigo"));
         String descricao = request.getParameter("txtDescricao");
         float precoVenda = Float.parseFloat(request.getParameter("txtPrecoVenda"));
         float precoCusto = Float.parseFloat(request.getParameter("txtPrecoCusto"));
         String obs = request.getParameter("txtObs");
         int estoqueMaximo = Integer.parseInt(request.getParameter("txtEstMax"));
         int estoqueMinimo = Integer.parseInt(request.getParameter("txtEstMin"));
         String dtValidade = request.getParameter("txtDtValidade");
         String lote = request.getParameter("txtLote");
         int idDistribuidor = Integer.parseInt(request.getParameter("slDistribuidor"));
         int idCategoria = Integer.parseInt(request.getParameter("slCategoria"));
          
         try{
             Categoria categoria = null;
            if (idCategoria != 0) {
               categoria = Categoria.obterCategoria(idCategoria);
            }
            
            Distribuidor distribuidor = null;
            if (idDistribuidor != 0) {
                distribuidor = Distribuidor.obterDistribuidor(idDistribuidor);
            }
            
             Produto produto = new Produto(idProduto, descricao, precoVenda, precoCusto, obs, estoqueMaximo, estoqueMinimo, dtValidade, lote, idDistribuidor, idCategoria, null, null);
             if(operacao.equals("Incluir")){
                 produto.gravar();
             }else{
                 if(operacao.equals("Editar")){
                     produto.alterar();
                 }else{
                     if(operacao.equals("Excluir")){
                         produto.excluir();
                     }
                 }
             }
             RequestDispatcher view = request.getRequestDispatcher("PesquisaProdutoController");
             view.forward(request, response);
         }catch(IOException e){
             throw new ServletException(e);
         }catch(SQLException e){
             throw new ServletException(e);
         }catch(ClassNotFoundException e){
             throw new ServletException(e);
         }catch(ServletException e){
             throw e;
         }
     }          

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

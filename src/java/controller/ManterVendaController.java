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
import model.Convenio;
import model.Distribuidor;
import model.Produto;
import model.Venda;

/**
 *
 * @author luiz_
 */
public class ManterVendaController extends HttpServlet {

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
            request.setAttribute("convenios", Convenio.obterConvenios());
            request.setAttribute("produtos", Produto.obterProdutos());
            if (!operacao.equals("Incluir")) {
                int idVenda = Integer.parseInt(request.getParameter("idVenda"));
                Venda venda = Venda.obterVenda(idVenda);
                request.setAttribute("venda", venda);
            }
            RequestDispatcher view = request.getRequestDispatcher("/views/inserirVenda.jsp");
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
         
         int idVenda = Integer.parseInt(request.getParameter("txtCodigo"));
         String dtVenda = request.getParameter("txtDtVenda");
         float total = Float.parseFloat(request.getParameter("txtTotal"));
         String formaPagamento = request.getParameter("selectFormaPag");
       
         int idConvenio = Integer.parseInt(request.getParameter("slConvenio"));
         int idProduto = Integer.parseInt(request.getParameter("slProduto"));
          
         try{
             Convenio convenio = null;
            if (idConvenio != 0) {
               convenio = Convenio.obterConvenio(idConvenio);
            }
            
            Produto produto = null;
            if (idProduto != 0) {
                produto = Produto.obterProduto(idProduto);
            }
            
            Venda venda = new Venda(idVenda, dtVenda, total, formaPagamento, convenio, produto, idConvenio, idProduto);
             if(operacao.equals("Incluir")){
                 venda.gravar();
             }else{
                 if(operacao.equals("Editar")){
                     venda.alterar();
                 }else{
                     if(operacao.equals("Excluir")){
                         venda.excluir();
                     }
                 }
             }
             RequestDispatcher view = request.getRequestDispatcher("PesquisaVendaController");
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

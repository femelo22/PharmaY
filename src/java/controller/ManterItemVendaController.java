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
import model.Cliente;
import model.Convenio;
import model.ItemVenda;
import model.Produto;

/**
 *
 * @author luiz_
 */
public class ManterItemVendaController extends HttpServlet {

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

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("produtos", Produto.obterProdutos()); //LINHA USADA QUANDO TEMOS UMA COMBO PUXANDO DE OUTRA TABELA NA TELA
            if (!operacao.equals("Incluir")) {
                int idItemVenda = Integer.parseInt(request.getParameter("idItemVenda"));
                ItemVenda itemVenda = ItemVenda.obterItemVenda(idItemVenda);
                request.setAttribute("itemVenda", itemVenda);
            }
            RequestDispatcher view = request.getRequestDispatcher("/views/inserirItemVenda.jsp");
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

        int idItemVenda = Integer.parseInt(request.getParameter("txtCodigo"));
        int quantidade = Integer.parseInt(request.getParameter("txtQtd"));
        float subtotal = Float.parseFloat(request.getParameter("txtSubtotal"));
        int idProduto = Integer.parseInt(request.getParameter("selectProduto"));

        try {
            Produto produto = null;
            if (idProduto != 0) {
                produto = Produto.obterProduto(idProduto);
            }
            ItemVenda itemVenda = new ItemVenda(idItemVenda, quantidade, subtotal, idProduto);
            if (operacao.equals("Incluir")) {
                itemVenda.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    itemVenda.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        itemVenda.excluir();
                    }
                }
            }

            RequestDispatcher view = request.getRequestDispatcher("PesquisaItemVendaController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
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

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
import model.Distribuidor;
import model.ItemVenda;
import model.Produto;

/**
 *
 * @author luiz_
 */
public class ManterDistribuidorController extends HttpServlet {

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
            if (!operacao.equals("Incluir")) {
                int idDistribuidor = Integer.parseInt(request.getParameter("idDistribuidor"));
                Distribuidor distribuidor = Distribuidor.obterDistribuidor(idDistribuidor);
                request.setAttribute("distribuidor", distribuidor);
            }
            RequestDispatcher view = request.getRequestDispatcher("/views/inserirDistribuidor.jsp");
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
        int idDistribuidor = Integer.parseInt(request.getParameter("txtIdDistribuidor"));
        String razaoSocial = request.getParameter("txtRazao");
        String cnpj = request.getParameter("txtCnpj");
        String logradouro = request.getParameter("txtLogradouro");
        String complemento = request.getParameter("txtComplemento");
        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        String bairro = request.getParameter("txtBairro");
        String estado = request.getParameter("txtEstado");
        String cidade = request.getParameter("txtCidade");
        String cep = request.getParameter("txtCep");
        try {
            Distribuidor distribuidor = new Distribuidor(idDistribuidor, razaoSocial, cnpj, logradouro, complemento, numero, bairro, estado, cidade, cep);
            if (operacao.equals("Incluir")) {
                distribuidor.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    distribuidor.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        distribuidor.excluir();
                    }
                }
            }

            RequestDispatcher view = request.getRequestDispatcher("PesquisaDistribuidorController");
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

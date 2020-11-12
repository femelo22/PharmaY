/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;

/**
 *
 * @author luiz_
 */
public class ManterFuncionarioController extends HttpServlet {

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
           if(!operacao.equals("Incluir")) {
               int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
               Funcionario funcionario = Funcionario.obterFuncionarios(idFuncionario);
               request.setAttribute("funcionario", funcionario);
           }
           RequestDispatcher view = request.getRequestDispatcher("/views/inserirFuncionario.jsp");
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
        int idFuncionario = Integer.parseInt(request.getParameter("txtCodFuncionario"));
        String nome = request.getParameter("txtNome");
        String cpf = request.getParameter("txtCpf");
        String email = request.getParameter("txtEmail");
        String nivelAcesso = request.getParameter("selectNivelAcesso");
        String senha = request.getParameter("txtSenha");
        String telefone = request.getParameter("txtTelefone");
        String logradouro = request.getParameter("txtLogradouro");
        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String estado = request.getParameter("selectEstados");
        String cidade = request.getParameter("txtCidade");
        String cep = request.getParameter("txtCep");

        try {
            Funcionario funcionario = new Funcionario(idFuncionario, nome, cpf, email, nivelAcesso, senha, telefone, logradouro, numero, complemento,bairro,estado,cidade,cep);
            if (operacao.equals("Incluir")) {
                funcionario.gravar();
            }else{
                if(operacao.equals("Editar")){
                    funcionario.alterar();
                }else{
                    if(operacao.equals("Excluir")){
                        funcionario.excluir();
                    }
                }
            }
             RequestDispatcher view = request.getRequestDispatcher("PesquisaFuncionarioController");
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

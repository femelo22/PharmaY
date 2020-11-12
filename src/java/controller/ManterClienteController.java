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
import model.Categoria;
import model.Cliente;
import model.Convenio;


/**
 *
 * @author luiz_
 */
public class ManterClienteController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }
    
    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        
        try {
           String operacao = request.getParameter("operacao");
           request.setAttribute("operacao", operacao);
           request.setAttribute("convenios", Convenio.obterConvenios());
           if(!operacao.equals("Incluir")) {
               int idCliente = Integer.parseInt(request.getParameter("idCliente"));
               Cliente cliente = Cliente.obterCliente(idCliente);
               request.setAttribute("cliente", cliente);
           }
           RequestDispatcher view = request.getRequestDispatcher("/views/inserirCliente.jsp");
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
         
         int idCliente = Integer.parseInt(request.getParameter("txtCodigo"));
         String nome = request.getParameter("txtNomeCliente");
         String cpf = request.getParameter("txtCpfCliente");
         String registro = request.getParameter("txtRegistroCliente");
         int idConvenio = Integer.parseInt(request.getParameter("selectConvenios"));
         
         try{
             Convenio convenio = null;
             if(idConvenio != 0){
                 convenio = Convenio.obterConvenio(idConvenio);
             }         
             Cliente cliente = new Cliente(idCliente, nome, cpf, registro, convenio, idConvenio);
             if(operacao.equals("Incluir")){
                 cliente.gravar();
             }else{
                 if(operacao.equals("Editar")){
                     cliente.alterar();
                 }else{
                     if(operacao.equals("Excluir")){
                         cliente.excluir();
                     }
                 }
             }
             RequestDispatcher view = request.getRequestDispatcher("PesquisaClienteController");
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

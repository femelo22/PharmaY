<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="display-4" style="text-align: center;">Ação Clientes - ${operacao}</h1>
        <div class="form-group">
            <form action="ManterClienteController?acao=confirmarOperacao&operacao=${operacao}" method="POST" name="frmManterCliente">
                <div class="col-md-4 mb-3">
                    <label>Código</label><br>
                    <input type="text" name="txtCodigo" required class="form-control" value="${cliente.idCliente}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Nome do cliente</label><br>
                    <input type="text" name="txtNomeCliente" required class="form-control" value="${cliente.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>CPF</label><br>
                    <input type="text" name="txtCpfCliente" required class="form-control" value="${cliente.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Registro</label><br>
                    <input type="text" name="txtRegistroCliente" required class="form-control" value="${cliente.registro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Selecione um convênio</label><br>          
                    <select name="selectConvenios" required class="form-control" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                        <option value="0" <c:if test="${cliente.convenio.idConvenio == null}"> selected</c:if>> </option>
                        <c:forEach items="${convenios}" var="convenio">  
                            <option value="${convenio.idConvenio}" <c:if test="${cliente.convenio.idConvenio == convenio.idConvenio}"> selected</c:if>>${convenio.razaoSocial}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div style="margin-left: 15px">
                    <input type="submit" class="btn btn-outline-success"/>
                    <a href="PesquisaClienteController" class="btn btn-outline-danger">Cancelar</a>
                </div>
               
            </form>
        </div>
    </body>
</html>

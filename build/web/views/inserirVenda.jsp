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
        <h1 class="display-4" style="text-align: center;">Ponto de venda</h1>   
        <div class="form-group">
            <form action="ManterVendaController?acao=confirmarOperacao&operacao=${operacao}" method="POST" name="frmManterVenda">
                
                <div class="col-md-4 mb-3">
                    <label>Código</label><br>
                    <input type="text" name="txtCodigo" required class="form-control" value="${venda.idVenda}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Data da venda</label><br>
                    <input type="text" name="txtDtVenda" required class="form-control" value="${venda.dtVenda}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Total</label><br>
                    <input type="text" name="txtTotal" required class="form-control" value="${venda.total}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                <label>Forma de pagamento</label><br>
                 <select name="selectFormaPag" required class="form-control">
                    <option value="Debito" <c:if test="${funcionario.formaPagamento == 'Debito'}"> selected</c:if>>Débito</option>
                    <option value="Credito" <c:if test="${funcionario.formaPagamento == 'Credito'}"> selected</c:if>>Crédito</option>
                    <option value="Dinheiro" <c:if test="${funcionario.formaPagamento == 'Dinheiro'}"> selected</c:if>>Dinheiro</option>
                </select>                         
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Convênio</label><br>
                    <select name="slConvenio" required class="form-control" <c:if test="${operacao == 'Excluir'}"> desabled</c:if>>
                        <option value="0" <c:if test="${venda.convenio.idConvenio == null}"> selected</c:if>> </option>
                        <c:forEach items="${convenios}" var="convenio"> 
                            <option value="${convenio.idConvenio}" <c:if test="${venda.convenio.idConvenio == convenio.idConvenio}"> selected</c:if>>${convenio.razaoSocial} </option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Produto</label><br>
                    <select name="slProduto" required class="form-control" <c:if test="${operacao == 'Excluir'}"> desabled</c:if>>
                        <option value="0" <c:if test="${venda.produto.idProduto == null}"> selected</c:if>> </option>
                        <c:forEach items="${produtos}" var="produto"> 
                            <option value="${produto.idProduto}" <c:if test="${venda.produto.idProduto == produto.idProduto}"> selected</c:if>>${produto.descricao}</option>
                        </c:forEach>
                    </select>
                </div>
                        
                <div style="margin-left: 15px">         
                    <input type="submit" class="btn btn-outline-success"/>
                    <a href="PesquisaVendaController" class="btn btn-outline-danger">Cancelar</a>
                </div>
            </form>
        </div>
    </body>
</html>

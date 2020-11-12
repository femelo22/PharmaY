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
        <h1 class="display-4" style="text-align: center;">Ação Item Venda - ${operacao}</h1>    
        <div class="form-group">
            <form  action="ManterItemVendaController?acao=confirmarOperacao&operacao=${operacao}" method="POST" name="frmManterItemVenda">
                <div class="col-md-4 mb-3">
                    <label>Código</label><br>
                    <input type="text" name="txtCodigo" required class="form-control" value="${itemVenda.idItemVenda}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                </div> 
                
                <div class="col-md-4 mb-3">
                    <label>Quantidade</label><br>
                    <input type="text" name="txtQtd" required class="form-control" value="${itemVenda.quantidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Subtotal</label><br>
                    <input type="text" name="txtSubtotal" required class="form-control" value="${itemVenda.subtotal}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>      
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Produto</label><br>
                    <select name="selectProduto" required class="form-control" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                    <option value="0" <c:if test="${itemVenda.produto.idProduto == null}"> selected</c:if>></option>
                        <c:forEach items="${produtos}" var="produto"> 
                            <option value="${produto.idProduto}"
                                <c:if test="${itemVenda.produto.idProduto == produto.idProduto}"> selected</c:if>>${produto.descricao}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                
                <div style="margin-left: 15px">
                    <input type="submit" class="btn btn-outline-success"/>
                    <a href="PesquisaItemVendaController" class="btn btn-outline-danger">Cancelar</a>
                </div>
            </form>
        </div>
    </body>
</html>

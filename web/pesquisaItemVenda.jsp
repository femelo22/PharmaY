<%-- 
    Document   : pesquisaCliente
    Created on : 14/09/2020, 21:56:43
    Author     : winicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Itens Vendas</title>
    </head>
    <body>
        <h1>Pesquisar itens vendas</h1>
        <table border =1>
            <tr>
                <th>Código</th>
                <th>Quantidade</th>
                <th>SubTotal</th>
                <th>Código do produto</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${itensvendas}" var="itemvenda">
                <tr>
                    <td><c:out value="${itemvenda.idItemVenda}" /></td>
                    <td><c:out value="${itemvenda.quantidade}" /></td>
                    <td><c:out value="${itemvenda.subtotal}" /></td>
                    <td><c:out value="${itemvenda.produto.descricao}" /></td>
                    <td><a href="ManterItemVendaController?acao=prepararOperacao&operacao=Editar$idItemVenda=<c:out value="${itemvenda.idItemVenda}"/>">Editar</a></td>
                    <td><a href="ManterItemVendaController?acao=prepararOperacao&operacao=Editar$idItemVenda=<c:out value="${itemvenda.idItemVenda}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterItemVendaController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>

    </body>
</html>
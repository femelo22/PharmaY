<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa venda</title>
    </head>
    <body>
    
        <h1>Pesquisa de vendas</h1>
        <table border =1>
            <tr>
                <th>Código</th>
                <th>Data da venda</th>
                <th>Total</th>
                <th>Forma de pagamento</th>
                <th>Convenio</th>
                <th>Produto</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${vendas}" var="venda">
                <tr>
                    <td><c:out value="${venda.idVenda}" /></td>
                    <td><c:out value="${venda.dtVenda}" /></td>
                    <td><c:out value="${venda.total}" /></td>
                    <td><c:out value="${venda.formaPagamento}" /></td>
                    <td><c:out value="${venda.convenio.razaoSocial}" /></td>
                    <td><c:out value="${venda.produto.descricao}" /></td>
                    <td><a href="ManterVendaController?acao=prepararOperacao&operacao=Editar$idVenda=<c:out value="${venda.idVenda}"/>">Editar</a></td>
                    <td><a href="ManterVendaController?acao=prepararOperacao&operacao=Editar$idVenda=<c:out value="${venda.idVenda}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterVendaController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>

    </body>
</html>
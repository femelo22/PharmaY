

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Clientes</title>
    </head>
    <body>
        <h1>Pesquisar clientes</h1>
        <table border =1>
            <tr>
                <th>Código</th>
                <th>Nome do cliente</th>
                <th>CPF</th>
                <th>Registro</th>
                <th>Codigo do convenio</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.idCliente}" /></td>
                    <td><c:out value="${cliente.nome}" /></td>
                    <td><c:out value="${cliente.cpf}" /></td>
                    <td><c:out value="${cliente.registro}" /></td>
                    <td><c:out value="${cliente.convenio.razaoSocial}" /></td>
                    <td><a href="ManterClienteController?acao=prepararOperacao&operacao=Editar$codCliente=<c:out value="${cliente.idCliente}"/>">Editar</a></td>
                    <td><a href="ManterClienteController?acao=prepararOperacao&operacao=Editar$codCliente=<c:out value="${cliente.idCliente}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterClienteController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>

    </body>
</html>
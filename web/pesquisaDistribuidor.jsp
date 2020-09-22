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
        <title>Pesquisa de Distribuidores</title>
    </head>
    <body>
        <h1>Pesquisar distribuidores</h1>
        <table border =1>
            <tr>
                <th>Código</th>
                <th>Razao Social</th>
                <th>CNPJ</th>
                <th>Logradouro</th>
                <th>Complemento</th>
                <th>Número</th>
                <th>Bairro</th>
                <th>Estado</th>
                <th>Cidade</th>
                <th>CEP</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${distribuidores}" var="distribuidor">
                <tr>
                    <td><c:out value="${distribuidor.idDistribuidor}" /></td>
                    <td><c:out value="${distribuidor.razaoSocial}" /></td>
                    <td><c:out value="${distribuidor.cnpj}" /></td>
                    <td><c:out value="${distribuidor.logradouro}" /></td>
                    <td><c:out value="${distribuidor.complemento}" /></td>
                    <td><c:out value="${distribuidor.numero}" /></td>
                    <td><c:out value="${distribuidor.bairro}" /></td>
                    <td><c:out value="${distribuidor.estado}" /></td>
                    <td><c:out value="${distribuidor.cidade}" /></td>
                    <td><c:out value="${distribuidor.cep}" /></td>
                    <td><a href="ManterDistribuidorController?acao=prepararOperacao&operacao=Editar$idDistribuidor=<c:out value="${distribuidor.idDistribuidor}"/>">Editar</a></td>
                    <td><a href="ManterDistribuidorController?acao=prepararOperacao&operacao=Editar$idDistribuidor=<c:out value="${distribuidor.idDistribuidor}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterDistribuidorController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>

    </body>
</html>
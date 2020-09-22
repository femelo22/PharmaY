

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de categorias</title>
    </head>
    <body>
        <h1>Pesquisar categorias</h1>
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Descrição categoria</th>
                <th colspan=2>Ação</th>      
            </tr>
            <c:forEach items="${categorias}" var="categoria">
            
                <tr>
                    <td><c:out value="${categoria.idCategoria}"/> </td>
                    <td> <c:out value="${categoria.descricao}" /> </td>
                    <td><a href="ManterCategoriaController?acao=prepararOperacao&operacao=Editar&idCategoria=<c:out value="${categoria.idCategoria}"/>">Editar</a></td>    
                    <td><a href="ManterCategoriaController?acao=prepararOperacao&operacao=Excluir&idCategoria=<c:out value="${categoria.idCategoria}"/>">Excluir</a></td>
                </tr>
                </c:forEach>
        </table>
    </body>
</html>

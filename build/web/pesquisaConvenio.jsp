

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de convenios</title>
    </head>
    <body>
        <h1>Pesquisar convenios</h1>
        <table border =1>
            <tr>
                <th>Código</th>
                <th>Razão Social</th>
                <th>CNPJ</th>
                <th>Inicio do convenio</th>
                <th>Fim do convenio</th>
                <th>email</th>
                <th>desconto</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${convenios}" var="convenio">
                <tr>
                    <td><c:out value="${convenio.idConvenio}" /></td>
                    <td><c:out value="${convenio.razaoSocial}" /></td>
                    <td><c:out value="${convenio.cnpj}" /></td>
                    <td><c:out value="${convenio.dtInicio}" /></td>
                    <td><c:out value="${convenio.dtTermino}" /></td>
                    <td><c:out value="${convenio.email}" /></td>
                    <td><c:out value="${convenio.desconto}" /></td>
                    <td><a href="ManterConvenioController?acao=prepararOperacao&operacao=Editar$idConvenio=<c:out value="${convenio.idConvenio}"/>">Editar</a></td>
                    <td><a href="ManterConvenioController?acao=prepararOperacao&operacao=Editar$idConvenio=<c:out value="${convenio.idConvenio}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterClienteController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>

    </body>
</html>
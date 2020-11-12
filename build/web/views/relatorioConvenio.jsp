<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Relatório de categoria</h1>
        <form action="Relatorio2ConvenioController?acao=emitir" method="post">
            Escolha a categoria
            <select name="txtCodConvenio">
                <c:forEach items="${convenios}" var="convenio">
                    <option value="${convenio.idConvenio}">${convenio.razaoSocial}</option>  
                </c:forEach>
            </select>
            <br/>
            <input type="submit"/>
        </form>
    </body>
</html>

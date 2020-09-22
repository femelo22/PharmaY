

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Funcionarios</title>
    </head>
    <body>
        <h1>Pesquisar funcionarios</h1>
        <table border =1>
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>Email</th>
                <th>Nível de acesso</th>
                <th>Senha</th>
                <th>Telefone</th>
                <th>Logradouro</th>
                <th>Número</th>
                <th>Complemento</th>
                <th>Bairro</th>
                <th>Estado</th>
                <th>Cidade</th>
                <th>CEP</th>
                <th colspan=2>Ação</th>
            </tr>
            
            <c:forEach items="${funcionarios}" var="funcionario">
                <tr>
                    <td><c:out value="${funcionario.idFuncionario}" /></td>
                    <td><c:out value="${funcionario.nome}" /></td>
                    <td><c:out value="${funcionario.cpf}" /></td>
                    <td><c:out value="${funcionario.email}" /></td>
                    <td><c:out value="${funcionario.nivelAcesso}" /></td>
                    <td><c:out value="${funcionario.senha}" /></td>
                    <td><c:out value="${funcionario.telefone}" /></td>
                    <td><c:out value="${funcionario.logradouro}" /></td>
                    <td><c:out value="${funcionario.numero}" /></td>
                    <td><c:out value="${funcionario.complemento}" /></td>
                    <td><c:out value="${funcionario.bairro}" /></td>
                    <td><c:out value="${funcionario.estado}" /></td>
                    <td><c:out value="${funcionario.cidade}" /></td>
                    <td><c:out value="${funcionario.cep}" /></td>
                    <td><a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Editar$idFuncionario=<c:out value="${funcionario.idFuncionario}"/>">Editar</a></td>
                    <td><a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Editar$idFuncionario=<c:out value="${funcionario.idFuncionario}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterFuncionarioController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>

    </body>
</html>
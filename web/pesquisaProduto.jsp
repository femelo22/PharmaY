<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Produtos</title>
    </head>
    <body>
    
        <h1>Pesquisa de produtos</h1>
        <table border =1>
            <tr>
                <th>Código</th>
                <th>Descrição</th>
                <th>Preço de venda</th>
                <th>Preço de custo</th>
                <th>Observações do produto</th>
                <th>Estoque máximo</th>
                <th>Estoque mínimo</th>
                <th>Data de validade</th>
                <th>Lote</th>
                <th>Código do distribuidor</th>
                <th>Código da categoria</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${produtos}" var="produto">
                <tr>
                    <td><c:out value="${produto.idProduto}" /></td>
                    <td><c:out value="${produto.descricao}" /></td>
                    <td><c:out value="${produto.precoVenda}" /></td>
                    <td><c:out value="${produto.precoCusto}" /></td>
                    <td><c:out value="${produto.obs}" /></td>
                    <td><c:out value="${produto.estoqueMaximo}" /></td>
                    <td><c:out value="${produto.estoqueMinimo}" /></td>
                    <td><c:out value="${produto.dataValidade}" /></td>
                    <td><c:out value="${produto.lote}" /></td>
                    <td><c:out value="${produto.distribuidor.razaoSocial}" /></td>
                    <td><c:out value="${produto.categoria.descricao}" /></td>
                    <td><a href="ManterProdutoController?acao=prepararOperacao&operacao=Editar$idProduto=<c:out value="${produto.idProduto}"/>">Editar</a></td>
                    <td><a href="ManterProdutoController?acao=prepararOperacao&operacao=Editar$idProduto=<c:out value="${produto.idProduto}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterProdutoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>

    </body>
</html>
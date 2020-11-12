<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de convenios</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                <a class="navbar-brand" href="index.jsp">Inicio</a>
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Consultar</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="PesquisaCategoriaController">Categorias</a>
                            <a class="dropdown-item" href="PesquisaClienteController">Clientes</a>
                            <a class="dropdown-item" href="PesquisaConvenioController">Convenios</a>
                            <a class="dropdown-item" href="PesquisaDistribuidorController">Distribuidores</a>
                            <a class="dropdown-item" href="PesquisaFuncionarioController">Funcionarios</a>
                            <a class="dropdown-item" href="PesquisaItemVendaController">Itens Vendas</a>
                            <a class="dropdown-item" href="PesquisaProdutoController">Produtos</a>
                            <a class="dropdown-item" href="PesquisaVendaController">Vendas</a>
                        </div>
                    </li>
                </ul>
                <li class="nav-item">
                    <a class="navbar-brand" href="Relatorio1ConvenioController?acao=emitir">Emitir relatório com agrupamento</a>
                </li>
                <li class="nav-item">
                    <a class="navbar-brand" href="Relatorio2ConvenioController?acao=filtrar">Emitir relatório com filtro</a>
                </li>              
            </div>
        </nav>
        <h1 class="display-3">Pesquisar Convenios</h1>
        <div class="table-responsive table-striped mx-auto" style="width: 900px; height: 1000px; margin-top: 100px">
            <table border="1" class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Código</th>
                        <th scope="col">Razão Social</th>
                        <th scope="col">CNPJ</th>
                        <th scope="col">email</th>
                        <th scope="col">desconto</th>
                        <th colspan=2 scope="col">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${convenios}" var="convenio">
                        <tr>
                            <th scope="row"><c:out value="${convenio.idConvenio}" /></th>
                            <td><c:out value="${convenio.razaoSocial}" /></td>
                            <td><c:out value="${convenio.cnpj}" /></td> 
                            <td><c:out value="${convenio.email}" /></td>
                            <td><c:out value="${convenio.desconto}" /></td>
                            <td><a href="ManterConvenioController?acao=prepararOperacao&operacao=Editar&idConvenio=<c:out value="${convenio.idConvenio}"/>">Editar</a></td>
                            <td><a href="ManterConvenioController?acao=prepararOperacao&operacao=Excluir&idConvenio=<c:out value="${convenio.idConvenio}"/>">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterConvenioController?acao=prepararOperacao&operacao=Incluir" method="post">
                <input type="submit" name="btnIncluir" value="Incluir" class="btn btn-outline-primary">
            </form>
        </div>
    </body>
</html>
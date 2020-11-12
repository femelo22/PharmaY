<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PharmaX</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                <a class="navbar-brand" href="#">Inicio</a>
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
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Controle de Estoque<span class="sr-only">(current)</span></a>
                    </li>
                </ul>            
            </div>
        </nav>
        <div class="card text-center">
            <div class="card-header">
            </div>
            <div class="card-body">
                <h2 class="card-title">Bem-Vindo(a)</h2>
                <p class="card-text">Sistema de gerenciamento farmacêutico.</p>
                <!--<a href="#" class="btn btn-primary">PharmaY</a>-->
            </div>
        </div>
    </body>
</html>
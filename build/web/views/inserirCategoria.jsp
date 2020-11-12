<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Categoria</title>
    </head>
    <body>
        <h5 class="display-4" style="text-align: center;">Ação Categoria - ${operacao}</h5>
        <div class="form-group"> 
            <form action="ManterCategoriaController?acao=confirmarOperacao&operacao=${operacao}" method="POST" name="frmManterCategoria">

                <div class="col-md-4 mb-3">
                    <label for="validationServer01">Código</label>
                    <input type="text" class="form-control"  name="txtCodigo" id="validationServer01" required value="${categoria.idCategoria}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>>
                    </div>

                    <div class="col-md-4 mb-3">
                        <label for="validationServer01">Descrição</label>
                        <input type="text" class="form-control" name="txtDescricao" id="validationServer01" required value="${categoria.descricao}"  <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                </div>

                <div style="margin-left: 15px">
                    <input type="submit" class="btn btn-outline-success"/>
                    <a href="PesquisaCategoriaController" class="btn btn-outline-danger">Cancelar</a>
                </div>      

            </form>
        </div>
    </body>
</html>

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
        <title>JSP Page</title>
    </head>
    <body>
         <h1 class="display-4" style="text-align: center;">Ação Distribuidores - ${operacao}</h1>
         <div class="form-group">
            <form action = "ManterDistribuidorController?acao=confirmarOperacao&operacao=${operacao}" method="POST" name="frmManterDistribuidor">
              <div class="col-md-4 mb-3">
                  <label>Codigo</label><br>
                  <input type="text" name="txtIdDistribuidor"  required class="form-control" value="${distribuidor.idDistribuidor}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
              </div>

              <div class="col-md-4 mb-3">
                  <label>Razão social</label><br>
                  <input type="text" name="txtRazao" required class="form-control" value="${distribuidor.razaoSocial}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
              </div>

              <div class="col-md-4 mb-3">
                  <label>CNPJ</label><br>
                  <input type="text" name="txtCnpj" required class="form-control" value="${distribuidor.cnpj}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
              </div>

              <div class="col-md-4 mb-3">
                  <label>Logradouro</label><br>
                  <input type="text" name="txtLogradouro" required class="form-control" value="${distribuidor.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
              </div>

              <div class="col-md-4 mb-3">
                  <label>Complemento</label><br>
                  <input type="text" name="txtComplemento" required class="form-control" value="${distribuidor.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
              </div>

              <div class="col-md-4 mb-3">
                  <label>Numero</label><br>
                  <input type="text" name="txtNumero" required class="form-control" value="${distribuidor.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
              </div>

              <div class="col-md-4 mb-3">
                  <label>Bairro</label><br>
                  <input type="text" name="txtBairro" required class="form-control" value="${distribuidor.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
              </div>

              <div class="col-md-4 mb-3">
                  <label>Estado</label><br>
                  <input type="text" name="txtEstado" required class="form-control" value="${distribuidor.estado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
              </div>

              <div class="col-md-4 mb-3">
                  <label>Cidade</label><br>
                  <input type="text" name="txtCidade" required class="form-control" value="${distribuidor.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
              </div>

              <div class="col-md-4 mb-3">
                  <label>CEP</label><br>
                  <input type="text" name="txtCep" required class="form-control" value="${distribuidor.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
              </div>

             <div style="margin-left: 15px">
                <input type="submit" class="btn btn-outline-success"/>
                <a href="PesquisaDistribuidorController" class="btn btn-outline-danger">Cancelar</a>
             </div>
          </form>
        </div>
    </body>
</html>
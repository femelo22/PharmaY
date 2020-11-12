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
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="display-4" style="text-align: center;">Ação Convênio - ${operacao}</h1>        
        <div class="form-group">
            <form action="ManterConvenioController?acao=confirmarOperacao&operacao=${operacao}" method="POST" name="frmManterConvenio">    
                
                <div class="col-md-4 mb-3">
                    <label for="validationServer01">Código</label>
                    <input type="text" name="txtCodigo" required class="form-control" value="${convenio.idConvenio}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label for="validationServer01">Razão social</label><br>
                    <input type="text" name="txtRazao" required class="form-control" value="${convenio.razaoSocial}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>CNPJ</label><br>
                    <input type="text" name="txtCnpj" required class="form-control" value="${convenio.cnpj}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Data início</label><br>
                    <input type="text" name="txtDtInicio"  required class="form-control" value="${convenio.dtInicio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
               
                <div class="col-md-4 mb-3">
                    <label>Data termino</label><br>
                    <input type="text" name="txtDtTermino" required class="form-control" value="${convenio.dtTermino}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
              
                <div class="col-md-4 mb-3">
                    <label>Email</label><br>
                    <input type="text" name="txtEmail" required class="form-control" value="${convenio.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
               
                <div class="col-md-4 mb-3">
                    <label>Desconto</label><br>
                    <input type="text" name="txtDesconto" required class="form-control" value="${convenio.desconto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br>
                </div>
                
               <div style="margin-left: 15px">
                <input type="submit" class="btn btn-outline-success"/>
                <a href="PesquisaConvenioController" class="btn btn-outline-danger">Cancelar</a>
               </div>
            </form> 
        </div>
    </body>
</html>

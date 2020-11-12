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
       <h1 class="display-4" style="text-align: center;">Cadastro de produtos - ${operacao}</h1> 
       <div class="form-group">
            <form action="ManterProdutoController?acao=confirmarOperacao&operacao=${operacao}" method="POST" name="frmManterProduto">
                
                <div class="col-md-4 mb-3">
                    <label>Código</label><br>
                    <input type="text" name="txtCodigo" required class="form-control" value="${produto.idProduto}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Descrição do produto</label><br>
                    <input type="text" name="txtDescricao" required class="form-control" value="${produto.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Preço de venda</label><br>
                    <input type="text" name="txtPrecoVenda" required class="form-control" value="${produto.precoVenda}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Preço de custo</label><br>
                    <input type="text" name="txtPrecoCusto" required class="form-control" value="${produto.precoCusto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Observações</label><br>
                    <input type="text" name="txtObs" required class="form-control" value="${produto.obs}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Estoque máximo</label><br>
                    <input type="text" name="txtEstMax" required class="form-control" value="${produto.estoqueMaximo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Estoque mínimo</label><br>
                    <input type="text" name="txtEstMin" required class="form-control" value="${produto.estoqueMinimo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Data de validade</label><br>
                    <input type="text" name="txtDtValidade" required class="form-control" value="${produto.dataValidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Lote</label><br>
                    <input type="text" name="txtLote" required class="form-control" value="${produto.lote}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Distribuidor</label><br>
                    <select name="slDistribuidor" required class="form-control" <c:if test="${operacao == 'Excluir'}"> desabled</c:if>>
                        <option value="0" <c:if test="${produto.distribuidor.idDistribuidor == null}"> selected</c:if>></option>
                        <c:forEach items="${distribuidores}" var="distribuidor"> 
                            <option value="${distribuidor.idDistribuidor}"
                                <c:if test="${produto.distribuidor.idDistribuidor == distribuidor.idDistribuidor}"> selected</c:if>>${distribuidor.razaoSocial}
                            </option>
                        </c:forEach>
                    </select>
                </div>    
                    
                <div class="col-md-4 mb-3">
                    <label>Categoria</label><br>
                    <select name="slCategoria" required class="form-control" <c:if test="${operacao == 'Excluir'}"> desabled</c:if>>
                        <option value="0" <c:if test="${produto.categoria.idCategoria == null}"> selected</c:if>></option>
                        <c:forEach items="${categorias}" var="categoria"> 
                            <option value="${categoria.idCategoria}"
                                <c:if test="${produto.categoria.idCategoria == categoria.idCategoria}"> selected</c:if>>${categoria.descricao}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div style="margin-left: 15px">        
                    <input type="submit" class="btn btn-outline-success"/>
                    <a href="PesquisaProdutoController" class="btn btn-outline-danger">Cancelar</a>
                </div>
            </form>
        </div>
    </body>
</html>

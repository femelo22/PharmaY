<%-- 
    Document   : inserirProduto
    Created on : 17/09/2020, 09:43:31
    Author     : luiz_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Cadastro de produtos</h1>      
        <form>
            <label>Descrição do produto</label><br>
            <input type="text" name="txtDescricao"/><br>

            <label>Preço de venda</label><br>
            <input type="text" name="txtPrecoVenda"/><br>

            <label>Preço de custo</label><br>
            <input type="text" name="txtPrecoCusto"/><br>
                             
            <label>Observações</label><br>
            <input type="text" name="txtObs"/><br>
            
            <label>Estoque máximo</label><br>
            <input type="text" name="txtEstMax"/><br>
            
            <label>Estoque mínimo</label><br>
            <input type="text" name="txtEstMin"/><br>
            
            <label>Data de validade</label><br>
            <input type="text" name="txtDtValidade"/><br>
            
            <label>Lote</label><br>
            <input type="text" name="txtLote"/><br>
            
            <label>Distribuidor</label><br>
            <select name="selectDistribuidor">
                <option value="">TODO</option>
                <option value="">TODO</option>
                <option value="">TODO</option>
            </select><br>
            
            <label>Categoria</label><br>
            <select name="selectCategoria">
                <option value="">TODO</option>
                <option value="">TODO</option>
                <option value="">TODO</option>
            </select><br><br>
                          
            <input type="submit"/>
        </form>
    </body>
</html>

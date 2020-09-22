<%-- 
    Document   : inserirVenda
    Created on : 17/09/2020, 09:52:14
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
         <h1>Ponto de venda</h1>      
        <form>
            <label>Data da venda</label><br>
            <input type="text" name="txtDtVenda"/><br>

            <label>Total</label><br>
            <input type="text" name="txtTotal"/><br>

            <label>Forma de pagamento</label><br>
             <select name="selectFormaPag">
                <option value="">Débito</option>
                <option value="">Crédito</option>
                <option value="">Dinheiro</option>
            </select><br>                           
            
            <label>Convênio</label><br>
            <select name="selectConvenio">
                 <option value=""></option>
                <option value="">TODO</option>
                <option value="">TODO</option>
                <option value="">TODO</option>
            </select><br>
            
            <label>Produto</label><br>
            <select name="selectProduto">
                 <option value=""></option>
                <option value="">TODO: puxar do item_venda</option>
                <option value="">TODO: puxar do item_venda</option>
                <option value="">TODO: puxar do item_venda</option>
            </select><br><br>
                          
            <input type="submit"/>
        </form>
    </body>
</html>

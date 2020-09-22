<%-- 
    Document   : inserirItemVenda
    Created on : 17/09/2020, 09:49:51
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
         <h1>Adicionar item</h1>      
        <form>
            <label>Quantidade</label><br>
            <input type="text" name="txtQtd"/><br>

            <label>Subtotal</label><br>
            <input type="text" name="txtSubtotal"/><br>       
            
            <label>Produto</label><br>
            <select name="selectProduto">
                <option value="">TODO</option>
                <option value="">TODO</option>
                <option value="">TODO</option>
            </select><br><br>
                          
            <input type="submit"/>
        </form>
    </body>
</html>

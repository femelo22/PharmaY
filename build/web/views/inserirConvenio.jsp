<%-- 
    Document   : inserirConvenio
    Created on : 16/09/2020, 22:44:50
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
        <h1>Cadastro de convênios</h1>        
        <form>
            <label>Razão social</label><br>
            <input type="text" name="txtRazao"/><br>
            
            <label>CNPJ</label><br>
            <input type="text" name="txtCnpj"/><br>
            
            <label>Data início</label><br>
            <input type="text" name="txtDtInicio"/><br>
            
            <label>Data termino</label><br>
            <input type="text" name="txtDtTermino"/><br>
            
            <label>Email</label><br>
            <input type="text" name="txtEmail"/><br>
            
            <label>Desconto</label><br>
            <input type="text" name="txtDesconto"/><br><br>
            
           <input type="submit"/>
        </form>  
    </body>
</html>

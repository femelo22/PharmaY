<%-- 
    Document   : inserirDistribuidor
    Created on : 16/09/2020, 22:53:27
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
         <h1>Cadastro de distribuidores</h1>        
        <form>
            <label>Razão social</label><br>
            <input type="text" name="txtRazao"/><br>
            
            <label>CNPJ</label><br>
            <input type="text" name="txtCnpj"/><br>
            
            <label>Logradouro</label><br>
            <input type="text" name="txtLogradouro"/><br>
            
            <label>Complemento</label><br>
            <input type="text" name="txtComplemento"/><br>
            
            <label>Numero</label><br>
            <input type="text" name="txtNumero"/><br>
            
            <label>Bairro</label><br>
            <input type="text" name="txtBairro"/><br>
            
            <label>Estado</label><br>
            <input type="text" name="txtEstado"/><br>
            
            <label>Cidade</label><br>
            <input type="text" name="txtCidade"/><br>
            
            <label>CEP</label><br>
            <input type="text" name="txtCep"/><br><br>
                     
           <input type="submit"/>
        </form>  
    </body>
</html>

<%-- 
    Document   : inserirCliente
    Created on : 16/09/2020, 22:39:18
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
        <h1>Cadastro de clientes</h1>      
        <form>
            <label>Nome do cliente</label><br>
            <input type="text" name="txtNomeCliente"/><br>

            <label>CPF</label><br>
            <input type="text" name="txtCpfCliente"/><br>

            <label>Registro</label><br>
            <input type="text" name="txtRegistroCliente"/><br>

            <label>Selecione um convênio</label><br>
            <select name="selectConvenios">
                <option value="">todo</option>
                <option value="">todo</option>
                <option value="">todo</option>
                <option value="">todo</option>
            </select><br><br>

            <input type="submit"/>
        </form>
    </body>
</html>

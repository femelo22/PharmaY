<%-- 
    Document   : inserirFuncionario
    Created on : 17/09/2020, 09:34:06
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
         <h1>Cadastro de funcionários</h1>      
        <form>
            <label>Nome</label><br>
            <input type="text" name="txtNome"/><br>

            <label>CPF</label><br>
            <input type="text" name="txtCpf"/><br>

            <label>Email</label><br>
            <input type="text" name="txtEmail"/><br>
                             
            <label>Telefone</label><br>
            <input type="text" name="txtTelefone"/><br>
            
            <label>Logradouro</label><br>
            <input type="text" name="txtLogradouro"/><br>
            
            <label>Numero</label><br>
            <input type="text" name="txtNumero"/><br>
            
            <label>Complemento</label><br>
            <input type="text" name="txtComplemento"/><br>
            
            <label>Bairro</label><br>
            <input type="text" name="txtBairro"/><br>
            
            <label>Estado</label><br>
            <select name="selectEstados">
                <option value="">AC</option>
                <option value="">AL</option>
                <option value="">AP</option>
                <option value="">AM</option>
                <option value="">BA</option>
                <option value="">CE</option>
                <option value="">ES</option>
                <option value="">GO</option>
                <option value="">MA</option>
                <option value="">MT</option>
                <option value="">MS</option>
                <option value="">MG</option>
                <option value="">PA</option>
                <option value="">PB</option>
                <option value="">PR</option>
                <option value="">PE</option>
                <option value="">PI</option>
                <option value="">RJ</option>
                <option value="">RN</option>
                <option value="">RS</option>
                <option value="">RO</option>
                <option value="">RP</option>
                <option value="">SC</option>
                <option value="">SP</option>
                <option value="">SE</option>
                <option value="">TO</option>
                <option value="">DF</option>
            </select><br>
            
            <label>Cidade</label><br>
            <input type="text" name="txtCidade"/><br>
            
            <label>CEP</label><br>
            <input type="text" name="txtCep"/><br>
            
              <label>Nível de acesso</label><br>
            <input type="text" name="txtNivel"/><br>
            
            <label>Senha</label><br>
            <input type="text" name="txtSenha"/><br><br>
           
            <input type="submit"/>
        </form>
    </body>
</html>

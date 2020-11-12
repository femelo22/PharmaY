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
        <h1 class="display-4" style="text-align: center;">Ação Funcionários - ${operacao}</h1> 
        <div class="form-group">
            <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="POST" name="frmManterFuncionario">
                
                <div class="col-md-4 mb-3">
                    <label>Código</label><br>
                    <input type="number" name="txtCodFuncionario" required class="form-control" value="${funcionario.idFuncionario}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>> 
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Nome</label><br>
                    <input type="text" name="txtNome" required class="form-control" value="${funcionario.nome}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>CPF</label><br>
                    <input type="text" name="txtCpf" required class="form-control" value="${funcionario.cpf}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                    
                <div class="col-md-4 mb-3">
                    <label>Email</label><br>
                    <input type="text" name="txtEmail" required class="form-control" value="${funcionario.email}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Nível de acesso</label><br>
                    <select name="selectNivelAcesso" required class="form-control" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                        <option value="Admin" <c:if test="${funcionario.nivelAcesso == 'Administrador'}"> selected</c:if>>Administrador</option>
                        <option value="Caixa" <c:if test="${funcionario.nivelAcesso == 'Caixa'}"> selected</c:if>>Caixa</option>
                        <option value="Sub-Admin" <c:if test="${funcionario.nivelAcesso == 'Farmaceútico'}"> selected</c:if>>Farmaceútico</option>
                    </select>
                </div> 
                    
                <div class="col-md-4 mb-3"> 
                    <label>Senha</label><br>
                    <input type="password" name="txtSenha" required class="form-control" value="${funcionario.senha}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                </div> 
                
                <div class="col-md-4 mb-3">
                    <label>Telefone</label><br>
                    <input type="text" name="txtTelefone"  required class="form-control" value="${funcionario.telefone}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Logradouro</label><br>
                    <input type="text" name="txtLogradouro" required class="form-control" value="${funcionario.logradouro}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div> 
                
                <div class="col-md-4 mb-3"> 
                    <label>Numero</label><br>
                    <input type="number" name="txtNumero" required class="form-control" value="${funcionario.numero}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3">
                    <label>Complemento</label><br>
                    <input type="text" name="txtComplemento" required class="form-control" value="${funcionario.complemento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div> 
                
                <div class="col-md-4 mb-3">
                    <label>Bairro</label><br>
                    <input type="text" name="txtBairro" required class="form-control" value="${funcionario.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div> 
                
                <div class="col-md-4 mb-3">
                    <label>Estado</label><br>
                    <select name="selectEstados" required class="form-control" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                        <option value="${funcionario.estado}"></option>
                        <option value="AC" <c:if test="${funcionario.estado == 'AC'}"> selected</c:if>>AC</option>
                        <option value="AL" <c:if test="${funcionario.estado == 'AL'}"> selected</c:if>>AL</option>
                        <option value="AP" <c:if test="${funcionario.estado == 'AP'}"> selected</c:if>>AP</option>
                        <option value="AM" <c:if test="${funcionario.estado == 'AM'}"> selected</c:if>>AM</option>
                        <option value="BA" <c:if test="${funcionario.estado == 'BA'}"> selected</c:if>>BA</option>
                        <option value="CE" <c:if test="${funcionario.estado == 'CE'}"> selected</c:if>>CE</option>
                        <option value="ES" <c:if test="${funcionario.estado == 'ES'}"> selected</c:if>>ES</option>
                        <option value="GO" <c:if test="${funcionario.estado == 'GO'}"> selected</c:if>>GO</option>
                        <option value="MA" <c:if test="${funcionario.estado == 'MA'}"> selected</c:if>>MA</option>
                        <option value="MT" <c:if test="${funcionario.estado == 'MT'}"> selected</c:if>>MT</option>
                        <option value="MS" <c:if test="${funcionario.estado == 'MS'}"> selected</c:if>>MS</option>
                        <option value="MG" <c:if test="${funcionario.estado == 'MG'}"> selected</c:if>>MG</option>
                        <option value="PA" <c:if test="${funcionario.estado == 'PA'}"> selected</c:if>>PA</option>
                        <option value="PB" <c:if test="${funcionario.estado == 'PB'}"> selected</c:if>>PB</option>
                        <option value="PR" <c:if test="${funcionario.estado == 'PR'}"> selected</c:if>>PR</option>
                        <option value="PE" <c:if test="${funcionario.estado == 'PE'}"> selected</c:if>>PE</option>
                        <option value="PI" <c:if test="${funcionario.estado == 'PI'}"> selected</c:if>>PI</option>
                        <option value="RJ" <c:if test="${funcionario.estado == 'RJ'}"> selected</c:if>>RJ</option>
                        <option value="RN" <c:if test="${funcionario.estado == 'RN'}"> selected</c:if>>RN</option>
                        <option value="RS" <c:if test="${funcionario.estado == 'RS'}"> selected</c:if>>RS</option>
                        <option value="RO" <c:if test="${funcionario.estado == 'RO'}"> selected</c:if>>RO</option>
                        <option value="RP" <c:if test="${funcionario.estado == 'RP'}"> selected</c:if>>RP</option>
                        <option value="SC" <c:if test="${funcionario.estado == 'SC'}"> selected</c:if>>SC</option>
                        <option value="SP" <c:if test="${funcionario.estado == 'SP'}"> selected</c:if>>SP</option>
                        <option value="SE" <c:if test="${funcionario.estado == 'SE'}"> selected</c:if>>SE</option>
                        <option value="TO" <c:if test="${funcionario.estado == 'TO'}"> selected</c:if>>TO</option>
                        <option value="DF" <c:if test="${funcionario.estado == 'DF'}"> selected</c:if>>DF</option>
                    </select>
                </div> 
                    
                <div class="col-md-4 mb-3"> 
                    <label>Cidade</label><br>
                    <input type="text" name="txtCidade" required class="form-control" value="${funcionario.cidade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div class="col-md-4 mb-3"> 
                    <label>CEP</label><br>
                    <input type="text" name="txtCep" required class="form-control" value="${funcionario.cep}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                
                <div style="margin-left: 15px">
                    <input type="submit" class="btn btn-outline-success"/>
                    <a href="PesquisaFuncionarioController" class="btn btn-outline-danger">Cancelar</a>
                </div>
            </form>
        </div>
    </body>
</html>

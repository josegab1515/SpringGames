<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file="/extra/header.jsp" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Modo de Jogo</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Modo de Jogo</h1>
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Descrição</th>

            </tr>
            <c:forEach var="mj" items="${modojogos}">
                <tr>
                    <td>${mj.id}</td>
                    <td>${mj.nome}</td>
                    <td>${mj.descricao}</td>
                    <td> 
                        <a href="/modojogos/update/${mj.id}" class="btn btn-warning">Editar Modo de Jogo</a>  
                        <a href="/modojogos/delete/${mj.id}" class="btn btn-danger">Remover Modo de Jogo</a>
                    </td>
                   
                </tr>
            </c:forEach>
        </table>
        <a href="/modojogos/insert" class="btn btn-primary mt-1">Novo Modo</a>
    </div>
</body>
</html>
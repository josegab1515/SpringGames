<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file="/extra/header.jsp" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Gêneros</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Gêneros</h1>
        <table class="table">
            <tr>
                <th>id</th>
                <th>nome</th>
            </tr>
            <c:forEach var="g" items="${generos}">
                <tr>
                    <td>${g.id}</td>
                    <td>${g.nome}</td>
                    <td> 
                        <a href="/generos/update/${g.id}" class="btn btn-warning">Editar Gênero</a>  
                        <a href="/generos/delete/${g.id}" class="btn btn-danger">Remover Gênero</a>
                    </td>
                   
                </tr>
            </c:forEach>
        </table>
        <a href="/generos/insert" class="btn btn-primary mt-1">Novo Gênero</a>
    </div>
</body>
</html>
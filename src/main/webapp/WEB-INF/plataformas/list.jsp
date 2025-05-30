<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file="/extra/header.jsp" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Plataformas</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Plataformas</h1>
        <table class="table">
            <tr>
                <th>id</th>
                <th>nome</th>
            </tr>
            <c:forEach var="pl" items="${plataformas}">
                <tr>
                    <td>${pl.id}</td>
                    <td>${pl.nome}</td>
                    <td> 
                        <a href="/plataformas/update/${pl.id}" class="btn btn-warning">Editar Plataforma</a>  
                        <a href="/plataformas/delete/${pl.id}" class="btn btn-danger">Remover Plataforma</a>
                    </td>
                   
                </tr>
            </c:forEach>
        </table>
        <a href="/plataformas/insert" class="btn btn-primary mt-1">Nova Plataforma</a>
    </div>
</body>
</html>
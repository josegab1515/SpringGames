<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <title>Novo Modo</title>
        <link rel="stylesheet" href="/css/bootstrap.min.css">
    </head>

    <body>
        <div class="container">
            <h1>Novo Modo de Jogo</h1>
            <form action="/modojogos/insert" method="post">
                <c:if test="${erro != null and not empty erro}">
                    <div class="alert alert-danger">${erro}</div>
                </c:if>
                
                <div class="mb-3">
                    <label for="nome" class="form-label">Nome:</label>
                    <input type="text" name="nome" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="descricao" class="form-label">Descrição:</label>
                    <input type="text" name="descricao" class="form-control">
                </div>
                
                <br>
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>

    </html>
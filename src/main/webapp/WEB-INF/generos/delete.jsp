<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <title>Excluir Gênero</title>
            <link rel="stylesheet" href="/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container">
                <h1 style="color: red;">Excluir Gênero</h1>
                <form action="/generos/delete" method="post">

                    <input type="hidden" name="id" value="${genero.id}">
                    <label for="name" class="form-label">Gênero</label>
                    <input type="text" name="nome" value="${genero.nome}" class="form-control mb-3">
                    <button type="submit" class="btn btn-danger">Deletar</button>

                </form>
            </div>
        </body>

        </html>
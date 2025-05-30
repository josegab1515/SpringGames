<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <title>Editar Plataforma</title>
            <link rel="stylesheet" href="/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container">
                <h1>Editar Plataforma</h1>
                <form action="/plataformas/update" method="post">

                    <input type="hidden" name="id" value="${plataformas.id}">
                    <label for="name" class="form-label">Plataforma</label>
                    <input type="text" name="nome" value="${plataformas.nome}" class="form-control  mb-3">
                    <button type="submit" class="btn btn-success">Atualizar</button>

                </form>
            </div>
        </body>

        </html>
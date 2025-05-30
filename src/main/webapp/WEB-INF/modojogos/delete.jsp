<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <title>Excluir Modo</title>
            <link rel="stylesheet" href="/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container">
                <h1 style="color: red;">Excluir Modo</h1>
                <form action="/modojogos/delete" method="post">

                    <input type="hidden" name="id" value="${modojogos.id}">
                    <label class="form-label">Modo:</label>
                    <input type="text" name="nome" value="${modojogos.nome}" class="form-control mb-3" readonly>
                    <label class="form-label">Descrição:</label>
                    <input type="text" name="descricao" value="${modojogos.descricao}" class="form-control mb-3" readonly>
                    <button type="submit" class="btn btn-danger">Deletar</button>

                </form>
            </div>
        </body>

        </html>
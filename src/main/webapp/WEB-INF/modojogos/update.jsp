<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <title>Editar Modo</title>
        <link rel="stylesheet" href="/css/bootstrap.min.css">
    </head>

    <body>
        <div class="container">
            <h1>Editar Modo de Jogo</h1>
            <form action="/modojogos/update" method="post">
                <input type="hidden" name="id" value="${modojogos.id}">
                <label for="name" class="form-label fw-medium">Modo de Jogo</label>
                <input type="text" name="nome" value="${modojogos.nome}" class="form-control mb-3">
                <label for="name" class="form-label fw-medium">descrição</label>
                <input type="text" name="descricao" value="${modojogos.descricao}" class="form-control mb-3">
                <button type="submit" class="btn btn-success">Atualizar</button>

            </form>
        </div>
    </body>
</html>
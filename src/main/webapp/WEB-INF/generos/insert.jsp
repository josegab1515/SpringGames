<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Novo Gênero</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Novo Gênero</h1>
        <form action="/generos/insert" method="post">
            <div>
                <label for="nome" class="form-label">Nome:</label>
                <input type="text" name="nome" class="form-control">
            </div>
            <br>
            <button type="submit" class="btn btn-success">Salvar</button>
        </form>
    </div>
</body>
</html>
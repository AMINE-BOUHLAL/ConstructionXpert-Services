<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Projet</title>
    <!-- Inclure le CSS ici -->
</head>
<body>
<div class="container">
    <h2>Modifier Projet</h2>
    <form action="${pageContext.request.contextPath}/projet?action=updateprojet" method="post">
        <input type="hidden" name="idProjet" value="${projet.idProjet}">
        <label>Nom du Projet:</label><input type="text" name="nomProjet" value="${projet.nomProjet}" required><br>
        <label>Description:</label><input type="text" name="description" value="${projet.description}" required><br>
        <label>Date de Début:</label><input type="date" name="dateDebut" value="${projet.dateDebut}" required><br>
        <label>Date de Fin:</label><input type="date" name="datefin" value="${projet.dateFin}" required><br>
        <label>Budget:</label><input type="number" name="budget" step="0.01" value="${projet.budget}" required><br>
        <button type="submit" class="btn">Mettre à jour</button>
    </form>
</div>
</body>
</html>
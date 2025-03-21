<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier Projet - ConstructionPRO</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --primary: #10CAB7;
            --secondary: #7f8c8d;
            --dark: #2c3e50;
            --light: #ecf0f1;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(45deg, #f8f9fa, #e8ecef);
            padding: 50px 0;
        }

        .container {
            max-width: 800px;
            background: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: var(--dark);
            font-weight: 700;
            margin-bottom: 30px;
            font-size: 2rem;
        }

        label {
            font-weight: 500;
            color: var(--dark);
            display: block;
            margin-bottom: 8px;
        }

        input[type="text"],
        input[type="date"],
        input[type="number"],
        textarea {
            width: 100%;
            padding: 12px 15px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 1rem;
            transition: border 0.3s ease;
        }

        input:focus,
        textarea:focus {
            border-color: var(--primary);
            outline: none;
        }

        .btn {
            background: var(--primary);
            color: white;
            border: none;
            padding: 12px 30px;
            font-size: 1rem;
            font-weight: 600;
            border-radius: 50px;
            text-transform: uppercase;
            letter-spacing: 1px;
            transition: background 0.3s ease;
            cursor: pointer;
            margin-top: 10px;
        }

        .btn:hover {
            background: #0ea896;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Modifier Projet</h2>
    <form action="projet" method="post">
        <input type="hidden" name="action" value="updateprojet">
        <input type="hidden" name="idProjet" value="${projet.idProjet}">
        <label for="nomProjet">Nom du projet :</label>
        <input type="text" id="nomProjet" name="nomProjet" value="${projet.nomProjet}" required><br>
        <label for="description">Description :</label>
        <input type="text" id="description" name="description" value="${projet.description}" required><br>
        <label for="dateDebut">Date de début :</label>
        <input type="date" id="dateDebut" name="dateDebut" value="${projet.dateDebut}" required><br>
        <label for="dateFin">Date de fin :</label>
        <input type="date" id="dateFin" name="dateFin" value="${projet.dateFin}" required><br>
        <label for="budget">Budget :</label>
        <input type="number" id="budget" name="budget" value="${projet.budget}" required><br>
        <button type="submit">Mettre à jour</button>
    </form>
</div>

<!-- Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
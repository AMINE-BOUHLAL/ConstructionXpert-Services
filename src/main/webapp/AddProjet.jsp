<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un Projet - ProGest</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
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
        }

        .navbar {
            background: rgba(255, 255, 255, 0.95);
            box-shadow: 0 5px 30px rgba(0, 0, 0, 0.1);
        }

        .navbar-brand {
            font-weight: 700;
            font-size: 28px;
            color: var(--primary);
        }

        .nav-link {
            font-weight: 500;
            color: var(--dark) !important;
            padding: 8px 20px !important;
        }

        .nav-link:hover {
            color: var(--primary) !important;
        }

        .form-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 30px;
            background: rgba(255, 255, 255, 0.95);
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
        }

        .form-container h2 {
            font-size: 2rem;
            font-weight: 700;
            color: var(--dark);
            margin-bottom: 25px;
            text-align: center;
        }

        .form-container label {
            font-weight: 600;
            color: var(--dark);
        }

        .form-container input,
        .form-container textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid var(--light);
            border-radius: 10px;
            font-size: 1rem;
        }

        .form-container textarea {
            resize: vertical;
            height: 100px;
        }

        .form-container .btn-submit {
            background: var(--primary);
            color: white;
            border: none;
            padding: 12px 30px;
            font-size: 1rem;
            font-weight: 600;
            border-radius: 50px;
            text-transform: uppercase;
            letter-spacing: 1px;
            width: 100%;
            cursor: pointer;
        }

        .form-container .btn-submit:hover {
            background: #0ea896;
        }

        @media (max-width: 768px) {
            .form-container {
                margin: 20px;
                padding: 20px;
            }

            .form-container h2 {
                font-size: 1.5rem;
            }
        }
    </style>
</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg">
    <div class="container">
        <a class="navbar-brand" href="#">Construction<span>PRO</span></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="index.jsp">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/projet?action=listprojet">Projets</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/tache?action=listtache">Taches</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/ressource?action=listressource">Ressources</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Add Project Form -->
<div class="form-container">
    <h2>Ajouter un Projet</h2>
    <form action="<%= request.getContextPath()%>/projet?action=createprojet" method="post">
        <div class="form-group">
            <label for="nom">Nom du Projet</label>
            <input type="text" id="nom" name="nomProjet" required>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" required></textarea>
        </div>
        <div class="form-group">
            <label for="date-debut">Date de Début</label>
            <input type="date" id="date-debut" name="dateDebut" required>
        </div>
        <div class="form-group">
            <label for="date-fin">Date de Fin</label>
            <input type="date" id="date-fin" name="datefin" required>
        </div>
        <div class="form-group">
            <label for="budget">Budget</label>
            <input type="number" id="budget" name="budget" step="0.01" required>
        </div>
        <button type="submit" class="btn-submit">Ajouter le Projet</button>
    </form>
</div>

<!-- Bootstrap JS (for navbar functionality) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ConstructionXpert Services - Ajouter un Projet</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background-image: url('https://i.imgur.com/placeholder-construction.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            color: #333;
            position: relative;
        }

        body::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(255, 255, 255, 0.85);
            z-index: -1;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
            position: relative;
        }

        header {
            background-color: #10CAB7;
            color: white;
            padding: 15px 0;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .header-content {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo h1 {
            font-size: 24px;
        }

        nav ul {
            display: flex;
            list-style: none;
        }

        nav ul li {
            margin-left: 20px;
        }

        nav ul li a {
            color: white;
            text-decoration: none;
            padding: 5px 10px;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        nav ul li a:hover {
            background-color: rgba(255, 255, 255, 0.2);
        }

        .active {
            background-color: #10CAB7;
        }

        .form-section {
            padding: 30px 0;
        }

        .form-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 30px;
        }

        .form-title {
            font-size: 28px;
            color: #7f8c8d;
        }

        .form-container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #7f8c8d;
        }

        .form-control {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
        }

        .form-control:focus {
            outline: none;
            border-color: #10CAB7;
        }

        textarea.form-control {
            min-height: 120px;
            resize: vertical;
        }

        .btn-group {
            display: flex;
            justify-content: flex-end;
            gap: 15px;
            margin-top: 30px;
        }

        .btn {
            background-color: #7f8c8d;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-weight: 600;
            transition: background-color 0.3s;
        }

        .btn:hover {
            background-color: #10CAB7;
        }

        .btn-primary {
            background-color: #10CAB7;
        }

        .btn-primary:hover {
            background-color: #0fb3a1;
        }

        .btn-secondary {
            background-color: #95a5a6;
        }

        .btn-secondary:hover {
            background-color: #7f8c8d;
        }
    </style>
</head>
<body>
<header>
    <div class="container">
        <div class="header-content">
            <div class="logo">
                <h1>ConstructionPRO</h1>
            </div>
            <nav>
                <ul>
                    <li><a href="#" class="active">Projets</a></li>
                    <li><a href="#">Ressources</a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>

<main>
    <div class="container">
        <section class="form-section">
            <div class="form-header">
                <h2 class="form-title">Ajouter un Nouveau Projet</h2>
            </div>

            <div class="form-container">
                <form action="<%=request.getContextPath()%>/projet/Ajouter" method="post">
                    <div class="form-group">
                        <label for="nom">Nom du Projet</label>
                        <input type="text" id="nom" name="nom" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea id="description" name="description" class="form-control" required></textarea>
                    </div>

                    <div class="form-group">
                        <label for="date_debut">Date de Début</label>
                        <input type="text" id="date_debut" name="date_debut" class="form-control" placeholder="JJ/MM/AAAA" required>
                    </div>

                    <div class="form-group">
                        <label for="date_fin">Date de Fin</label>
                        <input type="text" id="date_fin" name="date_fin" class="form-control" placeholder="JJ/MM/AAAA" required>
                    </div>

                    <div class="form-group">
                        <label for="budget">Budget (€)</label>
                        <input type="number" id="budget" name="budget" class="form-control" min="0" step="0.01" required>
                    </div>

                    <div class="btn-group">
                        <a href="<%=request.getContextPath()%>/projet/Liste" class="btn btn-secondary">Annuler</a>
                        <button type="submit" class="btn btn-primary">Enregistrer</button>
                    </div>
                </form>
            </div>
        </section>
    </div>
</main>
</body>
</html>
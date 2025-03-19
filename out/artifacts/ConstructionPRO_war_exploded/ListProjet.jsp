<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ConstructionXpert Services - Gestion de Projets</title>
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

        .dashboard {
            padding: 30px 0;
        }

        .dashboard-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 30px;
        }

        .dashboard-title {
            font-size: 28px;
            color: #7f8c8d;
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

        /* Tableau des projets - card style removed */
        .projects-table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
        }

        .projects-table th {
            background-color: #10CAB7;
            color: white;
            padding: 12px 15px;
            text-align: left;
        }

        .projects-table tr:nth-child(even) {
            background-color: #f8f9fa;
        }

        .projects-table td {
            padding: 12px 15px;
            border-bottom: 1px solid #ecf0f1;
        }

        .projects-table tr:last-child td {
            border-bottom: none;
        }

        .projects-table tr:hover {
            background-color: #f1f1f1;
        }

        .project-actions {
            display: flex;
            gap: 10px;
        }

        .action-btn {
            padding: 5px 10px;
            border-radius: 4px;
            color: white;
            font-size: 12px;
            text-decoration: none;
            cursor: pointer;
        }

        .edit-btn {
            background-color: #7f8c8d;
        }

        .delete-btn {
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
        <section class="dashboard">
            <div class="dashboard-header">
                <h2 class="dashboard-title">Gestion des Projets</h2>
              <a href="AddProjet.jsp">  <button class="btn" >+ Nouveau Projet</button></a>
            </div>

            <table class="projects-table">
                <thead>
                <tr>
                    <th>Nom </th>
                    <th>Description</th>
                    <th>Date de Debut</th>
                    <th>Date de Fin</th>
                    <th>Budget</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <div class="project-actions">
                            <a href="<%=request.getContextPath()%>/projet/Modifier" class="action-btn edit-btn">Modifier</a>
                            <a href="<%=request.getContextPath()%>/projet/Supprimer" class="action-btn delete-btn">Supprimer</a>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </section>
    </div>
</main>
</body>
</html>
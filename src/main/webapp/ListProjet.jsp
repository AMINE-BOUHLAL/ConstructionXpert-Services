<%@ page import="Model.Projet" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ConstructionXpert Services - Gestion de Projets</title>
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

        .dashboard {
            padding: 50px 0;
        }

        .dashboard-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 30px;
        }

        .dashboard-title {
            font-size: 2rem;
            font-weight: 700;
            color: var(--dark);
        }

        .dashboard-title span {
            color: var(--primary);
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
        }

        .btn:hover {
            background: #0ea896;
        }

        .projects-table {
            width: 100%;
            border-collapse: collapse;
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }

        .projects-table th {
            background: var(--primary);
            color: white;
            padding: 15px 20px;
            text-align: left;
            font-weight: 600;
        }

        .projects-table td {
            padding: 15px 20px;
            color: var(--dark);
            border-bottom: 1px solid var(--light);
        }

        .projects-table tr:last-child td {
            border-bottom: none;
        }

        .projects-table tr:hover {
            background: rgba(16, 202, 183, 0.1);
        }

        .project-actions {
            display: flex;
            gap: 10px;
        }

        .action-btn {
            padding: 8px 15px;
            border-radius: 50px;
            color: white;
            font-size: 0.9rem;
            font-weight: 600;
            text-decoration: none;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        .edit-btn {
            background: var(--primary);
        }

        .edit-btn:hover {
            background: #0ea896;
        }

        .delete-btn {
            background: var(--secondary);
        }

        .delete-btn:hover {
            background: #6c757d;
        }

        .details-btn {
            background: #3498db;
        }

        .details-btn:hover {
            background: #2980b9;
        }

        @media (max-width: 768px) {
            .dashboard-title {
                font-size: 1.5rem;
            }

            .btn {
                padding: 10px 20px;
                font-size: 0.9rem;
            }

            .projects-table th, .projects-table td {
                padding: 10px 15px;
            }

            .action-btn {
                padding: 6px 12px;
                font-size: 0.8rem;
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
                    <a class="nav-link active" href="#">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Projets</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Taches</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Ressources</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<main>
    <div class="container">
        <section class="dashboard">
            <div class="dashboard-header">
                <h2 class="dashboard-title">Gestion des <span>Projets</span></h2>
                <a href="AddProjet.jsp">
                    <button class="btn">+ Nouveau Projet</button>
                </a>
            </div>

            <!-- Affichage du message d'erreur s'il existe -->
            <% if(request.getAttribute("errorMessage") != null) { %>
            <div class="alert alert-danger" role="alert">
                <%= request.getAttribute("errorMessage") %>
            </div>
            <% } %>

            <table class="projects-table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Date de Debut</th>
                    <th>Date de Fin</th>
                    <th>Budget</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody id="project-table">
                <%
                    List<Projet> projets = (List<Projet>) request.getAttribute("projets");
                    if (projets != null) {
                        for (Projet projet : projets) {
                %>
                <tr>
                    <td><%= projet.getIdProjet() %></td>
                    <td><%= projet.getNomProjet() %></td>
                    <td><%= projet.getDescription() %></td>
                    <td><%= projet.getDateDebut() %></td>
                    <td><%= projet.getDateFin() %></td>
                    <td><%= projet.getBudget() %></td>
                    <td class="actions" style="width: 150px;">
                        <div class="project-actions">
                            <a href="<%=request.getContextPath()%>/projet?action=neweditform&idProjet=<%=projet.getIdProjet()%>" class="action-btn edit-btn">Modifier</a>
                            <a href="<%=request.getContextPath()%>/projet?action=deleteprojet&id=<%=projet.getIdProjet()%>" class="action-btn delete-btn">Supprimer</a>
                            <button class="action-btn details-btn">Details</button>
                        </div>
                    </td>
                </tr>
                <% }
                } %>
                </tbody>
            </table>
        </section>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    // JavaScript for "Details" button functionality
    document.querySelectorAll('.details-btn').forEach(button => {
        button.addEventListener('click', function() {
            alert('Détails du projet');
            // Add more functionality here
        });
    });
</script>
</body>
</html>
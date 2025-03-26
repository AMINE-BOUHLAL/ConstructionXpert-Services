<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ProGest - Gestion de Projets</title>
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
            color: #10CAB7;
        }

        .nav-link {
            font-weight: 500;
            color: var(--dark) !important;
            padding: 8px 20px !important;
        }

        .nav-link:hover {
            color: var(--primary) !important;
        }

        .main-content {
            display: flex;
            height: calc(100vh - 76px);
            align-items: center;
            justify-content: space-between;
            padding: 0 50px;
        }

        .image-side img {
            max-width: 80%;
            max-height: 80%;
            border-radius: 20px;
            box-shadow: 0 20px 40px rgba(0,0,0,0.4);
        }

        .content-side {
            max-width: 500px;
        }

        .welcome-text {
            font-size: 0.9rem;
            font-weight: 600;
            color: #10CAB7;
            text-transform: uppercase;
            letter-spacing: 3px;
            margin-bottom: 25px;
        }

        .main-title {
            font-size: 3rem;
            font-weight: 700;
            color: var(--dark);
            margin-bottom: 25px;
        }

        .main-title span {
            color: var(--primary);
        }

        .description {
            color: var(--secondary);
            font-size: 1.1rem;
            margin-bottom: 40px;
        }

        .btn-start {
            background: #10CAB7;
            color: white;
            border: none;
            padding: 16px 45px;
            font-size: 1rem;
            font-weight: 600;
            border-radius: 50px;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        .btn-start:hover {
            background: #0ea896;
        }

        @media (max-width: 992px) {
            .main-content {
                flex-direction: column;
                height: auto;
                padding: 50px 20px;
            }

            .image-side {
                margin-bottom: 50px;
            }

            .main-title {
                font-size: 2.5rem;
            }
        }

        @media (max-width: 576px) {
            .main-title {
                font-size: 2rem;
            }

            .welcome-text {
                font-size: 0.8rem;
            }

            .description {
                font-size: 1rem;
            }

            .btn-start {
                padding: 12px 30px;
                font-size: 0.9rem;
            }
        }
    </style>
</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg">
    <div class="container">
        <a class="navbar-brand" href="#">Construction<span>Xpert</span></a>
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

<!-- Main Content -->
<div class="main-content">
    <!-- Image Side -->
    <div class="image-side">
        <img src="ICON/PIC1.jpeg" alt="Project Management" />
    </div>

    <!-- Content Side -->
    <div class="content-side">
        <p class="welcome-text">Bienvenue sur ProGest</p>
        <h1 class="main-title">Gerez vos <span>projets</span> avec efficacite</h1>
        <p class="description">Une solution simple et intuitive pour organiser, suivre et reussir tous vos projets professionnels. Commencez des maintenant et boostez votre productivite.</p>
        <a href="${pageContext.request.contextPath}/projet?action=list" class="btn btn-start">
            Commencer <i class="fas fa-arrow-right"></i>
        </a>
    </div>
</div>

<!-- Bootstrap JS (for navbar functionality) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
package Controllers;

import DAO.ProjetDao;
import Model.Projet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/projet")
public class ProjetServlet extends HttpServlet {

    private ProjetDao projetDao;

    @Override
    public void init() throws ServletException {
        try {
            projetDao = new ProjetDao();
        } catch (SQLException e) {
            throw new ServletException("Erreur lors de l'initialisation de ProjetDao", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "listprojet";
        }
        switch (action) {
            case "newprojet":
                showNewForm(req, resp);
                break;
            case "neweditform":
                try {
                    showEditForm(req, resp);
                } catch (SQLException e) {
                    throw new ServletException("Erreur lors de l'affichage du formulaire de modification", e);
                }
                break;
            case "createprojet":
                ajoutProjet(req, resp);
                break;
            case "listprojet":
                listProjet(req, resp);
                break;
            case "updateprojet":
                try {
                    updateProjet(req, resp);
                } catch (SQLException e) {
                    throw new ServletException("Erreur lors de la mise à jour du projet", e);
                }
                break;
            case "deleteprojet":
                supprimerProjet(req, resp);
                break;
            default:
                listProjet(req, resp);
                break;
        }
    }

    private void updateProjet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("idProjet"));
        String nomProjet = request.getParameter("nomProjet");
        String description = request.getParameter("description");
        String dateDebut = request.getParameter("dateDebut");
        String dateFin = request.getParameter("dateFin");
        float budget = Float.parseFloat(request.getParameter("budget"));

        Projet projet = new Projet(id, nomProjet, description, dateDebut, dateFin, budget);
        projetDao.updateProjet(projet);
        response.sendRedirect(request.getContextPath() + "/projet?action=listprojet");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String idParam = request.getParameter("idProjet");
        if (idParam == null || idParam.isEmpty()) {
            request.setAttribute("errorMessage", "ID de projet manquant");
            listProjet(request, response);
            return;
        }

        int id = Integer.parseInt(idParam);
        Projet existingProjet = projetDao.getProjet(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditProjet.jsp");
        request.setAttribute("projet", existingProjet);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddProjet.jsp");
        dispatcher.forward(request, response);
    }

    public void ajoutProjet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomProjet = req.getParameter("nomProjet");
        String description = req.getParameter("description");
        String dateDebut = req.getParameter("dateDebut");
        String dateFin = req.getParameter("datefin");
        float budget = Float.parseFloat(req.getParameter("budget"));
        Projet projet = new Projet(nomProjet, description, dateDebut, dateFin, budget);
        projetDao.insertProjet(projet);

        resp.sendRedirect(req.getContextPath() + "/projet?action=listprojet");
    }


    private void listProjet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Projet> projets = projetDao.getAllProjets();
        req.setAttribute("projets", projets);
        RequestDispatcher dispatcher = req.getRequestDispatcher("ListProjet.jsp");
        dispatcher.forward(req, resp);
    }

    private void supprimerProjet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        projetDao.deleteProjet(id);
        resp.sendRedirect(req.getContextPath() + "/projet?action=listprojet");
    }
}
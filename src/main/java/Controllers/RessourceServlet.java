package Controllers;

import DAO.RessourceDAO;
import Model.Ressource;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/ressource")
public class RessourceServlet extends HttpServlet {
    private RessourceDAO ressourceDao;

    @Override
    public void init() throws ServletException {
        try {
            ressourceDao = new RessourceDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
            action = "listressource"; // Action par défaut
        }
        try {
            switch (action) {
                case "newressource":
                    showNewForm(req, resp);
                    break;
                case "neweditform":
                    showEditForm(req, resp);
                    break;
                case "createressource":
                    ajoutRessource(req, resp);
                    break;
                case "listressource":
                    listRessource(req, resp);
                    break;
                case "updateressource":
                    updateRessource(req, resp);
                    break;
                case "deleteressource":
                    supprimerRessource(req, resp);
                    break;
                default:
                    listRessource(req, resp);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException("Erreur de base de données : " + e.getMessage(), e);
        }
    }

    private void updateRessource(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id_ressource"));
        String nom = req.getParameter("nom");
        String type = req.getParameter("type");
        int quantite = Integer.parseInt(req.getParameter("quantite"));
        String fournisseur = req.getParameter("fournisseur");

        Ressource ressource = new Ressource(id, nom, type, quantite, fournisseur);
        ressourceDao.updateRessource(ressource);
        resp.sendRedirect(req.getContextPath() + "/ressource?action=listressource");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_ressource"));
        Ressource existingRessource = ressourceDao.getRessource(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EditRessource.jsp");
        request.setAttribute("ressource", existingRessource);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Addressource.jsp");
        dispatcher.forward(request, response);
    }

    private void ajoutRessource(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String type = req.getParameter("type");
        int quantite = Integer.parseInt(req.getParameter("quantite"));
        String fournisseur = req.getParameter("fournisseur");

        Ressource ressource = new Ressource(0, nom, type, quantite, fournisseur); // ID sera auto-incrémenté
        ressourceDao.createRessource(ressource);
        resp.sendRedirect(req.getContextPath() + "/ressource?action=listressource");
    }

    private void listRessource(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ressource> ressources = ressourceDao.getAllRessources();
        req.setAttribute("ressources", ressources);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/ListRessource.jsp");
        dispatcher.forward(req, resp);
    }

    private void supprimerRessource(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ressourceDao.deleteRessource(id);
        resp.sendRedirect(req.getContextPath() + "/ressource?action=listressource");
    }
}
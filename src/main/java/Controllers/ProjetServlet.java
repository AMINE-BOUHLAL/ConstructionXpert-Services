package Controllers;

import DAO.ProjetDAO;
import Model.Projet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;



@WebServlet("/projet")
public class ProjetServlet  extends HttpServlet {
private ProjetDAO projetDAO ;
@Override
    public void init() {
    projetDAO = new ProjetDAO();
}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) action = "list";
    switch (action) {
                case "Afficher":
                  afficheEditForm(request,response );
                  break;
                case "Ajouter":
                    try {
                        ajouterProjet(request,response );
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "Modifier":
                  modifierProjet(request,response );
                  break;
                case "Supprimer":
                    try {
                        supprimerProjet(request,response );
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
        case "list":
            try {
                listProjets(request,response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}

    public void ajouterProjet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String nom = req.getParameter("nomProjet");
        String description = req.getParameter("description");
        String date_Debut = req.getParameter("date_Debut");
        String date_Fint = req.getParameter("date_fin");
        float budget = Float.parseFloat(req.getParameter("budget"));
        Projet projet = new Projet(nom, description, date_Debut, date_Fint, budget);
        try {
            projetDAO.Ajouter(projet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect(req.getContextPath() + "/projet?action=listprojet");
    }
    private void modifierProjet(HttpServletRequest request, HttpServletResponse response) {
    }

    private void afficheEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Projet projet = ProjetDAO.getProjetById(id);
        request.setAttribute("projet", projet);
        request.getRequestDispatcher("ListProjet.jsp").forward(request, response);
    }

    private void supprimerProjet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    int id = Integer.parseInt(request.getParameter("id"));
    projetDAO.Supprimer(id);
    response.sendRedirect("projet/list");


    }

    private void listProjets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Projet> listProjets = ProjetDAO.Afficher();
        request.setAttribute("listProjets", listProjets);
        request.getRequestDispatcher("listProjet.jsp").forward(request, response);
    }

}


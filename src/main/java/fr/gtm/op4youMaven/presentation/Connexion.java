package fr.gtm.op4youMaven.presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.op4youMaven.domaine.Youtuber;
import fr.gtm.op4youMaven.service.YoutuberService;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/connexion")
public class Connexion extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Connexion() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}
	
	protected void traitement(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Etape 1 : R�cup�ration des param�tres de la requ�te :
		String login = request.getParameter("loginuser");
		String pwd = request.getParameter("mdpuser");

		// Etape 2 : Soumettre les param�tres de la requ�te � la couche service et pr�parer en fonction la r�ponse � envoyer
		RequestDispatcher dispatcher;
		YoutuberService yts = new YoutuberService();
		Youtuber monYoutuber = null;
		
		monYoutuber = yts.authentifier(login, pwd);
		ArrayList<Youtuber> listeYoutuber = yts.getAll();
		
		HttpSession maSession = request.getSession();
		maSession.setAttribute("user", monYoutuber);
		maSession.setAttribute("listeyt", listeYoutuber);
			
		
		if (monYoutuber != null){
		
			dispatcher = request.getRequestDispatcher("Accueil.jsp");
			
		} else {
			dispatcher = request.getRequestDispatcher("error.jsp");
		}

		// Etape 3 : envoyer la R�ponse � l'utilisateur
		dispatcher.forward(request, response);

	}
}

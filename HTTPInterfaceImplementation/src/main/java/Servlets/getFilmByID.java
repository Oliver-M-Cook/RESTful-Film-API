package Servlets;

import models.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class getFilmByID
 * 
 * @author Oliver
 */
@WebServlet("/get-film-by-id")
public class getFilmByID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getFilmByID() {
		super();
	}

	/**
	 * This method sends a request to the filmDAO for a film with
	 * a specified ID, the result is formatted and returned through
	 * the response
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		Film film = null;
		ArrayList<Film> filmList = new ArrayList<Film>();
		int idSearch = Integer.parseInt(request.getParameter("searchText"));

		film = filmDAO.getFilmByID(idSearch);
		filmList.add(film);

		String json = new Gson().toJson(filmList);
		
		if(film == null) {
			System.out.println("No film found with ID: " + idSearch);
		}
		else {
			System.out.println("Film found with ID: " + idSearch);
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

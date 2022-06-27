package Servlets;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import models.FilmDAO;

/**
 * Servlet implementation class deleteFilm
 * 
 * @author Oliver
 */
@WebServlet("/delete-film")
public class deleteFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteFilm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * This method gets the data from the request, formats it and
	 * calls a filmDAO method to delete the requested film
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestData = request.getReader().lines().collect(Collectors.joining());
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		JsonObject jsonData = new Gson().fromJson(requestData, JsonObject.class);
		
		int id = jsonData.get("id").getAsInt();
		int success = filmDAO.deleteFilm(id);
		
		if(success == 1) {
			System.out.println("Successfully deleted film: " + id);
		}
		else {
			System.out.println("Failed to delete film: " + id);
		}
	}
}

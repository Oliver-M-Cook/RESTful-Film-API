package Servlets;

import models.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import com.google.gson.Gson;

/**
 * Servlet implementation class getAllFilms
 * 
 * @author Oliver
 */
@WebServlet("/get-all-films")
public class getAllFilms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getAllFilms() {
		super();
	}

	/**
	 * This method sends a request to the FilmDAO to get all
	 * the films from the database, then formats it into json 
	 * and sends it through the response
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		ArrayList<Film> filmList = new ArrayList<Film>();

		filmList = filmDAO.getAllFilms();
		
		System.out.println(filmList.size() + " films found");

		String json = new Gson().toJson(filmList);

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

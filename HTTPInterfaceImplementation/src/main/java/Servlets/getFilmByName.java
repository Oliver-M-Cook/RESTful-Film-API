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
 * Servlet implementation class getFilmByName
 * 
 * @author Oliver
 */
@WebServlet("/get-film-by-name")
public class getFilmByName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getFilmByName() {
		super();
	}

	/**
	 * This method gets the required data from the request and calls filmDAO
	 * getFilmByName method, formats the result and sends the result through
	 * the response
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		ArrayList<Film> filmList = new ArrayList<Film>();
		String nameSearch = request.getParameter("searchText");

		filmList = filmDAO.getFilmByName(nameSearch);

		String json = new Gson().toJson(filmList);
		
		System.out.println("Searching for films including: " + nameSearch);
		System.out.println(filmList.size() + " films have been matched");

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

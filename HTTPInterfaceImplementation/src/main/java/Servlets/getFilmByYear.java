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
 * Servlet implementation class getFilmByYear
 * 
 * @author Oliver
 */
@WebServlet("/get-film-by-year")
public class getFilmByYear extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getFilmByYear() {
		super();
	}

	/**
	 * This method gets data from the request and calls the filmDAO 
	 * getFilmByYear method, formats the result and returns the result
	 * through the response
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		ArrayList<Film> filmList = new ArrayList<Film>();
		int yearSearch = Integer.parseInt(request.getParameter("searchText"));

		filmList = filmDAO.getFilmByYear(yearSearch);

		String json = new Gson().toJson(filmList);
		
		if(filmList.isEmpty()) {
			System.out.println("No films found in the year: " + yearSearch);
		}
		else {
			System.out.println(filmList.size() + " films found with the year: " + yearSearch);
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

package Servlets;

import models.*;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.*;

/**
 * Servlet implementation class insertFilm
 * 
 * @author Oliver
 */
@WebServlet("/insert-film")
public class insertFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public insertFilm() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * This method gets the data that is sent to the servlet through
	 * the request, formatted into json. A film object is created using
	 * the formatted data, the film object is sent to filmDAO insertFIlm
	 * method
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestData = request.getReader().lines().collect(Collectors.joining());
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		JsonObject jsonData = new Gson().fromJson(requestData, JsonObject.class);

		int id = jsonData.get("id").getAsInt();
		String title = jsonData.get("title").getAsString();
		int year = jsonData.get("year").getAsInt();
		String director = jsonData.get("director").getAsString();
		String stars = jsonData.get("stars").getAsString();
		String review = jsonData.get("review").getAsString();

		Film film = new Film(id, title, year, director, stars, review);

		int success = filmDAO.insertFilm(film);

		if (success == 1) {
			System.out.println("Successfully added film: " + title);
		} else {
			System.out.println("Failed to insert film: " + title);
		}
	}

}

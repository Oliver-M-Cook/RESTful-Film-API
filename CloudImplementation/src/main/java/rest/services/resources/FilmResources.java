package rest.services.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

import rest.services.models.*;

/**
 * The FilmResources class holds all the methods that
 * get, post, put and delete. Jersey is used to make the code
 * more readable 
 * 
 * @author Oliver
 *
 */
@Path("/films")
public class FilmResources {
	
	/**
	 * This method is used when GET is used under the films path is called and the requested format is
	 * either JSON or XML. Jersey converts the result from the DAO into the 
	 * requested type. The GET annotation is used to enforce CRUD
	 * 
	 * @return Film[] This returns an array of films that were returned 
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Film[] getAllFilms(){
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		ArrayList<Film> filmList = new ArrayList<Film>();
		
		filmList = filmDAO.getAllFilms();
		Film[] filmArray = new Film[filmList.size()];
		
		filmList.toArray(filmArray);
		
		System.out.println(filmList.size() + " films found in the database");
		
		return filmArray;
	}
	
	/**
	 * This method is used when GET is used under the films path and the
	 * requested format is string. The method converts the results into 
	 * a string with a unique separator
	 * 
	 * @return String This returns a long string that holds the returned data
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllFilmsAsString() {
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		ArrayList<Film> filmList = new ArrayList<Film>();
		String filmStrings = "";
		
		filmList = filmDAO.getAllFilms();
		
		for(Film film : filmList) {
			filmStrings += film.toString() + "*,*";
		}
		
		System.out.println(filmList.size() + " films found in the database");
		
		return filmStrings;
	}
	
	/**
	 * This method is used when GET is called under film/{id} path and the requested
	 * format is either JSON or XML. 
	 * 
	 * @param id This is ID to be used to get film with a selected ID
	 * @return Film[] This returns an array films from the DAO results
	 */
	@GET
    @Path("film/{id: [0-9]*}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Film[] getFilmByID(@PathParam("id") int id) {
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		Film film = filmDAO.getFilmByID(id);
		
		ArrayList<Film> filmList = new ArrayList<Film>();
		filmList.add(film);
		
		Film[] filmArray = new Film[filmList.size()];
		
		filmList.toArray(filmArray);
		
		if(film == null) {
			System.out.println("Film with ID: " + id + " has not been found");
		}
		else {
			System.out.println("Film with ID: " + id + " has been found");
		}
		
		return filmArray;
	}
	
	/**
	 * This method is used when GET is called under film/{id} path and the requested
	 * format is string, the method converts the result into a string with unique
	 * separator
	 * 
	 * @param id This is the ID to be used to get film with a selected ID
	 * @return String This returns a long string that holds the returned data
	 */
	@GET
	@Path("film/{id: [0-9]*}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFilmByIDAsString(@PathParam("id") int id) {	
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		Film film = filmDAO.getFilmByID(id);
		
		if(film == null) {
			System.out.println("Film with ID: " + id + " has been found");
		}
		else {
			System.out.println("Film with ID: " + id + " has not been found");
		}
		
		return film.toString();
	}
	
	/**
	 * This method is used when GET is used under year/{year} path and the requested
	 * format is either JSON or XML
	 * 
	 * @param year This is the year to be used to get films with the selected year
	 * @return Film[] This returns an array of films from the DAO results
	 */
	@GET
	@Path("year/{year: [0-9]*}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Film[] getFilmByYear(@PathParam("year") int year){
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		ArrayList<Film> filmList = new ArrayList<Film>();
		filmList = filmDAO.getFilmByYear(year);
		
		Film[] filmArray = new Film[filmList.size()];
		
		filmList.toArray(filmArray);
		
		System.out.println(filmList.size() + " films have matched with the year: " + year);
		
		return filmArray;
	}
	
	/**
	 * This method is used when GET is used under the year/{year} path and the requested
	 * format is string, the method converts the results to a string with a unique
	 * separator
	 * 
	 * @param year This is the year to be used to get films with the selected year
	 * @return String This returns a long string that holds the returned data
	 */
	@GET
	@Path("year/{year: [0-9]*}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFilmByYearAsString(@PathParam("year") int year) {
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		ArrayList<Film> filmList = new ArrayList<Film>();
		String filmStrings = "";
		
		filmList = filmDAO.getFilmByYear(year);
		
		for(Film film : filmList) {
			filmStrings += film.toString() + "*,*";
		}
		
		System.out.println(filmList.size() + " films have matched with the year: " + year);
		
		return filmStrings;
	}
	/**
	 * This method is used when GET is used under the films/{name} path and the requested
	 * format is either JSON or XML
	 * 
	 * @param name This is the name to be used to get films that contain name
	 * @return Film[] This returns an array of films from the DAO results 
	 */
	@GET
	@Path("{name}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Film[] getFilmByName(@PathParam("name") String name){
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		ArrayList<Film> filmList = new ArrayList<Film>();
		filmList = filmDAO.getFilmByName(name);
		
		Film[] filmArray = new Film[filmList.size()];
		
		filmList.toArray(filmArray);
		
		System.out.println(filmList.size() + " films matched with the name: " + name);
		
		return filmArray;
	}
	
	/**
	 * This method is used when GET is used under the films/{name} path and the requested
	 * format is string, the method converts the results into a string with a unique 
	 * separator
	 * 
	 * @param name This is the name to be used to get films that contain name
	 * @return String This returns a long string that holds the returned data
	 */
	@GET
	@Path("{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFilmByNameAsString(@PathParam("name") String name) {
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		ArrayList<Film> filmList = new ArrayList<Film>();
		String filmStrings = "";
		
		filmList = filmDAO.getFilmByName(name);
		
		for(Film film : filmList) {
			filmStrings += film.toString() + "*,*";
		}
		
		System.out.println(filmList.size() + " films matched with the name: " + name);
		
		return filmStrings;
	}
	
	/**
	 * This method is used when GET is used under the count path, used
	 * to get the next ID from the database as the database doesn't have 
	 * auto-increment enabled
	 * 
	 * @return String This returns the next ID to be used 
	 */
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getNextID() {
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		int nextID = filmDAO.getNextID();
		String text = "" + nextID;
		
		return text;
	}
	
	/**
	 * This method is used when POST is called under the film path, the method
	 * consumes JSON or XML formats and inserts the film.
	 * 
	 * @param film This is the Film object to be inserted into the database
	 */
	@POST
	@Path("film")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void insertFilm(Film film) {
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		
		int success = filmDAO.insertFilm(film);

		if (success == 1) {
			System.out.println("Successfully added film: " + film.getTitle());
		} else {
			System.out.println("Failed to insert film: " + film.getTitle());
		}
	}
	/**
	 * This method is used when PUT is called under the film path, the method
	 * consumes JSON or XML formats and updates a film
	 * 
	 * @param film This is the Film object to be updated into the database
	 */
	@PUT
	@Path("film")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void updateFilm(Film film) {
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		
		int success = filmDAO.updateFilm(film);
		
		if (success == 1) {
			System.out.println("Successfully updated film: " + film.getTitle());
		} else {
			System.out.println("Failed to update film: " + film.getTitle());
		}
	}
	
	/**
	 * This method is used when DELETE is called under the film path, the method
	 * consumes JSON and calls DAO delete function with given ID
	 * 
	 * @param id This is ID of a film that will be deleted from the database
	 */
	@DELETE
	@Path("film")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteFilm(String id) {
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		
		int success = filmDAO.deleteFilm(Integer.parseInt(id));
		
		if(success == 1) {
			System.out.println("Successfully deleted film: " + id);
		}
		else {
			System.out.println("Failed to delete film: " + id);
		}
	}
}

package rest.services.models;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

/**
 * The FilmDAO holds all the methods that interact
 * with the database, including selects, update, insert
 * and delete.
 * The class also manages the connections to the database
 * by being able to open and close connections when requested
 * 
 * @author Oliver
 */
public class FilmDAO {
	private static FilmDAO filmDAOObject;
	
	private Film film = null;
	private Connection conn = null;
	private Statement statement = null;
	private String endpoint = "enterprisedb.cxqj9xd9wulz.eu-west-2.rds.amazonaws.com";
	private String port = "3306";
	private String dbName = "filmDB";
	private String user = "admin";
	private String password = "adminPassword";
	
	private String url = "jdbc:mysql://" + endpoint + ":" + port + "/" + dbName;
	
	/**
	 * The method gets FilmDAO object if it already
	 * exists or creates a new one.
	 * This method creates a singleton design pattern
	 * as there will only be one FilmDAO object
	 * 
	 * @return FilmDAO This returns the DAO object
	 */
	public static synchronized FilmDAO getFilmDAO() {
		if(filmDAOObject == null) {
			filmDAOObject = new FilmDAO();
		}
		
		return filmDAOObject;
	}
	
	/**
	 * This method creates the connection between the class and MySQL
	 * server with the set login details.
	 * If the login fails an error message will be printed to the console
	 */
	private void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			statement = conn.createStatement();
		}
		catch(SQLException se) {
			System.out.println(se);
		}
	}
	
	/**
	 * This method closes the connection once the program 
	 * is done with the connection to the database
	 */
	private void closeConnection() {
		try {
			conn.close();
		}
		catch(SQLException se) {
			System.out.println(se);
		}
	}
	
	/**
	 * This method gets the film data from row that is passed in,
	 * the method then creates a film object to be returned
	 * 
	 * @param rs This holds a row of results from the query
	 * @return Film This returns a constructed Film object from the results
	 */
	private Film getNextFilm(ResultSet rs) {
		Film film = null;
		try {
			film = new Film(rs.getInt("id"),
							rs.getString("title"),
							rs.getInt("year"),
							rs.getString("director"),
							rs.getString("stars"),
							rs.getString("review"));
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		return film;
	}
	
	/**
	 * This methods runs an SQL query that selects all
	 * the films from the database and returns them in a list
	 *
	 * @return ArrayList<Film> This returns a list of films 
	 */
	public ArrayList<Film> getAllFilms(){
		ArrayList<Film> filmList = new ArrayList<Film>();
		openConnection();
		
		try {
			String selectSQL = "select * from films";
			ResultSet rs = statement.executeQuery(selectSQL);
			
			while(rs.next()) {
				film = getNextFilm(rs);
				filmList.add(film);
			}
			
			statement.close();
			closeConnection();
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		
		return filmList;
	}
	
	/**
	 * This method runs an SQL query that selects a film
	 * with the inputed ID and returns the film object
	 * 
	 * @param id This is the ID that will be used in the query
	 * @return Film This returns a film object
	 */
	public Film getFilmByID(int id) {
		openConnection();
		film = null;
		
		try {
			String selectSQL = "select * from films where id = " + id;
			ResultSet rs = statement.executeQuery(selectSQL);
			
			while(rs.next()) {
				film = getNextFilm(rs);
			}
			
			statement.close();
			closeConnection();
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		
		return film;
	}
	
	/**
	 * This method runs an SQL query that selects all the films
	 * in the database that include the name that was passed through,
	 * the method then returns the processed films as a list
	 * 
	 * @param name This is string that will be used in the query
	 * @return ArrayList<Film> This returns a list of film objects
	 */
	public ArrayList<Film> getFilmByName(String name){
		openConnection();
		ArrayList<Film> filmList = new ArrayList<Film>();
		
		try {
			String selectSQL = "select * from films where title like '%" + name + "%'";
			ResultSet rs = statement.executeQuery(selectSQL);
			
			while(rs.next()) {
				film = getNextFilm(rs);
				filmList.add(film);
			}
			
			statement.close();
			closeConnection();
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		
		return filmList;
	}
	
	/**
	 * This method runs an SQL query that selects all the films
	 * that were released in the passed through year,
	 * the method then returns a list of all the films found
	 * 
	 * @param year This is an int that will be used in the query
	 * @return ArrayList<Film> This returns a list of film objects
	 */
	public ArrayList<Film> getFilmByYear(int year){
		openConnection();
		ArrayList<Film> filmList = new ArrayList<Film>();
		
		try {
			String selectSQL = "select * from films where year = " + year;
			ResultSet rs = statement.executeQuery(selectSQL);
			
			while(rs.next()) {
				film = getNextFilm(rs);
				filmList.add(film);
			}
			
			statement.close();
			closeConnection();
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		
		return filmList;
	}
	
	/**
	 * This method takes a constructed film object, 
	 * inserts the data into the database and returns a 1 or 0
	 * depending on the success of the insertion
	 * 
	 * @param film This is a Film object holds the data for the insert
	 * @return int This returns an integer value depending on the success of the query
	 */
	public int insertFilm(Film film) {
		openConnection();
		
		try {
			String insertSQL = "insert into films values(?,?,?,?,?,?)"; 
			
			PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
			preparedStatement.setInt(1, film.getId());
			preparedStatement.setString(2, film.getTitle());
			preparedStatement.setInt(3, film.getYear());
			preparedStatement.setString(4, film.getDirector());
			preparedStatement.setString(5, film.getStars());
			preparedStatement.setString(6, film.getReview());
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			closeConnection();
			return 1;
		}
		catch(SQLException se) {
			System.out.println(se);
			return 0;
		}
	}
	
	/**
	 * This method takes an ID and runs a query that deletes a film from
	 * the database that has the same ID, the method then returns a 1 or 0
	 * depending on the success of the query
	 * 
	 * @param id This is the ID that will be used when deleting the requested film
	 * @return int This returns an integer value depending on the success of the query
	 */
	public int deleteFilm(int id) {
		openConnection();
		
		try {
			String deleteSQL = "delete from films where id = ?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(deleteSQL);
			
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			closeConnection();
			return 1;
		}
		catch(SQLException se) {
			System.out.println(se);
			return 0;
		}
	}
	
	/**
	 * This method takes a constructed film object and creates an
	 * SQL query that will update an existing film with new data,
	 * the method then returns a 1 or 0 depending on the success of the query
	 * 
	 * @param film This is Film object that is used to the update a film
	 * @return int This returns an integer value depending on the success of the query
	 */
	public int updateFilm(Film film) {
		openConnection();
		
		try {
			String updateSQL = "update films set title = ?, year = ?, director = ?, stars = ?, review = ? where id = ?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(updateSQL);
			
			preparedStatement.setString(1, film.getTitle());
			preparedStatement.setInt(2, film.getYear());
			preparedStatement.setString(3, film.getDirector());
			preparedStatement.setString(4, film.getStars());
			preparedStatement.setString(5, film.getReview());
			preparedStatement.setInt(6, film.getId());
			
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			closeConnection();
			return 1;
		}
		catch(SQLException se){
			System.out.println(se);
			return 0;
		}
	}
	
	/**
	 * This method runs an SQL query that selects the max ID
	 * from the database and returns the value to where the
	 * method was called
	 * 
	 * @return int This returns the next ID in the database
	 */
	public int getNextID() {
		openConnection();
		
		try {
			String selectSQL = "select max(id) as maxID from films";	
			PreparedStatement preparedStatement;
			ResultSet rs;
			int nextID = -1;
			preparedStatement = conn.prepareStatement(selectSQL);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
			    nextID = rs.getInt("maxID") + 1;
			}
			
			statement.close();
			closeConnection();
			
			return nextID;
		}
		catch(SQLException se) {
			System.out.println(se);
			return -1;
		}
	}
	
	private FilmDAO() {}
}

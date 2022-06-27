package models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Film class holds the getters and setters
 * as well as an overridden toString function that 
 * formats the film data
 *  
 * @author Oliver
 */
@XmlRootElement
public class Film {
	private int id;
	private String title;
	private int year;
	private String director;
	private String stars;
	private String review;
	
	/**
	 * This method gets the ID from the class
	 * and returns to where the method was called
	 * 
	 * @return int This returns the ID of the film object
	 */
	@XmlElement
	public int getId() {
		return id;
	}
	
	/**
	 * This method sets the ID to the class variable
	 * 
	 * @param id This is ID to be set in the film class
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This method gets the title from the class
	 * and returns to where the method was called
	 * 
	 * @return String This returns the title of the film object
	 */
	@XmlElement
	public String getTitle() {
		return title;
	}
	
	/**
	 * This method sets the title to the class variable
	 * 
	 * @param title This is the title to be set in the film class
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * This method gets the year from the class
	 * and returns to where the method was called
	 * 
	 * @return int This returns the year of the film object
	 */
	@XmlElement
	public int getYear() {
		return year;
	}
	
	/**
	 * This method sets the year to the class variable
	 * 
	 * @param year This is the year to be set in the film class
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * This method gets the director from the class
	 * and returns to where the method was called
	 * 
	 * @return String This returns the director of the film object
	 */
	@XmlElement
	public String getDirector() {
		return director;
	}
	
	/**
	 * This method sets the director to the class variable
	 * 
	 * @param director This is the director to be set in the film class
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	
	/**
	 * This method gets the stars from the class
	 * and returns to where the method was called
	 * 
	 * @return String This returns the stars of the film object
	 */
	@XmlElement
	public String getStars() {
		return stars;
	}
	
	/**
	 * This method sets the stars to the class variable
	 * 
	 * @param stars This is the stars to be set in the film class
	 */
	public void setStars(String stars) {
		this.stars = stars;
	}
	
	/**
	 * This method gets the review from the class
	 * and returns to where the method was called
	 * 
	 * @return String This returns the review of the film object
	 */
	@XmlElement
	public String getReview() {
		return review;
	}
	
	/**
	 * This method sets the review to the class variable
	 * 
	 * @param review This is the review to be set in the film class
	 */
	public void setReview(String review) {
		this.review = review;
	}
	
	@Override
	public String toString() {
		return "Film [id = " + id + ", title = " + title + ", year = " + year + ", director = " + director
				+ ", stars = " + stars + ", review = " + review + "]";
	}

	public Film() {
	}

	public Film(int id, String title, int year, String director, String stars, String review) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.director = director;
		this.stars = stars;
		this.review = review;
	}
}

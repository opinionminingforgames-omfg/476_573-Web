import java.util.ArrayList;

public class Game {
	
	private String name;
	private String genres;
	ArrayList<Comment> comments;
	private double rating;
	private String content;
	
	public Game() { }
	
	public Game(String n, String g, double r, String con) {
		
		setName(n);
		setGenres(g);
		comments = new ArrayList<Comment>();
		setRating(r);
		setContent(con);
	}

	public String getContent() {
		return content;
	}

	private void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public String getGenres() {
		return genres;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public double getRating() {
		return rating;
	}

	private void setName(String names) {
		this.name = names;
	}

	private void setGenres(String genres) {
		this.genres = genres;
	}
	
	private void setRating(double rating) {
		this.rating = rating;
	}
}

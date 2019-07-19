
public class Game {
	
	String name;
	String genres;
	String comments;
	double rating;
	
	public Game() { }
	
	public Game(String n, String g, String c, double r) {
		
		setName(n);
		setGenres(g);
		setComments(c);
		setRating(r);
	}

	public String getName() {
		return name;
	}

	public String getGenres() {
		return genres;
	}

	public String getComments() {
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

	private void setComments(String comments) {
		this.comments = comments;
	}

	private void setRating(double rating) {
		this.rating = rating;
	}
}

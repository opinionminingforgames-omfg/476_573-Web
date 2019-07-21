import java.util.ArrayList;

public class Comment {
	
	private String ofGame;
	private String owner;
	private String content;
	
	public Comment() { }
	
	public Comment(String og, String o, String c) {

		setOfGame(og);
		setOwner(o);
		setContent(c);
	}

	public String getOfGame() {
		return ofGame;
	}

	public String getOwner() {
		return owner;
	}

	public String getContent() {
		return content;
	}

	public void setOfGame(String ofGame) {
		this.ofGame = ofGame;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public ArrayList<Comment> takeCom(String c, String g, String u) {
		
		ArrayList<Comment> co = new ArrayList<Comment>();
		String com;
		Comment tmp;
		while(c.indexOf(",") > 0) {
			
			com = c.substring(0, c.indexOf(","));
			c = c.substring(c.indexOf(",") +2);
		    tmp = new Comment(g, u, com);
		    co.add(tmp);
		}
		tmp = new Comment(g, u, c);
		co.add(tmp);
		return co;
	}
}

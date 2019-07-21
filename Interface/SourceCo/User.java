import java.util.ArrayList;

public class User {
	
	private String uname;
	private String pswd;
	private String interest;
    ArrayList<Comment> comments;
	
	public User() {}
	public User(String u, String p, String i) {
		
		setUname(u);
		setPswd(p);
		setInterest(i);
		comments = new ArrayList<Comment>();
	}
	public ArrayList<Comment> getComments() {
		return comments;
	}
	public String getInterest() {
		return interest;
	}
	private void setInterest(String interest) {
		this.interest = interest;
	}
	public String getUname() {
		return uname;
	}
	public String getPswd() {
		return pswd;
	}
	private void setUname(String uname) {
		this.uname = uname;
	}
	private void setPswd(String pswd) {
		this.pswd = pswd;
	}
}

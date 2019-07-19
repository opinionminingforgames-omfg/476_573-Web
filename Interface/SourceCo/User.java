
public class User {
	
	String uname;
	String pswd;
	
	public User() {}
	public User(String u, String p) {
		setUname(u);
		setPswd(p);
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

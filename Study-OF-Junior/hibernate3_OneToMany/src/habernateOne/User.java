package habernateOne;

public class User {
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", id=" + id + "]";
	}
	private  String  username;
	private String password;
	private int id;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}

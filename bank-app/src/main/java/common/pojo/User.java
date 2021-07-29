package common.pojo;

public class User {

	private String name;
	private String username;
	private String password;
	private int id;
	//no setter for this we don't want this to be changed unless we're creating
	//a new user....	
	private static int idCtr = 1;
	
	public User(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.id = idCtr;
		//this ensures that each id will be unique
		idCtr++;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		//need security here
		return username;
	}
	public void setUserName(String username) {
		//need security here
		this.username = username;
	}
	public String getPassword() {
		//TODO: Need some security here
		return password;
	}
	public void setPassword(String password) {
		//TODO: Need some security here
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}

	
	
}

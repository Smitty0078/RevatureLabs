package common.pojo;

public abstract class Account {

	private String name;
	private String username;
	private String password;
	private int id;
	
	
	public Account(String name, String username, String password, int id) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
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
		return "Account [name=" + name + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
}

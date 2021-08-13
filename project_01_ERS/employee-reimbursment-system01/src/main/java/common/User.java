package common;

//import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="employee")
public class User {//implements Serializable{

	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String username;
	@Column
	private String password;
	@Column (name = "is_admin")
	private boolean isAdmin;
	
	public User(int id, String name, String username, String password, boolean isAdmin) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	public User() {}

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

	


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", isAdmin="
				+ isAdmin + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && isAdmin == other.isAdmin && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	
}

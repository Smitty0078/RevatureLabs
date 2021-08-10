import java.util.Objects;

public class PwdEncription {

	private String password;
	
	
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public int hashCode() {
		return Objects.hash(password);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PwdEncription other = (PwdEncription) obj;
		return Objects.equals(password, other.password);
	}


	public static void main(String[] args) {
		
		
		PwdEncription p = new PwdEncription();
		
		p.setPassword("password");
		
		System.out.println(p.getPassword());
		
		//p.hashCode();
		
		System.out.println(p.getPassword());
		
		
	}
	
}


public class Constructors {
	
	public Constructors()
	{
		System.out.println("default constructor ran");
	}
	
	public Constructors(int value)
	{
		System.out.println(value);
	}
	

	public static void main(String[] args) {
		Constructors c = new Constructors(5839);
		
		Constructors cNoArg = new Constructors();
		

	}

}

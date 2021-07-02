
public class OverloadedMethods {

	public static void main(String[] args) {
		OverloadedMethods om = new OverloadedMethods();
		om.print();
		om.print("second print method");
		om.print("second", "third");
	}
	
	public void print()
	{
		System.out.println("original print method");
	}
	
	public void print(String str)
	{
		System.out.println(str);
	}
	
	public void print(String str, String str2)
	{
		System.out.println(str + " " + str2);
	}
	
	/*
	 * this doesnt work
	public void print(String str, String str2)
	{
		System.out.println(str + " " + str2);
	}
	*/

}


public class ExampleOne {
	public static void main(String[] args)
	{
		int i = 5;
		ExampleOne e = new ExampleOne();
		System.out.println(e.factorial(i));
		
		
	}
	
	public int factorial(int num)
	{
		if (num <= 0)
		{
			return 0;
		}
		
		if(num == 1)
		{
			return 1;
		}
		
		return num * factorial(num-1);
	}
}

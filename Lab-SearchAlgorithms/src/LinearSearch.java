
public class LinearSearch {

	public static void main(String[] args) {
		char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
						  'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r','s', 't', 
						  'u', 'v', 'w', 'x', 'y', 'z'};
		LinearSearch ls = new LinearSearch();
		char letter = 'm';
		int result = ls.findLetter(letter, letters);
		System.out.println(result);
		
		char[] arr = {};
		result = ls.findLetter(letter, arr);
		System.out.println(result);
		

	}
	
	public int findLetter(char target, char[] data)
	{
		if(data == null)
		{
			return -1;
		}
		
		for(int i = 0; i < data.length; i++)
		{
			if(data[i] == target)
			{
				return i;
			}
		}
		
		return -1;
	}

}

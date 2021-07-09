package fixtures;

public class Chair extends RoomItem implements Interactable {

	public Chair(String name, String shortDesc, String longDesc) 
	{
		super(name, shortDesc, longDesc);
	}

	@Override
	public void interact1()
	{
		//Sitting
		System.out.println("You sit in the chair...");
		
	}

	@Override
	public void interact2() 
	{
		//Stop sitting
		System.out.println("You stop sitting in the chair...");
		
	}
	
	

	
	
}

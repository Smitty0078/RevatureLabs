package fixtures;

public class Chair extends RoomItem implements Interactable {

	public Chair(String name, String shortDesc, String longDesc) 
	{
		super(name, shortDesc, longDesc);
	}

	@Override
	public void interact()
	{
		//Sitting
		System.out.println("Sitting in the chair...");
		
	}
	
	

	
	
}

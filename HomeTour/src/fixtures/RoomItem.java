package fixtures;

public class RoomItem extends Fixtures implements Interactable {


	public RoomItem(String name, String shortDesc, String longDesc) 
	{
		super(name, shortDesc, longDesc);
	}

	@Override
	public void interact1() {}

	@Override
	public void interact2() {}
	
	

}

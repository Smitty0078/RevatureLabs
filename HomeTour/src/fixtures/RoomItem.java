package fixtures;

//room item extends fixtures uses interactable
public class RoomItem extends Fixtures implements Interactable {

	//Parameterized constructor
	public RoomItem(String name, String shortDesc, String longDesc) 
	{
		super(name, shortDesc, longDesc);
	}

	//interact method specified at lower level
	@Override
	public void interact() {}

}

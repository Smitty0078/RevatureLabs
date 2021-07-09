package fixtures;

public class Table extends RoomItem implements Interactable {

	public Table(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void interact1() 
	{
		System.out.println("looks at the table");
		
	}

	@Override
	public void interact2() {
		//not needed for this object
		
	}

	
}

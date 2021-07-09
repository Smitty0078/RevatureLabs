package fixtures;

public class Desk extends RoomItem implements Interactable{

	public Desk(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void interact() {
		// TODO Auto-generated method stub
		System.out.println("I should probably start my Home tour project..... Nahhhh, opens steam xD");
	}
	
	

}

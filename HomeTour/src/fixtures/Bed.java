package fixtures;

public class Bed extends RoomItem implements Interactable{

	public Bed(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
	}

	@Override
	public void interact() {
		System.out.println("Laying on the bed.... Very comfy!");
	}
	
	
	
	

}

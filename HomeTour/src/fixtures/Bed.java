package fixtures;

public class Bed extends RoomItem implements Interactable{

	public Bed() {
		super("Bed", "Big Bed", "Big Comfy Bed");
	}

	@Override
	public void interact() {
		System.out.println("Laying on the bed.... Very comfy!");
	}
	
	
	
	

}

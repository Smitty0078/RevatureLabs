package fixtures;

public class SwimmingPool extends RoomItem implements Interactable {

	public SwimmingPool(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
	}

	@Override
	public void interact() {
		System.out.println("Finally, its warm enough out to enjoy the pool! CANNON BALL!!!! SPLASH!!!!");
	}
	
	

	
	
}

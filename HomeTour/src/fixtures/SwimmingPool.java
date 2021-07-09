package fixtures;

public class SwimmingPool extends RoomItem implements Interactable {

	public SwimmingPool() {
		super("Swimming Pool", "large swimming pool", "20 foot in-ground pool with tanning deck and swim up tiki bar. :)");
	}

	@Override
	public void interact() {
		System.out.println("Finally, its warm enough out to enjoy the pool! CANNON BALL!!!! SPLASH!!!!");
	}
	
	

	
	
}

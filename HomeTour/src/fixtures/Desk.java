package fixtures;

public class Desk extends RoomItem implements Interactable{

	public Desk() {
		super("Computer Desk", "Duel Monitor Gaming Desk", 
			  "Professional streamer setup complete with triple monitors, and stacked empty cans of mountain dew.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void interact() {
		// TODO Auto-generated method stub
		System.out.println("I should probably start my Home tour project..... Nahhhh, opens steam xD");
	}
	
	

}

package fixtures;

public class Television extends RoomItem implements Interactable{

	public Television() {
		super("Television", "Big Television", "80 inch 4k hd curved tv");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void interact() {
		System.out.println("Lets take a break from the home tour project and watch some Invincible... :)");
	}
	
	

}

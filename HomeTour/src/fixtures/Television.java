package fixtures;

public class Television extends RoomItem implements Interactable{

	public Television(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);

	}

	@Override
	public void interact() {
		System.out.println("Lets take a break from the home tour project and watch some Invincible... :)");
	}
	
	

}

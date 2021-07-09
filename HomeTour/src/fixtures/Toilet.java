package fixtures;

public class Toilet extends RoomItem implements Interactable {

	public Toilet(String name, String shortDesc, String longDesc) {
		super("Toilet", "White Toilet", "Clean White Toilet");
		
	}
	
	@Override
	public void interact() {
		System.out.println("Flushhhhhhh......");
	}

}

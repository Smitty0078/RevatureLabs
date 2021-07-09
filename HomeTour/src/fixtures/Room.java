package fixtures;

//Subclass of Fixtures
public class Room extends Fixtures {

	private RoomItem[] items = new RoomItem[2]; //holds all intractable items
	private Room[] exits = new Room[4]; //holds all adjacent rooms
	
	//Parameterized constructor
	public Room(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
		
	}
	
	//used for debugging
	public void printExits()
	{
		System.out.println("Room name: "+getName());
		if(exits[0]!=null) System.out.println("North room = "+exits[0].getName());
		else System.out.println("No rooms to the north");
		
		if(exits[1]!=null) System.out.println("South room = "+exits[1].getName());
		else System.out.println("No rooms to the South");
		
		if(exits[2]!=null) System.out.println("East room = "+exits[2].getName());
		else System.out.println("No rooms to the East");
		
		if(exits[3]!=null) System.out.println("West room = "+exits[3].getName());
		else System.out.println("No rooms to the West");
		
		
	}

	//getter for exits array
	public Room[] getAllExits()
	{
		return exits;
	}
	//getter to get a specific adjacent room based on its index or direction
	public Room getSpecificExit(int index) {
		return exits[index];
	}

	//setter to create array of adjacent rooms
	//kind of not needed...
	public void setAllExits(Room[] r)
	{
		this.exits = r;
	}
	
	//setter to set a specific room at a specific index
	public void setSpecificExit(int index, Room r) {
		this.exits[index] = r;
	}

	//gets an intractable item at given index
	public RoomItem getItems(int index) 
	{
		return items[index];
	}

	//sets an intractable item at given index
	public void setItems(int index, RoomItem item) 
	{
		this.items[index] = item;
	}
	
	


}

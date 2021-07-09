package fixtures;

public class Room extends Fixtures {

	private RoomItem[] items;
	private Room[] exits = new Room[4];
	
	
	public Room(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
		
	}
	
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

	public Room[] getAllExits()
	{
		return exits;
	}
	
	public Room getSpecificExit(int index) {
		return exits[index];
	}
	
	public Room getExit(String direction)
	{
		//implement this;
		return exits[0];
	}


	public void setAllExits(Room[] r)
	{
		this.exits = r;
	}
	
	public void setSpecificExit(int index, Room r) {
		//System.out.println("here");
		this.exits[index] = r;
	}


	public RoomItem getItems(int index) 
	{
		return items[index];
	}

	public void setItems(int index, RoomItem item) 
	{
		this.items[index] = item;
	}


}

package game;

import java.util.Arrays;

import fixtures.*;

public class RoomManager {

	private Room startingRoom; //used to keep track of where to start I have this hard coded for now
	private Room [] rooms = new Room[14]; // used to hold rooms in the house also hard coded
	
	//getter for starting room
	public Room getStartingRoom() {
		return startingRoom;
	}
	//setter for starting room
	public void setStartingRoom(Room r)
	{
		startingRoom = r;
	}
	//getter for rooms[]
	public Room[] getRooms() {
		return rooms;
	}
	//getter for a specific room given its index
	public Room getSpecificRoom(int index)
	{
		return rooms[index];
	}
	//setter for rooms given an array of rooms
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
	
	//toString uses for debugging
	@Override
	public String toString() {
		return "RoomManager [rooms=" + Arrays.toString(rooms) + "]";
	}

	//used to populate rooms as well as exits, and items.
	//Not very efficient but it is what it is
	public void init()
	{
		
		//hard code each room initializing them.
		Room frontPorch = new Room(
				"Front Porch",
				"You stand on an enclosed porch.",
				"To the south, there is a white door that leads to a big open hallway."
				);
		
		Room hallway = new Room(
				"Hallway",
				"Large Open Hallway",
				"To the south of the hallway the kitchen is within view. "
		  +'\n'+"To the west of the hallway there is a fine diningroom."
		  +'\n'+"To the east of the hallway there is a small foyer to welcome guests."
		  +'\n'+"To the north of the hallway you can see the front door leading out to the front porch."
				);
		
		Room bathroom = new Room(
				"Bathroom",
				"Small bathroom with a <TOILET> and a shower.",
				"Private bathroom with only one door, to the south, leading to the Foyer."
				);
		
		Room diningroom = new Room(
				"Dining Room",
				"Fancy dining room table and <CHAIR>s.",
				"A large fancy wood table is in the middle of the room"
		 +'\n'+ "with many chairs surrounding it. To the south you can see the office"
		 +'\n'+ "where there is a computer desk. To the east you see a large open hallway."
				);
		
		Room foyer = new Room(
				"Foyer",
				"Small room used to welcome guests.",
				"To the north there is a door to the bathroom."
		  +'\n'+"To the east there is a bedroom with a large bed inside."
		  +'\n'+"To the west there is a large open hallway."
				);
		
		Room bedroom = new Room(
				"Bedroom",
				"Large bedroom with a large comfortable <BED> inside.",
				"To the west there is a small foyer."
				);
		
		Room garage = new Room(
				"Garage",
				"A large garage big enough for two cars.",
				"To the south there is a door leading into the family room."
				);
		
		Room office = new Room(
				"Office",
				"There is a large computer <DESK> here with other office supplies.",
				"To the north you can see into the dining room."
		  +'\n'+"To the east you can see into the kitchen."
				);
		
		Room kitchen = new Room(
				"Kitchen",
				"Large kitchen with modern appliances and black granite counter tops.",
				"To the north, you can see a large open hallway. To the west you"
		  +'\n'+"can see a small table and chairs for less fancy dining. To"
		  +'\n'+"the east you can see into the office."
				);
		
		Room dinette = new Room(
				"Dinette",
				"A small kitchen table and chairs for everyday meals.",
				"To the south there is a small storage closet. To the east you"
		  +'\n'+"can see clearly into the kitchen. To the west you can see"
		  +'\n'+"clearly into the family room."
				);
		
		Room familyRoom = new Room(
				"Family Room",
				"A large room with several comfortable couches and reclining chairs with a giant <TELEVISION>"
		  +'\n'+"in the middle of the north wall.",
				"Next to the tv to the north there is a door that leads to a large garage. To the west you can"
		  +'\n'+"see into the dinette. To the south there is a door leading to the back porch."
				);
		
		Room closet = new Room(
				"Closet",
				"Small storage closet with cleaning supplies",
				"To the north there is a small dinette for everyday meals."
				);
		
		Room backPorch = new Room(
				"Back Porch",
				"An enclosed porch with several lounge chairs and tables.",
				"To the south there is a door leading out to the back yard. You"
		  +'\n'+"can see a large swimming pool."
				);
		
		Room backYard = new Room(
				"Backyard",
				"A large back yard with a large <SWIMMING POOL>, a small pond, a tiki bar,"
		  +'\n'+"a fire pit, and a small table with chairs to eat.",
				"To the north you can see the enterance to the back porch."
				);
		
		
		//This sets up the adjacent rooms for each room
		//I used a Room[4] array with 0->NORTH, 1->SOUTH, 2->EAST, AND 3->WEST
		//This set up exits method helped make it a little less tedious for me
		setUpExits(frontPorch, null, hallway, null, null);
		rooms[0] = frontPorch;
		setStartingRoom(rooms[0]);
		
		setUpExits(hallway, frontPorch, kitchen, foyer, diningroom);
		rooms[1] = hallway;
		
		setUpExits(bathroom, null, foyer, null, null);
		//this is where I populate the intractable items within the Room class (item[])
		//I had bigger ambitions to populate the rooms with more items but there just 
		//wasn't enough time for me to reach my goals.
		RoomItem toilet = new Toilet("toilet", "short", "long");
		bathroom.setItems(0, toilet);
		rooms[2] = bathroom;
		
		
		setUpExits(diningroom, null, office, hallway, null);
		RoomItem chair = new Chair("chair", "short", "long");
		diningroom.setItems(0, chair);
		rooms[3] = diningroom;
		
		setUpExits(foyer, bathroom, null, bedroom, hallway);
		rooms[4] = foyer;
		
		setUpExits(bedroom, null, null, null, foyer);
		RoomItem bed = new Bed("bed", "short", "long");
		bedroom.setItems(0, bed);
		rooms[5] = bedroom;
		
		setUpExits(garage, null, familyRoom, null, null);
		rooms[6] = garage;
		
		setUpExits(office, diningroom, null, kitchen, null);
		RoomItem desk = new Desk("Computer Desk", "Duel Monitor Gaming Desk", 
				  "Professional streamer setup complete with triple monitors, and stacked empty cans of mountain dew.");
		office.setItems(0, desk);
		rooms[7] = office;
		
		setUpExits(kitchen, hallway, null, dinette, office);
		rooms[8] = kitchen;
		
		setUpExits(dinette, null, closet, familyRoom, kitchen);
		rooms[9] = dinette;
		
		setUpExits(familyRoom, garage, backPorch, null, dinette);
		RoomItem tv = new Television("Television", "Big Television", "80 inch 4k hd curved tv");
		familyRoom.setItems(0, tv);
		rooms[10] = familyRoom;
		
		setUpExits(closet, dinette, null, null, null);
		rooms[11] = closet;
		
		setUpExits(backPorch, familyRoom, backYard, null, null);
		rooms[12] = backPorch;
		
		setUpExits(backYard, backPorch, null, null, null);
		RoomItem pool = new SwimmingPool("Swimming Pool", "large swimming pool", "20 foot in-ground pool with tanning deck and swim up tiki bar. :)");
		backYard.setItems(0, pool);
		rooms[13] = backYard;
		
		
		
		
	}
	
	//helper method to filling adjacent rooms array exits
	public void setUpExits(Room room, Room northRoom, Room southRoom, Room eastRoom, Room westRoom)
	{
		room.setSpecificExit(0, northRoom); 
		room.setSpecificExit(1, southRoom);
		room.setSpecificExit(2, eastRoom);
		room.setSpecificExit(3, westRoom);
	}
	
	
	
}

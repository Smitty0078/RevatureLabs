package game;

import java.util.Arrays;

import fixtures.*;

public class RoomManager {

	private final Room startingRoom;
	private Room [] rooms = new Room[14];
	
	public RoomManager(Room r)
	{
		this.startingRoom = r;
	}
	
	public Room getStartingRoom() {
		return startingRoom;
	}

	public Room[] getRooms() {
		return rooms;
	}
	
	public Room getSpecificRoom(int index)
	{
		return rooms[index];
	}
	
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
	
	@Override
	public String toString() {
		return "RoomManager [rooms=" + Arrays.toString(rooms) + "]";
	}

	public void init()
	{
		Room frontPorch = new Room(
				"Front Porch",
				"You stand on an enclosed porch.",
				"To the south, there is a white <DOOR> that leads to a big open hallway."
				);
		
		Room hallway = new Room(
				"Hallway",
				"Short desc",
				"Long desc"
				);
		
		Room bathroom = new Room(
				"Bathroom",
				"Short desc",
				"Long desc"
				);
		
		Room diningroom = new Room(
				"Dining Room",
				"Short desc",
				"Long desc"
				);
		
		Room foyer = new Room(
				"Foyer",
				"Short desc",
				"Long desc"
				);
		
		Room bedroom = new Room(
				"Bedroom",
				"Short desc",
				"Long desc"
				);
		
		Room garage = new Room(
				"Garage",
				"Short desc",
				"Long desc"
				);
		
		Room office = new Room(
				"Office",
				"Short desc",
				"Long desc"
				);
		
		Room kitchen = new Room(
				"Kitchen",
				"Short desc",
				"Long desc"
				);
		
		Room dinette = new Room(
				"Dinette",
				"Short desc",
				"Long desc"
				);
		
		Room familyRoom = new Room(
				"Family Room",
				"Short desc",
				"Long desc"
				);
		
		Room closet = new Room(
				"Closet",
				"Short desc",
				"Long desc"
				);
		
		Room backPorch = new Room(
				"Back Porch",
				"Short desc",
				"Long desc"
				);
		
		Room backYard = new Room(
				"Backyard",
				"Short desc",
				"Long desc"
				);
		
		setUpExits(frontPorch, null, hallway, null, null);
		rooms[0] = frontPorch;
		
		setUpExits(hallway, frontPorch, kitchen, foyer, diningroom);
		rooms[1] = hallway;
		
		setUpExits(bathroom, null, foyer, null, null);
		rooms[2] = bathroom;
		
		setUpExits(diningroom, null, office, hallway, null);
		rooms[3] = diningroom;
		
		setUpExits(foyer, bathroom, null, bedroom, hallway);
		rooms[4] = foyer;
		
		setUpExits(bedroom, null, null, null, foyer);
		rooms[5] = bedroom;
		
		setUpExits(garage, null, familyRoom, null, null);
		rooms[6] = garage;
		
		setUpExits(office, diningroom, null, kitchen, null);
		rooms[7] = office;
		
		setUpExits(kitchen, hallway, null, dinette, office);
		rooms[8] = kitchen;
		
		setUpExits(dinette, null, closet, familyRoom, kitchen);
		rooms[9] = dinette;
		
		setUpExits(familyRoom, garage, backPorch, null, dinette);
		rooms[10] = familyRoom;
		
		setUpExits(closet, dinette, null, null, null);
		rooms[11] = closet;
		
		setUpExits(backPorch, familyRoom, backYard, null, null);
		rooms[12] = backPorch;
		
		setUpExits(backYard, backPorch, null, null, null);
		rooms[13] = backYard;
		
		
		
		
	}
	
	public void setUpExits(Room room, Room northRoom, Room southRoom, Room eastRoom, Room westRoom)
	{
		room.setSpecificExit(0, northRoom); 
		room.setSpecificExit(1, southRoom);
		room.setSpecificExit(2, eastRoom);
		room.setSpecificExit(3, westRoom);
	}
	
	
	
}

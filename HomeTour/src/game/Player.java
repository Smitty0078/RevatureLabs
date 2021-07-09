package game;

import fixtures.*;

public class Player {
	//gives current room
	private Room currentRoom;
	//getter
	public Room getCurrentRoom() {
		return currentRoom;
	}
	//setter
	public void setCurrentRoom(Room r) {
		this.currentRoom = r;
	}
	//printer used for debugging
	public void printCurrentRoom()
	{
		System.out.println("Current Room: "+currentRoom.getName()+'\n'
										   +currentRoom.getShortDesc()+'\n'
										   +currentRoom.getLongDesc());
		
	}

	//used for debugging
	@Override
	public String toString() {
		return "Player [currentRoom=" + currentRoom + "]";
	}
	
	
	
}

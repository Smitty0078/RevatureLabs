package game;

import fixtures.*;

public class Player {
	private Room currentRoom;

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room r) {
		this.currentRoom = r;
	}
	
	public void printCurrentRoom()
	{
		System.out.println("Current Room: "+currentRoom.getName()+'\n'
										   +currentRoom.getShortDesc()+'\n'
										   +currentRoom.getLongDesc());
		
	}

	@Override
	public String toString() {
		return "Player [currentRoom=" + currentRoom + "]";
	}
	
	
	
}

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

	@Override
	public String toString() {
		return "Player [currentRoom=" + currentRoom + "]";
	}
	
	
	
}

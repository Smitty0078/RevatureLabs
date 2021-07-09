package game;

import fixtures.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		boolean continueGame = true;
		Scanner scan = new Scanner(System.in);
		Room startingRoom = new Room("Porch", "Front Porch", "Enterance of house");
		RoomManager roomManager = new RoomManager(startingRoom);
		Player player = new Player();
		roomManager.init();
		player.setCurrentRoom(roomManager.getSpecificRoom(0));
		
		
		printGreeting();
		
		while(continueGame)
		{
			player.printCurrentRoom();	
			collectInput(scan);
			
			continueGame = false;
		}
		
		scan.close();
	}
	
	
	private static void printGreeting()
	{
		System.out.println(
				"Welcome to Michael Smith's Virtual Home Tour!"+'\n'
				+"Explore this one bedroom ranch home using the following commands:"+'\n'
				+"GO or MOVE + DIRECTION (GO NORTH or MOVE WEST)"+'\n'
				+"Some rooms will have items you can interact with the following commands:"+'\n'
				+"INTERACT + ITEMNAME (INTERACT CHAIR)"+'\n'
				+"Interactable items will be denoted in the description as such:"+'\n'
				+"<ITEM_NAME>"+'\n'
				);
	}
	private static String[] collectInput(Scanner scan) 
	{
		String[] line;
		//line = scan.split();
		
		
		return null;
	}
		
	
}

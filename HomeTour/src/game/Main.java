package game;

import fixtures.*;
import java.util.Scanner;

public class Main {

	//loop control variable
	private static boolean continueGame = true;
	
	//Getter for loop control variable
	public static boolean getContinueGame()
	{
		return continueGame;
	}
	
	//Setter for loop control variable
	public static void setContinueGame(boolean b)
	{
		continueGame = b;
	}
	
	
	
	public static void main(String[] args) 
	{
		
		//initialization of variables
		String[] input;
		Scanner scan = new Scanner(System.in);
		RoomManager roomManager = new RoomManager();
		Player player = new Player();
		//used to populate house with rooms
		roomManager.init();
		//initializes current room
		player.setCurrentRoom(roomManager.getSpecificRoom(0));
		
		//prints greeting to the screen
		printGreeting();
		
		//main game loop
		while(continueGame)
		{
			//prints the current room
			player.printCurrentRoom();	
			//Invokes method that collects user input 
			input = collectInput(scan);
			//Invokes method that parses input
			parse(input, roomManager, player);
		}
		
		scan.close();
	}
	
	//------------------------------------------------------------------------------------------------------------------------
	//prints basic instructions on navigation and interaction
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
	//------------------------------------------------------------------------------------------------------------------------
	//Collects user input
	private static String[] collectInput(Scanner scan) 
	{
		String line = null;
		
		line = scan.nextLine();
		String[] input = line.split(" ", 2);

		return input;
	}
	
	//------------------------------------------------------------------------------------------------------------------------
	//parses input to determine what actions to take
	private static void parse(String[] input, RoomManager roomManager, Player player)
	{
		
		String action = input[0].toUpperCase().intern();
		String details = null;
		
		if(input.length > 1)
		{
			details = input[1].toUpperCase().intern();
		}
		
		//flow of control handled here to find correct adjacent room
		if(action == "GO" || action == "MOVE")
		{
			if(details == "NORTH")
			{
				changeRooms(player, 0);
			}
			else if(details == "SOUTH")
			{
				changeRooms(player, 1);
			}
			else if(details == "EAST")
			{
				changeRooms(player, 2);	
			}
			else if(details == "WEST")
			{
				changeRooms(player, 3);
			}
			else
			{
				System.out.println("Invalid direction");
			}
		}
		else if (action == "INTERACT" || action == "USE") // used for interactable objects
		{
			useItem(player, details);
		}
		else if (action == "QUIT")
		{
			setContinueGame(false);
			System.out.println("Thank you for taking my virtual home tour!"+'\n'+"Goodbye! :)");
			
		}
		else
		{
			System.out.println("Invalid input...");
		}
		
		
		
	}
	
	//------------------------------------------------------------------------------------------------------------------------
	//handles movement between rooms
	private static void changeRooms(Player p, int i)
	{
		Room r = p.getCurrentRoom();
		r = r.getSpecificExit(i);
		if(r != null)
		{
			p.setCurrentRoom(r);
		}
		else
		System.out.println("There are no rooms in that direction...");
	}
	
	//------------------------------------------------------------------------------------------------------------------------
	//handles interaction between objects
	private static void useItem(Player p, String details)
	{
		Room r = p.getCurrentRoom();
		RoomItem ri = r.getItems(0);
		if(ri != null)
			ri.interact();
		else
			System.out.println("can't interact");
	}
	
		
	
}

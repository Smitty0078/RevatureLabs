package game;

import fixtures.*;
import java.util.Scanner;

public class Main {

	private static boolean continueGame = true;
	
	public static boolean getContinueGame()
	{
		return continueGame;
	}
	
	public static void setContinueGame(boolean b)
	{
		continueGame = b;
	}
	
	
	
	public static void main(String[] args) 
	{
		
		String[] input;
		Scanner scan = new Scanner(System.in);
		RoomManager roomManager = new RoomManager();
		Player player = new Player();
		roomManager.init();
		player.setCurrentRoom(roomManager.getSpecificRoom(0));
		
		
		printGreeting();
		
		while(continueGame)
		{
			player.printCurrentRoom();	
			input = collectInput(scan);
			parse(input, roomManager, player);
			//continueGame = false;
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
		String line = null;
		
		line = scan.nextLine();
		String[] input = line.split(" ", 2);

		return input;
	}
	
	private static void parse(String[] input, RoomManager roomManager, Player player)
	{
		
		String action = input[0].toUpperCase().intern();
		String details = null;
		
		if(input.length > 1)
		{
			details = input[1].toUpperCase().intern();
		}
		
		if(action == "GO" || action == "MOVE")
		{
			if(details == "NORTH")
			{
				System.out.println("north");
				changeRooms(player, 0);
				
			}
			else if(details == "SOUTH")
			{
				System.out.println("south");
				changeRooms(player, 1);
				
			}
			else if(details == "EAST")
			{
				System.out.println("east");
				changeRooms(player, 2);
				
			}
			else if(details == "WEST")
			{
				System.out.println("west");
				changeRooms(player, 3);
				
			}
			else
			{
				System.out.println("Invalid");
			}
		}
		else if (action == "INTERACT" || action == "USE")
		{
			//IMPLEMENT THIS NOWWWW
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
	
	private static void changeRooms(Player p, int i)
	{
		Room r = p.getCurrentRoom();
		r = r.getSpecificExit(i);
		if(r != null)
		{
			p.setCurrentRoom(r);
			System.out.println(p.getCurrentRoom());
		}
		else
		System.out.println("There are no rooms in that direction...");
	}
	
	private static void useItem()
	{
		//get er tf goin
	}
	
		
	
}

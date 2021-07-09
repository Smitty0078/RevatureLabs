package game;

import fixtures.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Room startingRoom = new Room("Porch", "Front Porch", "Enterance of house");
		RoomManager roomManager = new RoomManager(startingRoom);
		Player player = new Player();

		roomManager.init();


	}
	
	private static void printRoom(Player player)
	{
		//TODO IMPLEMENT THIS ASAP
	}
	
	private static String[] collectInput() 
	{

		return null;
	}
		
	private static void parse(String[] command, Player player) {

	}
	
}

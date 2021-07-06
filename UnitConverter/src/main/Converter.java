package main;

import java.util.Scanner;

public class Converter {
	
	public double num;
	public double convertedNum;
	
	public static void main(String[] args) {	
		//initialize variables
		int menuSelection = 0;
		boolean askForInput = true;
		Scanner scan = new Scanner(System.in);
		Converter convert = new Converter();
	
		//drives data converter
		while(askForInput)
		{
			System.out.println("Welcome to the main Unit Converter!"+'\n');
			//Ask user to input which unit converter they wish to run
			System.out.println("Please select an option:"+'\n'
		                      +"1 : Volume Conversions"+'\n'
							  +"2 : Distance Conversions"+'\n'
		                      +"3 : Quit"+'\n'
							  +'\n');
			
			//allows user to input an integer value to select which converter to use
			menuSelection = scan.nextInt();
			
			//uses input to call the correct converter
			switch(menuSelection) 
			{
            	//Opens Volume Unit Converter
				case 1: 
            	{
            		convert.volumeConversions(scan);
            		break;
            	}
            	//Opens Distance Unit Converter
				case 2:
            	{
            		convert.distanceConversions(scan);
            		break;
            	}
            	//Quits Main Application
				case 3:
            	{
            		System.out.println("Thank you for using our Unit Converter"+'\n'+"Good bye :)");
            		askForInput = false;
            		break;
            	}
            	//Handles Invalid Input
				default:
            	{
            		System.out.println("Invalid Input");
            		break;
            	}
			}
		}
		//Closes input stream
		scan.close();

	}
	
	//------------------------------------------------------------------------------------------------------
	//Collects input for conversion
	private static double collectQuantity(String unit, Scanner scan)
	{
		double quantity = 0.0;
		System.out.println("Please Enter Number of "+unit+": ");
		quantity = scan.nextDouble();
		
		return quantity;
	}
	
	//------------------------------------------------------------------------------------------------------
	//Drives Volume Unit Conversions
	public void volumeConversions(Scanner scan)
	{
		boolean askForInput = true;
		int menuSelection = 0;
		while(askForInput)
		{
			System.out.println("Welcome to the Volume Unit Converter!"+'\n');
			//Ask user which conversion units they wish to use
			System.out.println("Please select an option:"+'\n'
							 +"1 : Cups to Teaspoons"+'\n'
							 +"2 : Teaspoons to Tablespoons"+'\n'
							 +"3 : US Gallons to Imperial Gallons"+'\n'
							 +"4 : Quit"
							 +'\n');
			menuSelection = scan.nextInt();
			switch(menuSelection) 
			{
				//Converts Cups to Teaspoons
            	case 1: 
            	{
            		num = collectQuantity("Cups", scan);
            		cupsToTeaspoonsConverter();
            		break;
            	}
            	//Converts Teaspoons to Tablespoons
            	case 2:
            	{
            		num = collectQuantity("Teaspoons", scan);
            		teaspoonsToTablespoons();
            		break;
            	}
            	//Converts Gallons to Imperial Gallons
            	case 3:
            	{
            		num = collectQuantity("Gallons", scan);
            		gallonsToImperialGallons();
            		break;
            	}
            	//Quits Volume Converter
            	case 4:
            	{
            		System.out.println("Thank you for using our Volume Converter"+'\n');
            		askForInput = false;
            		break;
            	}
            	//Handles invalid input
            	default:
            	{
            		System.out.println("Invalid Input");
            		break;
            	}
			}
	
		}
	}
	
	//------------------------------------------------------------------------------------------------------
	//Distance Unit Conversions
	public void distanceConversions(Scanner scan)
	{
		boolean askForInput = true;
		int menuSelection = 0;
		
		while(askForInput)
		{
			System.out.println("Welcome to the Distance Unit Converter!"+'\n');
			//Ask user which units they want to convert
			System.out.println("Please select an option:"+'\n'
							 +"1 : Feet to Meters"+'\n'
							 +"2 : Miles to Kilometers"+'\n'
							 +"3 : Quit"
							 +'\n');
			menuSelection = scan.nextInt();
			switch(menuSelection) 
			{
				//Converts Feet to Meters
            	case 1: 
            	{
            		num = collectQuantity("Feet", scan);
            		feetToMeters();
            		break;
            	}
            	//Converts Miles to Kilometers
            	case 2:
            	{
            		num = collectQuantity("Miles", scan);
            		milesToKilometers();
            		break;
            	}
            	//Quits Distance Converter
            	case 3:
            	{
            		System.out.println("Thank you for using our Distance Converter"+'\n');
            		askForInput = false;
            		break;
            	}
            	//Handles Invalid Input
            	default:
            	{
            		System.out.println("Invalid Input");
            		break;
            	}
            		
			}
		}
	}
	
	//------------------------------------------------------------------------------------------------------
	//Drives conversion for teaspoons to tablespoons
	public void teaspoonsToTablespoons()
	{
		//Conversion ratio: 1 teaspoon = 0.333333 tablespoons
		convertedNum = num * 0.333333;
		System.out.println(num+" teaspoon(s) is equal to "+convertedNum+" tablespoon(s)."+'\n');
	}
	
	//------------------------------------------------------------------------------------------------------
	//Drives conversion for cups and teaspoons
	public void cupsToTeaspoonsConverter()
	{	
		//Conversion ratio: 1 Cup = 48 Teaspoons
		convertedNum = num * 48;
		System.out.println(num+" cup(s) is equal to "+convertedNum+" teaspoon(s)."+'\n');
	}
	
	//------------------------------------------------------------------------------------------------------
	//Drives conversion for gallons to imperial gallons
	public void gallonsToImperialGallons()
	{
		//conversion ratio: 1 Gallon = 0.832674 Imperial Gallons
		convertedNum = num * 0.832674;
		System.out.println(num+" gallon(s) is equal to "+convertedNum+" imperial gallon(s)"+'\n');
	}
	
	//------------------------------------------------------------------------------------------------------
	//Drives conversion for miles and kilometers
	public void milesToKilometers()
	{
		//Conversion ratio: 1 Mile = 1.60934 Kilometers
		convertedNum = num * 1.60934;
		System.out.println(num + " mile(s) is equal to "+convertedNum+" kilometer(s)."+'\n');
	}
	
	//------------------------------------------------------------------------------------------------------
	//Drives conversion for feet to meters
	public void feetToMeters()
	{
		//Conversion ratio: 1 foot = 0.3048 Meters
		convertedNum = num * 0.3048;
		if(num == 1.0)
			System.out.println(num + " foot is equal to "+convertedNum+" meter(s)."+'\n');
		else
			System.out.println(num + " feet is equal to "+convertedNum+" meter(s)."+'\n');
	}

}

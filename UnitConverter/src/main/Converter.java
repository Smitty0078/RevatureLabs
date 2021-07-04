package main;

import java.util.Scanner;

public class Converter {
	
	public double num;
	public double convertedNum;
	
	public static void main(String[] args) {
		//initialize variables
		int conversionType = 0;
		boolean askForInput = true;
		Scanner scan = new Scanner(System.in);
		Converter convert = new Converter();
	
		//drives data converter
		while(askForInput)
		{
			//Ask user to input conversion type
			System.out.println("Please select an option:"+'\n'
		                      +"1 : Cups to Teaspoons"+'\n'
							  +"2 : Miles to Kilometers"+'\n'
		                      +"3 : US Gallons to Imperial Gallons"+'\n'
							  +"4 : Quit"
							  +'\n');
			
			//allows user to input an integer value to select which converter to use
			conversionType = scan.nextInt();
			
			//uses input to call the correct converter
			switch(conversionType) 
			{
            	case 1: {
            		
            		System.out.println("Please Enter Number of Cups: ");
            		convert.num = scan.nextDouble();
            		convert.cupsToTeaspoonsConverter();
            		break;
            	}
            	case 2:{
            		System.out.println("Please Enter Number of Miles: ");
            		convert.num = scan.nextDouble();
            		convert.milesToKilometers();
            		break;
            	}
            	case 3:
            	{
            		System.out.println("Please Enter Number of Gallons: ");
            		convert.num = scan.nextDouble();
            		convert.gallonsToImperialGallons();
            		break;
            	}
            	case 4:
            	{
            		System.out.println("Thank you for using our Unit Converter"+'\n'+"Good bye :)");
            		askForInput = false;
            		break;
            	}
            	default:
            	{
            		System.out.println("Invalid Input");
            		break;
            	}
			}
		}
		
		
		
		scan.close();

	}
	//Drives conversion for cups and teaspoons
	public void cupsToTeaspoonsConverter()
	{	
		//Conversion ratio: 1 Cup = 48 Teaspoons
		convertedNum = num * 48;
		System.out.println(num+" cup(s) is equal to "+convertedNum+" teaspoons."+'\n');
	}
	
	//Drives conversion for miles and kilometers
	public void milesToKilometers()
	{
		//Conversion ratio: 1 Mile = 1.60934 Kilometers
		convertedNum = num * 1.60934;
		System.out.println(num + " mile(s) is equal to "+convertedNum+" kilometer(s)."+'\n');
	}
	
	//Drives conversion for gallons to imperial gallons
	public void gallonsToImperialGallons()
	{
		//conversion ratio: 1 Gallon = 0.832674 Imperial Gallons
		convertedNum = num * 0.832674;
		System.out.println(num+" gallon(s) is equal to "+convertedNum+" imperial gallon(s)"+'\n');
	}

}

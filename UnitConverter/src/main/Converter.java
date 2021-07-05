package main;

import java.util.Scanner;

public class Converter {
	
	public double num;
	public double convertedNum;
	
	public static void main(String[] args) {
		//initialize constant conversion variables
		final double cupsToTeaspoons = 48.0;
		final double milesToKilometers = 1.60934;
		final double gallonsToImperialGallons = 0.832674;
		
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
            		convert.converter(cupsToTeaspoons, "cup", "teaspoon");
            	
            		break;
            	}
            	case 2:{
            		System.out.println("Please Enter Number of Miles: ");
            		convert.num = scan.nextDouble();
            		convert.converter(milesToKilometers, "mile", "kilometer");
            		
            		break;
            	}
            	case 3:
            	{
            		System.out.println("Please Enter Number of Gallons: ");
            		convert.num = scan.nextDouble();
            		convert.converter(gallonsToImperialGallons, "gallon", "imperial gallon");
            		
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
	
	public void converter(double conversionRatio, String type1, String type2)
	{
		convertedNum = num * conversionRatio;
		System.out.println(num+" "+type1+"(s) is equal to "+convertedNum+" "+type2+"(s)."+'\n');
	}
	

}

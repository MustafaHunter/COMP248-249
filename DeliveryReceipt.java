//----------------------------------------------------------------
/*
*Assignment #1 (Question 2)
*Written by: Mustafa Al awadi Student Id= 40217764
*For COMP248 Section R - Fall 2021
*Due October 1 2021
*/
//-----------------------------------------------------------------

/**
 * In this program, I will generate a receipt for a delivery company, called "Montreal Delivery Express" that delivers good to its clients. 
 * The company is located in Montreal and operates only in Quebec. 
 * The program will generate the receipt based on the information entered by the user. 
 * 
 */

package AssignGot;

import java.nio.file.FileSystemNotFoundException;
import java.util.Scanner;

public class DeliveryReceipt {

	public static void main(String[] args) {
	
		
// I will be displaying a welcome message.
		
		
		System.out.println("----------------------------------");
		System.out.println("Welcome to the Receipt Generator:");
		System.out.println("-----------------------------------");
		
		
//I will display a message guiding the client to enter their information
		
		
		System.out.println("Please enter the client info:");
		
		
// I will prompt the user to enter the Full client name
		
		
		Scanner receipt= new Scanner(System.in);
		
		
		System.out.print("\nFirst name? ");
		String FirstName= receipt.nextLine();
		String capFirstName=FirstName.substring(0,1).toUpperCase() + FirstName.substring(1).toLowerCase();
		
		System.out.print("Last name? ");
		String LastName= receipt.nextLine();
		String capLastName=LastName.substring(0,1).toUpperCase() + LastName.substring(1).toLowerCase();
		
		
// I will prompt the user to enter their address including their street number, name and apt number if applicable.
		
		
		System.out.print("Address? (Include street number, street name and apt number if applicable) ");
		String fullAddress= receipt.nextLine();
		
		
// I will prompt the user to enter their City and province.
		
		
		System.out.print("City? ");
		String theCity= receipt.next();
		String capCity=theCity.substring(0,1).toUpperCase() + theCity.substring(1).toLowerCase();
		
		System.out.print("Province? ");
		String theProv= receipt.next();
		String capProv= theProv.toUpperCase();
		
		
// I will prompt the user to enter their postal code.
		
		
		System.out.print("Postal code? ");
		String thePostcod= receipt.next();
		String capPostcod=thePostcod.toUpperCase();
			
		
// I will display a message notifying the client to enter their delivery information.
		
		
		System.out.println("\n\nPlease enter the delivery info: ");
		

// I will prompt the user to enter the date of delivery.
	
		
		System.out.print("\n\nDay of delivery (between 1 and 31)? ");
		int deliveryDay= receipt.nextInt();
		
		System.out.print("Month Of delivery (between 1 and 12) ");
		int deliveryMonth= receipt.nextInt();
		
		System.out.print("Year of delivery (between 2020 and 2021) ");
		int deliveryYear= receipt.nextInt();
		
		
// I will prompt the user to enter the distance from source to destination in kilometers.
		
		
		System.out.print("Distance from source to destination in kilometers? ");
		float distanceKm=receipt.nextFloat();
		
		
// I will prompt the user to enter the value of the goods to be delivered.
		
		
		System.out.print("Value of the goods? ");
		float valueGoods=receipt.nextFloat();
		
		
// I will be displaying a horizontal line to separate the info
		
		
		System.out.println("\n___________________________________________________________________________________________");
		
		
// I will be display in the receipt the name of the company and the delivery date.
		
		
		System.out.println("\t\tMontréal Delivery Express\t\t" + deliveryDay + "/" + deliveryMonth + "/" + deliveryYear);
		
		
// I will be displaying in the receipt the full name of the client (first letters of the last name and first name in capital).
		
		
		System.out.println(("\n\n" + capFirstName + "	" + capLastName));
		

/*
*I will be displaying in the receipt the full address (street,city,province, and postal code).
*The province will be displayed as QC and postal code will be displayed in Upper Case letters.
*/	
		
		System.out.println(fullAddress);
		
		System.out.print((capCity + ", " + capProv +", " + capPostcod));
		
		
		
// I will be displaying a horizontal line to separate the info		
		
		
		System.out.println("\n___________________________________________________________________________________________");
		
		
/* 
*I will be displaying the value of the goods followed by the delivery fees
*then the TPS value, then the TVQ value and finally the Total value of the bill
*Every Kilometer equals 55 cents
*/		
		
		float chargePerKm= 0.55f;
		float feeRateTps=(5/valueGoods);
		float feeRateTvq=((float)9.975/valueGoods);
		
		System.out.print("\nSub-total\t\t\t\t\t\t");
		System.out.print(valueGoods + " $");
		
		  
		System.out.print("\nDelivery Fees (55 Cents * "+distanceKm+" KM)\t\t\t");
		float deliveryFees=distanceKm * chargePerKm;
		System.out.printf("%.2f $",deliveryFees);
		
		System.out.print("\nTPS\t12345 6789 RT0001 - 5 %\t\t\t\t");
		float tps=((valueGoods + deliveryFees) * feeRateTps);
		System.out.printf("%.2f $",tps );
		
		System.out.print("\nTVQ\t1234567890 TQ0020 - 9.975 %\t\t\t");
		float tvq=((valueGoods + deliveryFees) * feeRateTvq);
		System.out.printf("%.2f $",tvq);
	
		
		System.out.print("\n\nTotal\t\t\t\t\t\t\t");
		System.out.printf("%.2f $",(valueGoods + deliveryFees + tps + tvq));
		
		
// I will be displaying a horizontal line to separate the info		
		
		
		System.out.println("\n___________________________________________________________________________________________");		
		
		
// I will display a farewell message, so that the user knows that the program has terminated normally
		
	
		System.out.println("\n\nThank you for choosing Montreal Delivery Express.");
		System.out.println("\nReceipt generated successfully.");
		

	}

}

//----------------------------------------------------------------
/*
 *Assignment #2 (Question 2)
 *Written by: Mustafa Al awadi Student Id= 40217764
 *For COMP248 Section R - Fall 2021
 *Due October 18 2021
 */
//-----------------------------------------------------------------

/**
 * This program will generate a covid-19 vaccine appointment booking.
 * I will first display a welcome message, then will remind the users that we're expecting them to enter their data from the keyboard.
 * All outputs are formatted to be easily read and understood by the user as the messages will be clear.
 * At the end of the program, a closing message will appear to the user so that they know that the program has terminated.
 */

import java.util.Scanner;

import com.sun.jdi.Location;

public class covidAppointment {

	public static void main(String[] args) {
		
		
		// I will create a Scanner to allow the users to enter their answers.
		
		
		Scanner appointment= new Scanner(System.in);
		
		// I will assign all my variables
		
		
		int locationChoice = 0;
		int choice =0;
		int timeSlots = 0;
		boolean isSuccessful = false;
		int vacShot = 0;

		
		// I will order my arrays to avoid repetition in the further steps. 
		
		
		String[] vaccines = {"Pfizer","Moderna","AstraZeneca","Johnson&Johnson","Sinovac","Gamelaya",""};
		String[] locations = {"Pharmaprix","Jean Coutu","Uniprix Clinic","Health Center"};
		String[] times = {"2:00 - 2:15","2:20 - 2:35","2:40 - 2:55","3:00 - 3:15"};
		String[] shots = {"1st","2nd"};


		// I will be displaying a welcome message.

		
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Welcome to Covid19 Vaccine Appointment Program!");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");

		
		// I will present the covid-19 vaccine menu of 6 choices and the 7th is an option to exit. 
		
		
		System.out.println("Here is the Covid-19 vaccine menu: ");		
		System.out.println("\t1. Pfizer");
		System.out.println("\t2. Moderna");
		System.out.println("\t3. AstraZeneca");
		System.out.println("\t4. Johnson&Johnson");
		System.out.println("\t5. Sinovac");
		System.out.println("\t6. Gamaleya");
		System.out.println("\t7. Exit");

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		
		boolean repeat = true;
		
		while(repeat) {
		System.out.print("\nPlease enter your choice (1-7): ");
		choice = appointment.nextInt();


		while (choice<1 || choice>7) {
		System.out.println("Invalid choice!");
		System.out.print("\nPlease enter your choice (1-7): ");
		choice = appointment.nextInt();
			} 
		
		
		// I will be using the switch technique instead to avoid confusion and to have a cleaner code.
		

	switch (choice) {
			case 1:	// This is for the Pfizer option. 
				
				System.out.println("Your choice is: "+vaccines[choice-1]+".");
				System.out.println("\n\nPlease chose the location of vaccine "+vaccines[choice-1]+": ");
				System.out.println("1- "+locations[0]);
				System.out.println("2- "+locations[1]);
				
				System.out.print("Please enter your choice: ");
				locationChoice= appointment.nextInt();
				
				
				// This is to validate the location.
				
				
				while (locationChoice<1 || locationChoice>2) {	
					System.out.println("Invalid location!");
					System.out.print("Please enter your choice: ");
					locationChoice = appointment.nextInt();
				} 
				
				
				System.out.println("\n\nPlease choose the time slots :");
				System.out.println("1- 2:00 - 2:15");
				System.out.println("2- 2:20 - 2:35");
				System.out.println("3- 2:40 - 2:55");
				System.out.println("4- 3:00 - 3:15");
				System.out.println("5- Quit");
				
				System.out.print("Please enter your choice (1-5): ");
				timeSlots=appointment.nextInt();
				
				
				// This is to validate the timeslot.
				
				
				while (timeSlots<1 || timeSlots>5) {	
					System.out.println("Invalid timeslot!");
					System.out.print("Please enter your choice (1-5): ");
					timeSlots = appointment.nextInt();
				} 
				
				
				if (timeSlots==5) {
					System.out.println("Your appointment is not booked successfully! Would you like to try again? (yes or no) ");
					String tryAgain = appointment.next(); 
					if (tryAgain.equalsIgnoreCase("no")) repeat=false;
				}
				
				
				else  {
					repeat=false;
					isSuccessful = true;
				}

				break;
				
				
			case 2:	// This is for the Moderna option. 
				
				System.out.println("Your choice is: "+vaccines[choice-1]+".");
				System.out.println("\n\nPlease chose the location of vaccine "+vaccines[choice-1]+": ");
				System.out.println("1- "+locations[0]);
				System.out.println("3- "+locations[2]);
				System.out.println("4- "+locations[3]);
				
				System.out.print("Please enter your choice: ");
				locationChoice= appointment.nextInt();
				
				
				// This is to validate the location.
				
				
				while (locationChoice!=1 && locationChoice!=3&&locationChoice!=4) {	
					System.out.println("Invalid location!");
					System.out.print("Please enter your choice: ");
					locationChoice = appointment.nextInt();
				} 
				
				
				System.out.println("\n\nPlease choose the time slots :");
				System.out.println("1- 2:00 - 2:15");
				System.out.println("2- 2:20 - 2:35");
				System.out.println("3- 2:40 - 2:55");
				System.out.println("4- 3:00 - 3:15");
				System.out.println("5- Quit");

				System.out.print("Please enter your choice (1-5): ");
				timeSlots=appointment.nextInt();
				
				
				// This is to validate the timeslot
				
				
				while (timeSlots<1 || timeSlots>5) {	
					System.out.println("Invalid timeslot!");
					System.out.print("Please enter your choice (1-5): ");
					timeSlots = appointment.nextInt();
				} 
				
				
				if (timeSlots==5) {
					System.out.println("Your appointment is not booked successfully! Would you like to try again? (yes or no) ");
					String tryAgain = appointment.next(); 
					if (tryAgain.equalsIgnoreCase("no")) repeat=false;
				}
				
				
				else  {
					repeat=false;
					isSuccessful = true;
				}
				
				break;
				
				
				
			case 3:	// This is for the AstraZeneca option. 
				
				System.out.println("Your choice is: "+vaccines[choice-1]+".");
				System.out.println("\n\nPlease chose the location of vaccine "+vaccines[choice-1]+": ");
				System.out.println("2- "+locations[1]);
				System.out.println("3- "+locations[2]);
				
				System.out.print("Please enter your choice: ");
				locationChoice= appointment.nextInt();
				
				
				// This is to validate the location.	
				
				
				while (locationChoice!=2 && locationChoice!=3) {	
					System.out.println("Invalid location!");
					System.out.print("Please enter your choice: ");
					locationChoice = appointment.nextInt();
				} 
				
				
				System.out.println("\n\nPlease choose the time slots :");
				System.out.println("1- 2:00 - 2:15");
				System.out.println("2- 2:20 - 2:35");
				System.out.println("3- 2:40 - 2:55");
				System.out.println("4- 3:00 - 3:15");
				System.out.println("5- Quit");

				System.out.print("Please enter your choice (1-5): ");
				timeSlots=appointment.nextInt();
				
				
				// This is to validate the timeslot.
				
				
				while (timeSlots<1 || timeSlots>5) {
					System.out.println("Invalid timeslot!");
					System.out.print("Please enter your choice (1-5): ");
					timeSlots = appointment.nextInt();
				} 
				
				
				if (timeSlots==5) {
					System.out.println("Your appointment is not booked successfully! Would you like to try again? (yes or no) ");
					String tryAgain = appointment.next(); 
					if (tryAgain.equalsIgnoreCase("no")) repeat=false;
				}
				
				
				else  {
					repeat=false;
					isSuccessful = true;
				}
				
				break;
				
				
			case 4:	// This is for the Johnson&Johnson option. 
				
				System.out.println("Your choice is: "+vaccines[choice-1]+".");
				System.out.println("\n\nPlease chose the location of vaccine "+vaccines[choice-1]+": ");
				System.out.println("4- "+locations[3]);
				System.out.print("Please enter your choice: ");
				locationChoice= appointment.nextInt();
				
				
				// This is to validate the location.
				
				
				while (locationChoice!=4) {
					System.out.println("Invalid location!");
					System.out.print("Please enter your choice: ");
					locationChoice = appointment.nextInt();
				} 
				
				
				System.out.println("\n\nPlease choose the time slots :");
				System.out.println("1- 2:00 - 2:15");
				System.out.println("2- 2:20 - 2:35");
				System.out.println("3- 2:40 - 2:55");
				System.out.println("4- 3:00 - 3:15");
				System.out.println("5- Quit");

				System.out.print("Please enter your choice (1-5): ");
				timeSlots=appointment.nextInt();
				
				
				// This is to validate the timeslot
				
				
				while (timeSlots<1 || timeSlots>5) {	
					System.out.println("Invalid timeslot!");
					System.out.print("Please enter your choice (1-5): ");
					timeSlots = appointment.nextInt();
				} 
				
				
				if (timeSlots==5) {
					System.out.println("Your appointment is not booked successfully! Would you like to try again? (yes or no) ");
					String tryAgain = appointment.next(); 
					if (tryAgain.equalsIgnoreCase("no")) repeat=false;
				}
				
				
				else  {
					repeat=false;
					isSuccessful = true;
				}
				
				break;
				
				
				// I will only put one break for case 5 and 6 since they both follow the same conditions.
				
				
			case 5:	// This is for the Sinovac option.
				
				
			case 6:	// This is for the Gamelaya option.
				
				System.out.println("Sorry, "+vaccines[choice-1]+ "is not available now!");
				System.out.println("Your appointment is not booked successfully! Would you like to try again? (yes or no) ");
				String tryAgain = appointment.next(); 
				if (tryAgain.equalsIgnoreCase("no")) repeat=false;
				
				break;
				
				
			case 7:	// This is an option for the user to exit the menu if they wish.
				
				repeat=false;

			default:
				
				break;
			}
		}
		
		
		if (isSuccessful) {	
		
			System.out.print("Please enter the 1st or 2nd vaccine shot (1 or 2): ");
			vacShot= appointment.nextInt();			
			System.out.println("Your booked appointment is "+vaccines[choice-1]+",  "+shots[vacShot-1]+" dose.");
			System.out.println("Your schedule is: "+times[timeSlots-1]+" @ "+locations[locationChoice-1]);
		
		} 
		
		
		else System.out.println("Please come back later and book your COVID19 vaccination!");
		
		System.out.println("\nThank you for using COVID19 Vaccination appointment program!");	
		System.exit(0);
			
		
	}
}


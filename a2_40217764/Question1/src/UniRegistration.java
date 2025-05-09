//----------------------------------------------------------------
/*
 *Assignment #2 (Question 1)
 *Written by: Mustafa Al awadi Student Id= 40217764
 *For COMP248 Section R - Fall 2021
 *Due October 18 2021
 */
//-----------------------------------------------------------------

/**
 * This program will generate a registration form for new coming Concordia University students.
 * I will first display a welcome message, then will remind the users that we're expecting them to enter their data from the keyboard.
 * All outputs are formatted to be easily read and understood by the user as the messages will be clear.
 * At the end of the program, a closing message will appear to the user so that they know that the program has terminated.
 */

import java.util.Scanner;

public class UniRegistration {

	public static void main(String[] args) {

		
		// I will add a Scanner to allow the user to input their answer.
		
		
		Scanner scan = new Scanner(System.in);

		
		// I will be displaying a welcome message.

		
		System.out.println("\n+++++++++++++++++++++++++++++++++++++");

		System.out.println("Welcome to Concordia University");

		System.out.println("+++++++++++++++++++++++++++++++++++++");

		
		// I will be displaying a message to promt the user to enter whether they are new to Concordia or not.
		
		
		System.out.print("\nAre you a new coming student at Concordia? (Yes or no) ");
		
		
		// I will create a string that allows the user to answer whether they are a new coming student or not.
		
		
		String truFal = scan.next();

		scan.nextLine();

		
		// In case the user enters "no", I will not have them go through the whole process of filling their information.
		
		
	if (truFal.equalsIgnoreCase("no")) {

			System.out.println("\nWelcome back! Hope you are having a great semester!");
			System.out.println("\nThank you for using this Program!");
		}

		
		// In case the user enters "yes", I will have them go through the process of filling their information. 
		
		
	else if (truFal.equalsIgnoreCase("Yes")) {

			System.out.print("\nPlease enter you name (Lastname, Firstname seperated by comma): ");
			
			
			// I will promt the user to enter their fullname.
			
			
			String fullName = scan.nextLine();

			
			// In this step, I will find the comma in the name and make sure that the whole name is stored in one string.
			
			
			int index = fullName.indexOf(","); 

			String lastName = fullName.substring(0, index).trim();
			String firstName = fullName.substring(index + 1).trim();
			String cleanFullName = firstName.substring(0, 1).toUpperCase()
					+ firstName.substring(1, firstName.length()).toLowerCase() + " "
					+ lastName.substring(0, 1).toUpperCase() + lastName.substring(1, lastName.length()).toLowerCase();
			
			
			// In this step, I will inform the user that we are expecting them to enter their date of birth.
			
			
			System.out.print("\nPlease enter your date of birth (Year-Month-Day): ");
			String dateOfBirth = scan.nextLine();
			
			
			/* 
			* In this step, I wish to know if the user owns a vaccine passport or not, so I create a boolean.
			* If the answer is false, I will wish for them at the end of the registration to get one.
			* If the answer is true, I will not be adding anything. 
			*/

			
			System.out.print("\nDo you have covid19 vaccine passport? (true or false): ");

			boolean passport = scan.nextBoolean();

			
			// In this step, I will inform the user that I'm expecting them to type the department.
			
			
			System.out.print("\nPlease enter your department: ");

			String department = scan.next();

			
			// I will be informing the user that they have successfully registered at Concordia University.
			
			
			System.out.println(
					"\nCongratulations, " + cleanFullName + "! You have successfully registered at Concordia University!");
			
			
			// Here, I will be generating a random 7-digit ID number for the student.
			
			
			int randomId = 0;
			randomId = (int) (Math.random() * 9000000) + 1000000;

			System.out.println("\nYour student ID is " + randomId + ".");

			if (passport == false)
				System.out.println("\nHope you will get your vaccine passport soon! Take care!");

			
			// I will display a closing message.
			
			
			System.out.println("\nThank you for using this program!");

		} 
		
		
			// In case the user enters any string other than "Yes" or "No", I will remind them that their input was wrong.
		
		
		else {
			System.out.println("\nPlease enter either \"Yes\" or \"No\" ");
		}
	}

}

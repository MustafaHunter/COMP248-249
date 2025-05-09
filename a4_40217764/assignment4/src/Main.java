//----------------------------------------------------------------
/*
 *Assignment #4 
 *Written by: Mustafa Al awadi Student Id= 40217764
 *For COMP248 Section R - Fall 2021
 *Due December 6 2021
 */
//-----------------------------------------------------------------

/**
 * In this assignment, I will write a program to simulate a ticketbooth which holds tickets and OPUScard. 
 * I will write a Tickets class, OPUScard class, a Ticketbooth class, and finally a driver.
 * I will first display a welcome message, then will remind the users that we're expecting them to enter their data from the keyboard.
 * All outputs are formatted to be easily read and understood by the user as the messages will be clear.
 * At the end of the program, a closing message will appear to the user so that they know that the program has terminated.
 * I also chose to do this assignment individually.
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {


		//Create sample data for demonstration
		Ticketbooth[] tb = new Ticketbooth[5];

		OPUSCard[] cards1 = new OPUSCard[10];
		OPUSCard c1 = new OPUSCard("REM","Name1",12,2025);
		OPUSCard c2 = new OPUSCard("STM","Name2",10,2022);
		OPUSCard c3 = new OPUSCard("STL","Name3",1,2021);
		cards1[0] = c1; 
		cards1[1] = c2; 
		cards1[2] = c3;
		
		OPUSCard[] cards2 = new OPUSCard[10];
		OPUSCard c4 = new OPUSCard("REM","Name4",2,2024);
		OPUSCard c5 = new OPUSCard("STM","Name5",12,2022);
		OPUSCard c6 = new OPUSCard("STL","Name6",1,2023);
		cards2[0] = c4; 
		cards2[1] = c5; 
		cards2[2] = c6;
		OPUSCard[] cards3 = new OPUSCard[10];
	
		

		Tickets t1 = new Tickets(10, 5, 2, 5, 3);
		Tickets t2 = new Tickets(t1);
		Tickets t3 = new Tickets(6,7,9,1,20);
		Tickets t4 = new Tickets(15, 13, 2, 2, 0);
		Tickets t5 = new Tickets(15, 6, 11, 15, 1);


		tb[0] = new Ticketbooth(t1,cards1);
		tb[1] = new Ticketbooth(t2,cards1.clone());
		tb[2] = new Ticketbooth(t3,cards2);
		tb[3] = new Ticketbooth(t4,cards3);
		tb[4] = new Ticketbooth(t5,cards3);

		//		tb.addOPUSCard(c3);


		
		
		
		
		
		// Displaying a welcome message to the Ticketbooth Application

		System.out.println("==================================================================");
		System.out.println("   Welcome to Concordia 2021 Fall Geek's Ticketbooth Application");
		System.out.println("==================================================================");
		
		// Adding a scanner to receive user input
		
		Scanner application= new Scanner(System.in);
		
		int option =1;
		int input;
		
		/* Presenting the menu to the user
		 * Displaying the tickets and OPUS cards of each ticketbooth
		 * Ask user which ticketbooth they wish to see the content of, and then display the tickets and OPUS cards info for that ticketbooth
		 * Compare all ticketbooth and display the pairs that have same total
		 * Display the pairs that have the same ticket distribution
		 * Ask user which ticketbooth they wish to remove
		 * Ask user which ticketbooth they wish to add
		 * Ask user which ticketbooth they wish to update
		 */
		
		while(option!=0){
			System.out.println("\nWhat would you like to do?");			
			System.out.println("1. See the content of all Ticketbooths");
			System.out.println("2. See the content of one Ticketbooth");
			System.out.println("3. List Ticketbooths with same amount of ticket's values");
			System.out.println("4. List Ticketbooths with same Tickets amount");
			System.out.println("5. List Ticketbooths with same amount of tickets values and same number of OPUS cards");
			System.out.println("6. Add a Opus card to an existing Ticketbooth");
			System.out.println("7. Remove an existing OPUS card from a Ticketbooth");
			System.out.println("8. Update the expiry date of an existing OPUS card");
			System.out.println("9. Add Tickets to a Ticketbooth");
			System.out.println("0. Quit");
			option = application.nextInt();
			switch (option) {
			
			// Option 1
			
			case 1:			
				System.out.println("> See the content of all Ticketbooths");
				for (int i = 0; i < tb.length; i++) {
					System.out.println((i)+": "+tb[i]);
				}
				break;
				
				// Option 2
				
			case 2:			
				System.out.println("> See the content of one Ticketbooth ");
				System.out.println("Which Ticketbooth do you want to see the content of? (Enter number 0 to "+(tb.length-1)+"):");
				input = application.nextInt();
				while (input>tb.length){
					System.out.println("Sorry but there is no Ticketbooth number "+input);
					System.out.println("Please select a ticketbooth between 0 and "+(tb.length-1)+"):");
					input = application.nextInt();
				}
				System.out.println(tb[input]);
				break;
				
				// Option 3
				
			case 3:	
				System.out.println("> List Ticketbooths with same amount of ticket's values");
				for (int i = 0; i < tb.length; i++) {
					for (int j=(i+1);j<tb.length;j++)
						if (tb[i].getTotalValue() == tb[j].getTotalValue())
								System.out.println("Tickebooth "+i+" and "+j+" have the same total ticket's amount: "+tb[i].getTotalValue());
				}
				
				break;
				
				// Option 4
			case 4:		
				System.out.println("> List Ticketbooths with same Tickets amount");
				for (int i = 0; i < tb.length; i++) {
					for (int j=(i+1);j<tb.length;j++)
						if (tb[i].getTickets().equals(tb[j].getTickets()))
								System.out.println("Tickebooth "+i+" and "+j+" have the same amount of tickets: "+tb[i].getTickets());
				}
				break;
				
				// Option 5
				
			case 5:		
				System.out.println("> List Ticketbooths with same amount of tickets values and same number of OPUS cards");
				for (int i = 0; i < tb.length; i++) {
					for (int j=(i+1);j<tb.length;j++)
						if (tb[i].getTickets().equals(tb[j].getTickets())&&tb[i].getTotalValue() == tb[j].getTotalValue())
								System.out.println("Tickebooth "+i+" and "+j+" have same amount and value.");
				}
				break;
				
				// Option 6
				
			case 6:		
				System.out.println("> Add a Opus card to an existing Ticketbooth");
				System.out.println("Which Ticketbooth do you want to add a OPUS card to? (Enter number 0 to "+(tb.length-1)+"):");
				input = application.nextInt();
				
				while (input>tb.length){
					System.out.println("Sorry but there is no Ticketbooth number "+input);
					System.out.println("Please select a ticketbooth between 0 and "+(tb.length-1)+"):");
					input = application.nextInt();
				}
				System.out.println("Please enter the following information to complete the transaction:");
				System.out.println("Type of OPUS card:");
				String card_type = application.next();
				System.out.println("Full name on OPUS card:");
				String cardholder_name = application.next();
				System.out.println("Expiration month and year in the following format: MM-YYYY");
				String expiration_date = application.next();
				String[] date_string = expiration_date.split("-");
				int expiration_month = Integer.parseInt(date_string[0]);
				int expiration_year = Integer.parseInt(date_string[1]);				
				OPUSCard c = new OPUSCard(card_type, cardholder_name, expiration_month, expiration_year);			
				tb[input].addOPUSCard(c);
				System.out.println("You now have "+tb[input].getNumberOfOPUSCards()+" OPUS cards in Ticketbooth "+input);
				break;
				
				// Option 7
				
			case 7:		
				System.out.println("> Remove an existing OPUS card from a Ticketbooth");
				System.out.println("Which Ticketbooth do you want to remove a OPUS card from? (Enter number 0 to "+(tb.length-1)+"):");
				input = application.nextInt();
				
				while (input>tb.length){
					System.out.println("Sorry but there is no Ticketbooth number "+input);
					System.out.println("Please select a ticketbooth between 0 and "+(tb.length-1)+"):");
					input = application.nextInt();
				}
				
				System.out.println("Ticketbooth "+input+" has "+tb[input].getNumberOfOPUSCards()+" OPUS Cards."
						+"\n(Enter card number 0 to "+(tb[input].getNumberOfOPUSCards()-1)+")");
				int cardNumber = application.nextInt();
				tb[input].removeOPUSCard(cardNumber);		
				break;
				
				// Option 8
				
			case 8:		
				System.out.println("> Update the expiry date of an existing OPUS card");
				System.out.println("Which Ticketbooth do you want to update an OPUS card from? (Enter number 0 to "+(tb.length-1)+"):");
				input = application.nextInt();
				
				while (input>tb.length){
					System.out.println("Sorry but there is no Ticketbooth number "+input);
					System.out.println("Please select a ticketbooth between 0 and "+(tb.length-1)+"):");
					input = application.nextInt();
				}
				
				System.out.println("Ticketbooth "+input+" has "+tb[input].getNumberOfOPUSCards()+" OPUS Cards."
						+"\n(Enter card number 0 to "+(tb[input].getNumberOfOPUSCards()-1)+")");
				cardNumber = application.nextInt();
				System.out.println("Expiration month and year in the following format: MM-YYYY");
				expiration_date = application.next();
				date_string = expiration_date.split("-");
				expiration_month = Integer.parseInt(date_string[0]);
				expiration_year = Integer.parseInt(date_string[1]);					
				c = new OPUSCard(tb[input].getCards()[cardNumber].getCard_type(),tb[input].getCards()[cardNumber].getCardholer_name(),expiration_month,expiration_year);
				tb[input].getCards()[input] = c;
				System.out.println("Expiration date updated");
				break;
				
				// Option 9
				
			case 9:		
				System.out.println("> Add Tickets to a Ticketbooth");
				System.out.println("Which Ticketbooth do you want to add tickets to? (Enter number 0 to "+(tb.length-1)+"):");
				input = application.nextInt();
				
				while (input>tb.length){
					System.out.println("Sorry but there is no Ticketbooth number "+input);
					System.out.println("Please select a ticketbooth between 0 and "+(tb.length-1)+"):");
					input = application.nextInt();
				}
				System.out.println("Current Value: " +tb[input].getTotalValue());
				System.out.println("How many regular, junior, senior, daily and weekly do you want to add?");
				System.out.println("Enter 5 numbers seperated by a dash");
				String tickets_string = application.next();
				String add_tickets[] = tickets_string.split("-");
				int rt = Integer.parseInt(add_tickets[0]);
				int jt = Integer.parseInt(add_tickets[1]);	
				int st  = Integer.parseInt(add_tickets[2]);	
				int dt = Integer.parseInt(add_tickets[3]);	
				int wt  = Integer.parseInt(add_tickets[4]);					
				tb[input].addTicketsToBooth(rt, jt, st, dt, wt);
				System.out.println("Updated Value: "+tb[input].getTotalValue());
				
				break;
				
				// Option 0
				
			case 0:	
				System.out.println("> Quit");
				System.out.println("Thank you for using Concordia 2021 Fall Geek's Ticketbooth Application!\n");
				break;
			default:
				System.out.println("Sorry that is not a valid choice. Try again.");
				break;
			}

		}


	}

}


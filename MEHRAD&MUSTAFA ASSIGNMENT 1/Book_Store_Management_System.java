/*
 * 
 * Assignment 0
 * Part2: Book Store
 * Written by Mehrad Mostaan(40248205)
 * presented to professor Dr.Aiman Hanna
 * 
 */
// use scanner since the user is required to enter a value
import java.util.*;
public class Book_Store_Management_System {
	//define attributes
	private static String password = "249";
	private static int Max_Attempts = 3;
	private static int Max_Books = 100;
	//use the class created in part 1
	private static book_for_a_day[] inventory = new book_for_a_day[100];
	
	private static int Num_Of_Books = 0;
	//there is a limit to the number of attempts 
	private static int password_attempts = 0;
	
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		// as defined based on the required output 
		
		System.out.println("\n Main Menu");
		System.out.println("1.  Enter new books(password required)");
		System.out.println("2.  Change information of a book(password required)");
		System.out.println("3.  Display all books by a specific author");
		System.out.println("4.  Display all books under a certain a price");
		System.out.println("5.  Quit");
		
		int option = sc.nextInt();
		switch(option) {
		case 1:
			Enter_new_books(sc);
			break;
		case 2:
			change_Book_Information(sc);
			break;
		case 3:
			display_a_book_by_author(sc);
			break;
		case 4:
			display_a_book_price(sc);
			break;
			
			
			
			
		}

		
		
	
		
		
		
		
		
		
		
		sc.close();

	}
	
// we need different methods for each number (1-5)
	
	private static void Enter_new_books(Scanner sc) {
		
		System.out.println("Enter your password: ");
		String password_enter = sc.nextLine();
		
		//since this method required a password 
		//we have to check number of attempts
		int num_of_book_add = sc.nextInt();
		
		

		//more than 12 times limit
		
		
		if (password_enter.equals("249"))
		{
		
		System.out.println("How many books would like to enter?");
		

		//enter number of books
		int Num_Of_Books = sc.nextInt();
		//
		if(Num_Of_Books + num_of_book_add <= Max_Books) {
			//we need a loop at this point of the code in order to enter books infos
			//the loop will set limits the number of books entered(added)
			for(int i =0; i < num_of_book_add; i++) {
				System.out.println("\n Enter information for the Book number " + (1 +i));
				System.out.print("Title: ");
				String title = sc.nextLine();
				System.out.print("Author: ");
				String author = sc.nextLine();
				System.out.print("ISBN: ");
				long ISBN = sc.nextLong();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.println();
				
				// after user adding all infos,
				// we can create a new object
				inventory[Num_Of_Books++] = new book_for_a_day(author, title, ISBN, price); 
				
				//display a message
				System.out.println("the Book number " + (i+1) + "has been added to the inventory");
				
			}
		
			}
		else {
			
		
			System.out.println("No more space in the inventory");

			
		}
		
		
		}	
	
		//else for wrong password
		
		
		else {
			 
			for (int i = 0; password_attempts >= (Max_Attempts * 3); i++) {
				System.out.println("Password incorrect ! Try again.");
				password_attempts++;
				}
			 System.out.println("Program detected suspicious activities and will terminate immediately!");
			
			
				
				
			}
			
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void change_Book_Information(Scanner sc) {
		// as define in order to change infos, the user needs to enter a password(249)
		//so fisrt ask for the password
		
		System.out.print("Enter password: ");
		String password = sc.nextLine();
		if(password_attempts >= Max_Attempts * 4) {
			System.out.println("Program detected suspicous activities and will terminate immediately!");
			return;
			
		}
		else if (password.equals(password)){
			System.out.print("Enter the book number you wish to update: ");
			int book_number = sc.nextInt();
			System.out.println();
			//verify if the user enter correct informations
			if(book_number < 0 || book_number > Num_Of_Books || inventory[book_number] == null){
				
				System.out.println("Invalid book number, try again !");
				
			}
			else {
				book_for_a_day book = inventory[book_number];
				//at this point we gonna use getter methods defined in the class in part one 
				System.out.println("Book Number: " + book_number);
				System.out.print("Author: " + book.getAuthor());
				System.out.print("Title: " + book.getTitle());
				System.out.print("ISBN: " + book.getISBN());
				System.out.print("Price: " + book.getPrice());
				
				
				
			}
			
			
		}
		
		
	}

	private static void display_a_book_by_author(Scanner sc) {
		Scanner sca = new Scanner(System.in);
		System.out.println("Enter author name: ");
		String author_Name = sca.nextLine();
	}
	private static void display_a_book_price(Scanner sc) {
		System.out.println("Enter a price : ");
		double price =sc.nextDouble();
		Find_Cheaper_Than(price);
		
		
	}
	
	private static void Find_Cheaper_Than(double price) {
		boolean found = false; 
		System.out.println("Books with a price less than $" + price + ":");

	    for (int i = 0; i < Num_Of_Books; i++) {
	        if (inventory[i] != null && inventory[i].getPrice() < price) {
	            // Book is cheaper than the specified price, display it
	            System.out.println("Book Number: " + i);
	            System.out.println("Author: " + inventory[i].getAuthor());
	            System.out.println("Title: " + inventory[i].getTitle());
	            System.out.println("ISBN: " + inventory[i].getISBN());
	            System.out.println("Price: $" + inventory[i].getPrice());
	            System.out.println(); // Add a separator line
	            found = true; // Set found flag to true
	        }
	    }

	    if (!found) {
	        System.out.println("No books found less than $" + price);
	    }
	}
		
		
	}



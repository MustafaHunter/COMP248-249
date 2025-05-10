/* 
 * Alawadi Mustafa (40217764)
 * Mehrad Moostan (40248205)
 * Comp249
 * Assignment 3 
 * Due December 1
 * Page3
 */



import java.io.*;
import java.util.*;


public class CellListUtilization {


	//create a class for scanner input, that contains two methods, and a single attribute
	//one method to call(create) other for close
	
	static class Instance {
		//use Scanner

		static Scanner sc;

		
		static void scanKey() {
			sc = new Scanner(System.in);
		}

		//close it
		static void closeScanKey() {
			
			//closing it so no data is lost by accident and making compile happy
			sc.close();
		}
	}

	//the entire main method
	public static void main(String[] args) {

		
		boolean fix = true; 

		CellList cellphonesFromFile = new CellList();
		CellList testingCellList  = new CellList();

		// Open Scanner for Cell_Info.txt
		final String inputFileName = "Cell_Info.txt";
		ReadingFile  ReadingFile  =new ReadingFile();
		ReadingFile.initializeReader(inputFileName);
		Scanner reader = ReadingFile.getInputReader();

		// Read inputs from the CellList class and put into a list
		
		int parseCounter = 0;
		while (reader.hasNextLine())
		{
			
			CellPhone cellPhoneFromLine = convertingCellPhone(reader);

			
			// Only add if the serial number doesn't exist
			if (!cellphonesFromFile.contains(cellPhoneFromLine.getSerialNumber()))
			{
				
				cellphonesFromFile.add(cellPhoneFromLine);
			}
			else
			{
				
			}
		}

		// Show content of list
		cellphonesFromFile.showContents();

		// Get serial numbers from user and search if it's there
		Instance.scanKey();
		boolean isEndProgram = false;

		//check using a while loop it will run as long as the program is not terminated
		while (!isEndProgram)
		{
			//use switch
			switch (displayMenu())
			{
				case 1:// Implementation for serial searching
					
					lookForSerialNumber(fix, cellphonesFromFile);
					break;
				case 2:
					
					demoOfCellPhoneMethods(cellphonesFromFile);
					break;
				case 3:
					
					tryingCellListMethods(cellphonesFromFile, testingCellList);
					break;
				case 4:
					System.out.println("\nWarning: progrm will crash.");
					end_insertAtIndex(cellphonesFromFile, 300);
					break;
				case 5:
					System.out.println("\nWarning: progrm will crash.");
					end_deleteFromIndex(cellphonesFromFile, 300);
					break;
				case 6:
					System.out.println("\nWarning: progrm will crash.");
					error_replaceAtIndex(cellphonesFromFile, 300);
					break;
				case 0:
					System.out.println("Program wil end.");
					isEndProgram = true;
					break;
				default:
					System.out.println("No such option. Please try again.");
					break;
			}
		}

	
		Instance.closeScanKey();
		ReadingFile.closeFiles();
		System.out.println("Program ended");
	}

	public static int displayMenu() {
		System.out.println("\n\nThese are the available options for this program.");
		System.out.println("[1]\t" + "Look for a serial number");
		System.out.println("[2]\t" + "Test the CellPhone Methods");
		System.out.println("[3]\t" + "Test the CellNode Methods");
		System.out.println("[4]\t" + "Insert at index");
		System.out.println("[5]\t" + "Delete from index");
		System.out.println("[6]\t" + "Error: Replace at Index");
		System.out.println("[0]\t" + "Ending Program.");

		boolean Continue = true;
		while (Continue)
		{
			try
			{
				System.out.print("\nPlease choose an option: ");
				return Instance.sc.nextInt();
			} catch (InputMismatchException e)
			{
				System.out.println("You need to insert an integer. Try again.");
				// Garbage the inputs
				Instance.sc.nextLine();
			}
		}

		return 0;
	}
//use this method to display the program to the user
	public static void demoOfCellPhoneMethods(CellList cellphoneFromFiles) {
		// Default constructor
		
		CellPhone cellphone1 = new CellPhone();
		System.out.println(cellphone1);
		System.out.print("\n");

	
		
		CellPhone cellphone2 = new CellPhone(123456, "Your choice", 871, 2009);
		System.out.println(cellphone2);
		System.out.print("\n");

	
		
		CellPhone cellphone3 = new CellPhone(cellphone2, 789101);
		System.out.println(cellphone3);
		System.out.print("\n");

		
		
		CellPhone cellphone4 = cellphone3.clone();
		System.out.println(cellphone4);
		System.out.print("\n");

		
		System.out.println("Accessors testing");
		System.out.println("Get Serial: " + cellphone3.getSerialNumber());
		System.out.println("Get Brand: " + cellphone3.getBrand());
		System.out.println("Get Price: " + cellphone3.getPrice());
		System.out.println("Get Year: " + cellphone3.getYear());
		System.out.print("\n");

		
		
		System.out.println("Change Serial to: 400");
		cellphone3.setSerialNumber(400);
		System.out.println("Change Brand to: HP");
		cellphone3.setBrand("HP");
		System.out.println("Change Price to: 24:00");
		cellphone3.setPrice(10.00);
		System.out.println("Change Year to: 2003");
		cellphone3.setYear(2003);
		System.out.println(cellphone3);
		System.out.print("\n");
	}
//use this method to display the program to the user
	public static void tryingCellListMethods(CellList cellphoneFiles, CellList otherList) {
	
		System.out.println("Deleting from start of empty list.");
		otherList.deleteFromStart();
		System.out.println("Copying the list of cellphones from files");
		otherList = new CellList(cellphoneFiles);
		System.out.println("Displaying the original list.");
		cellphoneFiles.showContents();
		System.out.println("Displaying copy list.");
		otherList.showContents();
		System.out.println("Checking for equality: " + cellphoneFiles.equals(otherList));
		System.out.print("\n");

		
		System.out.println("Deleting node at index 3 on copy cellphone list.");
		otherList.deleteFromIndex(3);
		System.out.println("Creating a new cellphone of serial number: 300, brand Nike, price 24.21, year 2023.");
		CellPhone cellPhone = new CellPhone(420, "Testing", 21.99, 2019);
		System.out.println("Showing cellphone: " + cellPhone);
		System.out.println("Replacing original list at index 3 for new cellphone.");
		cellphoneFiles.replaceAtIndex(cellPhone, 3);

		// Showing the two list
		System.out.println("Showing the two lists.");
		cellphoneFiles.showContents();
		otherList.showContents();
		System.out.print("\n");

		System.out.println("Add to start of list.");
		cellphoneFiles.addToStart(cellPhone);
		cellphoneFiles.showContents();
		System.out.print("\n");

		System.out.println("Insert at Index 3");
		cellphoneFiles.insertAtIndex(cellPhone, 4);
		cellphoneFiles.showContents();
		System.out.print("\n");

		System.out.println("Delete from Index 3");
		cellphoneFiles.deleteFromIndex(3);
		cellphoneFiles.showContents();
		System.out.print("\n");

		System.out.println("Delete from start");
		cellphoneFiles.deleteFromStart();
		cellphoneFiles.showContents();
		System.out.print("\n");

		System.out.println("Replace at Index");
		cellphoneFiles.replaceAtIndex(cellPhone, 2);
		cellphoneFiles.showContents();
		System.out.print("\n");
	}
	
	public static void end_insertAtIndex(CellList cellphonesFromFile, int index) {

		System.out.println("Create a cellphone to insert at index " + index);
		System.out.println("Creating a new cellphone of serial number: 300, brand Nike, price 24.21, year 2023.");
		CellPhone cellPhone = new CellPhone(300, "Nike", 24.21, 2023);

		cellphonesFromFile.insertAtIndex(cellPhone, index);

	}

	public static void end_deleteFromIndex(CellList cellphonesFromFile, int index) {
		System.out.println("Deleting node at index " + index);
		cellphonesFromFile.deleteFromIndex(index);
	}

	public static void error_replaceAtIndex(CellList cellphonesFromFile, int index) {
		System.out.println("Create a cellphone to replace at index " + index);
		System.out.println("Creating a new cellphone of serial number: 300, brand Nike, price 24.21, year 2023.");
		CellPhone cellPhone = new CellPhone(300, "Nike", 24.21, 2023);

		cellphonesFromFile.replaceAtIndex(cellPhone, index);
	}
	
	
	
	
	
	
	
	
	
	public static long UserInput() {
		long serialNumber = 0;
		//call the scanner class
		Scanner scan = Instance.sc;

		boolean correctSerial = false;

		do
		{
			System.out.print("Please enter a serial number : ");

			//exception handelling
			try
			{
				
				serialNumber = scan.nextLong();
				correctSerial = true;

			} catch (InputMismatchException e)
			{
				System.out.println("The serial number is not valid. \n" + "Please make sure that the serial number is only made out of numbers.\n" + "Try again. \n");

			
				//
				if (scan.hasNextLine())
				{
					scan.nextLine();
				}
			}
		} while (!correctSerial);

		return serialNumber;
	}

	
	private static void manipulatePrintNumber(boolean fix, long number) {
		if (fix)
		{
			System.out.println("Printing serial number: " + number);
		}
	}
	
	
	
	
	
	
	
//search for a serial number method 
	public static void lookForSerialNumber(boolean fix, CellList cellphonesFromFile) {
		boolean Continue = true;
		int searchCounter = 0;
		while (Continue)
		{
			
			System.out.println("\n\n" +
					"Serial number search #" + (searchCounter + 1) + "\n" + "========================\n");
			System.out.println("Input a serial number to search for. Enter 0 to exit.");
			long serialNumber = UserInput();
			manipulatePrintNumber(fix, serialNumber);

			if (serialNumber == 0)
			{
				System.out.println("You've searched " + searchCounter + " time(s).");
				Continue = false;
			}
			else
			{

				
				cellphonesFromFile.lookFor(serialNumber);
			}

			searchCounter++;
		}
	}

	public static CellPhone convertingCellPhone(Scanner reader) {
		String line = reader.nextLine();
		StringTokenizer token = new StringTokenizer(line);
		//use an array
		String[] cellphoneInfo = new String[4];

		int index = 0;
		while (token.hasMoreTokens())
		{
			cellphoneInfo[index] = token.nextToken();
			index++;
		}
		return new CellPhone(Long.parseLong(cellphoneInfo[0]), cellphoneInfo[1], Double.parseDouble(cellphoneInfo[2]), Integer.parseInt(cellphoneInfo[3]));
	}


	
	
	
}	
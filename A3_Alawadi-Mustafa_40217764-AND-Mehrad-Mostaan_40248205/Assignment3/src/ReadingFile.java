/* 
 * Alawadi Mustafa (40217764)
 * Mehrad Moostan (40248205)
 * Comp249
 * Assignment 3 
 * Due December 1
 * Page4
 */



import java.io.*;

import java.util.*;

//this class will enable to read from the provided text: Cell_Info.txt

public class ReadingFile {

	boolean displayIssue = false;                      
	private Scanner inputReader = null;
	private PrintWriter outputWriter = null;
	private String inputFileName = null;
	private String outputFileName = null;

	
	//default constructor
	public ReadingFile() {
		if (displayIssue)
		{
			System.out.println("ReadingFile.java default constructor tested." + "\ninputReader and outputWriter have to be initialized manually." + "\n Use: initializeReader(String filename) and initializeWriter(String filename)");
		}
	}
	
	
	
public void InitializeScannerAndPrintWriter(String inputFileName, String outputFileName) {
		
		if (inputFileName != null && outputFileName != null)
		{
			
			if (!initializeReader(inputFileName))
			{
				System.out.println("End of program");
				System.exit(0);
			}

			
			if (!usingWriter(outputFileName))
			{
				System.out.println("End of program");
				System.exit(0);
			}
		}
	}

	//parametrized constructor
	public ReadingFile(String outputFileName) {
		inputFileName = promptForFileName(true);
		this.outputFileName = outputFileName;
		InitializeScannerAndPrintWriter(inputFileName, this.outputFileName);
	}
	
	
	
	
	//mutators and accessors : 
	
	

	public Scanner getInputReader() {
		return inputReader;
	}

	
	public PrintWriter getOutputWriter() {
		return outputWriter;
	}

	
	public String getInputFileName() {
		return inputFileName;
	}

	
	public String getOutputFileName() {
		return outputFileName;
	}


	


	//a boolean method 
	public boolean closeFiles() {
		if (inputReader != null || outputFileName != null)
		{
			if (inputReader != null)
			{
				if (displayIssue == true)
				{
					
				}
				inputReader.close();
			}

			if (outputWriter != null)
			{
				if (displayIssue == true)
				{
					
				}
				outputWriter.close();
			}

			return true;
		}
		else
		{
			return false;
		}
	}

	
	public String promptForFileName(boolean checkExists) {

		Scanner sc = new Scanner(System.in);
		boolean accept_input = false;
		String filename = null;
		int usingCounter = 1;

		do
		{

			if (usingCounter > 3)
			{
				System.out.println("Limit of tries.");
				System.out.println("Bye.");
				System.exit(0);
			}
			else if (usingCounter != 1)
			{
				System.out.println("\nTry again. Try #" + usingCounter + " (3 Maximum)");
			}

			// Prompting user
			System.out.print("Please enter the full name of the file \n you wish to create a dictionary: ");
			filename = sc.nextLine();

			if (!filename.contains("."))
			{
				accept_input = false;
				System.out.println("\nPlease enter a file extension. Try again.");
				usingCounter++;
			}
			else if (checkExists)
			{
				// Check if the file exists
				File inputFile = new File(filename);
				if (!inputFile.exists())
				{
					System.out.println("\nThe file doesn't exist. Check your input and that the file is in the right directory.");
					usingCounter++;
				}
				else
				{
					accept_input = true;
				}
			}

		}
		while (!accept_input);

		return filename;
	}

	// boolean file to read
	public boolean initializeReader(String filename) {
		try
		{
			
			this.inputReader = new Scanner(new FileInputStream(filename));
			
			return true;
		} catch (FileNotFoundException e)
		{
			System.out.println("Error opening Scanner using " + filename + ": \n" + e.getMessage());
			return false;
		}
	}


	
	public boolean usingWriter(String filename) {
		try
		{
			
			this.outputWriter = new PrintWriter(new FileOutputStream(filename));
		
			return true;
		} catch (FileNotFoundException e)
		{
			System.out.println("Error opening PrintWriter using " + filename + ": \n" + e.getMessage());
			return false;
		}
	}

	
	public boolean deleteOutput() {
		File outputFile = new File(outputFileName);
		if (outputFile.exists())
		{
			outputFile.delete();
			return true;
		}
		else
		{
			return false;
		}
	}
}
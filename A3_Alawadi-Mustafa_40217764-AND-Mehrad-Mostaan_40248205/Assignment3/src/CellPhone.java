/* 
 * Alawadi Mustafa (40217764)
 * Mehrad Moostan (40248205)
 * Comp249
 * Assignment 3 
 * Due December 1
 * Page1
 */



import java.util.*;


public class CellPhone {

	
	//private attributes
	private long   serialNumber;
	private String brand;
	private int    year;
	private double price;

	//default constructor
	public CellPhone() {
		
	}

	//parametrized constructor
	public CellPhone(long serialNumber, String brand, double price, int year) {
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}

	//copy constructor, with two parametr, second one a long serialNumber 
	public CellPhone(CellPhone cellphone, long serialNumber) {
		this.serialNumber = serialNumber;
		this.brand = cellphone.brand;
		this.year = cellphone.year;
		this.price = cellphone.price;
	}

	
	public CellPhone clone() {
		Scanner scanner = CellListUtilization.Instance.sc;
		boolean is_Correct       = false;
		long newSerialNumber = 0;

		//use a while loop
		while (!is_Correct)
		{
			try
			{
				System.out.print("Please enter a new serial number for the cloned cellphone: ");
				newSerialNumber = scanner.nextLong();
				is_Correct = true;
			} catch (InputMismatchException e)
			{
				System.out.println("Please enter a valid serial number. Try again...");

				if (scanner.hasNextLine())
				{
					scanner.nextLine();
				}
			}
		}

		return new CellPhone(this, newSerialNumber);
	}

	//generate mutators and accessor
	public long getSerialNumber() {
		return serialNumber;
	}

	
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBrand() {
		return brand;
	}

	
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	
	public void setYear(int year) {
		this.year = year;
	}

	
	public double getPrice() {
		return price;
	}

	
	public void setPrice(double price) {
		this.price = price;
	}

	//an equals() method using object
	public boolean equals(Object obj) {
		if (this == obj)
		{
			return true;
		}
		if (obj == null || getClass() != obj.getClass())
		{
			return false;
		}
		//casting
		CellPhone cellPhone = (CellPhone) obj;
		return year == cellPhone.year &&
				Double.compare(cellPhone.price, price) == 0 &&
				brand.equals(cellPhone.brand);
	}

	//String method
	public String toString() {
		return "[" + serialNumber + ": " + brand + " " + price + "$ " + year + "]";
	}
}
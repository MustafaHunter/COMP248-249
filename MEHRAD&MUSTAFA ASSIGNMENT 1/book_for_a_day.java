

/*
 * 
 * Assignment 0
 * Part1: Book
 * Written by Mehrad Mostaan(40248205)
 * presented to professor Dr.Aiman Hanna
 * 
 */


public class book_for_a_day {
	
	//as mentioned in the specifications we need 4 attributes
	
	private String title;
	private String author;
	private long ISBN;
	private double price;
	
	
	private static int numberOfCreatedBooks;

	// define and design a book class 
	
	//a parametrized constructor
	public book_for_a_day (String title, String author, long ISBN, double price) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.price = price;
		
		//
		numberOfCreatedBooks++;
		
		
	}
	
	//a getter method for title
	public String getTitle() {
		return title;
		
	}
	// a setter method for title 
	public void setTitle(String title) {
		this.title = title;
		
	}
	
	// a getter method for author 
	public String getAuthor() {
		return author;
	}
	
	//a setter method for author 
	public void setAuthor(String author) {
		this.author = author;
	}
	
	// a getter method for ISBN
	public long getISBN() {
		return ISBN;
		
	}
	//a setter for ISBN
	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}
	// a getter for price
	public double getPrice() {
		return price;
		
	}
	//a setter for price
	public void setPrice(double price) {
		this.price=price;
	}
	
	
	
	
	//findNumberOfCreatedBooks()
	
	public static int numberOfCreatedBooks() {
		return numberOfCreatedBooks;
	}
	
	
	// equals method
	
	
	 public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
	        book_for_a_day otherBook = (book_for_a_day) obj;
	        return ISBN == otherBook.ISBN && Double.compare(price, otherBook.price) == 0;
	    }
	
	
	//to string method
	
	public String toString() {
		
		return "Book : " + " "
				+ "\n " + " Title : " + title + 
				 " \n " + " author : " + author 
				+ " \n " + " ISBN : " + ISBN +  
				" \n " + " price : " + price; 
						
	}

	

}

/*
 * 
 * Assignment 0
 * Part1: Book_main
 * Written by Mehrad Mostaan(40248205)
 * presented to professor Dr.Aiman Hanna
 * 
 */
public class main {

	public static void main(String[] args) {

		 // Create some Book objects
		book_for_a_day book1 = new book_for_a_day("Title 1", "Author 1", 1234567890L, 19.99);
		book_for_a_day book2 = new book_for_a_day("Title 2", "Author 2", 1234567890L, 19.99);

        // Display book information using toString()
        System.out.println(book1.toString());
        System.out.println(book2.toString());

        // as defined in the class we can choose the getter and setter attribute 
        
        System.out.println("Original Title of book1: " + book1.getTitle());
        
        book1.setTitle("New Title");
        
        System.out.println("Updated Title of book1: " + book1.getTitle());

        // Compare books for equality
        //use boolean :true or false 
        boolean areEqual = book1.equals(book2);
        System.out.println("Are the books equal? " + areEqual);

        // Find the number of created books
       int numberOfBooks = book_for_a_day.numberOfCreatedBooks();
        System.out.println("Number of created books: " + numberOfBooks);
    }
}
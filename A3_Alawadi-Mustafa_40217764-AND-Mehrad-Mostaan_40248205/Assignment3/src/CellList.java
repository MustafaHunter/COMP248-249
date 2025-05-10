/* 
 * Alawadi Mustafa (40217764)
 * Mehrad Moostan (40248205)
 * Comp249
 * Assignment 3 
 * Due December 1
 * Page2
 */




//import package
import java.util.*;

public class CellList {

	
	//create an inner class, private
	private class CellNode {

		//attributes
		CellPhone cellphone;
		CellNode  nextNode;

		
		
		
		//default constructor 
		public CellNode() {
			cellphone = null;
			nextNode = null;
		}

		//parametrized constructors 
		public CellNode(CellPhone cellphone, CellNode nextNode) {
			this.cellphone = cellphone;
			this.nextNode = nextNode;
		}

		//copy constructor
		public CellNode(CellNode cellNode) {
			this.cellphone = cellNode.cellphone;
			this.nextNode = cellNode.nextNode;
		}

		//we use a clone() method
		public CellNode clone() {

			
			return new CellNode(new CellPhone(this.cellphone, this.cellphone.getSerialNumber()), this.nextNode);
		}

		
		// use a boolean equal method
		public boolean equals(Object obj)
		{
			if (this == obj)
			{
				return true;
			}
			if (obj == null || getClass() != obj.getClass())
			{
				return false;
			}
			CellNode cellNode = (CellNode) obj;
			if (nextNode == null || cellNode.nextNode == null)
			{
				return nextNode == cellNode.nextNode;
			}
			else
			{
				return cellphone.equals(cellNode.cellphone) && nextNode.equals(((CellNode) obj).nextNode);
			}
		}
	}
//we move out of the inner class
	
	
	//attributes for the outer class
	//using node type
	private CellNode head;
	private int  size = 0;

	//default attribute
	public CellList() {
		head = null;
	}

	// a copy constructor
	public CellList(CellList cellList)
	{
		
		CellNode copyTheNode = cellList.head;

		for (int i = 0; i < cellList.size; i++)
		{
			if (copyTheNode != null)
			{
				add(copyTheNode.cellphone);
				copyTheNode = copyTheNode.nextNode;
			}
		}
	}

	//addToStart method
	public void addToStart(CellPhone cellPhone) {
		// Add the new node to the head, assign previous head as the nextNode
		head = new CellNode(cellPhone, head);
		size++;

	}

	//insertAtIndex
	public void insertAtIndex(CellPhone cellPhone, int index) {
		if (size == 0)
		{
			addToStart(cellPhone);
		}
		else
		{
			// Get related nodes
			CellNode node_beforeIndex = nodeAtIndex(index - 1, index);
			CellNode node_atIndex = node_beforeIndex.nextNode;

			// Create new node with nodeAtIndex as its nextNode
			CellNode nodeToInsert = new CellNode(cellPhone, node_atIndex);
			size++;

			// Point previous node to new node
			node_beforeIndex.nextNode = nodeToInsert;

			// Prevent leaks
			node_beforeIndex = null;
			node_atIndex = null;
			nodeToInsert = null;

			return;
		}
	}

	// a deletFromIndex()method
	public void deleteFromIndex(int index) {
		
		//exception
		try
		{
			
			if (size == 0)
			{
				throw new NullPointerException();
			}

			// Get the node right before the one at the index
			CellNode node_beforeIndex = nodeAtIndex(index - 1, index);

			// Skip the next node and go to the one after; assign it to that previous node
			node_beforeIndex.nextNode = node_beforeIndex.nextNode.nextNode;
			size--;

			
			node_beforeIndex = null;
			return;

		} 
		
		// use a catch block
		catch (NullPointerException e)
		{
			System.out.println("Error: the list is of size 0, You can't delete the element.");
			
			//stop the program
			System.exit(0);
		}
	}

	//deleteFromStart()method
	public void deleteFromStart() {
		
		//create multiple conditions
		if (size > 1)
		{
			head = head.nextNode;
			//decrementing
			size--;
		}
		else if (size == 1)
		{
			head = null;
			size = 1;
		}
		else
		{
			System.out.println("No more elements to be deleted");
		}
	}

	//replaceAtIndex() method
	public void replaceAtIndex(CellPhone cellPhone, int index)
	{
		//create multiple conditions
		if (index < 0 || index >= size)
		{
			System.out.println("No element to be replaced.");
			return;
		}
		else
		{
			// Navigate to node at index
			CellNode node_atIndex = nodeAtIndex(index -1 , index);

			// Replace that node
			node_atIndex.nextNode = new CellNode(cellPhone, node_atIndex.nextNode);

		}
	}

	//searching method
	private CellNode searching(long serialNumber) {
		int searchNum = 1;
		CellNode checkingNode   = head;

		//while condition check if is not equal to null (node)
		while (checkingNode != null)
		{
			
			// Check if it is equal, return the nodeToCheck if true
			if (checkingNode.cellphone.getSerialNumber() == serialNumber)
			{
				return checkingNode;
			}
			else
			{
				// Go to next node
				checkingNode = checkingNode.nextNode;
				searchNum++;
			}
		}

		
		return null;
	}

	//lookFor() method
	public void lookFor(long serialNumber) {
		System.out.println("\nSearching for the Serial Number# " + serialNumber + " in the list.");
		CellNode node = searching(serialNumber);

		if (node != null)
		{
			System.out.println("Found a matching serial number.\n \n This is 1the information of the cellphone:");
			System.out.println("\n" + node.cellphone);
		}
		else
		{
			System.out.println("There is no matching serial number found.\n");
		}
	}

	//contains, which is a boolean method
	public boolean contains(long serialNumber) {
		//check the condition if equals to null
		if (searching(serialNumber) == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	//show contnents method
	public void showContents() {

		// node pointing not equal to null (checked)
		if (head != null)
		{
			int nodeNum = 0;
			CellNode currentNode = head;

			// Printing header
			String message = "The current list is " + size + ". These are the contents of the list";
			System.out.print("\n" + message + "\n");
			for (int i = 0; i < message.length(); i++)
			{
				System.out.print("=");
			}
			System.out.print("\n");

			// Printing list
			while (currentNode != null)
			{

				if (nodeNum % 3 == 0 && nodeNum != 0)
				{
					// Insert return
					System.out.print("\n");
				}

				System.out.print(currentNode.cellphone);
				currentNode = currentNode.nextNode;
				System.out.print(" ---> ");
				nodeNum++;
			}
			System.out.println("X");
		}
		else
		{
			System.out.println("No nodes found to be printed.");
		}
	}

	//use a node
	private CellNode nodeAtIndex(int indexToCheck, int indexCallingMethod) {
		try
		{
			// Check if it's a valid index
			if ((indexToCheck < 0 || indexToCheck >= size) || (indexCallingMethod < 0 && indexCallingMethod >= size))
			{
				throw new NoSuchElementException();
			}
			else
			{
				// Return the node at the specified index
				CellNode node = head;
				for (int i = 0; i < indexToCheck; i++)
				{
					if (node != null)
					{
						node = node.nextNode;
					}
					else
					{
						throw new NullPointerException();
					}
				}

				return node;
			}
		} catch (NoSuchElementException e)
		{
			System.out.println("Error: " + indexCallingMethod + " is invalid index: " + e.getMessage());
			System.exit(0);
		} catch (NullPointerException e)
		{
			System.out.println("Error: unexpected null node in the middle of the linked list.");
			System.exit(0);
		}

		
		return null;
	}

	//add method
	public void add(CellPhone cellPhone) {
		if (size != 0)
		{
			
			
			CellNode lastNode = nodeAtIndex(size - 1, size - 1);
			lastNode.nextNode = new CellNode(cellPhone, null);
			size++;
			
		}
		else
		{
			addToStart(cellPhone);
		}
	}

	// equals() method
	public boolean equals(Object obj) {
		if (this == obj)
		{
			return true;
		}
		if (obj == null || getClass() != obj.getClass())
		{
			return false;
		}
		CellList cellList = (CellList) obj;
		return size == cellList.size && checkIfSameElements(cellList);
	}

	//boolean method for checkIfSame elements 
	public boolean checkIfSameElements(CellList list) {
		CellNode list_1Head = head;
		CellNode list_2Head = list.head;

			if (list_1Head == null || list_2Head == null)
			{
				if (list_1Head == null && list_2Head == null)
					return true;
				else
					return false;
			}
			else
			{
				return list_1Head.equals(list_2Head);
			}
	}
}
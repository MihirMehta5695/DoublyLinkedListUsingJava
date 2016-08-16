package dll;

import java.util.Scanner;

public class DLLTest 
{
	
	public static void main(String args[])
	{
		
		DoublyLinkedList ll=new DoublyLinkedList();//creating an object of SinglyLinkedClass
		Scanner sc=new Scanner(System.in);//Creating an object of scanner class to read input from user
		int choice;//to hold the choice of user
		int value,key;
		while(true)
		{
			
			System.out.println("\n\n\n\n\n");
			System.out.println("-------------------MENU--------------------");
			System.out.println("1)  Create List");
			System.out.println("2)  Insert value at the BEGINNING of the List");
			System.out.println("3)  Insert value at the AFTER a node of the List");
			System.out.println("4)  Insert value at the END of the List");
			System.out.println("5)  Delete the node from BEGINNING from the List");
			System.out.println("6)  Delete the node having a VALUE");
			System.out.println("7)  Delete the node from END of the List");
			System.out.println("8)  Find POSITION of a node having a value");
			System.out.println("9)  Display the Entire List in FORWARD order");
			System.out.println("10) Display the Entire List in BACKWARD order");
			System.out.println("11) Destroy the Entire List");
			System.out.println("12) Exit the program");
			System.out.println("---------------END OF MENU-----------------");
			System.out.println("\n\nEnter your choice : ");
			
			choice=sc.nextInt();//Inputting the user choice
			
			switch(choice)
			{
			
			 case 1:
				 		ll.createList();
				 		break;
			
			 case 2:
				 		System.out.println("Enter the value to insert : ");
				 		value=sc.nextInt();
				 		ll.insertAtBegin(value);
				 		break;
				 		
			 case 3:
				 		System.out.println("Enter the Key Node : ");
				 		key=sc.nextInt();
				 		System.out.println("Enter the value : ");
				 		value=sc.nextInt();
				 		ll.insertAfter(key, value);
				 		break;
				 		
			 case 4:
				 		System.out.println("Enter the Value : ");
				 		value=sc.nextInt();
				 		ll.insertAtEnd(value);
				 		break;
				 		
			 case 5:	
				 		ll.deleteAtBegin();
			 			break;
			 		
			 case 6:
				 		System.out.println("Enter the key node : ");
				 		key=sc.nextInt();
				 		ll.deleteValue(key);
				 		break;
			 		
			 case 7:
				 		ll.deleteAtEnd();
			 			break;
			 		
			 case 8:
				 		System.out.println("Enter the key Node : ");
				 		key=sc.nextInt();
				 		ll.findPosition(key);
			 			break;
			 		
			 case 9:	
				 		ll.displayList();
			 			break;
			 		
			 case 10:
				 		ll.displayListReverse();
				 		break;
				 		
			 case 11:
				 		ll.vanishList();
				 		break;
			 		
			 case 12:
				 		System.exit(0);
			 			break;
			 		
			 default:	
				 		System.out.println("Enter a valid choice !!!!");
				 		break;
			 			
				 		
				 		
				 		
			}//End of switch stmt
			
			
		}//end of while loop
		
	}//end of main method(.)
	
}//end of SLLTest class

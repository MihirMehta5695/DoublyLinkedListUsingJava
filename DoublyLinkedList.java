package dll;

public class DoublyLinkedList
{

	Node head;//The head of the list,which points towards the first node of list
	Node temp;//Temporary variable of Node type to help in insert and delete operations
	Node p;//The primary variable of type Node to be used for all operations regarding SinglyLinkedList
	boolean isListExisting=false;//flag for checking existence of the list
	boolean isListEmpty=true;//flag for checking if list is empty
	
	//Creating a list
	void createList()
	{

		head=new Node();//Creating the head node which points the first node of the list (if the list exists)
		isListEmpty=true;
		isListExisting=true;

	}//end of createList(.) method

	void insertAtEnd(int value)
	{

		if(!isListExisting)//Check if the list exists or not 
		{
			System.out.println("Error: No list exists yet,Please a create list to enter values");
			return;
		}//end of if

		if(isListEmpty)//if the list is empty the value is inserted at the begining of the list		
		{

			insertAtBegin(value);
			System.out.println("Value inserted successfully");
			return;

		}//end of if

		else
		{
			p=head.next;//assigning the first node to be represented by the variable 'p'

			while(p.next!=null)//traverse to the end of the list 
			{
				 
				p=p.next;
			}//end of while loop
			
			temp=new Node(value);//creating a new Node
			temp.next=p.next;//Assigning the value 
			temp.prev=p;
			p.next=temp;//variable 'p' points towards newly created node
			isListEmpty=false;
			isListExisting=true;
		}


	}//end of insertAtEnd(.) method
	
	void insertAtBegin(int value)
	{
		if(isListExisting)
		{
			temp=new Node(value);
			p=head.next;
			p=p.next;
			temp.next=head.next;//making the first node of the list as the second node of the list , since we are inserting node at the beginning
			head.next=temp;//head now points to the newly created node
			temp.prev=head;
			p.prev=temp;
			isListEmpty=false;
			isListExisting=true;
		}//end of if stmt
		
		else
		{
			System.out.println("Error: No list Exists,please create a new list and try again");
		}
		
		
	}//end of insertAtBegin(.) method
	
	void insertAfter(int key,int value)
	{
		if(isListExisting)
		{
			
			p=head.next;//assigning the value of first node to variable 'p'
			while(true)
			{
				
				if(p.data==key)
				{
					
					temp=new Node(value);
					temp.next=p.next;
					p.next=temp;
					temp.prev=p;
					return;
					
				}//end of if stmt
				
				else
				{
					if(p.next!=null)
					{
						
						p=p.next;
						continue;
					}//end of if stmt
					
					if(p.data==key)
					{
						
						temp=new Node(value);
						temp.next=p.next;
						p.next=temp;
						temp.prev=p;
						return;
						
					}//end of if stmt
					
					if(!isListEmpty)
					{
						
						System.out.println("Error: there exists no value so inserting the node at the end of the list! ");
						insertAtEnd(value);
						return;
						
					}//end of else stmt
					
					
				}//end of else stmt
				
			}//end of while stmt
			
		}//end of if stmt
		
		else
		{
			
			System.out.println("Error: The List does not exists!!!!");
			
		}//end of else stmt
		
		
	}//end of insertAfter(..)
	
	void displayList()
	{
		
		if(isListExisting&&!isListEmpty)
		{
			p=head.next;
			System.out.println("\n\n\nThe List is as : ");
			while(p.next!=null)
			{
				
				System.out.println(p.data);
				p=p.next;
				
			}//end of while stmt
			
			System.out.println(p.data);
			
						
		}//end of if stmt
		else
		{
			System.out.println("The List is either Empty or Not Existing yet,pls try again !");
		}
		
	}//end of displayList() method
		
	void findPosition(int value)//Find the position of a node with first occurance of a particular value with respect to head node
	{
		if(isListExisting&&!isListEmpty)
		{
			int count=1;//initialising the counter variable
			p=head.next;//initialising variable p with the first node
			
			while(p.next!=null)
			{
				
				if(p.data==value)//if the value is found
				{
					System.out.println("The node with the value "+value+" is found at Position : "+count);
					return;
				}//end of if stmt
				
				else
				{
					p=p.next;
					count++;
				}//end of else stmt
				
				
			}//end of while loop
			
			if(p.data==value)//if the value is found
			{
				System.out.println("The node with the value "+value+" is found at Position : "+count);
				return;
			}//end of if stmt
			
			else
			{
				System.out.println("Error : No such value is present in the list!");
				return;
			}//end of else stmt
		
		}//end of if stmt
		
		else
		{
			
			System.out.println("Error: Either the list does not exist yet or either the list is empty!");
			return;
			
		}//end of else stmt
			
	}//end of findPosition(.) method
	
	void deleteAtBegin()
	{
		if(isListExisting&&!isListEmpty)
		{
			
			p=head.next;//the node to be deleted is represented by temp;
			head.next=p.next;
			p=null;//deleting the node
			return;
			
		}//end of if stmt
		
		else
		{
			System.out.println("Error: Either the list does not exists yet or the list is empty!");
			return;
			
		}//end of else stmt
			
	}//end of deleteAtBegin() method

	void deleteAtEnd()
	{
		if(isListExisting&&!isListEmpty)
		{
			
			p=head.next;
			while(p.next!=null)
			{
				temp=p;
				p=p.next;
			}//end of while loop
			
			temp.next=p.next;
			p=null;
			return;
			
		}//end of if stmt
		
		else
		{
			System.out.println("Either the list doesnot exists or the list is empty!");
			return;
		}//end of else stmt
		
	}//end of deleteAtEnd() method

	void deleteValue(int key)
	{
		
		if(isListExisting&&!isListEmpty)
		{
			
			p=head.next;//assigning the value of first node to variable 'p'
			if(p.data==key)
			{
				deleteAtBegin();
				return;
			}//end of if stmt
			
			while(true)
			{
				if(p.data==key)
				{
					temp.next=p.next;
					p=null;
					return;
				}//end of if stmt
				
				else
				{
					
					if(p.next!=null)
					{
						temp=p;//making temp hold value of p;
						p=p.next;
						continue;
					}//end of if stmt
					
					if(p.next==null)
					{
						if(p.data==key)
						{
							temp.next=p.next;
							p=null;
							return;
						}//end of if stmt
						
						else
						{
							System.out.println("Error : no such node with given value exists");
							return;
						}//end of else stmt
						
					}//end of if stmt
					
					
												
				}//end of else statement
				
			}//end of while loop
			
		}//end of if stmt
		
		else
		{
			
			System.out.println("Error : Either the List is not created or the Lit is Empty");
						
		}//end of else stmt
		
		
	}//end of deleteAfter(.) method

	void vanishList()
	{

		head=null;
		isListEmpty=true;
		isListExisting=false;
	}
	
}//end of DoublyLinkedList class{}
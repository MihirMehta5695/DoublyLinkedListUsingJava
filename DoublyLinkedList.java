package dll;

public class DoublyLinkedList
{

	Node head;//The head of the list,which points towards the first node of list
	Node temp;//Temporary variable of Node type to help in insert and delete operations
	Node p;//The primary variable of type Node to be used for all operations regarding SinglyLinkedList
	boolean isListExisting=false;//flag for checking existence of the list
	boolean isListEmpty=true;//flag for checking if list is empty
	//completed declaration
	
	//Creating a list
	void createList()
	{

		head=new Node();//Creating the head node which points the first node of the list (if the list exists)
		isListEmpty=true;
		isListExisting=true;

	}//end of createList(.) method
	//completed createList(.) method

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
			System.out.println("Value inserted successfully at the beginning as the list is empty!");
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
			return;
		}//end of else stmt


	}//end of insertAtEnd(.) method
	//completed insertAtEnd(.) method
	
	void insertAtBegin(int value)
	{
		if(isListExisting)//checking whether the list is even created or not
		{
			
			if(isListEmpty)
			{
				temp=new Node(value);
				if(head.next==null)//special case if list is empty
				{
					
					temp.prev=head;
					head.next=temp;
					isListEmpty=false;
					return;
									
				}//end of if stmt
				
			}//end of if stmt
			temp=new Node(value);
			temp.next=head.next;
			p=temp.next;//making the first node of the list as the second node of the list , since we are inserting node at the beginning
			head.next=temp;//head now points to the newly created node
			temp.prev=head;
			p.prev=temp;
			isListEmpty=false;
			isListExisting=true;
			return;
			
		}//end of if stmt
		
		else
		{
			
			System.out.println("Error: No list Exists,please create a new list and try again");
			
		}//end of else stmt
		
		
	}//end of insertAtBegin(.) method
	//completed insertAtBegin stmt
	
	void insertAfter(int key,int value)
	{

		if(isListExisting)//checking whether the list even exists or not
		{
			
			if(isListEmpty)
			{
				
				if(head.next==null)
				{
					
					System.out.println("Warning: Since the list is Empty Inserting value at Beginning!");
					insertAtBegin(value);
					return;
					
				}//end of if stmt
				
			}//end of if stmt
			else
			{
				
				p=head.next;//assigning the value of first node to variable 'p'
				if(p.data==key)
				{
					temp=new Node(value);
					temp.next=p.next;
					temp.prev=p;
					p.next=temp;
					if(temp.next!=null)
					{
						p=temp.next;
						p.prev=temp;
						return;
					}//end of if stmt
					temp.next=null;
					return;
					
				}//end of if stmt
				
				while(true)
				{
					
					if(p.data==key)
					{
						temp=new Node(value);
						temp.next=p.next;
						temp.prev=p;
						p.next=temp;
						if(temp.next!=null)
						{
							p=temp.next;
							p.prev=temp;
							return;
						}//end of if stmt
						temp.next=null;
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
							temp.prev=p;
							p.next=temp;
							if(temp.next!=null)
							{
								p=temp.next;
								p.prev=temp;
								return;
							}//end of if stmt
							temp.next=null;
							return;
							
						}//end of if stmt
						
						if(!isListEmpty)
						{
							
							System.out.println("Error: there exists no value so inserting the node at the end of the list! ");
							insertAtEnd(value);
							return;
							
						}//end of if stmt
						
						
					}//end of else stmt
					
				}//end of while loop
				
			}//end of else stmt
			
		}//end of if stmt
		else
		{
			
			System.out.println("Error: The List does not exists!!!!");
			
		}//end of else stmt
		
		
	}//end of insertAfter(..)
	//completed
	
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
	//completed	
	
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
	//completed
	
	void deleteAtBegin()
	{
		if(isListExisting&&!isListEmpty)
		{
			
			temp=head.next;//the node to be deleted is represented by temp;
			head.next=temp.next;
			if(temp.next!=null)
			{
				
				p=temp.next;
				p.prev=head;
				temp=null;
				return;
				
			}//end of if stmt
			
			temp=null;//deleting the node
			head.next=null;
			isListEmpty=true;
			return;
			
		}//end of if stmt
		
		else
		{
			System.out.println("Error: Either the list does not exists yet or the list is empty!");
			return;
			
		}//end of else stmt
			
	}//end of deleteAtBegin() method
	//completed

	void deleteAtEnd()
	{
		if(isListExisting&&!isListEmpty)
		{
			
			p=head.next;
			if(p.next==null)
			{
				
				deleteAtBegin();
				isListEmpty=true;
				return;
				
			}//end of if stmt
			while(p.next!=null)
			{
				p=p.next;
			}//end of while loop
			
			temp=p.prev;
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
	//completed 

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
					if(p.next==null)
					{
						deleteAtEnd();
						return;
						
					}//end of if stmt
					temp=p.prev;
					temp.next=p.next;
					temp=p.next;
					temp.prev=p.prev;
					p=null;
					return;
				}//end of if stmt
				
				else
				{
					
					if(p.next!=null)
					{
						
						p=p.next;
						continue;
						
					}//end of if stmt
					
					System.out.println("No value exists in List!");
					break;
																	
				}//end of else statement
				
			}//end of while loop
			
		}//end of if stmt
		
		else
		{
			
			System.out.println("Error : Either the List is not created or the List is Empty");
						
		}//end of else stmt
		
		
	}//end of deleteValue(.) method
	//Completed deleteValue(.) method

	void vanishList()
	{

		head=null;
		isListEmpty=true;
		isListExisting=false;
	}//end of vanishList() method
	//Completed vanishList() method
	
	void displayListReverse()
	{
		
		if(isListExisting&&!isListEmpty)
		{
			p=head.next;
			System.out.println("\n\n\nThe List in reverse order is as : ");
			while(p.next!=null)
			{
				
				p=p.next;
				
			}//end of while stmt
			
			while(p.prev!=head)
			{
				
				System.out.println(p.data);
				p=p.prev;
				
			}//end of while stmt
			
			System.out.println(p.data);
									
		}//end of if stmt
		
		else
		{
			
			System.out.println("The List is either Empty or Not Existing yet,pls try again !");
			
		}//end of else stmt
		
	}//end of displayListReverse()
	//completed displayListReverse()
	
}//end of DoublyLinkedList class{}
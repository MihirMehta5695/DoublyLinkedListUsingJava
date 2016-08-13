package dll;

public class Node 
{

	int data;//to hold the data
	Node prev;//to point towards the previous node in the list
	Node next;//to point towards the next node in the list
	
	Node()//Explicit no-arg constructor for head node only
	{
		data=-1;
		next=null;
		prev=null;
	}//end of ctor
	
	Node(int value)//Explicit arg ctor for all nodes except head node
	{
		data=value;
		next=null;
		prev=null;
	}//end of arg ctor
}

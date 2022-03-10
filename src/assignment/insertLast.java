package assignment;

public class insertLast 
{void insertLast(int key, int data) 

	   //create a link
	   struct node *link = (struct node*) malloc(sizeof(struct node));
	   link->key = key;
	   link->data = data;
		
	   if(isEmpty()) {
	      //make it the last link
	      last = link;
	   } else {
	      //make link a new last link
	      last->next = link;     
	      
	      //mark old last node as prev of new link
	      link->prev = last;
	   }

	   //point last to new last node
	   last = link;

}

import java.util.AbstractList;

/*
 * Name: Lawond Zangana 
 * Email: lazangana@ucsd.edu
 * PID: A17708568
 */

public class MyLinkedList<E> extends AbstractList<E> {

    int size;
    Node head;
    Node tail;


    /**
     * A Node class that holds data and references to previous and next Nodes.
     */
    protected class Node {
        E data;
        Node next;
        Node prev;

        /** 
         * Constructor to create singleton Node 
         * @param element Element to add, can be null	
         */
        public Node(E element) {
            // Initialize the instance variables
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /** 
         * Set the parameter prev as the previous node
         * @param prev new previous node
         */
        public void setPrev(Node prev) {
            this.prev = prev;		
        }

        /** 
         * Set the parameter next as the next node
         * @param next new next node
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /** 
         * Set the parameter element as the node's data
         * @param element new element 
         */
        public void setElement(E element) {
            this.data = element;
        }

        /** 
         * Accessor to get the next Node in the list 
         * @return the next node
         */
        public Node getNext() {
            return this.next;
        }
        /** 
         * Accessor to get the prev Node in the list
         * @return the previous node  
         */
        public Node getPrev() {
            return this.prev;
        } 
        /** 
         * Accessor to get the Nodes Element 
         * @return this node's data
         */
        public E getElement() {
            return this.data;
        } 
    }

    //  Implementation of the MyLinkedList Class

    public MyLinkedList() {
       
    /* Add your implementation here */
        // TODO
        
        //initialize all necessary variables 
        this.head = new Node(null);
        this.tail = new Node(null); 
        head.next = tail; 
        tail.prev = head;
        size = 0; 
        
    }

    @Override
    public int size() {
        /* Add your implementation here */
        return size; // TODO
    }

    @Override
    public E get(int index) {
        /* Add your implementation here */

        //Throw IndexOutOfBoundsException if true
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

       

        //Create node that can be used to track where we are
        Node tracker2 = head; 
        /* Loop through starting from the head until 1 before the 
        index we want */
        for (int i = 0; i < index+1; i++) {
            tracker2 = tracker2.next; 
        } 
        
        
        //Return this specificNode
        return tracker2.getElement();  // TODO
    }

    @Override
    public void add(int index, E data) {
        /* Add your implementation here */
        // TODO

        //Throw NullPointerException if true 
        if (data == null) {
            throw new NullPointerException("data can not be null");
        }

        //Throw IndexOutofBoundsException if true
        if (index < 0 || index >size) {
            throw new IndexOutOfBoundsException(); 
        }

        //Create a new node that uses the new data
        Node nodeAdded = new Node(data);

        //For loop that goes through all Nodes until one before our index
        Node tracker2 = head; 
        for (int i = 0; i < index; i++) {
            tracker2 = tracker2.next; 
        } 

        // Adding the node to the specific index

        /* set the node in front of new Node to point back to our 
        nodeAdded */ 
        tracker2.next.prev = nodeAdded;

        /* Set our nodeAdded next to the node that was originally in the 
        front */ 
        nodeAdded.next = tracker2.next;

        //Set the node before to the nodeAdded
        tracker2.next = nodeAdded; 

        //Set the nodeAdded previous to the Node before it
        nodeAdded.prev = tracker2; 
        
        //Increase size 
        size++; 

    }

    @Override
    public boolean add(E data) {
        /* Add your implementation here */

        //NullPointerException to be thrown if true 
        if(data == null) {
            throw new NullPointerException("data can not be null."); 
        }

       //Adding the node at the end of the list

       /* Set the Node that comes before the tail as its own node, 
       to ensure no data is lost */
       Node prevNode = tail.prev; 

       //Create a new node that uses the new data
       Node newNode = new Node(data);

       //Set the previous Node's next to the new Node 
       prevNode.next = newNode; 

       /*Set the new Node's next to the tail, which means it's 
       in the end */ 
       newNode.next = tail; 

       //Set the tail's previous to the new Node added
       tail.prev = newNode;

       //Set the new Node's previous to the Node that came before it
       newNode.prev = prevNode; 
    
        //Increase size 
        size++; 

        return true; // TODO
}

    @Override
    public E set(int index, E data) {
        /* Add your implementation here */

        //Throw NullPointerException if true
        if (data == null) {
            throw new NullPointerException();
        }
        //Throw IndexOutOfBoundsException if true
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }


         //For loop that goes through all Nodes until one before our index
         Node tracker2 = head; 
         for (int i = 0; i < index; i++) {
             tracker2 = tracker2.next; 
         } 

        //Save the data of the old node into a variable
         E oldData = tracker2.next.getElement();

        //Set the Node before where we want to add to the new Node
         tracker2.next.setElement(data);
        

        //return the old data of the Node
        return oldData;
        
    }

    @Override
    public E remove(int index) {
        /* Add your implementation here */

         //Throw IndexOutOfBoundsException if true
         if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        //For loop that goes through all Nodes until one before our index
        Node tracker2 = head; 
        for (int i = 0; i < index+1; i++) {
            tracker2 = tracker2.next; 
        } 
        
       //Save old data to a variable
       E oldData = tracker2.getElement();
    
       /* Make the Nodes that are before and after the one we are removing 
       to point at each other */ 
       tracker2.prev.next = tracker2.next; 
       tracker2.next.prev = tracker2.prev;
       tracker2.prev = null; 
       tracker2.next = null; 
        

        //Decrement the size
        size--;
        return oldData; // TODO
    }

    @Override
    public void clear() {
        /* Add your implementation here */
        // TODO

        if (size > 0) { 
       head.next.prev = null; 
       tail.prev.next = null; 
       head.next = tail; 
       tail.prev = head; 
        } 
        //change size back to default of 0
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        /* Add your implementation here */
        /* if statement that checks if the head and the tail are both 
         * pointing at null, which would mean there is nothing in the list
         */
        if (size == 0){
            return true;
        } else
         return false;
    }

    protected Node getNth(int index) {
        /* Add your implementation here */

        //IndexOutOfBoundsException to be thrown if true
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(); 
        }

        /*Create a Node variable that is initialized to the head, to ensure 
        you start from the beginning */
        Node tracker = head; 
        //For loop that runs until index and updates tracker to current node
       for (int i = 0; i < index+1; i++){
        tracker = tracker.getNext(); 
       }
       //return tracker, which is now the updated node at index
       return tracker;
    }

    public boolean contains(E elem, int start, int end) {
        /*Add your implementation here */

        //Throw IndexOutOfBoundsException if true 
        if (start < 0 || start >= size || end < 0 || end > size) {
            throw new IndexOutOfBoundsException();
        }

        //if statement that checks if the given range is valid
        if (end <= start){ 
            return false;
        }  

      
        //Loop through the given range and see if the element is there
        for(int i = start; i < end; i++) {
            Node tracker2 = getNth(i);
           if(tracker2.data.equals(elem)) { 
            return true;
           }
        
          } return false;

    }
}

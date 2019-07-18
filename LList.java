
public class LList <T> implements MyCollectionInterfaceProject04 {
	
	// ************************************************************************
		
	private static class Node<T> {
		
		private T element;
		private Node<T> prev;
		private Node<T> next;
		public Node(T e, Node<T> p, Node<T> n) {
			element = e;
			next = n;
			prev = p;
		}
		
		public T getElement() {
			return element;
		}
		
		public Node<T> getNext() {
			return next;
		}
		
		public Node<T> getPrev() {
			return prev;
		}
		
		public void setPrev(Node<T> p) {
			prev = p;
		}
		
		public void setNext(Node<T> n) {
			next = n;
		}
		
	} // End nested Node class
	
	// ************************************************************************	
	
	private Node<T> head = null; // Creates head of list
	private Node<T> tail = null; // Creates tail of list
	private int size = 0; // sets current size to 0
	
	// ********************************************************************

	public LList() {
		
		head = new Node<>(null, null, null);
		tail = new Node<>(null, head, null);
		head.setNext(tail);
		
	} // End Constructor
	
	// ************************************************************************

	public int size() {
		
		return size;
      
	} // End size
	
	// ************************************************************************

	public T first() {
		if(isEmpty()) {
			return null;
		}
		return head.getElement();
      
	} // End first
	
	// ************************************************************************

	public T last() {
		if(isEmpty()) {
			return null;
		}
		
		return tail.getElement();
		
	} // End last
	
	// ************************************************************************

	public void addFirst(T anEntry) {
		Node<T> newNode = new Node<>(anEntry, head, tail);
		if(size == 0) {
			
			tail = head;
		}
		
		else {
			
		head.setNext(newNode);
		head = newNode;
		
		}
		
		size++;
      
	} // End addFirst
	
	// ************************************************************************

	public void addLast(T anEntry) {
		Node<T> newNode = new Node<>(anEntry, null, tail);
		if(isEmpty()) {
			head = newNode;
			
		}
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
      
	} // End addLast
	
	// ************************************************************************

	public T removeFirst() {
		if(isEmpty()) {
			return null;
		}
		T answer = head.getElement();
		head = head.getNext();
		size--;
		
		if(size == 0) {
			tail = null;
		}
		
		return answer;
      
	} // End removeFirst
	
	// ************************************************************************

	public void firstNode(T t) {
		final Node<T> f = head;
		final Node<T> newNode = new Node<>(null, head, tail);
		head = newNode;
		if (head == null) {
			head = newNode;
		}
      
	} // End firstNode
	
	// ************************************************************************
	
	public T replace (int givenPosition, T newEntry) {
		
		if ((givenPosition == 1) && (givenPosition <= size)) {
			
			Node desiredNode = getNodeAt(givenPosition);
			newNode = newNode.getNextNode(nodeAfter);
			newNode = head;
			head = null;
		}
		
	} // End replace

	// ************************************************************************

	private Node<T> getNodeAt(int givenPosition) {
		
		if((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) {
			
			Node newNode = new Node();
			
		}
		
		return null;
      
	} // End getNodeAt
	
	// ************************************************************************

	public boolean add(T givenPosition) {
		
		Node newNode = new Node(newNode, newNode, newNode);
		if(isEmpty()) {
			newNode = head;
			
		}
		
		else {
			Node lastNode = getNodeAt(size);
			lastNode.setNext(newNode);
			
		}
		
		return true;
      
	} // End add

	// ************************************************************************

	public boolean add(Object newItem, int position) {
		
		
		return false;
	}

	// ************************************************************************

	public boolean remove(Object anEntry) {
		

		
		return false;
		
	} // end remove

	// ************************************************************************

	public void clear() {

		head.setNext(null);
		
	} // End clear

	// ************************************************************************

	public int getCurrentSize() {

		return size;
		
	} // End getCurrentSize

	// ************************************************************************

	public boolean isEmpty() {
		
		if(size == 0) {
			
			return true;
			
		}
		
		return false;
      
	} // End isEmpty

	// ************************************************************************

	public int getFrequencyOf(Object anEntry) {

		return 0;
      
	} // End getFrequencyOf

	// ************************************************************************

	public boolean contains(T anEntry) {
				
		boolean found = false;
		
		return found;
	} // End Contains

} // End Class

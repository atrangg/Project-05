/*
 * Stack Class - methods used for stack
 * 
 * @author Trang, Anthony
 * @version 1
 * 
 */

public class Stack<T> {

	LList<T> link = new LList<T>(); // Instantiate class LList
		
	/*
	 * push method - pushes the first element into the link
	 */
	
	public void push(T data) {
		
		link.addFirst(data);
		
	} // End push
	
	// ********************************************************************

	/*
	 * pop method - pops the first element out of the link
	 */
	
	public String pop() {
		
		return link.removeFirst();
		
	} // End pop
	
	// ********************************************************************

	/*
	 * peek method - Displays the first element on the top of the link.
	 */
	public String peek() {
		
		return link.first();
		
	} // End peek
	
	// ********************************************************************

	/*
	 * isEmpty - Checks if the stack is empty.
	 * 
	 * @return if the stack is empty.
	 */
	
	public boolean isEmpty() {
		
		return link.isEmpty();
		
	} // end isEmpty
	
	// ********************************************************************

	/*
	 * clear method - Clears the stack elements
	 */
	
	public void clear() {
		
		link.clear();
		
	} // End clear
	
	
} // End Stack class

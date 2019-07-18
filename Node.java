/**
* Node<T> class - Used to instantiate Node Objects
*    
* @author Duvenhage, Willem  
* @version 1  
*/

public class Node<T>
{
	private T data;
	private Node<T> next;
	private Node<T> previous;
	
	public Node(T data)
	{
		this.data = data;
	}
	
	public void setData(T data)
	{
		this.data = data;
	}
	
	public T getData()
	{
		return data;
	}
	
	public void setNext(Node<T> next)
	{
		this.next = next;
	}
	
	public Node<T> getNext()
	{
		return this.next;
	}

	public void setPrevious(Node<T> previous)
	{
		this.previous = previous;
	}
	
	public Node<T> getPrevious()
	{
		return this.previous;
	}
}
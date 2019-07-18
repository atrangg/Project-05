/**
* Link class - Used to instantiate Link Lists
*    
* @author Duvenhage, Willem  
* @version 2  
*/


public class Link<T> implements MyCollectionInterfaceProject04<T>
{
	// Declare Variables for Link<T> Class
	private Node<T> firstNode; 		// Head reference to first Node
	private Node<T> lastNode;		// Tail reference to last Node
	public int numberOfEntries;	// Number of Entries in List
	
	public Link()
	{
		//Initialize the link list
		clear();
	}

	// ********************************************************************** 
	
	/**
	 * add method - adds a new Node to linked list
	 * @param newItem
	 * @return True if the addition is successful, or false if not.
	 */

	public boolean add(T newItem)
	{
		// Create newNode that contains newItem
		 Node<T> newNode = new Node<T>(newItem);

		try
		{
			if (isEmpty())
			{
				firstNode = newNode;
				lastNode = firstNode;
			}
			else
			{
				// Set next node to newNode and set newNode previous Node to lastNode
				lastNode.setNext(newNode);
				newNode.setPrevious(lastNode);
				// Set lastNode to the new node in last position
				lastNode = newNode;
			}
			numberOfEntries++;
			return true;
		}
		catch (IllegalArgumentException e)
		{
			return false;
		}
	}
	
	// ********************************************************************** 
	
	/**
	 * add method - adds entry at the given position
	 * @param newItem The object to be added to the collection
	 * @param position The location where newItem will be inserted.
	 * @return True if the addition is successful, or false if not.
	 */
	
	public boolean add(T newItem, int position)
	{	
		// Create newNode that contains newItem
		Node<T> newNode = new Node<T>(newItem);

		try
		{
			if (isEmpty())
			{
				firstNode = newNode;
				lastNode = firstNode;
			}
			else
			{
				if (position == numberOfEntries + 1)
				{
					return add(newItem);
				}
				else if (position == 1)
				{
					firstNode.setPrevious(newNode);
					newNode.setNext(firstNode);
					newNode = firstNode;
				}
				else
				{
					// Create currentNode that contains the node at the given position
					Node<T> currentNode = getNodeAt(position);
					// Create previousNode that contains the node at the location before currentNose
					Node<T> previousNode = currentNode.getPrevious();
					
					// Set next node to newNode and set newNode previous Node to lastNode
					currentNode.setPrevious(newNode);
					newNode.setNext(currentNode);
					newNode.setPrevious(previousNode);
					previousNode.setNext(newNode);
				}
			}
			numberOfEntries++;
			return true;
		}
		catch (IllegalArgumentException e)
		{
			return false;
		}
	}
	
	// ********************************************************************** 
	
	/**
	 * remove method - Removes entry from list
	 * @return the entry that was removed
	 */
	public T remove()
	{
		T dataToReturn = lastNode.getData();
		Node<T> nodeBefore = lastNode.getPrevious();
		if(nodeBefore == null)
		{
			clear();
			return dataToReturn;
		}
		else
		{
			nodeBefore.setNext(null);
			lastNode = nodeBefore;
			return dataToReturn;
		}
	}

	// ********************************************************************** 
	
	/**
	 * remove method - Removes the given entry from list
	 * @param anEntry
	 * @return True if the removal is successful, or false if not.
	 */
	
	public boolean remove(T anEntry)
	{
		Node<T> currentNode = firstNode;
		Node<T> nodeBefore = firstNode.getPrevious();
		int position = 0;
		
		while (currentNode != null)
		{
			// Increment position to indicate current node
			position ++;
			if (anEntry.equals(currentNode.getData()))
			{
				// Remove the entry then return true
				
				if (position == 1)
				{
					firstNode = firstNode.getNext();
					firstNode.setPrevious(null);
				}
				else if (position == numberOfEntries)
				{
					nodeBefore.setNext(null);
					lastNode = nodeBefore;
				}
				else
				{
					Node<T> nodeAfter = currentNode.getNext();
					nodeBefore.setNext(nodeAfter);
					nodeAfter.setPrevious(nodeBefore);
				}
				numberOfEntries--;
				return true;
			}
			else
			{
				nodeBefore = currentNode;
				currentNode = currentNode.getNext();
			}
		}
		return false;
	}
	
	// ********************************************************************** 
	
	/**
	 * clear method - removes all entries from the linked list
	 * 
	 */
	
	public void clear()
	{
		// Remove all entries from collection
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	}
	
	// ********************************************************************** 
	
	/**
	 * getCurrentSize method - get the current number of entries in the linked list
	 * 
	 * @return the number of Entries in the linked list
	 */

	public int getCurrentSize()
	{
		return numberOfEntries;
	}
	
	// ********************************************************************** 
	
	/**
	 * isEmpty method - Checks if linked list is empty
	 * 
	 * @return Wether the list is empty or not
	 */

	public boolean isEmpty()
	{
		return (numberOfEntries == 0);
	}
	
	// ********************************************************************** 
	
	/**
	 * getFrequencyOf method - gets the number of times an entry appears in the list
	 * @param anEntry
	 * @return the number of Entries
	 */

	public int getFrequencyOf(T anEntry)
	{
		int count = 0;
		// Count number of times anEntry is in the collection
		Node<T> currentNode = firstNode;
		
		while (currentNode != null)
		{
			if (anEntry.equals(currentNode.getData()))
			{
				count++;
			}
			currentNode = currentNode.getNext();
		}
		return count;
	}
	
	// ********************************************************************** 
	
	/**
	 * contains method - determines wether an entry is contained in the linked list
	 * @param anEntry
	 * @return Wether the entry is contained in the list or not
	 */
	
	@Override
	public boolean contains(T anEntry)
	{
		Node<T> currentNode = firstNode;
		
		while (currentNode != null)
		{
			if (anEntry.equals(currentNode.getData()))
			{
				return true;
			}
			else
			{
				currentNode = currentNode.getNext();
			}
		}
		return false;
	}
	
	// ********************************************************************** 
	
	/**
	 * toArray method - adds linked list items to an array
	 * 
	 * @return the array that is created
	 */
	
	public Object[] toArray()
	{	
		Object[] array = new Object[numberOfEntries];

		Node<T> currentNode = firstNode;

		for ( int i = 0; i < numberOfEntries; i++ )
		{
			array[i] = currentNode.getData();
			currentNode = currentNode.getNext();
		}
		return array;
	}
	
	// ********************************************************************** 
	
	/**
	 * getNodeAt method - gets the node at the given position
	 * @param givenPosition
	 * @return the node at the given position
	 */

	private Node<T> getNodeAt(int givenPosition)
	{
		Node<T> currentNode = firstNode;
		for (int counter = 1; counter <= givenPosition; counter++)
		{
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}

	// ********************************************************************** 
	
	/**
	 * getNodeAt method - gets the node at the given position
	 * 
	 * @return the data of the last Node in List
	 */

	public T first()
	{
		return lastNode.getData();
	}
}

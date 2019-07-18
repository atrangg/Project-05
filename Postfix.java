/**
* Postfix class - Converts infix to postfix
*    
* @author Duvenhage, Willem  
* @version 1  
*/

public class Postfix // will interface with the stack class
{
	public static Stack<Character> stack;
	public static char charReturned;
	public static char[] postfixArray;
	public static int size;
	public static char topChar;
	public static char charToAdd;
	
	/**
	 * convertToPostfix method - Converts the input received to Postfix 
	 * @param inputExpression
	 * @return the postfix result
	 */
	
	public static String convertToPostfix(String inputExpression)
	{
		// Take inputExpression and use .toCharArray() to create an Array of each of the characters
		System.out.println("New Expression: ");
		char[] inputArray = inputExpression.toCharArray();
		postfixArray = inputArray;
		size = 0;
		stack = new Stack<>();
		
		System.out.println(inputArray);

		// Process to check each character in array create postfixArray
		for (int i = 0; i < inputArray.length; i++)
		{
			characterCheck(inputArray[i]);
        }
        
		// Check to make sure the stack is Empty, if not return an empty String
		if (!stack.isEmpty())
		{
                return "";
		}
		// Create & Return the postfixString created from postfixArray
		String postFixString = new String(postfixArray);
		System.out.println(postFixString);
		return postFixString;
	}
	
	//********************************************************************************************************************
	
	/**
	 * characterCheck method - Checks the character received to determine if it has to be pushed to the stack or returned
	 * @param newChar
	 * @return a character based on the character received
	 */
	
	
	public static void addCharToArray(char addChar)
	{
		if (size == 0)
		{
			postfixArray[size] = addChar;
		}
		else
		{
			size++;
			postfixArray[size] = addChar;
			System.out.println(postfixArray);
		}
	}
	
	 // Checks the character to determine if it needs to be added to the stack or returned to be added to the postfixString
	public static void characterCheck(char newChar)
	{
		System.out.println(newChar);
		if (newChar == '+')
		{
			// Check if Stack is Empty
			if(stack.isEmpty())
			{
				stack.push(newChar);
			}

			// Peek at top of stack
			topChar = stack.peek();

            if (topChar == '(')
			{
				// Push the new  char to the stack
				stack.push(newChar);
			}
            else if (topChar == '-' || topChar == '*' || topChar == '/' || topChar == '^')
			{
				// Return top character of Stack and Push the new  char to the stack
				charToAdd = stack.pop();
				stack.push(newChar);
				addCharToArray(charToAdd);
			}
		}
        else if (newChar == '-')
		{
			// Check if Stack is Empty
			if(stack.isEmpty())
			{
				stack.push(newChar);
			}

			// Peek at top of stack
			topChar = stack.peek();

			if (topChar == '(')
			{
				// Push the new  char to the stack
				stack.push(newChar);
			}
            else if (topChar == '+' || topChar == '*' || topChar == '/' || topChar == '^')
			{
				// Return top character of Stack and Push the new  char to the stack
				charToAdd = stack.pop();
				stack.push(newChar);
				addCharToArray(charToAdd);
			}
		}
        else if (newChar == '*')
		{
			// Check if Stack is Empty
			if(stack.isEmpty())
			{
				stack.push(newChar);
			}

			// Peek at top of stack
			topChar = stack.peek();

			if (topChar == '-' || topChar == '+' || topChar == '(')
			{
				// Push the new  char to the stack
				stack.push(newChar);
			}
            else if (topChar == '/' || topChar == '^')
			{
				// Return top character of Stack and Push the new  char to the stack
				charToAdd = stack.pop();
				stack.push(newChar);
				addCharToArray(charToAdd);
			}
		}
        else if (newChar == '/')
		{
			// Check if Stack is Empty
			if(stack.isEmpty())
			{
				stack.push(newChar);
			}

			// Peek at top of stack
			topChar = stack.peek();

			if (topChar == '-' || topChar == '+' || topChar == '(')
			{
				// Push the new  char to the stack
				stack.push(newChar);
			}
            else if (topChar == '*' || topChar == '^')
			{
				// Return top character of Stack and Push the new  char to the stack
				charToAdd = stack.pop();
				stack.push(newChar);
				addCharToArray(charToAdd);
			}
		}
        else if (newChar == '^')
		{
            stack.push(newChar);
		}
        else if (newChar == '(')
		{
            stack.push(newChar);
		}
        else if (newChar == ')')
		{
			// Check if Stack is Empty
			if(stack.isEmpty())
			{
				// Return an Error
			}

			// Peek at top of stack
			topChar = stack.peek();

            while (topChar != '(')
			{
				topChar = stack.pop();
				addCharToArray(topChar);
				topChar = stack.peek();
			}
		}
		else
		{
			addCharToArray(newChar);
		}
	}
}



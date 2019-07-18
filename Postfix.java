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
	public static String postfixString;
	public static int counter;
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
		char[] inputArray = inputExpression.toCharArray();
		postfixString = "";
		counter = 0;
		stack = new Stack<>();

		// Process to check each character in array create postfixArray
		for (int i = 0; i < inputArray.length; i++)
		{
			characterCheck(inputArray[i]);
        }
        
		// Check to make sure the stack is Empty, if not return an empty String
		//if (!stack.isEmpty())
		//{
                //return "";
		//}
		// Create & Return the postfixString created from postfixArray
		return postfixString;
	}
	
	//********************************************************************************************************************
	
	/**
	 * characterCheck method - Checks the character received to determine if it has to be pushed to the stack or returned
	 * @param newChar
	 * @return a character based on the character received
	 */
	
	
	public static void addCharToString(char addChar)
	{
		postfixString = postfixString + Character.toString(addChar);
	}
	
	 // Checks the character to determine if it needs to be added to the stack or returned to be added to the postfixString
	public static void characterCheck(char newChar)
	{
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
				addCharToString(charToAdd);
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
				addCharToString(charToAdd);
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
				addCharToString(charToAdd);
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
				addCharToString(charToAdd);
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
				addCharToString(topChar);
				topChar = stack.peek();
			}
		}
		else if (newChar != ' ')
		{
			addCharToString(newChar);
		}
	}
}



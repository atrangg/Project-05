/**
* Postfix class - Converts infix to postfix
*    
* @author Duvenhage, Willem  
* @version 1  
*/

public class Postfix // will interface with the stack class
{
	public static Stack stack;
	public static String charReturned;
	public static String postfixString;
	public static String topChar;
	public static String charToReturn;
	
	/**
	 * convertToPostfix method - Converts the input received to Postfix 
	 * @param inputExpression
	 * @return the postfix result
	 */

	public static String convertToPostfix(String[] inputArray)
	{
		// Process to check each character in array and begin creating postfixString
		for (int i = 0; i <= inputArray.length; i++)
		{
			charReturned = characterCheck(inputArray[i]);
            
			// If the returned string is not a blank string, add it to the postfixString
			if (!charReturned.equals(""))
			{
                postfixString = postfixString + charReturned;
			}
        }
        
		// Check to make sure the stack is Empty, if not return an empty String
		if (!stack.isEmpty())
		{
                return "";
		}
        // Returns the postfixString created
		return postfixString;
	}
	
	//********************************************************************************************************************
	
	/**
	 * characterCheck method - Checks the character received to determine if it has to be pushed to the stack or returned
	 * @param newChar
	 * @return a character based on the character received
	 */
	
	// Checks the character to determine if it needs to be added to the stack or returned to be added to the postfixString
	public static String characterCheck(String newChar)
	{
        if (newChar.equals("+"))
		{
			// Check if Stack is Empty
			if(stack.isEmpty())
			{
				stack.push(newChar);
				return "";
			}

			// Peek at top of stack
			topChar = stack.peek();

            if (topChar.equals("("))
			{
				// Push the new  char to the stack
				stack.push(newChar);
				return "";
			}
            else if (topChar.equals("+"))
			{
				return "";
			}
            else if (topChar.equals("-") || topChar.equals("*") || topChar.equals("/") || topChar.equals("^"))
			{
				// Return top character of Stack and Push the new  char to the stack
				charToReturn = stack.pop();
				stack.push(newChar);
				return charToReturn + " ";
			}
		}
        else if (newChar.equals("-"))
		{
			// Check if Stack is Empty
			if(stack.isEmpty())
			{
				stack.push(newChar);
				return "";
			}

			// Peek at top of stack
			topChar = stack.peek();

			if (topChar.equals("("))
			{
				// Push the new  char to the stack
				stack.push(newChar);
				return "";
			}
            else if (topChar.equals("-"))
			{
				return "";
			}
            else if (topChar.equals("+") || topChar.equals("*") || topChar.equals("/") || topChar.equals("^"))
			{
				// Return top character of Stack and Push the new  char to the stack
				charToReturn = stack.pop();
				stack.push(newChar);
				return charToReturn + " ";
			}
		}
        else if (newChar.equals("*"))
		{
			// Check if Stack is Empty
			if(stack.isEmpty())
			{
				stack.push(newChar);
				return "";
			}

			// Peek at top of stack
			topChar = stack.peek();

			if (topChar.equals("-") || topChar.equals("+") || topChar.equals("("))
			{
				// Push the new  char to the stack
				stack.push(newChar);
				return "";
			}
            else if (topChar.equals("*"))
			{
				return "";
			}
            else if (topChar.equals("/") || topChar.equals("^"))
			{
				// Return top character of Stack and Push the new  char to the stack
				charToReturn = stack.pop();
				stack.push(newChar);
				return charToReturn + " ";
			}
		}
        else if (newChar.equals("/"))
		{
			// Check if Stack is Empty
			if(stack.isEmpty())
			{
				stack.push(newChar);
				return "";
			}

			// Peek at top of stack
			topChar = stack.peek();

			if (topChar.equals("-") || topChar.equals("+") || topChar.equals("("))
			{
				// Push the new  char to the stack
				stack.push(newChar);
				return "";
			}
            else if (topChar.equals("/"))
			{
				return "";
			}
            else if (topChar.equals("*") || topChar.equals("^"))
			{
				// Return top character of Stack and Push the new  char to the stack
				charToReturn = stack.pop();
				stack.push(newChar);
				return charToReturn + " ";
			}
		}
        else if (newChar.equals("^"))
		{
            stack.push(newChar);
		}
        else if (newChar.equals("("))
		{
            stack.push(newChar);
		}
        else if (newChar.equals(")"))
		{
			// Check if Stack is Empty
			if(stack.isEmpty())
			{
				// Return an Error
				return "";
			}

			// Peek at top of stack
			topChar = stack.peek();

            while (!topChar.equals("("))
			{
                charToReturn = charToReturn + " ";
				topChar = stack.peek();
			}
            return charToReturn  + " ";
		}
        else
		{
            return newChar + " ";
		}   
        return "";
	}
}



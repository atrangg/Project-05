/**
* Postfix class - Converts infix to postfix
*    
* @author Duvenhage, Willem  
* @version 1  
*/

public class Postfix // will interface with the stack class
{
	// Initialized variables
	public static Stack<Character> stack;	// The stack for storing characters
	public static char charReturned;		// Char returned for the postfixString
	public static String postfixString;		// Converted infix to postfix
	public static char topChar;				// Character at the top of the stack
	public static char charToAdd;			// Character to be added to the postfixString
	
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
		stack = new Stack<>();

		System.out.print("Infix Array getting converted: " + new String(inputArray) + " ... ");

		// Check Syntax of infix to be converted to ensure it contains no errors while converting to postfix
		boolean correctSyntax = true;
		int leftHandBracketCount = 0;
		int rightHandBracketCount = 0;
		char previousChar = ' ';

		for (int i = 0; i < inputArray.length && correctSyntax; i++)
		{
			if (inputArray[i] == '*' || inputArray[i] == '/' || inputArray[i] == '+' || inputArray[i] == '-' || inputArray[i] == '^' )
			{
				if (previousChar != '*' || previousChar != '/' || previousChar != '+' || previousChar != '-' || previousChar != '(' || previousChar != ' ' || previousChar != '^' )
				{
					characterCheck(inputArray[i]);
					previousChar = inputArray[i];
				}
				else
				{
					correctSyntax = false;
				}
			}
			else if (inputArray[i] == '(')
			{
				leftHandBracketCount++;
				if (previousChar == '*' || previousChar == '/' || previousChar == '+' || previousChar == '-' || previousChar == '(' || previousChar == '^' || previousChar == ' ')
				{
					characterCheck(inputArray[i]);
					previousChar = inputArray[i];
				}
				else
				{
					correctSyntax = false;
				}
			}
			else if (inputArray[i] == ')' && !stack.isEmpty())
			{
				rightHandBracketCount++;
				if (previousChar != '*' || previousChar != '/' || previousChar != '+' || previousChar != '-' || previousChar != '^' )
				{
					characterCheck(inputArray[i]);
					previousChar = inputArray[i];
				}
				else
				{
					correctSyntax = false;
				}
			}
			else if (inputArray[i] != ' ')
			{
				if (previousChar == '*' || previousChar == '/' || previousChar == '+' || previousChar == '-' || previousChar == '(' || previousChar == '^'   || previousChar == ' ')
				{
					characterCheck(inputArray[i]);
					previousChar = inputArray[i];
				}
				else
				{
					correctSyntax = false;
				}
			}
		}
		
		// Check to make sure that each "(" has a ")"
		if (rightHandBracketCount != leftHandBracketCount)
		{
			correctSyntax = false;
		}

		// Check to make sure the stack is Empty
		while (!stack.isEmpty() && correctSyntax)
		{
			if (stack.peek() != '(')
			{
				addCharToString(stack.pop());
			}
			else
			{
				stack.pop();
			}
		}

		System.out.println("done.\n");

		// Create & Return the postfixString created from postfixArray
		if (!correctSyntax)
		{
			return "Does Not have correct syntax.";
		}
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



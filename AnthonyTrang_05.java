/*
  AnthonyTrang_05 - A conversion application to convert input file containing infix to postfix and generate a report with the resulting answers
  Anthony Trang & Willem Duvenhage
  Project # 5
  Various Systems & IDEs
  Mathematics - the abstract science of number, quantity, and space. 
				  Mathematics may be studied in its own right (pure mathematics), 
				  or as it is applied to other disciplines such as physics and 
				  engineering (applied mathematics).
  “Since the mathematicians have invaded the theory of relativity I do not understand it myself any more.” 
	- Albert Einstein - Mar 14, 1879 - Apr 18, 1955 (age 76)
*/

// Import Statements
import java.io.File;					// Access Java input/output classes
import java.io.FileNotFoundException;	// File Not Found Exception
import java.io.FileWriter;				// Use Filewriter
import java.io.IOException;				// IO Exception
import java.io.PrintWriter;				// Use PrintWriter
import java.util.Scanner;				// Use scanner class

/**
 * AnthonyTrang_05 class - The main class
 * 
 * @author Anthony Trang & Willem Duvenhage
 * @version 1
 */

public class AnthonyTrang_05
{	
	//private static Postfix postfix;
	private static String postfixResults;
	/**
	 * processInput method - processes the input received from file
	 * @throws FileNotFoundException
	 */
	
	public static void processInput() throws FileNotFoundException
	{
        // String to store postfix results
		postfixResults = "";
		String result;

		// Setup input file
		File inputDataFile;
		Scanner inputFile;
		String inputString;
		String inputFilename = "Project05_Input.txt";
		inputDataFile = new File(inputFilename);
		
		//Scan input file
		if (inputDataFile.exists()) {
			System.out.println("Reading data from file " + inputFilename + "\n");

			// Create our Scanner instance
			inputFile = new Scanner(inputDataFile);
			
			

			while (inputFile.hasNextLine()) {
				// Read the next line in the inputFile
				inputString = inputFile.nextLine();

				//Send line to convertToPostfix method in Postfix Class & Save result in postfixArray
				result = Postfix.convertToPostfix(inputString);
				postfixResults = postfixResults + result + ",";	
			}
			// Close the input file
			inputFile.close();
		}
		// If the file does not exist, throw an exception
		else {
			// Throw new Exception(inputFilename + " could not be found");
			System.err.println("Error: " + inputFilename + " could not be found");
		}
    }

	//********************************************************************************************************************
	
	/**
	 * generateReport method - Creates the report of students and their grades and
	 * prints to an output file
	 * 
	 * @param info
	 * @throws IOException
	 */
	
	public static void generateReport() throws IOException
	{
        // Setup Array for postfixResults
		String[] resultsArray;
		// Setup OutputFile
		FileWriter outputDataFile;
		PrintWriter outputFile;
		String outputFilename = "Project05_Output.txt"; // Output file name

		outputDataFile = new FileWriter(outputFilename);
		outputFile  = new PrintWriter(outputDataFile);
		
		System.out.print("Generating report to file " + outputFilename + "... ");

		// Generate the Report and output the report to Project_03_Outputxx.txt, x = 01,02, 03.... based on initial input file
		resultsArray = postfixResults.split(",");
		
		for (int i = 0; i < resultsArray.length; i++)
		{
			outputFile.println(resultsArray[i]);
		}

		// Close the output file
		outputFile.close();

		System.out.print("done.");
	}

	//********************************************************************************************************************
	
	/**
	 * main method - Calls processInput & generateReport methods
	 * 
	 * @param args
	 */

	public static void main (String[] args) throws Exception
	{
		processInput();
        generateReport();
	}
}
            


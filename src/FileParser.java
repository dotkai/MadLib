import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


//Kai Austin
//January 2011
//Reads the input file and organizes/adds rules


public class FileParser
{
	static Scanner scan;
	
	//Creating the various classes to be used for constructing new elements
	static Grammar gram;
	static Rule rule;
	static RightHandSide rhs;
	static Terminal term;
	static Variable var;
	
	static String name; //naming the input rules, rhs, etc.
	static String nextPattern; //to keep track of the scan.next()
	
	public FileParser(String filename)
	{
		try
		{
			//file to be scanned
			FileReader fr = new FileReader(filename);
			scan = new Scanner(fr);
			
			//Also creating a new Grammar file, as the fileParser
			//will only be called once
			//And allows for some of the method bellow to be used
			gram = new Grammar();
			
			//No need for delimiter as may mess up intended spacing
			
			//Creating a default string so that the scanner will not
			//move onto the next string when comparing to the input
			
			nextPattern = scan.next();
			
			while (scan.hasNext())
			{
				gram.addToRuleArray(parseRule(nextPattern));
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: File Not Found");
		}

	}
	
	public static Rule parseRule(String nextPattern)
	{
		
		//Designed to skip all lines and strings until reaches the start
		//of a curly brace and rule set
		
		while (!nextPattern.equals("{") && scan.hasNext())
		{
			nextPattern = scan.next();
		}
		
		//indicates the start of the set, so skip the curly brace
		nextPattern = scan.next();
		
		//cut the brackets, and create a new rule with that name
		//Adds it to the Grammar ArrayList
		name = cutString(nextPattern);
		rule = new Rule(name);

		//Once the rule and its name are created, scan the next line
		//and continue parsing
		
		nextPattern = scan.next();
		
		//End curly brace means the end of the set
		while (!nextPattern.equals("}") && scan.hasNext())
		{
			rule.addToArrayList(parseRHS(nextPattern));

			//And once again, scan the next element
			nextPattern = scan.next();
		}
		
		if (scan.hasNext())
		{	nextPattern = scan.next();	}
		
		return rule;
	}
	
	public static RightHandSide parseRHS(String nextPattern)
	{
		//Else the series of statements/right hand rules begins
		//they are on a line which should end with a semi-colon (;)
		//indicating the end of the line
		rhs = new RightHandSide();

		while (!nextPattern.equals(";"))
		{
			sortVarAndTerm(nextPattern);
			
			nextPattern = scan.next();
		}
		
		return rhs;
	}
	
	
	public static String cutString (String s)
	{
		//If there are brackets, this method is designed to cut them off
		if (s.contains("["))
		{		
			//First get the length of the string and (- 1) 
			//to remove the ending bracket
			int temp = s.length() - 1;
			//Then set the sting to a substring, start at 1 as numbers begin at 0
			s = s.substring(1, temp);
		}
			//else, do nothing - the stng has no brackets to worry about
		
		return s;
	}
	
	public static void sortVarAndTerm(String nextPattern)
	{
			if (nextPattern.contains("["))
			{
				//if the next element contains brackets,
				//this indicates the presence of a terminal
				//cut the brackets and create a new
				//adding it to the "current" rightHandSide
				//(as new one should not be created until the end
				//of the first loop (finding end "}")
				
				name = cutString(nextPattern);
				term = new Terminal(name);
				rhs.addToRHSList(term);
			}
			else
			{
				//else the "pattern" is a variable
				//So creating a new variable to add to the
				//rhs list
				
				name = nextPattern;
				var = new Variable(name);
				rhs.addToRHSList(var);
			}
	}

	public Grammar getG()
	{
		return gram;
	}
	
}

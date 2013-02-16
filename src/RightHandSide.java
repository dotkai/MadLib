import java.util.ArrayList;
import java.util.Random;

//Kai Austin
//January 2011

//Options the rules give
//Contains a sequence of Terminals and Variables. "Sequence" implies 
//that the order is important, so I suggest using an ArrayList to store 
//them. (Since you'll want a sequence that can contain Terminals or 
//Variables, but not other kinds of objects, it might make sense for 
//Terminal and Variable to implement an interface called Symbol, which 
//won't need methods, but will "mark" Terminal and Variable as being 
//similar, for the purposes of grouping them together into an ArrayList<Symbol>. 
//If Terminal and Variable each implement Symbol, but nothing else does, 
//an ArrayList<Symbol> will be able to contain Terminals or Variables, 
//but nothing else.)

public class RightHandSide implements Generable
{
	ArrayList<Symbol> rhsSequence;
	FileParser fp;
	
	//Below are used to determine if such a symbol is present within
	//the statement and at ArrayPosition (will actually check "term"
	//if not, default will be the variable), also used later for generate
	Terminal term;
	Variable var;
	
	public RightHandSide()
	{
		//also creating an linkedList to hold all the terminals and variables
		//classified as "Symbols," order will matter so it is important
		//that all arrive in the exactly correct sequence
		rhsSequence = new ArrayList<Symbol>();
	}
	
	public void addToRHSList(Symbol sym)
	{
		rhsSequence.add(sym);
	}
	
	@Override
	public String generate(Grammar g, Random r)
	{
		//And empty string and creation of a new random to be passed
		//through to the elements of the array
		String sentence = "";
		
		//creating a for loop as the entire statement itself
		//must be returned and randomized (each symbol)
		for (int i = 0; i < rhsSequence.size(); i++)
		{
			sentence = sentence + rhsSequence.get(i).generate(g, r);
		}

		return sentence;
	}

}

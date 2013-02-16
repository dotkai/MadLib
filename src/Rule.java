import java.util.ArrayList;
import java.util.Random;

//Kai Austin
//January 2011

//Contains the name of a variable and a set of RightHandSides. 
//Since you'll need to select a RightHandSide randomly by generating 
//a random number, it makes sense to store these RightHandSides in 
//an ArrayList, though the order of them turns out to be irrelevant.

public class Rule implements Generable
{
	String ruleName;
	ArrayList <RightHandSide> rhs;
	
	public Rule (String s)
	{	
		//creating the new name of the rule with which it will
		//be identified
		ruleName = s;
		//also creating a new array list in which to store the
		//right hand sides (or grammar/statements
		rhs = new ArrayList<RightHandSide>();

	}
	
	//Adding to the RHS array list
	public void addToArrayList(RightHandSide rhside)
	{
		rhs.add(rhside);
	}
	
	public String getRuleName()
	{
		//used when comparing terminals and elements of the grammar array
		return ruleName;
	}
	
	public String generate(Grammar g, Random r)
	{
		//random generator to fit the size of
		//the rhs arrayList (and thus not go out of bounds)
		int randomI = r.nextInt(rhs.size());

		//next getting the random arrayList element and generating
		//a random for the variables and terminals which may be a part of
		String s = rhs.get(randomI).generate(g, r);
		
		//returns a string because rhs...generate(.) returns a string as well
		return s;
	}
}
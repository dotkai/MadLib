import java.util.ArrayList;
import java.util.Random;

//Kai Austin
//January 2011
//Where going to send command to make new thing
//New rules make grammar

public class Grammar implements Generable
{
	public Rule rule;
	public ArrayList<Rule> rules;
	
	//The first element in the array list will be the starting rule
	
	public Grammar()
	{
		rules = new ArrayList<Rule>();
	}
	
	public void addToRuleArray(Rule e)
	{
		rules.add(e);
	}
	
	public int findRule(int i, String ruleName)
	{
		//loop to match the name of the rule to the stored rule
		while (!ruleName.equals(getRule(i).getRuleName()))
		{
			i++;
		}
		return i;
	}
	
	//Paired up with findRule(), but due to the way the parameters work
	//they cannot be within the same method
	public Rule getRule(int rulePosition)
	{
		return rules.get(rulePosition);
	}
	
	@Override
	public String generate(Grammar g, Random r)
	{
		//gets the rule corresponding to the one requested
		//then creates a string to pass that rule through
		//Begins a chain of generated randoms
		
		return "" + rules.get(0).generate(g, r);
	}

}

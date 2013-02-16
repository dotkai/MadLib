import java.util.Random;

//Kai Austin
//January 2011

//Contains only the word that makes up one terminal.

public class Terminal implements Symbol
{
	String terminalName;
		
	public Terminal(String name)
	{
		terminalName = name;
	}
	
	public String getName()
	{
		return terminalName;
	}
	
	@Override
	public String generate(Grammar g, Random r)
	{
		//As a terminal is a "rule within a statement," the grammar ArrayList
		//of Rules is needed hence "Grammar g" in parameters
		
		int tempI = g.findRule(0, getName());
		//Will return an int corresponding to the correct position
		//in the grammar arrayList where the terminal --> rule is
		
		//while does not completely skip the grammar generator,
		//continues past the "first rule" one straight onto the Rule
		//class itself until there are no more terminals remaining
		return g.getRule(tempI).generate(g, r);
		
		//No random generator is needed - used in the Rule class
		//through which the parapeters pass
	}

}

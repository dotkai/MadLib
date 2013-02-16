import java.util.Random;

//Kai Austin
//January 2011

//Contains only the name of the variable.
//

public class Variable implements Symbol
{
	//Variables will only have a name
	//As they do not change. While the selection of variables
	//maybe random, the variable itself is set
	//No need for arrayList
	String variableName;
	
	public Variable(String name)
	{
		variableName = name;
	}

	public String getName()
	{
		return variableName;
	}
	
	@Override
	public String generate(Grammar g, Random r)
	{
		return " " + getName();
	}

}

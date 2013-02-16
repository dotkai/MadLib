import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

//Kai Austin January 2011
//Gets the args
//MAIN METHOD

public class Generator
{
	// java Generator grammar.grm 10 start sentences.out
	//args[0] = input
	//args[1] = number of lines
	//args[3] = output
	
	static Grammar g;
	static Random r;
	
	public static void main(String[] args) throws FileNotFoundException
	{

		for (int i = 0; i < 10; i++)
			{	
				//Change the filename here
				FileParser fp = new FileParser("sentence.txt");
				
				r = new Random();
				g = fp.getG();
				
				String sentence = g.generate(g, r);
				System.out.println(sentence);
			}
	}
}

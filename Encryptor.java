//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.System.*;

public class Encryptor
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File ("C:\\Users\\majeskia7104\\Desktop\\CAST-128\\CAST-128\\Hello.txt"));
		//int size = file.nextInt();
		//file.nextLine();
		PrintWriter TestWordSave = new PrintWriter( "C:\\Users\\Public\\Pictures\\POOP.txt" );
		while(file.hasNext())
		{
			String word = file.next();
			System.out.println(word);
			
			TestWordSave.write(word+" ");




	   }
		TestWordSave.close();
	}
}
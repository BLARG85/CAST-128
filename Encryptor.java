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
		Scanner file = new Scanner(new File ("C:\\Users\\natbl\\Documents\\GitHub\\CAST-128\\Hello.txt"));
		PrintWriter TestWordSave = new PrintWriter( "C:\\Users\\Public\\Documents\\POOP.txt" );
		
		//int keygen = 
		
		while(file.hasNext())
		{
			String word = file.next();
			System.out.println(word);
			
			for(int i=0; i<word.length(); i++){
				
			}
			
			TestWordSave.write(word+" ");




	   }
		TestWordSave.close();
	}
}
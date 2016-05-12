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
		/*
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
		*/
		
		
		
		int binaryInput = 0b101;
		// 0b1010; (10)  shifted left once if 5 is times 2
		// 0b10100; (20) times 2 shifts everything once left
		int hexInput = 0x32;
		int input = 5;
		input <<= 5;
		
		System.out.println(binaryInput);
		System.out.println(hexInput);
		System.out.println(input);
		
	}
}
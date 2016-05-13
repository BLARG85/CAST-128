import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

public class Cipher_Runner{
	
	private static String WordSave= "";
	private static Scanner file = null;
	private static PrintWriter FileWordSave = null;
	
	public static void main(String args[]) throws IOException
	{
		//Cast5 run = new Cast5();
		/**
		//String to Byte Array
		String guy = "hello";
		byte[] b = guy.getBytes(Charset.forName("UTF-8"));
		System.out.println(Arrays.toString(b));
		
		//Byte Array to String
		String ByteArrayToString = new String(b, Charset.defaultCharset());
		System.out.println(ByteArrayToString);
		**/
		
		
		
		
		
		Encryptor run = new Encryptor();
		
		
		try {
			file = new Scanner(new File ("C:\\Users\\Public\\Documents\\Cipher_Input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(" - Incorrect File Destination for Input:\n");
		}
		
		try {
			FileWordSave = new PrintWriter( "C:\\Users\\Public\\Documents\\Cipher_Output.txt" );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(" - Incorrect File Destination for Output:\n");
		}
		
		
		while(file.hasNext())
		{
			String word = file.next();
			System.out.print(word + " ");
			FileWordSave.write(word+" ");
			WordSave += word + " ";
	   }
		System.out.println();
		FileWordSave.close();
		

	}
	
}

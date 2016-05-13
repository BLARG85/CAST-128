import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Scanner;

public class Cipher_Runner{
	
	private static String WordSave= "";
	private static Scanner file = null;
	private static PrintWriter FileWordSave = null;
	
	public static void main(String args[]) throws IOException, InvalidKeyException
	{
		//Cast5 run = new Cast5();
		
		//String to Byte Array
		String guy = "Gullible";
		byte[] b = guy.getBytes(Charset.forName("UTF-8"));
		System.out.println(Arrays.toString(b));
		
		//Byte Array to String
		String ByteArrayToString = new String(b, Charset.defaultCharset());
		System.out.println(ByteArrayToString);
		
		
		
		
		
		
		
		
		Encryptor run = new Encryptor();
		Object KEY = run.makeKey(b, 8);
		
		byte[] OUTPUT = new byte[8];
		
		run.encrypt(b, 0, OUTPUT, 0, KEY, 8);
		System.out.println(new String(OUTPUT, Charset.defaultCharset()));
		
		byte[] UnEncrypted = new byte[8];
		
		run.decrypt(OUTPUT, 0, UnEncrypted, 0, KEY, 8);
		System.out.println(new String(UnEncrypted, Charset.defaultCharset()));
		
		
		
		/** 	TO BE IMPLIMENTED LATER
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
		**/

	}
	
}

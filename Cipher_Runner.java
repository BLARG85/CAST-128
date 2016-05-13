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
	private static final String newline = System.getProperty("line.separator");
	
	
	public static void OLDmain(String args[]) throws IOException, InvalidKeyException
	{
		//String to Byte Array
		String guy = "Gullible";  //NEEDS TO BE 8 LONG
		byte[] b = guy.getBytes(Charset.forName("UTF-8"));
		String STRING_toBeKEY = "12mghftghsogndli";  //KEY need to be between 5 and 16 characters (inclusive)
		byte[] toBeKEY = STRING_toBeKEY.getBytes(Charset.forName("UTF-8"));
		/**
		System.out.println(Arrays.toString(b));
		
		//Byte Array to String
		String ByteArrayToString = new String(b, Charset.defaultCharset());
		System.out.println(ByteArrayToString);
		**/
		
		
		
		
		
		
		// FORMAT TO FOLLOW
		Encryptor run = new Encryptor();
		Object KEY = run.makeKey(toBeKEY, 8);
		
		byte[] OUTPUT = new byte[8];
		
		run.encrypt(b, 0, OUTPUT, 0, KEY, 8);
		System.out.println(new String(OUTPUT, Charset.defaultCharset()));
		
		byte[] UnEncrypted = new byte[8];
		
		run.decrypt(OUTPUT, 0, UnEncrypted, 0, KEY, 8);
		System.out.println(new String(UnEncrypted, Charset.defaultCharset()));

		
		
		
		
		
		
		/**	TO BE IMPLIMENTED LATER
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
	
	
	public static void main(String args[]) throws IOException, InvalidKeyException
	{
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
		FileWordSave.write(newline+newline);
		System.out.println("\n");

		
		
		
		
		
		//  Makes the String length equal to a number divible by 8
		int WordSave_LENGTH = WordSave.length();
		boolean isDivisibleByEight = false;
		if ((8 - WordSave_LENGTH%8) == 8)  isDivisibleByEight = true;
		int BITS = WordSave_LENGTH;
		if (!isDivisibleByEight)  BITS += (8 - WordSave_LENGTH%8);
		
		
		

		
		//  Converts the string into Bytes and puts them in an array
		//  long enough to hold all characters, while length is divisible by 8
		byte[] INPUT = new byte[BITS];
		byte[] HoldWord = WordSave.getBytes(Charset.forName("UTF-8"));
		for (int g=0; g<BITS; g++)
		{
			if (g<HoldWord.length)
			{
				INPUT[g] = HoldWord[g];
			}
			else  INPUT[g] = 0;
		}

		
		
		
		
		//  sets up KEY
		String STRING_toBeKEY = "12mghftghsogndli";  //KEY need to be between 5 and 16 characters (inclusive)
		byte[] toBeKEY = STRING_toBeKEY.getBytes(Charset.forName("UTF-8"));
		Object KEY = run.makeKey(toBeKEY, 8);
		
		
		
		
		
		//	Encrypts
		String NowEncrypted = "";
		byte[] ENCRYPTED_INFORMATION = new byte[BITS];
		for (int h=0; h<BITS; h+=8)
		{
			byte[] OUTPUT = new byte[8];
			run.encrypt(INPUT, h, OUTPUT, 0, KEY, 8);
			String ENCRYPTED = new String(OUTPUT, Charset.defaultCharset());
			for (int d=0; d<8; d++)
			{
				ENCRYPTED_INFORMATION[d+h] = OUTPUT[d];
			}
			NowEncrypted += ENCRYPTED;
		}
		System.out.println(NowEncrypted + "\n");
		FileWordSave.write(NowEncrypted + newline+newline);
		
		
		
		//	Decrypts
		String NowDecrypted = "";
		byte[] DECRYPTED_INFORMATION = new byte[BITS];
		for (int y=0; y<BITS; y+=8)
		{
			byte[] UnEncrypted = new byte[8];
			run.decrypt(ENCRYPTED_INFORMATION, y, UnEncrypted, 0, KEY, 8);
			String DECRYPTED = new String(UnEncrypted, Charset.defaultCharset());
			for (int d=0; d<8; d++)
			{
				DECRYPTED_INFORMATION[d+y] = UnEncrypted[d];
			}
			NowDecrypted += DECRYPTED;
		}
		System.out.println(NowDecrypted + "\n");
		FileWordSave.write(NowDecrypted + newline+newline);
		
		
		
		
		FileWordSave.close();
	}
}

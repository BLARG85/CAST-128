import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Scanner;

public class Transmit extends Encryptor{
	
	private static Scanner file = null;
	private static PrintWriter FileWordSave = null;
	private static final String newline = System.getProperty("line.separator");
	

	public static void main(String args[]) throws IOException, InvalidKeyException
	{
		
		Encryptor run = new Encryptor();
		
		//asks for file destinations
		Scanner sc = new Scanner(System.in);
		System.out.print("Please paste/type the destination of the file you would like to load"+"\n  -  ");
	    String fileTake = sc.next();
	    System.out.print("\nPlease paste/type the location of where the file should be saved"+"\n  -  ");
	    String fileSaveLoc = sc.next() + "\\";
	    System.out.print("\nPlease enter a name"+"\n  -  ");
	    String fileSaveName = sc.next();
		
		
		try {
			//file = new Scanner(new File ("C:\\Users\\Public\\Documents\\Cipher_Input.txt"));   	// C:\Users\Public\Documents\Cipher_Input.txt
			file = new Scanner(new File (fileTake));
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("\t- Incorrect File Destination for Input:\n");
		}
		
		try {
			//FileWordSave = new PrintWriter( "C:\\Users\\Public\\Documents\\Cipher_Output.txt" );
			FileWordSave = new PrintWriter(fileSaveLoc+fileSaveName+".txt");
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("\t- Incorrect File Destination for Output:\n");
		}
		
		
		String entireFileText = new Scanner(new File(fileTake)).useDelimiter("\\A").next();
		System.out.println("\n\n\n **ORIGINAL**\n\" " +entireFileText + " \"\n\n");
		FileWordSave.write(entireFileText + newline+newline+newline);

		
		
		
		
		
		//  Makes the String length equal to a number divisible by 8
		int WordSave_LENGTH = entireFileText.length();
		boolean isDivisibleByEight = false;
		if ((8 - WordSave_LENGTH%8) == 8)  isDivisibleByEight = true;
		int BITS = WordSave_LENGTH;
		if (!isDivisibleByEight)  BITS += (8 - WordSave_LENGTH%8);
		
		
		

		
		//  Converts the string into Bytes and puts them in an array
		//  long enough to hold all characters, while length is divisible by 8
		byte[] INPUT = new byte[BITS];
		byte[] HoldWord = entireFileText.getBytes(Charset.forName("UTF-8"));
		for (int g=0; g<BITS; g++){
			if (g<HoldWord.length)  INPUT[g] = HoldWord[g];
			else  INPUT[g] = 0;}

		
		
		
		
		//  sets up KEY
		String STRING_toBeKEY = "12mghftghsogndli";  //KEY need to be between 5 and 16 characters (inclusive)
		byte[] toBeKEY = STRING_toBeKEY.getBytes(Charset.forName("UTF-8"));
		Object KEY = run.makeKey(toBeKEY, 8);
		
		
		
		
		
		//	Encrypts
		String NowEncrypted = "";
		byte[] ENCRYPTED_INFORMATION = new byte[BITS];
		for (int h=0; h<BITS; h+=8){
			byte[] OUTPUT = new byte[8];
			run.encrypt(INPUT, h, OUTPUT, 0, KEY, 8);
			String ENCRYPTED = new String(OUTPUT, Charset.defaultCharset());
			for (int d=0; d<8; d++)  ENCRYPTED_INFORMATION[d+h] = OUTPUT[d];
			NowEncrypted += ENCRYPTED;}
		System.out.println(" **ENCRYPTED**\n\" " + NowEncrypted + " \"\n\n");
		FileWordSave.write(NowEncrypted + newline+newline+newline);
		
		
		
		//	Decrypts
		String NowDecrypted = "";
		byte[] DECRYPTED_INFORMATION = new byte[BITS];
		for (int y=0; y<BITS; y+=8){
			byte[] UnEncrypted = new byte[8];
			run.decrypt(ENCRYPTED_INFORMATION, y, UnEncrypted, 0, KEY, 8);
			String DECRYPTED = new String(UnEncrypted, Charset.defaultCharset());
			for (int d=0; d<8; d++)  DECRYPTED_INFORMATION[d+y] = UnEncrypted[d];
			NowDecrypted += DECRYPTED;}
		System.out.println(" **DECRYPTED**\n\" " + NowDecrypted + " \"\n\n");
		FileWordSave.write(NowDecrypted + newline+newline+newline);
		
		
		
		
		FileWordSave.close();
	}
}

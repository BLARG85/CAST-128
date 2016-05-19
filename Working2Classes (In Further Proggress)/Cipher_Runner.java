import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.Scanner;



public class Cipher_Runner{

	public static void main(String args[]) throws IOException, InvalidKeyException
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Would you like to  encrypt  or  decrypt ?"+"\n  -  ");
	    String E_or_D = sc.next();
	    
	    if(E_or_D.equals("encrypt")){
	    	Ask CAST128 = new Ask("Encrypt");
	    }
	    else if(E_or_D.equals("decrypt")){
	    	Ask CAST128 = new Ask(1);
	    }
		
	}
}
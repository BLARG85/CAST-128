import java.security.InvalidKeyException;

public interface Cipher_Require{
	
	public Object makeKey(byte[] uk, int bs) throws InvalidKeyException;
	public void encrypt(byte[] in, int i, byte[] out, int j, Object k, int bs);
	public void decrypt(byte[] in, int i, byte[] out, int j, Object k, int bs);
	
}

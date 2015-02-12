package encryption;

import java.io.IOException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * AESEncryption.java
 * 
 * Encryption and decryption of strings with a passphrase/password
 * this class is not used directly (use EncryptionWrapper!)
 * 
 * @author Andy Dunkel andy.dunkel"at"ekiwi.de
 * @author published under the terms and conditions of the
 *      GNU General Public License,
 *      for details see file gpl.txt in the distribution
 *      package of this software
 *
 */
public class AESEncryption implements IEncryption 
{
    /**
     * Encrypts a message with a passphrase
     * 
     * @param passphrase
     * @param message
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public String encryptString(String passphrase, String message) throws Exception
     {
       /*
        * we dont use the password for encryption, we just
        * make an md5 of the passphrase and use that as password
        */        
       MessageDigest md;
       md = MessageDigest.getInstance("MD5");
       
       md.update(passphrase.getBytes("UTF-8"));
       
       byte digest[] = md.digest();
       String digestString = base64encode(digest);
       System.out.println(digestString);
       //----------
       
       SecureRandom sr = new SecureRandom(digestString.getBytes());
       KeyGenerator kGen = KeyGenerator.getInstance("AES");
       kGen.init(128,sr);
       Key key = kGen.generateKey();
       Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

       // encrypt
       cipher.init(Cipher.ENCRYPT_MODE,key);
       byte[] bIn = cipher.doFinal(message.getBytes("UTF-8"));
       
       // convert encrypted bytes into string
       String base64Encoded = base64encode(bIn);// for store use, so must convert to string
	
       return base64Encoded;	       		
	}
	
    /**
     * Decrypts a crypted string with the given passphrase
     * 
     * @param passphrase
     * @param crypted
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public String decryptString(String passphrase, String crypted) throws Exception
    {
       MessageDigest md;
       md = MessageDigest.getInstance("MD5");
       
       md.update(passphrase.getBytes("UTF-8"));
       
       byte digest[] = md.digest();
       String digestString = base64encode(digest);
       System.out.println(digestString);
       
       SecureRandom sr = new SecureRandom(digestString.getBytes());
       KeyGenerator kGen = KeyGenerator.getInstance("AES");
       kGen.init(128,sr);
       Key key = kGen.generateKey();
       Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");       

       // decrypt
       cipher.init(Cipher.DECRYPT_MODE, key); 
       byte[] cryptString = base64decode(crypted);     
       byte[] bOut = cipher.doFinal(cryptString);
       
       String outString = new String(bOut, "UTF-8");
       
       return outString;
    }
	
    private String base64encode(byte[] in)
    {
        String out = new String(Base64.encodeBytes(in));
        return out;
    }
	
    private byte[] base64decode(String crypted)
    {               
        byte[] b = null;        
        
        try {
            b = Base64.decode(crypted);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return b;
    }
}

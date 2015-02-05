package encryption;

/**
 * IEncryption.java
 * 
 * Interface for the encryption, so we can other encryption
 * algorithms later
 * 
 * @author Andy Dunkel andy.dunkel"at"ekiwi.de
 * @author published under the terms and conditions of the
 *      GNU General Public License,
 *      for details see file gpl.txt in the distribution
 *      package of this software
 *
 */
public interface IEncryption 
{
    public String encryptString(String passphrase, String message) throws Exception;
    public String decryptString(String passphrase, String crypted) throws Exception;
    

}

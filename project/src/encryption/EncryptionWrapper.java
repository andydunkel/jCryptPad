package encryption;


/**
 * EncryptionWrapper.java
 * 
 * Wrapper for the encryption
 * 
 * @author Andy Dunkel andy.dunkel"at"ekiwi.de
 * @author published under the terms and conditions of the
 *      GNU General Public License,
 *      for details see file gpl.txt in the distribution
 *      package of this software
 *
 */
public class EncryptionWrapper 
{
    private IEncryption encryption = new AESEncryption();
    private String beginMessage = "-----BEGIN ENCRYPTED MESSAGE-----";
    private String beginFile = "-----BEGIN ENCRYPTED FILE-----";
    private String endMessage = "-----END ENCRYPTED MESSAGE-----";
    private String beginEnc = "-----BEGIN-----";
    private String versionInfo = "Version: jCryptPad V1.0";
    
    
    public String encryptMessage(String message, String key) throws Exception
    {
        String out = beginMessage + "\n";
        out += versionInfo + "\n\n";
                
        out += beginEnc + "\n";
        out += encryption.encryptString(key, message) + "\n";
        
        out += endMessage;
                
        return out;      
    }
    
    public String encryptFile(String message, String key) throws Exception
    {
        String out = beginFile + "\n";
        out += versionInfo + "\n\n";
                
        out += beginEnc + "\n";
        out += encryption.encryptString(key, message) + "\n";
        
        out += endMessage;
                
        return out;      
    }
           
       
    public String decryptMessage(String message, String key) throws Exception
    {        
        int posStart = message.indexOf(beginEnc);
        int posEnd = message.indexOf(endMessage);
        
        if ((posStart != -1) && (posEnd != -1))
        {
            posStart += beginEnc.length() + 1;
            
            String msgEnc = message.substring(posStart, posEnd);
            
            //remove all whitespaces          
            int i = msgEnc.indexOf(" ");
            msgEnc = msgEnc.replace(" ", "");            
            
            IEncryption enc = new AESEncryption();
            String out = enc.decryptString(key, msgEnc);
            return out;
        } else
        {
            throw new Exception("Error in encrypted message.");
        }       
        
    }  
  
}

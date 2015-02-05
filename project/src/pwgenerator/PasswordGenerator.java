package pwgenerator;

import java.util.Random;

/**
 * PasswordGenerator.java
 * 
 * generates passwords
 * 
 * @author Andy Dunkel andy.dunkel"at"ekiwi.de
 * @author published under the terms and conditions of the
 *      GNU General Public License,
 *      for details see file gpl.txt in the distribution
 *      package of this software
 *
 */
public class PasswordGenerator 
{
    private boolean specialCharsAllowed = false;
    private boolean numbersAllowed = false;
    private boolean capitalsAllowed = false;
    
    private final String chars = "abcdefghijklmnopqrstuvwxyz";
    private final String specialChars = "!\"§$%&/()[]{}+*#'-.,><|";
    private final String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String numberChars = "0123456789";
    
    public String generatePassword(int length)
    {
        Random r = new Random();
        String password = "";
        
        for (int i = 0; i < length;i++)
        {            
            boolean choosen = false;
            
            do
            {                        
                int c = r.nextInt(4);
                if (c == 0)
                {   
                    password = password + randomChar();
                    choosen = true;
                }
            
                if ((c == 1) && (this.capitalsAllowed == true)) 
                {
                    password = password + randomCapitalChar();
                    choosen = true;
                }
            
                if ((c == 2) && (this.numbersAllowed == true))
                {
                    password = password + randomNumberChar();
                    choosen = true;
                }
            
                if ((c == 3) && (this.specialCharsAllowed == true))
                {
                    password = password + randomSpecialChar();
                    choosen = true;
                }                        
            }
            while(choosen == false);
        }
        
        return password;
    }
    
    private String randomChar()
    {
        Random r = new Random();
        int c = Math.abs(r.nextInt(chars.length()));
        
        return chars.substring(c, c+1);        
    }
    
    private String randomCapitalChar()
    {
        Random r = new Random();
        int c = Math.abs(r.nextInt(capitalChars.length()));
        
        return capitalChars.substring(c, c+1);        
    }    
    
    private String randomNumberChar()
    {
        Random r = new Random();
        int c = Math.abs(r.nextInt(numberChars.length()));
        
        return numberChars.substring(c, c+1);        
    }       
    
    private String randomSpecialChar()
    {
        Random r = new Random();
        int c = Math.abs(r.nextInt(specialChars.length()));
        
        return specialChars.substring(c, c+1);        
    }      

    public boolean isSpecialCharsAllowed()
    {
        return specialCharsAllowed;
    }

    public void setSpecialCharsAllowed(boolean specialCharsAllowed) 
    {
        this.specialCharsAllowed = specialCharsAllowed;
    }

    public boolean isNumbersAllowed() 
    {
        return numbersAllowed;
    }

    public void setNumbersAllowed(boolean numbersAllowed) 
    {
        this.numbersAllowed = numbersAllowed;
    }

    public boolean isCapitalsAllowed() 
    {
        return capitalsAllowed;
    }

    public void setCapitalsAllowed(boolean capitalsAllowed) 
    {
        this.capitalsAllowed = capitalsAllowed;
    }

}

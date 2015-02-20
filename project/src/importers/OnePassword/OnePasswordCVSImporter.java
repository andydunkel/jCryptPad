/*
    published under the terms and conditions of the
       GNU General Public License,
       for details see file gpl.txt in the distribution
       package of this software
*/
package importers.OnePassword;

import importers.ImportHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andy Dunkel
 */
public class OnePasswordCVSImporter {
    
    private final static char DIV = ',';
    private final static char MARK = '\"';
    private final static char NL = '\n';
    
    public final static String TYPE_LOGIN = "Login";
    public final static String TYPE_PASSWORD = "Password";
    public final static String TYPE_SOFTWARE_LICENSE = "Software License";
    public final static String TYPE_SECURE_NOTE = "Secure Note";
    
    private final String fileName;
    
    private final List<OnePasswordEntry> listSecureNotes = new ArrayList<OnePasswordEntry>();
    private final List<OnePasswordEntry> listPasswords = new ArrayList<OnePasswordEntry>();
    private final List<OnePasswordEntry> listSoftware = new ArrayList<OnePasswordEntry>();   
    private final List<OnePasswordEntry> listLogin = new ArrayList<OnePasswordEntry>();   

    
    private OnePasswordEntry currentEntry = new OnePasswordEntry();
    
    private int max = 0;  
    private int row = 0;
    private String currentField = "";
    private boolean inField = false;
    
    private String content = "";
    
    private char current = ' ';
    
  
    /**
     * Constructor
     * @param fileName 
     */
    public OnePasswordCVSImporter(String fileName) {
        this.fileName = fileName;
    }
    
    public void importData() throws IOException {
               
        content = ImportHelper.loadFile(fileName);
        normalizeLineEndings();
        
        max = content.length();
        
        for (int i = 0; i < max; i++) {                                               
            current = content.charAt(i);

            if (parseChar()) {
                //normal character
                currentField += current;
            }
                     
        }            
    }
    
    /**
     * Adds a field to the entry
     * @param fieldContent
     * @param row 
     */
    private void addField() {
        System.out.println("Content: " + currentField + " ; " + row);
        switch (row) {
            case 0: //text
                currentEntry.setDescription(currentField);
                break;
            case 1: //Password
                currentEntry.setPassword(currentField);
                break;
            case 2: //title
                currentEntry.setName(currentField);                
                break;
            case 3: //Type
                currentEntry.setType(currentField);
                break;
            case 4: //link
                currentEntry.setUrl(currentField);
                break;
            case 5: //username
                currentEntry.setUsername(currentField);
                break;             
        }
        
        currentField = "";
        
    }


    
    /**
     * Parse the character and decide what to do
     */
    private boolean parseChar() {  
        
        
        //"x - line starts with " and followed by value
        if ((current == MARK) && (!inField)) {
            inField = true;
            return false;
        }
        
        //xxx" - end of value
        if ((current == MARK) && (inField)) {
            inField = false;
            return false;
        }
        
        //, - line starts with
        if ((current == DIV) && (!inField)) {
            addField();
            inField = false;
            row++;
            return false;
        }
        
        //new line
        if ((current == NL) && (!inField)) {
            addToList();
            currentEntry = new OnePasswordEntry();
            row = 0;
            return false;
        }

        return true;
    }

    /**
     * Filters the line endings to \n
     */
    private void normalizeLineEndings() {
        content = content.replace("\r\n", "\n");
        content = content.replace("\r", "\n");
    }

    /**
     * Adds to the lists
     */
    private void addToList() {
                     
        if (currentEntry.getType().equals(TYPE_LOGIN)) {
            listLogin.add(currentEntry);
            return;
        }
        
        if (currentEntry.getType().equals(TYPE_PASSWORD)) {
            listPasswords.add(currentEntry);
            return;
        }
        
        if (currentEntry.getType().equals(TYPE_SOFTWARE_LICENSE)) {
            listSoftware.add(currentEntry);
            return;
        }               
        
        listSecureNotes.add(currentEntry);        
    }

    public List<OnePasswordEntry> getListSecureNotes() {
        return listSecureNotes;
    }

    public List<OnePasswordEntry> getListPasswords() {
        return listPasswords;
    }

    public List<OnePasswordEntry> getListSoftware() {
        return listSoftware;
    }

    public List<OnePasswordEntry> getListLogin() {
        return listLogin;
    }
    
    
       
}

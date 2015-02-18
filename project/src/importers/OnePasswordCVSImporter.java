/*
    published under the terms and conditions of the
       GNU General Public License,
       for details see file gpl.txt in the distribution
       package of this software
*/
package importers;

import java.io.IOException;

/**
 *
 * @author Andy Dunkel
 */
public class OnePasswordCVSImporter {
    
    private String fileName;
    
    /**
     * Constructor
     * @param fileName 
     */
    public OnePasswordCVSImporter(String fileName) {
        this.fileName = fileName;
    }
    
    public void importData() throws IOException {
       
        String s = ImportHelper.loadFile(fileName);
        System.out.println(s);
        
    }
    
    
}

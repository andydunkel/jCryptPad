/*
    published under the terms and conditions of the
       GNU General Public License,
       for details see file gpl.txt in the distribution
       package of this software
*/
package importers;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author dunkel
 */
public class ImportHelper {
    
    /**
     * Loads a file and returns as string
     * @param fileName
     * @return 
     * @throws java.io.IOException 
     */
    public static String loadFile(String fileName) throws IOException  {
        Path path = FileSystems.getDefault().getPath(fileName);
        String s = new String(Files.readAllBytes(path));
        return s;
    }        
            
    
}

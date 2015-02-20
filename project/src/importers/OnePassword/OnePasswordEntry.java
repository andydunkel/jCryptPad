/*
    published under the terms and conditions of the
       GNU General Public License,
       for details see file gpl.txt in the distribution
       package of this software
*/
package importers.OnePassword;

import interfaces.IConsts;

/**
 *
 * @author dunkel
 */
public class OnePasswordEntry {
    
    private String description = "";
    private String username = "";
    private String password = "";
    private String url = "";
    private String name = "";
    private String type = "";
    
    @Override
    public String toString() {    
        String s = "";
        
        s += "# " + this.name + IConsts.CRLF + IConsts.CRLF;
        
        if (username.length() > 0) s += "- Username: " + this.username + IConsts.CRLF;
        if (password.length() > 0) s += "- Password: " + this.password + IConsts.CRLF;
        
        s += IConsts.CRLF;
        
        if (url.length() > 0) {
            s += "## URL" + IConsts.CRLF + IConsts.CRLF;
            s += url + IConsts.CRLF;
        }
        
        
        
        if (description.length() > 0) {
            s += "## Description" + IConsts.CRLF + IConsts.CRLF;
            s += description;
        }
        
        return s;
    }
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}

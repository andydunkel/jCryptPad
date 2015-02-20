/*
 *  * 
 * @author Andy Dunkel andy.dunkel"at"ekiwi.de
 * @author published under the terms and conditions of the
 *      GNU General Public License,
 *      for details see file gpl.txt in the distribution
 *      package of this software
 *
 */
package importers.OnePassword;

import daimanager.EntryTreeNode;
import interfaces.IDataModel;

/**
 *
 * @author Andy Dunkel (andy.dunkel@ekiwi.de)
 */
public class OnePasswordGuiHelper {

    /**
     * Import the data to the data model and tree
     * @param imp
     * @param fileName
     * @param node 
     * @param model 
     */
    public void importNodes(OnePasswordCVSImporter imp, String fileName, EntryTreeNode node, IDataModel model) {
        
        EntryTreeNode logins = model.addNode(node, OnePasswordCVSImporter.TYPE_LOGIN);
        
        for (OnePasswordEntry e : imp.getListLogin()) {
            EntryTreeNode child = model.addNode(logins, e.getName());
            model.setNodeContent(child, e.toString());
        }
        
        EntryTreeNode passwords = model.addNode(node, OnePasswordCVSImporter.TYPE_PASSWORD);
        
        for (OnePasswordEntry e : imp.getListPasswords()) {
            EntryTreeNode child = model.addNode(passwords, e.getName());
            child.setContent(e.toString());
        }
        
        EntryTreeNode notes = model.addNode(node, OnePasswordCVSImporter.TYPE_SECURE_NOTE);
        
        for (OnePasswordEntry e : imp.getListSecureNotes()) {
            EntryTreeNode child = model.addNode(notes, e.getName());
            child.setContent(e.toString());
        }
        
        EntryTreeNode lics = model.addNode(node, OnePasswordCVSImporter.TYPE_SOFTWARE_LICENSE);
        
        for (OnePasswordEntry e : imp.getListSoftware()) {
            EntryTreeNode child = model.addNode(lics, e.getName());
            child.setContent(e.toString());
        }
        
        model.refreshObservers();
    }
    
    
    
}

package interfaces;

import daimanager.EntryTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * IDataModel.java
 * 
 * interface for the data model
 * 
 * @author Andy Dunkel andy.dunkel"at"ekiwi.de
 * @author published under the terms and conditions of the
 *      GNU General Public License,
 *      for details see file gpl.txt in the distribution
 *      package of this software
 *
 */
public interface IDataModel 
{
    public void saveFile(String file) throws Exception;
    public void loadFile(String file) throws Exception;
    
    public void subcribe(IObserver observer);
    public void unsubscribe(IObserver observer);
    public void refreshObservers();
    
    public EntryTreeNode addNode(EntryTreeNode father, String title);
    public void deleteNode(EntryTreeNode node);
    public EntryTreeNode getRootNode();
    
    public String getPassword();
    public void setPassword(String password);
    
    public void setNodeTitle(EntryTreeNode node, String title);
    public void setNodeContent(EntryTreeNode node, String content);
    
    public DefaultTreeModel getTreeModel();
    
    public void clearModel();
}

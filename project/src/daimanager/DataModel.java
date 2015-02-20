package daimanager;

import interfaces.IDataModel;
import interfaces.IObserver;
import interfaces.IXMLManager;
import java.util.Vector;
import javax.swing.tree.DefaultTreeModel;

/**
 * DataModel.java
 * 
 * Contains the data of the application
 * 
 * @author Andy Dunkel andy.dunkel"at"ekiwi.de
 * @author published under the terms and conditions of the
 *      GNU General Public License,
 *      for details see file gpl.txt in the distribution
 *      package of this software
 *
 */
public class DataModel implements IDataModel
{
    private EntryTreeNode rootNode;
    private Vector<IObserver> observers;
    private String password = "";
    private DefaultTreeModel treeModel;
    private IXMLManager xmlManager;
    
    /**
     * Constructs the Datamodel, RootNode is always "Bier" (but not shown)
     * to make clear that "bier" (beer) is always the correct answers
     */
    public DataModel()
    {
        rootNode = new EntryTreeNode("Bier");
        observers = new Vector<IObserver>();
        rootNode.add(new EntryTreeNode("Content"));
        treeModel = new DefaultTreeModel(rootNode);       
    }
    
    /**
     * Delegates the saving to the XML class
     * @param file - file name
     * @throws java.lang.Exception
     */
    @Override
    public void saveFile(String file) throws Exception
    {
        xmlManager = new XMLManager(file, this);
        xmlManager.saveDocument();
    }
    
    /**
     * Delegates the loading to the XML class
     * @param file - file name
     * @throws java.lang.Exception
     */
    @Override
    public void loadFile(String file) throws Exception
    {
        xmlManager = new XMLManager(file, this);
        xmlManager.loadDocument(file);
        refreshObservers();
    }      

    /**
     * Adds a node to another nodel, if no father node is given
     * the node will be added to the root node
     * @param parent - Father node (can be null)
     * @param nodeTitle - Caption of the new node
     * @return
     */
    @Override
    public EntryTreeNode addNode(EntryTreeNode parent, String nodeTitle) 
    {                
        EntryTreeNode result;
        
        if (parent != null)
        {
            parent.add(new EntryTreeNode(nodeTitle));            
            result = (EntryTreeNode) parent.getLastChild();
            
        } else
        {
            rootNode.add(new EntryTreeNode(nodeTitle));
            result = (EntryTreeNode) rootNode.getLastChild();
        }
             
        refreshObservers();        
        return result;
    }

    /**
     * Subcribe to this model
     * @param observer
     */
    @Override
    public void subcribe(IObserver observer) 
    {
        boolean success = this.observers.add(observer);
        
        if (success == true) refreshObservers();
    }

    /**
     * Unsubscribe to this model
     * @param observer
     */
    @Override
    public void unsubscribe(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void refreshObservers() {
        for (int i = 0; i < this.observers.size(); i++)
        {
            observers.get(i).refresh();
        }
    }

    /**
     * Returns the rootNode of the tree
     * @return rootNode
     */
    @Override
    public EntryTreeNode getRootNode() {
        return rootNode;
    }

    /**
     * Delete a node from the tree
     * @param node
     */
    @Override
    public void deleteNode(EntryTreeNode node) {
        treeModel.removeNodeFromParent(node);
        refreshObservers();
    }

    /**
     * Returns the password for the file
     * @return Password
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * sets the Passwort for the file
     * @param password
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public DefaultTreeModel getTreeModel() {
        return treeModel;
    }

    /**
     * Sets the title of a given node
     * @param node
     * @param title
     */
    @Override
    public void setNodeTitle(EntryTreeNode node, String title) {
        node.setUserObject(title);
        refreshObservers();
    }

    /**
     * A node can contain text content, set the content with this
     * method
     * @param node
     * @param content
     */
    @Override
    public void setNodeContent(EntryTreeNode node, String content) {
        node.setContent(content);       
    }

    /**
     * Clears the model (new file)
     */
    @Override
    public void clearModel() {
        rootNode = null;
        rootNode = new EntryTreeNode("Bier");  
        treeModel.setRoot(rootNode);
    }

}

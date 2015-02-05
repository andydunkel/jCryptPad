package daimanager;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * EntryTreeNode.java
 * 
 * The node in the tree, extended from DefaultmutableTreeNode
 * extended by content handling
 * 
 * @author Andy Dunkel andy.dunkel"at"ekiwi.de
 * @author published under the terms and conditions of the
 *      GNU General Public License,
 *      for details see file gpl.txt in the distribution
 *      package of this software
 *
 */
public class EntryTreeNode extends DefaultMutableTreeNode
{
   
    private String content = "";

    public EntryTreeNode(Object droppedObject) {
        super(droppedObject);
    }
    
    public EntryTreeNode(String nodeTitle)
    {
        super(nodeTitle);        
    }
    
    private boolean selected = false;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    
}

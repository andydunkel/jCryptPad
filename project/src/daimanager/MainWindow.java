/**
 * MainWindow.java
 * 
 * The main window of the application
 * 
 * @author Andy Dunkel andy.dunkel"at"ekiwi.de
 * @author published under the terms and conditions of the
 *      GNU General Public License,
 *      for details see file gpl.txt in the distribution
 *      package of this software
 *
 */

package daimanager;

import daimanager.tree.NodeMoveTransferHandler;
import daimanager.encryptiondialog.EncryptionDialog;
import daimanager.tree.TreeDropTarget;
import interfaces.IDataModel;
import interfaces.IObserver;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;


public class MainWindow extends javax.swing.JFrame implements IObserver{
    
    private static final String APPNAME = "jCryptPad";
    private IDataModel model;
    private boolean saved = false;
    private String savedFileName = "";
    
    
    /** Creates new form MainWindows */
    public MainWindow(IDataModel model) {
        initComponents();
        
        this.model = model;
        this.model.subcribe(this);       
        
        jNavTree.setModel(model.getTreeModel());
        NodeMoveTransferHandler handler = new NodeMoveTransferHandler();
        
        jNavTree.setTransferHandler(handler);
        jNavTree.setDropTarget(new TreeDropTarget(handler));
        jNavTree.setDragEnabled(true);
                
        
        //Settings for tree component        		
        ImageIcon leafIcon = new ImageIcon(getClass().getResource("/res/leaf.png") );
        ImageIcon folderIcon = new ImageIcon(getClass().getResource("/res/folder_closed16.png") );
        ImageIcon openIcon = new ImageIcon(getClass().getResource("/res/folder_open16.png") );

        if (leafIcon != null) 
        {
            DefaultTreeCellRenderer renderer = 
                new DefaultTreeCellRenderer();
            renderer.setLeafIcon(leafIcon);
            renderer.setClosedIcon(folderIcon);
            renderer.setOpenIcon(openIcon);
            this.jNavTree.setCellRenderer(renderer);
        }
        
        initTree();        
        
        this.setTitle(APPNAME + " - untitled.jcrypt");
            
        jNavTree.setComponentPopupMenu(jPopUpTree);
        jNavTree.setRootVisible(false);
        jNavTree.setSelectionModel(new DefaultTreeSelectionModel());
        jNavTree.getSelectionModel().setSelectionMode(DefaultTreeSelectionModel.SINGLE_TREE_SELECTION);
       
        //create new Controller
        
        this.setJMenuBar(jMainMenu);
    }
    
    
    /**
     * Initialize the tree
     */
    private void initTree()
    {
        DefaultTreeModel t = (DefaultTreeModel)this.jNavTree.getModel();
        
        //t.setRoot(getModel().getRootNode());
        t.reload(getModel().getRootNode());
        jNavTree.repaint();
        
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopUpTree = new javax.swing.JPopupMenu();
        popupNewMainNode = new javax.swing.JMenuItem();
        popupNewSiblingNode = new javax.swing.JMenuItem();
        popupNewChildNode = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JSeparator();
        popupEditNode = new javax.swing.JMenuItem();
        popupDeleteItem = new javax.swing.JMenuItem();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jNavTree = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEdit = new javax.swing.JEditorPane();
        jToolBar = new javax.swing.JToolBar();
        btNew = new javax.swing.JButton();
        btOpen = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btNewMainNode = new javax.swing.JButton();
        btNewSibling = new javax.swing.JButton();
        btNewChild = new javax.swing.JButton();
        btEditNode = new javax.swing.JButton();
        btDeleteNode = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btCut = new javax.swing.JButton();
        btCopy = new javax.swing.JButton();
        btPaste = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btAboutDlg = new javax.swing.JButton();
        jMainMenu = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        itemFileNew = new javax.swing.JMenuItem();
        itemOpen = new javax.swing.JMenuItem();
        itemSave = new javax.swing.JMenuItem();
        itemSaveAs = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        itemExit = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenu();
        itemCut = new javax.swing.JMenuItem();
        itemCopy = new javax.swing.JMenuItem();
        itemPaste = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JSeparator();
        itemDeleteNode = new javax.swing.JMenuItem();
        mnuEncryption = new javax.swing.JMenu();
        itemSetPassword = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JSeparator();
        itemPasswordGenerator = new javax.swing.JMenuItem();
        itemTextEncryption = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        popupNewMainNode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/mainnode.png"))); // NOI18N
        popupNewMainNode.setText("New main node");
        popupNewMainNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doNewMainNode(evt);
            }
        });
        jPopUpTree.add(popupNewMainNode);

        popupNewSiblingNode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/sibling.png"))); // NOI18N
        popupNewSiblingNode.setText("Add new sibling node");
        popupNewSiblingNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doNewSiblingNode(evt);
            }
        });
        jPopUpTree.add(popupNewSiblingNode);

        popupNewChildNode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/childnode.png"))); // NOI18N
        popupNewChildNode.setText("Add new child node");
        popupNewChildNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doNewChildNode(evt);
            }
        });
        jPopUpTree.add(popupNewChildNode);
        jPopUpTree.add(jSeparator5);

        popupEditNode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/edit.png"))); // NOI18N
        popupEditNode.setText("Edit Node");
        popupEditNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doEditNode(evt);
            }
        });
        jPopUpTree.add(popupEditNode);

        popupDeleteItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/delete16.png"))); // NOI18N
        popupDeleteItem.setText("Delete item");
        popupDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doDeleteNode(evt);
            }
        });
        jPopUpTree.add(popupDeleteItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("jCryptPad");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onWindowClose(evt);
            }
        });

        jNavTree.setAutoscrolls(true);
        jNavTree.setDragEnabled(true);
        jNavTree.setMaximumSize(new java.awt.Dimension(32000, 32000));
        jNavTree.setMinimumSize(new java.awt.Dimension(200, 300));
        jNavTree.setPreferredSize(new java.awt.Dimension(150, 64));
        jNavTree.setShowsRootHandles(true);
        jNavTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                selectionChangeTree(evt);
            }
        });
        jScrollPane1.setViewportView(jNavTree);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jEdit.setFont(new java.awt.Font("Courier New", 0, 11));
        jScrollPane2.setViewportView(jEdit);

        jSplitPane1.setRightComponent(jScrollPane2);

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/tb_new.png"))); // NOI18N
        btNew.setToolTipText("New File");
        btNew.setFocusable(false);
        btNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doNewFile(evt);
            }
        });
        jToolBar.add(btNew);

        btOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/tb_open.png"))); // NOI18N
        btOpen.setToolTipText("Open File");
        btOpen.setFocusable(false);
        btOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doOpen(evt);
            }
        });
        jToolBar.add(btOpen);

        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/tb_save.png"))); // NOI18N
        btSave.setToolTipText("Save File");
        btSave.setFocusable(false);
        btSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doSave(evt);
            }
        });
        jToolBar.add(btSave);
        jToolBar.add(jSeparator1);

        btNewMainNode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/mainnode.png"))); // NOI18N
        btNewMainNode.setToolTipText("Add Main Node");
        btNewMainNode.setFocusable(false);
        btNewMainNode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNewMainNode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNewMainNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doNewMainNode(evt);
            }
        });
        jToolBar.add(btNewMainNode);

        btNewSibling.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/sibling.png"))); // NOI18N
        btNewSibling.setToolTipText("Add Sibling");
        btNewSibling.setFocusable(false);
        btNewSibling.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNewSibling.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNewSibling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doNewSiblingNode(evt);
            }
        });
        jToolBar.add(btNewSibling);

        btNewChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/childnode.png"))); // NOI18N
        btNewChild.setToolTipText("Add Child Node");
        btNewChild.setFocusable(false);
        btNewChild.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNewChild.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNewChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doNewChildNode(evt);
            }
        });
        jToolBar.add(btNewChild);

        btEditNode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/edit.png"))); // NOI18N
        btEditNode.setToolTipText("Edit Node");
        btEditNode.setFocusable(false);
        btEditNode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEditNode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEditNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doEditNode(evt);
            }
        });
        jToolBar.add(btEditNode);

        btDeleteNode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/delete16.png"))); // NOI18N
        btDeleteNode.setToolTipText("Delete marked node");
        btDeleteNode.setFocusable(false);
        btDeleteNode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btDeleteNode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btDeleteNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doDeleteNode(evt);
            }
        });
        jToolBar.add(btDeleteNode);
        jToolBar.add(jSeparator2);

        btCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cut16.png"))); // NOI18N
        btCut.setToolTipText("Cut");
        btCut.setFocusable(false);
        btCut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doCut(evt);
            }
        });
        jToolBar.add(btCut);

        btCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/copy16.png"))); // NOI18N
        btCopy.setToolTipText("Copy");
        btCopy.setFocusable(false);
        btCopy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCopy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doCopy(evt);
            }
        });
        jToolBar.add(btCopy);

        btPaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/paste16.png"))); // NOI18N
        btPaste.setToolTipText("Paste");
        btPaste.setFocusable(false);
        btPaste.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPaste.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doPaste(evt);
            }
        });
        jToolBar.add(btPaste);
        jToolBar.add(jSeparator3);

        btAboutDlg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Info.png"))); // NOI18N
        btAboutDlg.setToolTipText("About jCryptpad");
        btAboutDlg.setFocusable(false);
        btAboutDlg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAboutDlg.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAboutDlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doAboutDlg(evt);
            }
        });
        jToolBar.add(btAboutDlg);

        mnuFile.setMnemonic('F');
        mnuFile.setText("File");

        itemFileNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        itemFileNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/tb_new.png"))); // NOI18N
        itemFileNew.setMnemonic('N');
        itemFileNew.setText("New");
        itemFileNew.setActionCommand("New File");
        itemFileNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doNewFile(evt);
            }
        });
        mnuFile.add(itemFileNew);

        itemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        itemOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/tb_open.png"))); // NOI18N
        itemOpen.setMnemonic('O');
        itemOpen.setText("Open");
        itemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doOpen(evt);
            }
        });
        mnuFile.add(itemOpen);

        itemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itemSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/tb_save.png"))); // NOI18N
        itemSave.setMnemonic('S');
        itemSave.setText("Save");
        itemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doSave(evt);
            }
        });
        mnuFile.add(itemSave);

        itemSaveAs.setText("Save as");
        itemSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doSaveAs(evt);
            }
        });
        mnuFile.add(itemSaveAs);
        mnuFile.add(jSeparator4);

        itemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        itemExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/exit.png"))); // NOI18N
        itemExit.setMnemonic('E');
        itemExit.setText("Exit");
        itemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doExit(evt);
            }
        });
        mnuFile.add(itemExit);

        jMainMenu.add(mnuFile);

        mnuEdit.setMnemonic('E');
        mnuEdit.setText("Edit");

        itemCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        itemCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cut16.png"))); // NOI18N
        itemCut.setMnemonic('C');
        itemCut.setText("Cut");
        itemCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doCut(evt);
            }
        });
        mnuEdit.add(itemCut);

        itemCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itemCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/copy16.png"))); // NOI18N
        itemCopy.setMnemonic('o');
        itemCopy.setText("Copy");
        itemCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doCopy(evt);
            }
        });
        mnuEdit.add(itemCopy);

        itemPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        itemPaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/paste16.png"))); // NOI18N
        itemPaste.setMnemonic('P');
        itemPaste.setText("Paste");
        itemPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doPaste(evt);
            }
        });
        mnuEdit.add(itemPaste);
        mnuEdit.add(jSeparator7);

        itemDeleteNode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/delete16.png"))); // NOI18N
        itemDeleteNode.setText("Delete Node");
        itemDeleteNode.setToolTipText("Delete marked node");
        itemDeleteNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doDeleteNode(evt);
            }
        });
        mnuEdit.add(itemDeleteNode);

        jMainMenu.add(mnuEdit);

        mnuEncryption.setText("Encryption");

        itemSetPassword.setText("Set password for this file");
        itemSetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doSetPwDlg(evt);
            }
        });
        mnuEncryption.add(itemSetPassword);
        mnuEncryption.add(jSeparator6);

        itemPasswordGenerator.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemPasswordGenerator.setText("Password Generator");
        itemPasswordGenerator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openPasswordGenerator(evt);
            }
        });
        mnuEncryption.add(itemPasswordGenerator);

        itemTextEncryption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemTextEncryption.setText("Text Encryption");
        itemTextEncryption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTextEncryptionActionPerformed(evt);
            }
        });
        mnuEncryption.add(itemTextEncryption);

        jMainMenu.add(mnuEncryption);

        mnuHelp.setMnemonic('h');
        mnuHelp.setText("Help");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Info.png"))); // NOI18N
        jMenuItem1.setText("About jCryptPad");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doAboutDlg(evt);
            }
        });
        mnuHelp.add(jMenuItem1);

        jMainMenu.add(mnuHelp);

        setJMenuBar(jMainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    /**
     * Selection of tree has changed
     * @param evt
     */
    private void selectionChangeTree(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_selectionChangeTree

        TreePath oldPath = evt.getOldLeadSelectionPath();
        TreePath path = evt.getNewLeadSelectionPath();
        
        try
        {
            EntryTreeNode oldNode = (EntryTreeNode)oldPath.getLastPathComponent();
            model.setNodeContent(oldNode, jEdit.getText());
        } catch (Exception e)
        {
            //
        }
            
        
        if (path != null)
        {
            //when changed we have to load the new content
            EntryTreeNode newNode = ((EntryTreeNode)path.getLastPathComponent());
            jEdit.setText(newNode.getContent());
        }
           
    }//GEN-LAST:event_selectionChangeTree

    /**
     * Add new main node 
     * 
     * @param evt
     */
    private void openPasswordGenerator(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openPasswordGenerator
        PasswordGeneratorDialog p = new PasswordGeneratorDialog(this,true);
        p.setLocationByPlatform(true);
        p.setVisible(true);
    }//GEN-LAST:event_openPasswordGenerator

    private void itemTextEncryptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTextEncryptionActionPerformed
        EncryptionDialog d = new EncryptionDialog();
        d.setLocationByPlatform(true);
        d.setVisible(true);
    }//GEN-LAST:event_itemTextEncryptionActionPerformed

    private void doPaste(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doPaste
        jEdit.paste();
    }//GEN-LAST:event_doPaste

    private void doCopy(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doCopy
        jEdit.copy();
    }//GEN-LAST:event_doCopy

    private void doCut(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doCut
        jEdit.cut();
    }//GEN-LAST:event_doCut

    private void doNewFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doNewFile
        int res = saveConfirmation();
        if (res != JOptionPane.CANCEL_OPTION)
        {
            newFile();
        }
    }//GEN-LAST:event_doNewFile

    private void doExit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doExit
        this.onWindowClose(null);        
    }//GEN-LAST:event_doExit

    private void doNewMainNode(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doNewMainNode
        NodeTitle dlg = new NodeTitle(this, true);
        dlg.setLocationByPlatform(true);
        dlg.setVisible(true);
        
        //create new node, under the main node
        if (dlg.getModalResult() == true)
        {
            getModel().addNode(null, dlg.getNodeTitle());
        }    
    }//GEN-LAST:event_doNewMainNode

    private void doNewSiblingNode(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doNewSiblingNode
        TreePath path = jNavTree.getSelectionPath();        

        if (path != null)
        {
            EntryTreeNode node = (EntryTreeNode)path.getLastPathComponent(); 
            NodeTitle dlg = new NodeTitle(this, true);
            dlg.setLocationByPlatform(true);
            dlg.setVisible(true);


            //create new node, under the main node
            if (dlg.getModalResult() == true)
            {
                getModel().addNode((EntryTreeNode)node.getParent(), dlg.getNodeTitle());
            }       
        }
    }//GEN-LAST:event_doNewSiblingNode

    private void doNewChildNode(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doNewChildNode
        NodeTitle dlg = new NodeTitle(this, true);
        dlg.setLocationByPlatform(true);
        dlg.setVisible(true);
        
        TreePath path = jNavTree.getSelectionPath();

        EntryTreeNode node = (EntryTreeNode)path.getLastPathComponent();         
        
        //create new node, under the main node
        if (dlg.getModalResult() == true)
        {
            getModel().addNode(node, dlg.getNodeTitle());
            jNavTree.expandPath(path);
        } 
    }//GEN-LAST:event_doNewChildNode

    private void doSetPwDlg(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doSetPwDlg
        showPasswordSetDlg();
    }//GEN-LAST:event_doSetPwDlg

    private void doDeleteNode(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doDeleteNode
        TreePath path = jNavTree.getSelectionPath();        

        if (path != null)
        {
            EntryTreeNode node = (EntryTreeNode)path.getLastPathComponent(); 

            int res = JOptionPane.showConfirmDialog(this,
                    "Delete this node and all children?",
                    "Node delete confirmation",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
                    
            //delete Node when user said yes
            if (res == JOptionPane.YES_OPTION)
            {
                getModel().deleteNode(node);
            }       
        }        
    }//GEN-LAST:event_doDeleteNode

    private void doEditNode(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doEditNode
        TreePath path = jNavTree.getSelectionPath();        

        if (path != null)
        {
            EntryTreeNode node = (EntryTreeNode)path.getLastPathComponent(); 

            NodeTitle n = new NodeTitle(this, true);
            n.setNodeTitle((String)node.getUserObject());
            n.setLocationByPlatform(true);
            n.setVisible(true);
                    
            //delete Node when user said yes
            if (n.getModalResult() == true)
            {
                model.setNodeTitle(node, n.getNodeTitle());
            }       
        }          
    }//GEN-LAST:event_doEditNode

    private void doSave(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doSave
        
        saveFileDlg(false);
}//GEN-LAST:event_doSave
    
    
    private void doOpen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doOpen
        openFileDlg();
}//GEN-LAST:event_doOpen

    private void doSaveAs(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doSaveAs
        saveFileDlg(true);
    }//GEN-LAST:event_doSaveAs

    private void doAboutDlg(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doAboutDlg
        AboutDialog dlg = new AboutDialog(this, true);
        dlg.setLocationByPlatform(true);        
        dlg.setVisible(true);
    }//GEN-LAST:event_doAboutDlg

    private void onWindowClose(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onWindowClose
        int res = saveConfirmation();
        if (res != JOptionPane.CANCEL_OPTION)
        {
          System.exit(0);
        } 
    }//GEN-LAST:event_onWindowClose
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAboutDlg;
    private javax.swing.JButton btCopy;
    private javax.swing.JButton btCut;
    private javax.swing.JButton btDeleteNode;
    private javax.swing.JButton btEditNode;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btNewChild;
    private javax.swing.JButton btNewMainNode;
    private javax.swing.JButton btNewSibling;
    private javax.swing.JButton btOpen;
    private javax.swing.JButton btPaste;
    private javax.swing.JButton btSave;
    private javax.swing.JMenuItem itemCopy;
    private javax.swing.JMenuItem itemCut;
    private javax.swing.JMenuItem itemDeleteNode;
    private javax.swing.JMenuItem itemExit;
    private javax.swing.JMenuItem itemFileNew;
    private javax.swing.JMenuItem itemOpen;
    private javax.swing.JMenuItem itemPasswordGenerator;
    private javax.swing.JMenuItem itemPaste;
    private javax.swing.JMenuItem itemSave;
    private javax.swing.JMenuItem itemSaveAs;
    private javax.swing.JMenuItem itemSetPassword;
    private javax.swing.JMenuItem itemTextEncryption;
    private javax.swing.JEditorPane jEdit;
    private javax.swing.JMenuBar jMainMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTree jNavTree;
    private javax.swing.JPopupMenu jPopUpTree;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JMenu mnuEdit;
    private javax.swing.JMenu mnuEncryption;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenuItem popupDeleteItem;
    private javax.swing.JMenuItem popupEditNode;
    private javax.swing.JMenuItem popupNewChildNode;
    private javax.swing.JMenuItem popupNewMainNode;
    private javax.swing.JMenuItem popupNewSiblingNode;
    // End of variables declaration//GEN-END:variables

    
    /**
     * Show the Open-File DLG
     */
    private void openFileDlg() 
    {
        int res;
        
        res = saveConfirmation();
        
        if (res != JOptionPane.CANCEL_OPTION)
        {
            JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("jCryptPad file", "jcrypt");
	    
	    chooser.setFileFilter(filter);
            res = chooser.showOpenDialog(this);
	    
            openFile(chooser.getSelectedFile().getAbsolutePath());            
        }
    }
    
    /**
     * Opens a files
     * for that we make a new model and then load the file
     * @param filename
     */
    public void openFile(String filename)
    {
        //first show the pw input-dlg
        DecryptPassword decryptDlg = new DecryptPassword(this,true);
        decryptDlg.setLocationByPlatform(true);
        decryptDlg.setVisible(true);

        if (decryptDlg.isModalResult() == true)
        {                
            String pw = new String(decryptDlg.getEdtPassword().getPassword());
            model.setPassword(pw);

            try {
                model.loadFile(filename);
                saved = true;
                savedFileName = filename;
                this.setTitle(APPNAME + " - " + savedFileName);
            } catch (javax.crypto.BadPaddingException ex) {
               JOptionPane.showMessageDialog(this,
                        "Error: Password for file seems to be wrong.",
                        "Error: Bad password", 
                        JOptionPane.ERROR_MESSAGE);

            } catch (Exception ex) {
               JOptionPane.showMessageDialog(this,
                        "Error: Could not open file, please check for file permissions.",
                        "Error: File Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
            
        }               
    }
    
    private int saveConfirmation()
    {
        int res;
        res = JOptionPane.showConfirmDialog(this, 
                "Save the current file?",
                "Save file?",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if (res == JOptionPane.YES_OPTION) saveFileDlg(false);
        
        return res;
    }
    
    /**
     * Save the current file, if the file was never saved before
     * a dialog is shown
     * 
     * @param showDlg = true for showing the FileChooser everytime
     */
    private void saveFileDlg(boolean showDlg)
    {
        //first save the current entry
       TreePath oldPath = jNavTree.getLeadSelectionPath();
        
        try
        {
            EntryTreeNode oldNode = (EntryTreeNode)oldPath.getLastPathComponent();
            model.setNodeContent(oldNode, jEdit.getText());
        } catch (Exception e)
        {
            //
        }

        
        
        int returnval;
        
        /**
         * User have to enter password for saving
         */
        boolean resPw = true;
        if (model.getPassword().equals(""))
        {
            resPw = showPasswordSetDlg();
        }
        
        if (resPw == false)
        {
            JOptionPane.showMessageDialog(this,
                    "You must enter a password to save the file.",
                    "Error: No password set", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
        
        if (((saved == false) || (showDlg == true)) && (resPw == true))
        {
            JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("jCryptPad file", "jcrypt");
	    
	    chooser.setFileFilter(filter);
            returnval = chooser.showSaveDialog(this);
	    
	    //user choosed a file
	    if(returnval == JFileChooser.APPROVE_OPTION) 
	    {		    	
               saveFile(chooser.getSelectedFile().getAbsolutePath());	    
            }
        } else
        {
            saveFile(savedFileName);
        }
     }  
    
    private void saveFile(String fileName)
    {
        try {
            model.saveFile(fileName);
            saved = true;
            savedFileName = fileName;
            this.setTitle(APPNAME + " - " + savedFileName);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,
                    "Error: Could not save file, please check for file permissions.",
                    "Error: File Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean showPasswordSetDlg()
    {
        EncryptPassword p = new EncryptPassword(this,true);
        p.setLocationByPlatform(true);
        p.setVisible(true);   
        
        if (p.isModalResult() == true)
        {
            String pw = new String(p.getEdtPw1().getPassword());
            model.setPassword(pw);
        }
        
        return p.isModalResult();
    }    
    
    private void newFile()
    {
        model = new DataModel();
        model.subcribe(this);
        jNavTree.setModel(model.getTreeModel());
        this.setTitle(APPNAME +  " - untitled.dacrypt");
    }
    
    /**
     * Called when there are changes to the DataModel
     */
    @Override
    public void refresh() 
    {
        initTree();
    }

    public IDataModel getModel() {
        return model;
    }

    public void setModel(IDataModel model) {
        this.model = model;
    }    
}
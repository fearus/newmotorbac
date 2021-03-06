/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelContexts.java
 *
 * Created on May 5, 2011, 5:07:14 PM
 */

package newmotorbac;

import newmotorbac.util.OrbacPolicyContext;
import com.Ostermiller.Syntax.HighlightedDocument;
import java.awt.Frame;
import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import newmotorbac.dialog.jDialogAddContext;
import newmotorbac.dialog.jDialogEditContextDefinition;
import orbac.AbstractOrbacPolicy;
import orbac.context.CContext;
import orbac.exception.COrbacException;

/**
 *
 * @author fabien
 */
public class PanelContexts extends javax.swing.JPanel {
    // policy context
    private OrbacPolicyContext thisContext;
    // syntax highlighter
    private HighlightedDocument docPane = new HighlightedDocument();
    // currently selected context
    private String selectedCtx;

    // the list of context definition editors that are open
    // the map key is the context name concatenated with the organization in which the definition is edited
    HashMap<String, jDialogEditContextDefinition> editors = new HashMap<String, jDialogEditContextDefinition>();

    /** Creates new form PanelContexts */
    public PanelContexts(OrbacPolicyContext thisContext) {
        initComponents();

        // store context
        this.thisContext = thisContext;

        thisContext.panelContexts = this;

        // set syntax highlightning object
        jTextPaneDefinition.setDocument(docPane);

        // disable some buttons
        jButtonDeleteContext.setEnabled(false);
        jButtonAddDefinition.setEnabled(false);
        jButtonDeleteDefinition.setEnabled(false);
        jButtonEditDefinition.setEnabled(false);

        // set table state variables to enable row selection
        jTableContexts.setCellSelectionEnabled(false);
        jTableContexts.setRowSelectionAllowed(true);
        jTableContexts.setColumnSelectionAllowed(false);

        UpdateContextTable();
    }
    
    public void CloseContextEditors()
    {
        for ( Entry<String, jDialogEditContextDefinition> e : editors.entrySet() )
            if ( e.getValue() != null )
                e.getValue().dispose();
    }

    public void UpdateContextTable()
    {
        // clear table
        DefaultTableModel model = (DefaultTableModel)jTableContexts.getModel();
        model.setNumRows(0);

        Map<String, CContext> ctxs = thisContext.thePolicy.GetContexts();
        // display context list
        Collection<CContext> values = ctxs.values();
        Iterator<CContext> ic = values.iterator();
        while ( ic.hasNext() )
        {
            CContext c = ic.next();
            String row[] = new String[2];
            row[0] = c.GetName();
            // get context class
            row[1] = c.GetType();
            model.addRow(row);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAddContext = new javax.swing.JButton();
        jButtonDeleteContext = new javax.swing.JButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContexts = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDefinitions = new javax.swing.JTable();
        jButtonAddDefinition = new javax.swing.JButton();
        jButtonDeleteDefinition = new javax.swing.JButton();
        jButtonEditDefinition = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPaneDefinition = new javax.swing.JTextPane();

        setMinimumSize(new java.awt.Dimension(400, 300));
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(newmotorbac.NewMotorbacApp.class).getContext().getResourceMap(PanelContexts.class);
        jButtonAddContext.setText(resourceMap.getString("jButtonAddContext.text")); // NOI18N
        jButtonAddContext.setName("jButtonAddContext"); // NOI18N
        jButtonAddContext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddContextActionPerformed(evt);
            }
        });

        jButtonDeleteContext.setText(resourceMap.getString("jButtonDeleteContext.text")); // NOI18N
        jButtonDeleteContext.setName("jButtonDeleteContext"); // NOI18N
        jButtonDeleteContext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteContextActionPerformed(evt);
            }
        });

        jSplitPane2.setName("jSplitPane2"); // NOI18N

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setName("jSplitPane1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTableContexts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContexts.setName("jTableContexts"); // NOI18N
        jTableContexts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableContexts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContextsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableContexts);
        jTableContexts.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTableContexts.columnModel.title0")); // NOI18N
        jTableContexts.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTableContexts.columnModel.title1")); // NOI18N

        jSplitPane1.setTopComponent(jScrollPane1);

        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTableDefinitions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Definitions"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDefinitions.setName("jTableDefinitions"); // NOI18N
        jTableDefinitions.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableDefinitions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDefinitionsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableDefinitions);
        jTableDefinitions.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTableDefinitions.columnModel.title0")); // NOI18N

        jButtonAddDefinition.setText(resourceMap.getString("jButtonAddDefinition.text")); // NOI18N
        jButtonAddDefinition.setName("jButtonAddDefinition"); // NOI18N
        jButtonAddDefinition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddDefinitionActionPerformed(evt);
            }
        });

        jButtonDeleteDefinition.setText(resourceMap.getString("jButtonDeleteDefinition.text")); // NOI18N
        jButtonDeleteDefinition.setName("jButtonDeleteDefinition"); // NOI18N
        jButtonDeleteDefinition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteDefinitionActionPerformed(evt);
            }
        });

        jButtonEditDefinition.setText(resourceMap.getString("jButtonEditDefinition.text")); // NOI18N
        jButtonEditDefinition.setName("jButtonEditDefinition"); // NOI18N
        jButtonEditDefinition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditDefinitionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAddDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDeleteDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEditDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jButtonDeleteDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jButtonEditDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel1);

        jSplitPane2.setLeftComponent(jSplitPane1);

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jTextPaneDefinition.setEditable(false);
        jTextPaneDefinition.setName("jTextPaneDefinition"); // NOI18N
        jScrollPane3.setViewportView(jTextPaneDefinition);

        jSplitPane2.setRightComponent(jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAddContext, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDeleteContext, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonDeleteContext, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddContext, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableContextsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContextsMouseClicked
        // get selected row
        DefaultTableModel model = (DefaultTableModel)jTableContexts.getModel();
        DefaultTableModel modelDefinition = (DefaultTableModel)jTableDefinitions.getModel();
        Point p = evt.getPoint();
        int row = jTableContexts.rowAtPoint(p);
        selectedCtx = (String)model.getValueAt(row, 0);

        // if the default context is selected, disable the buttons
        jButtonDeleteContext.setEnabled( !selectedCtx.equals(AbstractOrbacPolicy.defaultContext) );
        jButtonAddDefinition.setEnabled( !selectedCtx.equals(AbstractOrbacPolicy.defaultContext) );
        jButtonDeleteDefinition.setEnabled( !selectedCtx.equals(AbstractOrbacPolicy.defaultContext) );
        jButtonEditDefinition.setEnabled( !selectedCtx.equals(AbstractOrbacPolicy.defaultContext) );

        // display definitions for this context
        DisplayContextDefinitions(selectedCtx);
    }//GEN-LAST:event_jTableContextsMouseClicked

    private void DisplayContextDefinitions(String context)
    {
        Map<String, CContext> contexts = thisContext.thePolicy.GetContexts();
        CContext selectedContext = contexts.get(selectedCtx);
        DefaultTableModel modelDefinition = (DefaultTableModel)jTableDefinitions.getModel();
        modelDefinition.setNumRows(0);
        String rowContent[] = new String[2];
        try
        {
            HashMap<String, String> definitions = selectedContext.GetContextDefinitions();

            // if no definition exist, disable some buttons
            if ( selectedCtx.equals(AbstractOrbacPolicy.defaultContext) == false )
            {
                jButtonDeleteDefinition.setEnabled( !definitions.isEmpty() );
                jButtonEditDefinition.setEnabled( !definitions.isEmpty() );
            }

            Set< Entry<String, String> > keys = definitions.entrySet();
            Iterator< Entry<String, String> > it = keys.iterator();
            while ( it.hasNext() )
            {
                Entry<String, String> e = it.next();
                String key = (String)e.getKey();
                rowContent[0] = key;
                modelDefinition.addRow(rowContent);
            }
        }
        catch ( Exception e )
        {
            System.out.println(e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(findActiveFrame(), e.getMessage());
        }
        finally
        {
            // if there is some definitions to display, select the first one in the lower table
            if ( modelDefinition.getRowCount() > 0 )
            {
                jTableDefinitions.setRowSelectionInterval(0, 0);
                // display it
                String org = (String)modelDefinition.getValueAt(0, 0);

                // display definition
                try
                {
                    String def = selectedContext.GetContextDefinition(org);
                    // display definition
                    jTextPaneDefinition.setText(def);
                }
                catch (COrbacException e)
                {
                    System.err.println(e);
                    e.printStackTrace();
                }
            }
        }
    }

    private void jTableDefinitionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDefinitionsMouseClicked
        // get organization name to display its definition in the text area
        if ( selectedCtx == null ) return;
        DefaultTableModel modelDefinition = (DefaultTableModel)jTableDefinitions.getModel();
        Point p = evt.getPoint();
        int row = jTableDefinitions.rowAtPoint(p);
        String org = (String)modelDefinition.getValueAt(row, 0);

        // get definition and display it
        Map<String, CContext> contexts = thisContext.thePolicy.GetContexts();
        CContext selectedContext = contexts.get(selectedCtx);
        try
        {
            String def = selectedContext.GetContextDefinition(org);
            // display definition
            jTextPaneDefinition.setText(def);
        }
        catch (COrbacException e)
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTableDefinitionsMouseClicked

    private void jButtonAddDefinitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddDefinitionActionPerformed
        // check if an organization is selected
        if ( thisContext.currentOrganization == null )
            JOptionPane.showMessageDialog(this, "No organization selected, please select the organization in the organization tree "
                                              + "in which you want to add a context definition");
        else
        {
            // first check if an editor is already open
            jDialogEditContextDefinition editor = editors.get(selectedCtx + thisContext.currentOrganization);
            if ( editor == null )
            {
                // if not display dialog box
                jDialogEditContextDefinition createDef = new jDialogEditContextDefinition(findActiveFrame(), false, "", selectedCtx, thisContext.currentOrganization, thisContext.thePolicy, this);
                createDef.setLocationRelativeTo(findActiveFrame());
                NewMotorbacApp.getApplication().show(createDef);
                // store editor in map
                editors.put(selectedCtx + thisContext.currentOrganization, createDef);
            }
            else editor.toFront();
        }
    }//GEN-LAST:event_jButtonAddDefinitionActionPerformed

    private void jButtonDeleteDefinitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteDefinitionActionPerformed
        try
    	{
            // get selected context
            int rowCtx = jTableContexts.getSelectedRow();
            int rowDef = jTableDefinitions.getSelectedRow();
            if ( rowDef == -1 && rowCtx == -1 ) return;
            String ctx = (String)jTableContexts.getModel().getValueAt(rowCtx, 0);
            String org = (String)jTableDefinitions.getModel().getValueAt(rowDef, 0);
            // delete selected context
            thisContext.thePolicy.DeleteContextDefinition(ctx, org);

            // refresh context display
            UpdateContextTable();
            // push policy on undo/redo stack
            thisContext.panelPolicy.PushPolicy();
            
            // reselect the previously selected context
            jTableContexts.getSelectionModel().setSelectionInterval(rowCtx, rowCtx);
            
            // display definitions for this context
            DisplayContextDefinitions(selectedCtx);
    	}
        catch (COrbacException e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(this, e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonDeleteDefinitionActionPerformed

    private void jButtonEditDefinitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditDefinitionActionPerformed
        // retrieve definition organization
        int rowIndex = jTableDefinitions.getSelectedRow();
        String org = (String)jTableDefinitions.getValueAt(rowIndex, 0);
        // first check if an editor is already open
        jDialogEditContextDefinition editor = editors.get(selectedCtx + org);
        if ( editor == null )
        {
            // if not display dialog box
            jDialogEditContextDefinition createDef = new jDialogEditContextDefinition(findActiveFrame(), false, jTextPaneDefinition.getText(), selectedCtx, org, thisContext.thePolicy, this);
            createDef.setLocationRelativeTo(findActiveFrame());
            NewMotorbacApp.getApplication().show(createDef);
            // store editor in map
            editors.put(selectedCtx + org, createDef);
        }
        else editor.toFront();
    }//GEN-LAST:event_jButtonEditDefinitionActionPerformed

    private void jButtonAddContextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddContextActionPerformed
        // retrieve supported context types
        List<String> ctxTypes = thisContext.thePolicy.GetContextManager().GetSupportedContextTypes();
        // remove default context type
        ctxTypes.remove("DefaultContext");
    	// ask context name
        jDialogAddContext createCtx = new jDialogAddContext(findActiveFrame(), true, ctxTypes);
        createCtx.setLocationRelativeTo(findActiveFrame());
        NewMotorbacApp.getApplication().show(createCtx);
        if ( createCtx.canceled == true ) return;
        try
        {
            // create context
            thisContext.thePolicy.CreateContext(createCtx.GetContextName(), createCtx.GetContextType());

            // push policy on undo/redo stack
            thisContext.panelPolicy.PushPolicy();
            // update context table
            UpdateContextTable();
        }
        catch ( COrbacException e )
        {
            System.out.println(e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(findActiveFrame(), e.getMessage());
        }
    }//GEN-LAST:event_jButtonAddContextActionPerformed

    private void jButtonDeleteContextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteContextActionPerformed
        
        // warn user
        int n = JOptionPane.showConfirmDialog(findActiveFrame(), "Deleting context " + selectedCtx + " will destroy all its context definitions. Confirm deletion?",
                                              "Delete context", JOptionPane.YES_NO_OPTION);
        try
        {
            if ( n == JOptionPane.YES_OPTION )
            {
                thisContext.thePolicy.DeleteContext(selectedCtx);

                // push policy on undo/redo stack
                thisContext.panelPolicy.PushPolicy();
                // update context table
                UpdateContextTable();
            }
        }
        catch ( COrbacException e )
        {
            System.out.println(e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(findActiveFrame(), e.getMessage());
        }
    }//GEN-LAST:event_jButtonDeleteContextActionPerformed

    public void ContextDefinitionEditorClosing(String context, String org)
    {
        // remove dialog instance from the map
        editors.remove(context + org);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddContext;
    private javax.swing.JButton jButtonAddDefinition;
    private javax.swing.JButton jButtonDeleteContext;
    private javax.swing.JButton jButtonDeleteDefinition;
    private javax.swing.JButton jButtonEditDefinition;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTable jTableContexts;
    private javax.swing.JTable jTableDefinitions;
    private javax.swing.JTextPane jTextPaneDefinition;
    // End of variables declaration//GEN-END:variables
    
    // helper function to find a frame object to display a dialog box for example
    private Frame findActiveFrame()
    {
        Frame[] frames = JFrame.getFrames();
        for (int i = 0; i < frames.length; i++)
        {
            Frame frame = frames[i];
            if (frame.isVisible())
            {
                return frame;
            }
        }
        return null;
    }
}

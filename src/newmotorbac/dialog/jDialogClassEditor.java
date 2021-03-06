/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jDialogClassEditor.java
 *
 * Created on Jun 10, 2011, 3:01:29 PM
 */

package newmotorbac.dialog;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import newmotorbac.NewMotorbacApp;
import newmotorbac.util.OrbacPolicyContext;
import orbac.exception.COrbacException;

/**
 *
 * @author fabien
 */
public class jDialogClassEditor extends javax.swing.JDialog {
    // policy context
    private OrbacPolicyContext thisContext;
    // text zone
    private JTextPane classesInfos = new JTextPane();
    // table model
    private MyTableModel tableModel = new MyTableModel();
    // currently selected class in the tree
    private String selectedClass;

    /** Creates new form jDialogClassEditor */
    public jDialogClassEditor(java.awt.Frame parent, boolean modal, OrbacPolicyContext thisContext) {
        super(parent, modal);
        initComponents();

        // set title
        setTitle("Class editor for policy \"" + thisContext.thePolicy.GetName() + "\"");

        // store policy context
        this.thisContext = thisContext;

        // set table model and renderer
        jTableClassAttributes.setModel(tableModel);
        jTableClassAttributes.setDefaultRenderer(Object.class, new ClassMemberCellRenderer());

        // display the class hierarchy for the current policy
        DisplayClassHierarchy();
        // no class selected at startup
        jButtonDelete.setEnabled(false);
        jButtonEdit.setEnabled(false);
        jButtonDeleteMember.setEnabled(false);
        jButtonAddMember.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jSplitPane = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeClasses = new javax.swing.JTree();
        jPanelAttributes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableClassAttributes = new javax.swing.JTable();
        jButtonAddMember = new javax.swing.JButton();
        jButtonDeleteMember = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 300));
        setName("pouet"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(newmotorbac.NewMotorbacApp.class).getContext().getResourceMap(jDialogClassEditor.class);
        jButtonAdd.setText(resourceMap.getString("jButtonAdd.text")); // NOI18N
        jButtonAdd.setName("jButtonAdd"); // NOI18N
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonDelete.setText(resourceMap.getString("jButtonDelete.text")); // NOI18N
        jButtonDelete.setName("jButtonDelete"); // NOI18N
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonEdit.setText(resourceMap.getString("jButtonEdit.text")); // NOI18N
        jButtonEdit.setName("jButtonEdit"); // NOI18N
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jSplitPane.setName("jSplitPane"); // NOI18N

        jScrollPane1.setMinimumSize(new java.awt.Dimension(220, 24));
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTreeClasses.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jTreeClasses.border.title"))); // NOI18N
        jTreeClasses.setName("jTreeClasses"); // NOI18N
        jTreeClasses.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeClassesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTreeClasses);

        jSplitPane.setLeftComponent(jScrollPane1);

        jPanelAttributes.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanelAttributes.border.title"))); // NOI18N
        jPanelAttributes.setName("jPanelAttributes"); // NOI18N

        jScrollPane2.setBorder(null);
        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTableClassAttributes.setBorder(null);
        jTableClassAttributes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "default value"
            }
        ));
        jTableClassAttributes.setName("jTableClassAttributes"); // NOI18N
        jTableClassAttributes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClassAttributesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableClassAttributes);
        jTableClassAttributes.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableClassAttributes.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTableClassAttributes.columnModel.title0")); // NOI18N
        jTableClassAttributes.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTableClassAttributes.columnModel.title1")); // NOI18N

        jButtonAddMember.setText(resourceMap.getString("jButtonAddMember.text")); // NOI18N
        jButtonAddMember.setName("jButtonAddMember"); // NOI18N
        jButtonAddMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddMemberActionPerformed(evt);
            }
        });

        jButtonDeleteMember.setText(resourceMap.getString("jButtonDeleteMember.text")); // NOI18N
        jButtonDeleteMember.setName("jButtonDeleteMember"); // NOI18N
        jButtonDeleteMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteMemberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAttributesLayout = new javax.swing.GroupLayout(jPanelAttributes);
        jPanelAttributes.setLayout(jPanelAttributesLayout);
        jPanelAttributesLayout.setHorizontalGroup(
            jPanelAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAttributesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addGroup(jPanelAttributesLayout.createSequentialGroup()
                        .addComponent(jButtonAddMember)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteMember)))
                .addContainerGap())
        );
        jPanelAttributesLayout.setVerticalGroup(
            jPanelAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAttributesLayout.createSequentialGroup()
                .addGroup(jPanelAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddMember)
                    .addComponent(jButtonDeleteMember))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane.setRightComponent(jPanelAttributes);

        jButtonClose.setText(resourceMap.getString("jButtonClose.text")); // NOI18N
        jButtonClose.setName("jButtonClose"); // NOI18N
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 403, Short.MAX_VALUE)
                        .addComponent(jButtonClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonClose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DisplayClassHierarchy()
    {
        try
        {
            DefaultMutableTreeNode rootOrg = new DefaultMutableTreeNode("All classes");
            thisContext.thePolicy.GetConcreteClassHierarchy(rootOrg, !thisContext.adorbacViewActive);
            jTreeClasses.setModel(new DefaultTreeModel(rootOrg));
        }
        catch ( COrbacException e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
    private void jTreeClassesValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeClassesValueChanged
        // fill table with the selected class attributes
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)jTreeClasses.getLastSelectedPathComponent();
        if ( node == null ) return;
        try
        {
            if ( node == jTreeClasses.getModel().getRoot() )
            {
                // show information about classes in the right part of the split pane
                jSplitPane.setBottomComponent(new JScrollPane(classesInfos,
                                                              JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                              JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
                classesInfos.setText("Please select a class in the class hierarchy to display its members.\n"
                                   + "Total number of classes for the current policy: " + thisContext.thePolicy.GetConcreteClassesList().size());

                jButtonDelete.setEnabled(false);
                jButtonEdit.setEnabled(false);
                jButtonDeleteMember.setEnabled(false);
                jButtonAddMember.setEnabled(false);
            }
            else
            {
                // display table
                jSplitPane.setBottomComponent(jPanelAttributes);
                // display selected class attributes and default values
                selectedClass = node.getUserObject().toString();
                Map<String, String> classAttributes = thisContext.thePolicy.GetConcreteClassMembers(selectedClass);
                tableModel.SetData(classAttributes);

                jButtonDelete.setEnabled(true);
                jButtonEdit.setEnabled(true);
                jButtonDeleteMember.setEnabled(false);
                jButtonAddMember.setEnabled(true);
            }
            jTreeClasses.invalidate();
        }
        catch ( COrbacException e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTreeClassesValueChanged

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        try
        {
            // get orbac classes
            Set<String> classes = thisContext.thePolicy.GetConcreteClassesList();
            // get selected class super classes
            Set<String> entityClasses = thisContext.thePolicy.GetConcreteSuperClasses(selectedClass);

            // get new entity name and the classes it instanciates
            JFrame mainFrame = NewMotorbacApp.getApplication().getMainFrame();
            jDialogAddClass dialogBox = new jDialogAddClass(mainFrame, selectedClass, classes, entityClasses, true);
            dialogBox.setLocationRelativeTo(mainFrame);
            NewMotorbacApp.getApplication().show(dialogBox);

            // create entity if requested
            if ( dialogBox.canceled == false )
            {
                String className = dialogBox.GetClassName();
                // rename class if necessary
                if ( selectedClass.equals(className) == false )
                {
                    thisContext.thePolicy.RenameConcreteClass(selectedClass, className);
                    selectedClass = className;
                }

                Set<String> selectedClasses = dialogBox.GetSuperClasses();
                // set super classes
                thisContext.thePolicy.DeleteConcreteClassSuperClasses(selectedClass);
                thisContext.thePolicy.AddConcreteClassSuperClasses(className, selectedClasses);

                DisplayClassHierarchy();
            }
        }
        catch ( COrbacException e )
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        try
        {
            // get orbac classes
            Set<String> classes = thisContext.thePolicy.GetConcreteClassesList();

            // get new entity name and the classes it instanciates
            JFrame mainFrame = NewMotorbacApp.getApplication().getMainFrame();
            jDialogAddClass dialogBox = new jDialogAddClass(mainFrame, classes, true);
            dialogBox.setLocationRelativeTo(mainFrame);
            NewMotorbacApp.getApplication().show(dialogBox);

            // create entity if requested
            if ( dialogBox.canceled == false )
            {
                String className = dialogBox.GetClassName();
                thisContext.thePolicy.CreateConcreteClass(className, dialogBox.GetSuperClasses());

                DisplayClassHierarchy();
            }
        }
        catch ( COrbacException e )
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        try
        {
            thisContext.thePolicy.DeleteConcreteClass(selectedClass);
            DisplayClassHierarchy();
        }
        catch ( COrbacException e )
        {
            System.out.println(e);
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        dispose();
        thisContext.panelPolicy.ClassEditorClosing();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonAddMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddMemberActionPerformed
        try
        {
            JFrame mainFrame = NewMotorbacApp.getApplication().getMainFrame();
            jDialogNewClassAttribute dialogBox = new jDialogNewClassAttribute(mainFrame, true);
            dialogBox.setLocationRelativeTo(mainFrame);
            NewMotorbacApp.getApplication().show(dialogBox);

            // create entity if requested
            if ( dialogBox.canceled == false )
            {
                String attributeName = dialogBox.GetAttributeName();
                String attributeValue = dialogBox.GetAttributeDefaultValue();
                thisContext.thePolicy.AddConcreteClassMember(selectedClass, attributeName, attributeValue);

                DisplayClassHierarchy();
            }
        }
        catch ( COrbacException e )
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonAddMemberActionPerformed

    private void jButtonDeleteMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteMemberActionPerformed
        try
        {
            // get selected member
            int row = jTableClassAttributes.getSelectedRow();
            if ( row == -1 ) return;

            String memberName = (String)jTableClassAttributes.getValueAt(row, 0);

            thisContext.thePolicy.DeleteConcreteClassMember(selectedClass, memberName);
        }
        catch ( COrbacException e )
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonDeleteMemberActionPerformed

    private void jTableClassAttributesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClassAttributesMouseClicked
        // get rule parameters and delete it
        int row = jTableClassAttributes.getSelectedRow();
        if ( row == -1 ) return;

        // an attribute is selected, enable the delete button
        jButtonDeleteMember.setEnabled(true);
    }//GEN-LAST:event_jTableClassAttributesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAddMember;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonDeleteMember;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JPanel jPanelAttributes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTable jTableClassAttributes;
    private javax.swing.JTree jTreeClasses;
    // End of variables declaration//GEN-END:variables

    // implement custom table model for class attributes edition
    class MyTableModel extends AbstractTableModel
    {
        private static final long serialVersionUID = 1L;

        // columns and data
        private String[] columnNames = {"Attribute", "Default value"};
        private String[] attributesNames = new String[0];
        private String[] attributesValues = new String[0];

        public void SetData(Map<String, String> dataMap)
        {
            // allocate memory
            attributesNames = new String[dataMap.size()];
            attributesValues = new String[dataMap.size()];
            // copy content
            Set< Entry<String, String> > es = dataMap.entrySet();
            Iterator< Entry<String, String> > ies = es.iterator();
            int i = 0;
            while ( ies.hasNext() )
            {
                Entry<String, String> e = ies.next();
                attributesNames[i] = e.getKey();
                attributesValues[i] = e.getValue();
                i++;
            }
            fireTableDataChanged();
        }
        public void clear()
        {
            HashMap<String, String> dummyMap = new HashMap<String, String>();
            SetData(dummyMap);
        }

        @Override
        public int getColumnCount()
        {
            return 2;
        }

        @Override
        public int getRowCount()
        {
            return attributesValues.length;
        }

        public boolean isCellEditable(int row, int col)
        {
            // inherited attributes names cannot be edited, otherwise everything is editable
            return true;
        }

        @Override
        public Object getValueAt(int arg0, int arg1)
        {
            if ( arg1 == 0 )
            {
                // attribute name
                return attributesNames[arg0];
            }
            else
            {
                // attribute value
                return attributesValues[arg0];
            }
        }
        public String getColumnName(int col)
        {
            return columnNames[col];
        }

        public void setValueAt(Object value, int row, int col)
        {
            if ( col == 0 )
            {
                // attribute name
            }
            else
            {
                // attribute value
                attributesValues[row] = (String)value;
                // reflect change in policy
                try
                {
                    thisContext.thePolicy.SetConcreteClassDefaultMemberValue(selectedClass, attributesNames[row], attributesValues[row]);
                }
                catch (COrbacException e)
                {
                    e.printStackTrace();
                }
            }
            fireTableCellUpdated(row, col);
        }
    }

    public class ClassMemberCellRenderer extends DefaultTableCellRenderer
    {
    	// just to remove the warning
    	static final long serialVersionUID = 0;

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            Color cellInherited = new Color(1.0f, 0.7f, 0.7f);
            Color cellMember = new Color(0.7f, 1.0f, 1.0f);

            // if we are displaying an inherited member, then change background color
            try
            {
                Map<String, String> membersOnly = thisContext.thePolicy.GetConcreteClassMembersOnly(selectedClass);
                String memberName = (String)table.getValueAt(row, 0);
                if ( membersOnly.containsKey(memberName) )
                    cell.setBackground(cellMember);
                else cell.setBackground(cellInherited);
            }
            catch (COrbacException e)
            {
                e.printStackTrace();
            }

            return cell;
        }
    }
}

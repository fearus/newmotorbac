/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jDialogContextDefinition.java
 *
 * Created on May 27, 2011, 11:59:29 AM
 */

package newmotorbac.dialog;

import com.Ostermiller.Syntax.HighlightedDocument;
import javax.swing.JOptionPane;
import newmotorbac.PanelEntityDefinitions;
import orbac.AbstractOrbacPolicy;
import orbac.abstractEntities.CEntityDefinition;
import orbac.exception.COrbacException;

/**
 *
 * @author fabien
 */
public class jDialogEditEntityDefinition extends javax.swing.JDialog {

    public boolean canceled = false;
    // syntax highlighter
    private HighlightedDocument docPane = new HighlightedDocument();
    // edited entity definition
    private String entityDefinitionName;
    // edited definition when dialogbox was created
    private String initialDefinition;
    // organization in which edition is made
    private String organization;
    // associated policy
    private AbstractOrbacPolicy policy;
    // parent entity definition interface
    private PanelEntityDefinitions entityDefGui;

    /** Creates new form jDialogEntityDefinition */
    public jDialogEditEntityDefinition(java.awt.Frame parent, boolean modal, String definition,
                                                                         String entityDefinitionName,
                                                                         String organization,
                                                                         AbstractOrbacPolicy policy,
                                                                         PanelEntityDefinitions entityDefGui) {
        super(parent, modal);
        initComponents();

        // save given variables
        this.policy = policy;
        this.organization = organization;
        this.entityDefinitionName = entityDefinitionName;
        this.entityDefGui = entityDefGui;

        // set title
        setTitle("Editing definition for entity definition \"" + entityDefinitionName + "\" in organization " + organization);

        // set syntax highlightning object
        jTextPaneDefinition.setDocument(docPane);
        // display definition
        jTextPaneDefinition.setText(definition);
        initialDefinition = definition;

        jComboBoxEntityType.setSelectedIndex(0);
    }

    public String GetDefinition()
    {
        return jTextPaneDefinition.getText();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContextDefinition = new javax.swing.JPanel();
        jButtonOk = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonSetDefinition = new javax.swing.JButton();
        jButtonCheckSyntax = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneDefinition = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxEntityType = new javax.swing.JComboBox();
        jComboBoxEntities = new javax.swing.JComboBox();
        jButtonTest = new javax.swing.JButton();
        jLabelTestResult = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(newmotorbac.NewMotorbacApp.class).getContext().getResourceMap(jDialogEditEntityDefinition.class);
        jPanelContextDefinition.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanelContextDefinition.border.title"))); // NOI18N
        jPanelContextDefinition.setName("jPanelContextDefinition"); // NOI18N

        jButtonOk.setText(resourceMap.getString("jButtonOk.text")); // NOI18N
        jButtonOk.setName("jButtonOk"); // NOI18N
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancel.setText(resourceMap.getString("jButtonCancel.text")); // NOI18N
        jButtonCancel.setName("jButtonCancel"); // NOI18N
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonSetDefinition.setText(resourceMap.getString("jButtonSetDefinition.text")); // NOI18N
        jButtonSetDefinition.setName("jButtonSetDefinition"); // NOI18N
        jButtonSetDefinition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetDefinitionActionPerformed(evt);
            }
        });

        jButtonCheckSyntax.setText(resourceMap.getString("jButtonCheckSyntax.text")); // NOI18N
        jButtonCheckSyntax.setName("jButtonCheckSyntax"); // NOI18N
        jButtonCheckSyntax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckSyntaxActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextPaneDefinition.setName("jTextPaneDefinition"); // NOI18N
        jScrollPane1.setViewportView(jTextPaneDefinition);

        javax.swing.GroupLayout jPanelContextDefinitionLayout = new javax.swing.GroupLayout(jPanelContextDefinition);
        jPanelContextDefinition.setLayout(jPanelContextDefinitionLayout);
        jPanelContextDefinitionLayout.setHorizontalGroup(
            jPanelContextDefinitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContextDefinitionLayout.createSequentialGroup()
                .addGroup(jPanelContextDefinitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContextDefinitionLayout.createSequentialGroup()
                        .addComponent(jButtonOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSetDefinition)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCheckSyntax))
                    .addGroup(jPanelContextDefinitionLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelContextDefinitionLayout.setVerticalGroup(
            jPanelContextDefinitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContextDefinitionLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContextDefinitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonSetDefinition)
                    .addComponent(jButtonCheckSyntax)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jComboBoxEntityType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "subject", "action", "object" }));
        jComboBoxEntityType.setName("jComboBoxEntityType"); // NOI18N
        jComboBoxEntityType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEntityTypeItemStateChanged(evt);
            }
        });

        jComboBoxEntities.setName("jComboBoxEntities"); // NOI18N

        jButtonTest.setText(resourceMap.getString("jButtonTest.text")); // NOI18N
        jButtonTest.setName("jButtonTest"); // NOI18N
        jButtonTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTestActionPerformed(evt);
            }
        });

        jLabelTestResult.setText(resourceMap.getString("jLabelTestResult.text")); // NOI18N
        jLabelTestResult.setName("jLabelTestResult"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jComboBoxEntityType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxEntities, 0, 161, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTestResult)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jComboBoxEntities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBoxEntityType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2)
                .addComponent(jButtonTest)
                .addComponent(jLabelTestResult))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelContextDefinition, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelContextDefinition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        // set context definition and close dialog
        try
        {
            // get entity definition to check syntax
            CEntityDefinition ed = policy.GetEntityDefinition(entityDefinitionName);
            if ( ed.CheckDefinitionSyntax(jTextPaneDefinition.getText()) == false )
            {
                String choices[]={ "Do not set definition and close", "Return to editor"};
                int ret = JOptionPane.showOptionDialog(this,
                                                       "Entity definition syntax is incorrect",
                                                       "Confirm entity definition",
                                                       JOptionPane.YES_NO_CANCEL_OPTION,
                                                       JOptionPane.QUESTION_MESSAGE,
                                                       null,
                                                       choices,
                                                       choices[0]);// default button
                switch ( ret )
                {
                    case 0:
                        // Do not set definition and close
                        canceled = true;
                        this.dispose();
                        // do not forget to notify the parent gui that the dialog box is closing
                        entityDefGui.EntityDefinitionEditorClosing(entityDefinitionName, organization);
                        break;
                    case 1:
                        // Return to editor
                        break;
                }
            }
            else
            {
                // Set definition and close, no exception should be thrown since we checked the syntax
                try {
                    ed.SetDefinition(organization, jTextPaneDefinition.getText());
                }
                catch ( Exception e ) {}
                canceled = false;
                this.dispose();
                // do not forget to notify the parent gui that the dialog box is closing
                entityDefGui.EntityDefinitionEditorClosing(entityDefinitionName, organization);
            }
        }
        catch (COrbacException e)
        {
                String choices[]={ "Do not set definition and close", "Return to editor"};
                int ret = JOptionPane.showOptionDialog(this,
                                                       "Entity definition syntax is incorrect: " + e,
                                                       "Confirm entity definition",
                                                       JOptionPane.YES_NO_CANCEL_OPTION,
                                                       JOptionPane.QUESTION_MESSAGE,
                                                       null,
                                                       choices,
                                                       choices[0]);// default button
                switch ( ret )
                {
                    case 0:
                        // Do not set definition and close
                        canceled = true;
                        this.dispose();
                        // do not forget to notify the parent gui that the dialog box is closing
                        entityDefGui.EntityDefinitionEditorClosing(entityDefinitionName, organization);
                        break;
                    case 1:
                        // Return to editor
                        break;
                }
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // close without setting the definition, but first check if it has been modified
        if ( initialDefinition.equals(jTextPaneDefinition.getText()) == false )
        {
            // warn user
            int n = JOptionPane.showConfirmDialog(this, "Close entity definition editor without saving the definition?",
                                                  "Cancel entity definition edition", JOptionPane.YES_NO_OPTION);
            if ( n == JOptionPane.YES_OPTION )
            {
                dispose();
                // do not forget to notify the parent gui that the dialog box is closing
                entityDefGui.EntityDefinitionEditorClosing(entityDefinitionName, organization);
            }
        }
        dispose();
        // do not forget to notify the parent gui that the dialog box is closing
        entityDefGui.EntityDefinitionEditorClosing(entityDefinitionName, organization);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonSetDefinitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetDefinitionActionPerformed
        // set context definition
        try
        {
            // create definition
            policy.SetEntityDefDefinition(entityDefinitionName, organization, jTextPaneDefinition.getText());
        }
        catch ( Exception e )
        {
            System.out.println(e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonSetDefinitionActionPerformed

    private void jButtonCheckSyntaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckSyntaxActionPerformed
        // ask the orbac api if definition is ok
        try
        {
            CEntityDefinition ed = policy.GetEntityDefinition(entityDefinitionName);
            if ( ed.CheckDefinitionSyntax( jTextPaneDefinition.getText() ) == false )
                JOptionPane.showMessageDialog(this, "Invalid syntax");
            else
                JOptionPane.showMessageDialog(this, "Entity definition syntax is correct");
        }
        catch (COrbacException e)
        {
            JOptionPane.showMessageDialog(this, "Invalid syntax: " + e);
        }
    }//GEN-LAST:event_jButtonCheckSyntaxActionPerformed

    private void jButtonTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTestActionPerformed
        // test context on the selected concrete entities and report the result
        String entity = (String)jComboBoxEntities.getSelectedItem();
        try
        {
            CEntityDefinition ed = policy.GetEntityDefinition(entityDefinitionName);
            boolean res = ed.CheckConcreteEntity(organization, entity);
            jLabelTestResult.setText(res ? "result: true" : "result: false");
        }
        catch ( Exception e )
        {
            jLabelTestResult.setText("result: error");
            JOptionPane.showMessageDialog(this, "Error while evaluating entity definition: " + e);
        }
    }//GEN-LAST:event_jButtonTestActionPerformed

    private void jComboBoxEntityTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEntityTypeItemStateChanged
        // fill entity combo box depending on selected entity type
        jComboBoxEntities.removeAllItems();
        try
        {
            switch ( jComboBoxEntityType.getSelectedIndex() )
            {
                case 0:// subjects
                    for ( String s : policy.GetSubjects() )
                        jComboBoxEntities.addItem(s);
                    break;
                case 1:// actions
                    for ( String s : policy.GetActions() )
                        jComboBoxEntities.addItem(s);
                    break;
                case 2:// objects
                    for ( String s : policy.GetObjects() )
                        jComboBoxEntities.addItem(s);
                    break;
            }
        }
        catch ( COrbacException e )
        {
            System.out.println(e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jComboBoxEntityTypeItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonCheckSyntax;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonSetDefinition;
    private javax.swing.JButton jButtonTest;
    private javax.swing.JComboBox jComboBoxEntities;
    private javax.swing.JComboBox jComboBoxEntityType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTestResult;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContextDefinition;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPaneDefinition;
    // End of variables declaration//GEN-END:variables

}

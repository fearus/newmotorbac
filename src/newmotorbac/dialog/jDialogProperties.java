/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jDialogProperties.java
 *
 * Created on 6 sept. 2011, 10:18:56
 */

package newmotorbac.dialog;

import newmotorbac.util.OrbacPolicyContext;
import orbac.exception.COrbacException;

/**
 *
 * @author fabien
 */
public class jDialogProperties extends javax.swing.JDialog {
    // policy context
    OrbacPolicyContext thisContext;

    public boolean canceled = false;

    /** Creates new form jDialogProperties */
    public jDialogProperties(java.awt.Frame parent, boolean modal, OrbacPolicyContext thisContext) {
        super(parent, modal);
        initComponents();

        this.thisContext = thisContext;

        // set title
        setTitle("Policy properties");

        // display properties
        jLabelPolicyName.setText(thisContext.thePolicy.GetName());
        jLabelCreationDate.setText(thisContext.thePolicy.GetCreationDate().toString());
        jLabelModificationDate.setText(thisContext.thePolicy.GetModificationDate().toString());
        jTextFieldVersion.setText(String.valueOf(thisContext.thePolicy.GetVersion()));
        jTextAreaComments.setText(thisContext.thePolicy.GetInformation());

        try
        {
            // compute statistics
            String stats = "";
            stats += "number of organizations: " + thisContext.thePolicy.GetOrganizationsList(false).size() + "\n";
            stats += "number of roles: " + thisContext.thePolicy.GetRolesList(false).size() + "\n";
            stats += "number of activities: " + thisContext.thePolicy.GetActivitiesList(false).size() + "\n";
            stats += "number of views: " + thisContext.thePolicy.GetViewsList(false).size() + "\n";
            stats += "number of permissions: " + thisContext.thePolicy.GetAbstractPermissions().size() + "\n";
            stats += "number of prohibitions: " + thisContext.thePolicy.GetAbstractProhibitions().size() + "\n";
            stats += "number of obligations: " + thisContext.thePolicy.GetAbstractObligations().size() + "\n";
            stats += "number of contexts: " + thisContext.thePolicy.GetContexts().size() + "\n";
            stats += "number of role definitions: " + thisContext.thePolicy.GetRoleDefinitionsVector().size() + "\n";
            stats += "number of activity definitions: " + thisContext.thePolicy.GetActivityDefinitionsVector().size() + "\n";
            stats += "number of view definitions: " + thisContext.thePolicy.GetViewDefinitionsVector().size() + "\n";
            jTextAreaInfo.setText(stats);
        }
        catch ( COrbacException e )
        {
            System.out.println(e);
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

        jLabelPolicyName = new javax.swing.JLabel();
        jLabelCreationDate = new javax.swing.JLabel();
        jLabelModificationDate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldVersion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaComments = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaInfo = new javax.swing.JTextArea();
        jButtonCancel = new javax.swing.JButton();
        jButtonOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 450));
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(newmotorbac.NewMotorbacApp.class).getContext().getResourceMap(jDialogProperties.class);
        jLabelPolicyName.setText(resourceMap.getString("jLabelPolicyName.text")); // NOI18N
        jLabelPolicyName.setName("jLabelPolicyName"); // NOI18N

        jLabelCreationDate.setText(resourceMap.getString("jLabelCreationDate.text")); // NOI18N
        jLabelCreationDate.setName("jLabelCreationDate"); // NOI18N

        jLabelModificationDate.setText(resourceMap.getString("jLabelModificationDate.text")); // NOI18N
        jLabelModificationDate.setName("jLabelModificationDate"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jTextFieldVersion.setText(resourceMap.getString("jTextFieldVersion.text")); // NOI18N
        jTextFieldVersion.setName("jTextFieldVersion"); // NOI18N

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jScrollPane1.border.title"))); // NOI18N
        jScrollPane1.setMinimumSize(new java.awt.Dimension(36, 100));
        jScrollPane1.setName("jScrollPane1"); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(50, 119));

        jTextAreaComments.setColumns(20);
        jTextAreaComments.setLineWrap(true);
        jTextAreaComments.setRows(5);
        jTextAreaComments.setMinimumSize(new java.awt.Dimension(50, 40));
        jTextAreaComments.setName("jTextAreaComments"); // NOI18N
        jScrollPane1.setViewportView(jTextAreaComments);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(50, 98));

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTextAreaInfo.setColumns(20);
        jTextAreaInfo.setEditable(false);
        jTextAreaInfo.setLineWrap(true);
        jTextAreaInfo.setRows(1);
        jTextAreaInfo.setMinimumSize(new java.awt.Dimension(0, 0));
        jTextAreaInfo.setName("jTextAreaInfo"); // NOI18N
        jScrollPane2.setViewportView(jTextAreaInfo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonCancel.setText(resourceMap.getString("jButtonCancel.text")); // NOI18N
        jButtonCancel.setName("jButtonCancel"); // NOI18N
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonOk.setText(resourceMap.getString("jButtonOk.text")); // NOI18N
        jButtonOk.setName("jButtonOk"); // NOI18N
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPolicyName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCreationDate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelModificationDate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(115, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPolicyName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCreationDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelModificationDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonOk))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        canceled = true;
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        canceled = false;
        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    public boolean HasBeenCancelled()
    {
        return canceled;
    }

    public float GetVersion()
    {
        return Float.parseFloat( jTextFieldVersion.getText() );
    }
    public String GetInformation()
    {
        return jTextAreaComments.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCreationDate;
    private javax.swing.JLabel jLabelModificationDate;
    private javax.swing.JLabel jLabelPolicyName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaComments;
    private javax.swing.JTextArea jTextAreaInfo;
    private javax.swing.JTextField jTextFieldVersion;
    // End of variables declaration//GEN-END:variables

}

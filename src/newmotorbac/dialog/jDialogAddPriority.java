/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDialogAddPriority.java
 *
 * Created on Jun 1, 2011, 4:43:35 PM
 */

package newmotorbac.dialog;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;
import orbac.AbstractOrbacPolicy;
import orbac.exception.COrbacException;
import orbac.securityRules.CAbstractRule;

/**
 *
 * @author fabien
 */
public class jDialogAddPriority extends javax.swing.JDialog {

    public boolean canceled = false;
    // associated policy
    private AbstractOrbacPolicy policy;
    
    /** Creates new form JDialogAddPriority */
    public jDialogAddPriority(java.awt.Frame parent, boolean modal, AbstractOrbacPolicy policy) {
        super(parent, modal);
        initComponents();

        this.policy = policy;
        
        try
        {
            Vector<String> rules = new Vector<String>();
            HashSet<CAbstractRule> r = null;
            Iterator<CAbstractRule> icr = null;
            r = policy.GetAbstractPermissions();
            icr = r.iterator();
            while ( icr.hasNext() )
                rules.add( icr.next().GetName() );
            r = policy.GetAbstractProhibitions();
            icr = r.iterator();
            while ( icr.hasNext() )
                rules.add( icr.next().GetName() );
            r = policy.GetAbstractObligations();
            icr = r.iterator();
            while ( icr.hasNext() )
            rules.add( icr.next().GetName() );

            // fill rules combo boxes
            for ( String rule : rules )
            {
                jComboBoxRule1.addItem(rule);
                jComboBoxRule2.addItem(rule);
            }

            // set selected rules
            jComboBoxRule1.setSelectedItem(rules.elementAt(0));
            jComboBoxRule2.setSelectedItem(rules.elementAt(1));
        }
        catch ( COrbacException e )
        {
            System.out.println(e);
            e.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jComboBoxRule1 = new javax.swing.JComboBox();
        jComboBoxRule2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxOrg1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxOrg2 = new javax.swing.JComboBox();
        jButtonCancel = new javax.swing.JButton();
        jButtonOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(689, 164));
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(newmotorbac.NewMotorbacApp.class).getContext().getResourceMap(jDialogAddPriority.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jComboBoxRule1.setName("jComboBoxRule1"); // NOI18N
        jComboBoxRule1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxRule1ItemStateChanged(evt);
            }
        });

        jComboBoxRule2.setName("jComboBoxRule2"); // NOI18N
        jComboBoxRule2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxRule2ItemStateChanged(evt);
            }
        });

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jComboBoxOrg1.setName("jComboBoxOrg1"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jComboBoxOrg2.setName("jComboBoxOrg2"); // NOI18N

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxRule2, 0, 205, Short.MAX_VALUE)
                            .addComponent(jComboBoxRule1, 0, 205, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxOrg1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxOrg2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxRule1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOrg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRule2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxOrg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonOk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        // check if the user has selected the same rule in both combo boxes
        String rule1 = (String)jComboBoxRule1.getSelectedItem();
        String rule2 = (String)jComboBoxRule2.getSelectedItem();
        if ( rule1.equals(rule2) )
        {
            JOptionPane.showMessageDialog(this, "You must select two different rules when defining a priority between rules");
            return;
        }
        canceled = false;
        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        canceled = true;
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jComboBoxRule1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxRule1ItemStateChanged
        // display organization list in whch the rule is defined
        String rule = (String)jComboBoxRule1.getSelectedItem();
        // since we don't know the rule type, we get all rules
        try
        {
          Map<String, CAbstractRule> allRules =  policy.GetAllAbstractRules();
          // get the selected rule
          CAbstractRule r = allRules.get(rule);
          // get sub-organizations of the one in which the rule is defined
          Set<String> subOrgs = policy.GetSubOrganizations( r.GetOrganization() );
          subOrgs.add( r.GetOrganization() );
          // fill combo box
            jComboBoxOrg1.removeAllItems();
          for ( String o : subOrgs )
              jComboBoxOrg1.addItem(o);
          jComboBoxOrg1.setSelectedItem( r.GetOrganization() );
        }
        catch ( COrbacException e )
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBoxRule1ItemStateChanged

    private void jComboBoxRule2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxRule2ItemStateChanged
        // display organization list in whch the rule is defined
        String rule = (String)jComboBoxRule2.getSelectedItem();
        // since we don't know the rule type, we get all rules
        try
        {
            Map<String, CAbstractRule> allRules =  policy.GetAllAbstractRules();
            // get the selected rule
            CAbstractRule r = allRules.get(rule);
            // get sub-organizations of the one in which the rule is defined
            Set<String> subOrgs = policy.GetSubOrganizations( r.GetOrganization() );
            subOrgs.add( r.GetOrganization() );
            // fill combo box
            jComboBoxOrg2.removeAllItems();
            for ( String o : subOrgs )
                jComboBoxOrg2.addItem(o);
            
            jComboBoxOrg2.setSelectedItem( r.GetOrganization() );
        }
        catch ( COrbacException e )
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBoxRule2ItemStateChanged

    public String GetMorePriorityRuleName()
    {
        return (String)jComboBoxRule1.getSelectedItem();
    }
    public String GetLessPriorityRuleName()
    {
        return (String)jComboBoxRule2.getSelectedItem();
    }
    public String GetFirstOrganization()
    {
        return (String)jComboBoxOrg1.getSelectedItem();
    }
    public String GetSecondOrganization()
    {
        return (String)jComboBoxOrg2.getSelectedItem();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JComboBox jComboBoxOrg1;
    private javax.swing.JComboBox jComboBoxOrg2;
    private javax.swing.JComboBox jComboBoxRule1;
    private javax.swing.JComboBox jComboBoxRule2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

}

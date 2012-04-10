package newmotorbac.dialog;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import newmotorbac.services.IPluginDiscovery;
import orbac.AbstractOrbacPolicy;
import orbac.COrbacCore;
import orbac.exception.CContextTypeNotFoundException;
import orbac.exception.COrbacException;
import orbac.service.IPolicyProcessorService;
import orbac.xmlImpl.XmlOrbacPolicy;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

/*
 * JDialogLoadPolicy.java
 *
 * Created on May 11, 2011, 5:14:44 PM
 */
/**
 *
 * @author fabien
 */
public class jDialogLoadPolicy extends javax.swing.JDialog {

    AbstractOrbacPolicy policy;

    /**
     * Creates new form JDialogLoadPolicy
     */
    public jDialogLoadPolicy(java.awt.Frame parent, File policyFile, boolean modal) {
        super(parent, modal);
        initComponents();

        // start thread loading the policy
        PolicyLoadingThread t = new PolicyLoadingThread(policyFile, this);
        t.start();
    }

    class PolicyLoadingThread extends Thread {

        private File file;
        private jDialogLoadPolicy dialog;

        public PolicyLoadingThread(File file, jDialogLoadPolicy dialog) {
            super();
            this.file = file;
            this.dialog = dialog;
        }

        @Override
        public void run() {
            try {
                dialog.SetLabelLoadingPolicyState(true);
                dialog.SetLabelSavePolicyState(false);
                dialog.SetLabelInferPolicyState(false);

                //This is one way of doing it
                //___________________________
                //create an empty policy
                //add context factories
                //then load from file
                //___________________________

                // the listeners are added at loading time
                policy = COrbacCore.GetTheInstance().LoadPolicy(file.toString());

                dialog.SetLabelLoadingPolicyState(false);
                dialog.SetLabelSavePolicyState(true);
                dialog.SetLabelInferPolicyState(false);

                // store new policy in history
                //PanelEntity.SavePolicyInHistoric(policy);

                dialog.SetLabelLoadingPolicyState(false);
                dialog.SetLabelSavePolicyState(false);
                dialog.SetLabelInferPolicyState(true);
            } catch (Exception ex) {
                ex.printStackTrace(System.err);
                try {
                    policy = COrbacCore.GetTheInstance().CreatePolicy("temp", XmlOrbacPolicy.class);
                    for (Bundle selectedPlugin : COrbacCore.GetPlugins()) {
                        BundleContext context = selectedPlugin.getBundleContext();
                        ServiceReference[] serviceRefs = selectedPlugin.getRegisteredServices();
                        for (int i = 0; i < serviceRefs.length; i++) {
                            if(((IPluginDiscovery) context.getService(serviceRefs[i])).contributesToPolicy())
                                ((IPolicyProcessorService) context.getService(serviceRefs[i])).ProcessPolicy(policy, file.toString());
                        }
                    }
                    policy.ReadPolicyFile(file.toString());
                } catch (COrbacException ex1) {
                    Logger.getLogger(jDialogLoadPolicy.class.getName()).log(Level.SEVERE, null, ex1);
                } catch (Exception ex1) {
                    Logger.getLogger(jDialogLoadPolicy.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                // destroy dialog
                dialog.dispose();
            }
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelLoadingPolicy = new javax.swing.JLabel();
        jLabelSavePolicy = new javax.swing.JLabel();
        jLabelInferPolicy = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N
        setResizable(false);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(newmotorbac.NewMotorbacApp.class).getContext().getResourceMap(jDialogLoadPolicy.class);
        jLabel1.setIcon(resourceMap.getIcon("jLabel1.icon")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jLabelLoadingPolicy.setText(resourceMap.getString("jLabelLoadingPolicy.text")); // NOI18N
        jLabelLoadingPolicy.setName("jLabelLoadingPolicy"); // NOI18N

        jLabelSavePolicy.setText(resourceMap.getString("jLabelSavePolicy.text")); // NOI18N
        jLabelSavePolicy.setName("jLabelSavePolicy"); // NOI18N

        jLabelInferPolicy.setText(resourceMap.getString("jLabelInferPolicy.text")); // NOI18N
        jLabelInferPolicy.setName("jLabelInferPolicy"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLoadingPolicy)
                    .addComponent(jLabelSavePolicy)
                    .addComponent(jLabelInferPolicy))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelLoadingPolicy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSavePolicy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInferPolicy)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public AbstractOrbacPolicy GetPolicy() {
        return policy;
    }

    public void SetLabelLoadingPolicyState(boolean state) {
        jLabelLoadingPolicy.setEnabled(state);
    }

    public void SetLabelSavePolicyState(boolean state) {
        jLabelSavePolicy.setEnabled(state);
    }

    public void SetLabelInferPolicyState(boolean state) {
        jLabelInferPolicy.setEnabled(state);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelInferPolicy;
    private javax.swing.JLabel jLabelLoadingPolicy;
    private javax.swing.JLabel jLabelSavePolicy;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

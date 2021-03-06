/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelAbstractEntities.java
 *
 * Created on May 9, 2011, 10:50:10 PM
 */

package newmotorbac;

import newmotorbac.util.OrbacPolicyContext;
import java.net.URL;
import javax.swing.ImageIcon;
import orbac.AbstractOrbacPolicy;

/**
 *
 * @author fabien
 */
public class PanelAbstractEntities extends javax.swing.JPanel {
    // policy context
    OrbacPolicyContext thisContext;
    // tabs
    private PanelAbstractEntity panelRoles, panelActivities, panelViews;

    /** Creates new form PanelAbstractEntities */
    public PanelAbstractEntities(OrbacPolicyContext thisContext) {
        initComponents();

        // create tabs
        panelRoles = new PanelAbstractEntity(thisContext, AbstractOrbacPolicy.TYPE_ROLE);
        panelActivities = new PanelAbstractEntity(thisContext, AbstractOrbacPolicy.TYPE_ACTIVITY);
        panelViews = new PanelAbstractEntity(thisContext, AbstractOrbacPolicy.TYPE_VIEW);
        // add them
        URL url = NewMotorbacView.class.getResource("/newmotorbac/resources/role_new.png");
        if( url != null )
        {
            ImageIcon img = new ImageIcon(url);
            jTabbedPaneAbstractEntities.addTab("Roles", img, panelRoles);
        }
        url = NewMotorbacView.class.getResource("/newmotorbac/resources/activity_new.png");
        if( url != null )
        {
            ImageIcon img = new ImageIcon(url);
            jTabbedPaneAbstractEntities.addTab("Activities", img, panelActivities);
        }
        url = NewMotorbacView.class.getResource("/newmotorbac/resources/view_new.png");
        if( url != null )
        {
            ImageIcon img = new ImageIcon(url);
            jTabbedPaneAbstractEntities.addTab("Views", img, panelViews);
        }
        // store them in context
        thisContext.panelAbstractEntities = this;
        thisContext.panelRoles = panelRoles;
        thisContext.panelActivities = panelActivities;
        thisContext.panelViews = panelViews;

        // update entities tabs
        UpdateTabs();
    }

    public void UpdateTabs()
    {
        panelRoles.UpdateHierarchy();
        panelActivities.UpdateHierarchy();
        panelViews.UpdateHierarchy();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneAbstractEntities = new javax.swing.JTabbedPane();

        setName("Form"); // NOI18N

        jTabbedPaneAbstractEntities.setName("jTabbedPaneAbstractEntities"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneAbstractEntities, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneAbstractEntities, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPaneAbstractEntities;
    // End of variables declaration//GEN-END:variables

}

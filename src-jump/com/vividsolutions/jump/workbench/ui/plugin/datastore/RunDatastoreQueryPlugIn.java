package com.vividsolutions.jump.workbench.ui.plugin.datastore;

import com.vividsolutions.jump.datastore.AdhocQuery;
import com.vividsolutions.jump.feature.FeatureDataset;
import com.vividsolutions.jump.io.FeatureInputStream;
import com.vividsolutions.jump.task.TaskMonitor;
import com.vividsolutions.jump.util.LangUtil;
import com.vividsolutions.jump.workbench.datastore.ConnectionManager;
import com.vividsolutions.jump.workbench.model.Layer;
import com.vividsolutions.jump.workbench.model.Layerable;
import com.vividsolutions.jump.workbench.plugin.PlugInContext;


public class RunDatastoreQueryPlugIn extends
    AbstractAddDatastoreLayerPlugIn {


    protected ConnectionPanel createPanel( PlugInContext context ) {
        return new RunDatastoreQueryPanel( context.getWorkbenchContext() );
    }

    protected Layerable createLayerable(
        ConnectionPanel panel,
        TaskMonitor monitor,
        PlugInContext context ) throws Exception {
        return createLayer( ( RunDatastoreQueryPanel ) panel, monitor, context );
    }


    private Layer createLayer( final RunDatastoreQueryPanel panel,
        TaskMonitor monitor,
        final PlugInContext context ) throws Exception {

        panel.saveQuery();

        monitor.allowCancellationRequests();
        monitor.report( "Creating layer" );

        int maxFeatures = ( ( Integer ) LangUtil.ifNull( panel.getMaxFeatures(),
            new Integer( Integer.MAX_VALUE ) ) ).intValue();
        FeatureInputStream featureInputStream = ConnectionManager.instance(
            context.getWorkbenchContext() )
            .getOpenConnection( panel.getConnectionDescriptor() ).execute(
            new AdhocQuery( panel.getQuery() ) );
        try {
            FeatureDataset featureDataset = new FeatureDataset(
                featureInputStream.getFeatureSchema() );
            int i = 0;
            while ( featureInputStream.hasNext()
                 && featureDataset.size() < maxFeatures
                 && !monitor.isCancelRequested() ) {
                featureDataset.add( featureInputStream.next() );
                monitor.report( ++i, -1, "features" );
            }
            return new Layer( panel.getQuery(), context.getLayerManager()
                .generateLayerFillColor(), featureDataset, context.getLayerManager() );
        } finally {
            featureInputStream.close();
        }
    }
}


/*
 * The Unified Mapping Platform (JUMP) is an extensible, interactive GUI 
 * for visualizing and manipulating spatial features with geometry and attributes.
 *
 * Copyright (C) 2003 Vivid Solutions
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 * For more information, contact:
 *
 * Vivid Solutions
 * Suite #1A
 * 2328 Government Street
 * Victoria BC  V8T 5G5
 * Canada
 *
 * (250)385-6040
 * www.vividsolutions.com
 */

package com.vividsolutions.jump.workbench.driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.vividsolutions.jump.feature.FeatureCollection;
import com.vividsolutions.jump.io.CompressedFile;
import com.vividsolutions.jump.io.DriverProperties;
import com.vividsolutions.jump.io.ParseException;
import com.vividsolutions.jump.io.WKTReader;
import com.vividsolutions.jump.workbench.model.Layer;
import com.vividsolutions.jump.workbench.model.LayerManager;
import com.vividsolutions.jump.workbench.ui.AbstractDriverPanel;
import com.vividsolutions.jump.workbench.ui.BasicFileDriverPanel;
import com.vividsolutions.jump.workbench.ui.ErrorHandler;
import com.vividsolutions.jump.workbench.ui.GUIUtil;
import com.vividsolutions.jump.workbench.ui.WorkbenchFileFilter;


public class WKTFileInputDriver extends AbstractInputDriver {
    private WKTReader reader = new WKTReader();
    private BasicFileDriverPanel panel;

    public WKTFileInputDriver() {
    }

    public String toString() {
        return GUIUtil.wktDesc;
    }

    public AbstractDriverPanel getPanel() {
        return panel;
    }

    public void input(LayerManager layerManager, String categoryName)
        throws FileNotFoundException, IOException, ParseException, 
            com.vividsolutions.jts.io.ParseException, 
            com.vividsolutions.jump.io.IllegalParametersException, Exception {
        String extension;
        File selectedFile = panel.getSelectedFile();
        String layerName = GUIUtil.nameWithoutExtension(selectedFile);
        String fname = selectedFile.getAbsolutePath();

        //<<TODO:AESTHETICS>> Source code formatting needs to be fixed here. [Jon Aquino]
        extension = fname.substring(fname.length() - 3);

        DriverProperties dp = new DriverProperties();

        if (extension.equalsIgnoreCase("zip")) {
            String internalName;

            dp.set("CompressedFile", fname);
            internalName = CompressedFile.getInternalZipFnameByExtension(".wkt",
                    fname);

            if (internalName == null) {
                internalName = CompressedFile.getInternalZipFnameByExtension(".txt",
                        fname);
            }

            if (internalName == null) {
                throw new Exception(
                    "Couldnt find a .wkt, or .txt file inside the .zip file: " +
                    fname);
            }

            dp.set("File", internalName);
        } else if (extension.equalsIgnoreCase(".gz")) {
            dp.set("CompressedFile", fname);
            dp.set("File", fname); // not useed
        } else {
            dp.set("File", fname);
        }

        FeatureCollection featureCollection = reader.read(dp);
        Layer layer = layerManager.addLayer(categoryName, layerName,
                featureCollection);
    }

    public void initialize(DriverManager driverManager,
        ErrorHandler errorHandler) {
        super.initialize(driverManager, errorHandler);
        panel = new BasicFileDriverPanel(errorHandler);
        panel.setFileDescription(GUIUtil.wktDesc);
        panel.setFileFilter(new WorkbenchFileFilter(GUIUtil.wktDesc));
        panel.setFileMustExist(true);
    }
}

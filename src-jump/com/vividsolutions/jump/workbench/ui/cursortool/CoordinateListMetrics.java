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
package com.vividsolutions.jump.workbench.ui.cursortool;

import java.util.*;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jump.workbench.ui.LayerViewPanel;
import com.vividsolutions.jump.geom.Angle;

/**
 * Generates strings describing metrics for coordinate lists.
 *
 * @author Martin Davis
 * @version 1.0
 */
public class CoordinateListMetrics
{
  public CoordinateListMetrics() {
  }

  public void displayMetrics(List coordinates, LayerViewPanel panel)
  {
    panel.getContext().setStatusMessage(getMetricsString(coordinates, panel));
  }

  public String getMetricsString(List coordinates, LayerViewPanel panel)
  {
    double dist = distance(coordinates);
    String dispStr = "Distance: " + panel.format(dist);

    double angle = angle(coordinates);
    dispStr += "   Angle: " + panel.format(angle);

    if (coordinates.size() > 2) {
      double area = area(coordinates);
      dispStr += "   Area: " + panel.format(area);
    }
    return dispStr;
  }

  public static double distance(List coordinates)
  {
    double distance = 0;
    for (int i = 1; i < coordinates.size(); i++) {
      distance += ((Coordinate) coordinates.get(i - 1)).distance((Coordinate) coordinates.get(
      i));
    }
    return distance;
  }

  /**
   * Computes the angle between the last 2 segments in the coordinates list
   *
   * @param coordinates
   * @return the angle in degrees
   */
  public static double angle(List coordinates)
  {
    int size = coordinates.size();
    if (size <= 1) return 0.0;
    Coordinate p1 = (Coordinate) coordinates.get(size - 2);
    Coordinate p2 = (Coordinate) coordinates.get(size - 1);
    // if only 2 coords, compute angle relative to X axis
    Coordinate p0 = null;
    if (size > 2)
      p0 = (Coordinate) coordinates.get(size - 3);
    else
      p0 = new Coordinate(p1.x + 1.0, p1.y);

    double angRad = Angle.angleBetween(p1, p0, p2);
    return Math.toDegrees(angRad);
  }

  /**
   * Computes the area for the coordinates list.
   * The area is forcd to be positive.
   * The coordinate list can be open, and the closing coordinate is supplied
   */
  private static double area(List coordinates)
  {
    if (coordinates.size() < 3) return 0.0;
    double sum = 0.0;
    for (int i = 0; i < coordinates.size(); i++) {
      Coordinate b = (Coordinate) coordinates.get(i);
      int nexti = i + 1;
      if (nexti > coordinates.size() - 1)
        nexti = 0;
      Coordinate c = (Coordinate) coordinates.get(nexti);
      sum += (b.x + c.x) * (c.y - b.y);
    }
    double signedArea = -sum / 2.0;
    if (signedArea >= 0)
      return signedArea;
    return -signedArea;
  }

}
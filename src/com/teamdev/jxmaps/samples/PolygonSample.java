/*
 * Copyright (c) 2000-2016 TeamDev Ltd. All rights reserved.
 * Use is subject to Apache 2.0 license terms.
 */


package com.teamdev.jxmaps.samples;

import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Polygon;
import com.teamdev.jxmaps.PolygonOptions;
import com.teamdev.jxmaps.swing.MapView;

import javax.swing.*;
import java.awt.*;

/**
 * This example demonstrates how to draw polygons on the map.
 *
 * @author Vitaly Eremenko
 */
public class PolygonSample extends MapView {
    public PolygonSample() {
        // Setting of a ready handler to MapView object. onMapReady will be called when map initialization is done and
        // the map object is ready to use. Current implementation of onMapReady customizes the map object.
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                // Check if the map is loaded correctly
                if (status == MapStatus.MAP_STATUS_OK) {
                    // Getting the associated map object
                    final Map map = getMap();
                    // Creating a map options object
                    MapOptions mapOptions = new MapOptions(map);
                    // Creating a map type control options object
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions(map);
                    // Changing position of the map type control
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    // Setting map type control options
                    mapOptions.setMapTypeControlOptions(controlOptions);
                    // Setting map options
                    map.setOptions(mapOptions);
                    // Setting the map center
                    map.setCenter(new LatLng(map, 24.886, -70.268));
                    // Setting initial zoom value
                    map.setZoom(5.0);
                    // Creating a path (array of coordinates) that represents a polygon
                    LatLng[] path = {new LatLng(map, 25.774, -80.190),
                            new LatLng(map, 18.466, -66.118),
                            new LatLng(map, 32.321, -64.757),
                            new LatLng(map, 25.774, -80.190)};
                    // Creating a new polygon object
                    Polygon polygon = new Polygon(map);
                    // Initializing the polygon with the created path
                    polygon.setPath(path);
                    // Creating a polyline options object
                    PolygonOptions options = new PolygonOptions(map);
                    // Setting fill color value
                    options.setFillColor("#FF0000");
                    // Setting fill opacity value
                    options.setFillOpacity(0.35);
                    // Setting stroke color value
                    options.setStrokeColor("#FF0000");
                    // Setting stroke opacity value
                    options.setStrokeOpacity(0.8);
                    // Setting stroke weight value
                    options.setStrokeWeight(2.0);
                    // Applying options to the polygon
                    polygon.setOptions(options);
                }
            }
        });
    }

    public static void main(String[] args) {
        final PolygonSample sample = new PolygonSample();

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(sample, BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

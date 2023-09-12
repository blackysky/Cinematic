package de.silke.cinematic.point;

import java.io.File;

public class PointManager {
    PointSaver saver = new PointSaver();

    public CameraPoint getPoint(int id) {
        File file = saver.getPointsFile();

        // TODO: Get point from file
        return null;
    }
}

package de.silke.cinematic.point;

import com.google.gson.Gson;
import de.silke.cinematic.Main;
import de.silke.cinematic.point.CameraPoint;
import lombok.Data;

import java.io.File;

@Data
public class PointSaver {
    // This class should contain methods for saving and loading point from file
    // Will be used when the plugin is going to be reloaded / disabled
    // Or just to save point to file
    // TODO: Save all point to file

    private File pointsFile = new File(Main.plugin.getDataFolder(), "points.json");
    private Gson gson = new Gson();

    public void savePoint(CameraPoint point) {
        String json = gson.toJson(point);
        // TODO: Save json to file
    }
}

package de.silke.cinematic.movie;

import com.google.gson.Gson;
import de.silke.cinematic.Main;
import de.silke.cinematic.point.CameraPoint;
import lombok.Data;

import java.io.File;

@Data
public class MovieSaver {
    // This class should contain methods for saving and loading movies from file
    // Will be used when the plugin is going to be reloaded / disabled
    // Or just to save movies to file
    // TODO: Save all movies to file

    private File moviesFile = new File(Main.plugin.getDataFolder(), "movies.json");
    private Gson gson = new Gson();

    public void saveMovie(Movie movie) {
        String json = gson.toJson(movie);
        // TODO: Save json to file
    }
}

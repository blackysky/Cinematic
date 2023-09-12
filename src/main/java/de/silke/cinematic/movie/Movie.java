package de.silke.cinematic.movie;

import de.silke.cinematic.point.CameraPoint;
import lombok.Data;

@Data
public class Movie {
    private String name;
    private int id;
    private CameraPoint[] points;
    private int startPointId;
    private int endPointId;
    private boolean isLooped;
    private boolean isPlayed;
    private boolean isPaused;
    private boolean isStopped;
    private boolean isFinished;
    private boolean isSaved;

    public Movie(String name, int id, CameraPoint[] points, int startPointId, int endPointId, boolean isLooped, boolean isPlayed, boolean isPaused, boolean isStopped, boolean isFinished, boolean isSaved) {
        this.name = name;
        this.id = id;
        this.points = points;
        this.startPointId = startPointId;
        this.endPointId = endPointId;
        this.isLooped = isLooped;
        this.isPlayed = isPlayed;
        this.isPaused = isPaused;
        this.isStopped = isStopped;
        this.isFinished = isFinished;
        this.isSaved = isSaved;
    }
}

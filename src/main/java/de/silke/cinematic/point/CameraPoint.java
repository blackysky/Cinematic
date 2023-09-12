package de.silke.cinematic.point;

import lombok.Data;

@Data
public class CameraPoint {
    private int id;
    private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;
    private String world;

    public CameraPoint(int id, double x, double y, double z, float yaw, float pitch, String world) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.world = world;
    }
}

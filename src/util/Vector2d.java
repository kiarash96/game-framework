package util;

/**
 * Created by kiarash on 7/18/16.
 */
public class Vector2d {
    double x, y;

    public Vector2d() {
        this(0.0, 0.0);
    }

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d add(Vector2d v) {
        return new Vector2d(this.x + v.x, this.y + v.y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

package fr.lezenn.penny.model.shape;

import fr.lezenn.penny.model.maths.Vector2d;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0.0, 0.0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2d toVector2d() {
        return new Vector2d(this.x, this.y);
    }
}

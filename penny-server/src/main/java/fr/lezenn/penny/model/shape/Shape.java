package fr.lezenn.penny.model.shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a shape that the player owns.
 */
public class Shape {

    private final List<Point> points;

    public Shape() {
        this.points = new ArrayList<>(150);
    }

    /**
     * Adds a point to the shape
     * @param point Point to add
     */
    public void addPoint(Point point) {
        this.points.add(point);
    }

    public void addPoints(List<Point> points) {
        this.points.addAll(points);
    }

    /**
     * Transforms the point list to make the shape connex
     */
    public void connexize() {

    }
}

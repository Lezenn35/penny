package fr.lezenn.penny.model.shape;

import fr.lezenn.penny.model.maths.Vector2d;

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

    public boolean containsPoint(Point point) {
        var nbPoints = this.points.size();
        var count = 0;

        if (nbPoints < 3) {
            return false;
        }

        for (int i = 0; i < nbPoints; i++) {
            var segPointA = this.points.get(i).toVector2d();
            Vector2d segPointB;

            if (i < nbPoints - 1) {
                segPointB = this.points.get(i + 1).toVector2d();
            } else {
                segPointB = this.points.get(0).toVector2d();
            }

            double x1 = segPointA.getX(),
                    y1 = segPointA.getY(),
                    x2 = segPointB.getX(),
                    y2 = segPointB.getY();

            if (

                    point.getY() <= y1 != point.getY() <= y2
                    && point.getX() <= (x2 - x1) * (point.getY() - y1) / (y2 - y1) + x1
            ) {
                count++;
            }
        }

        return count % 2 != 0;
    }

    public List<Point> getPoints() {
        return this.points;
    }
}

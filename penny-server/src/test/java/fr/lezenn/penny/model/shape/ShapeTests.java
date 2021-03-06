package fr.lezenn.penny.model.shape;

import fr.lezenn.penny.model.maths.Vector2d;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ShapeTests {

    @Test
    public void createEmptyShapeTest() {
        var shape = new Shape();
        Assertions.assertEquals(0, shape.getPoints().size());
    }

    @Test
    public void addPointTest() {
        var shape = new Shape();
        shape.addPoint(new Vector2d(0, 0));

        Assertions.assertEquals(1, shape.getPoints().size());
    }

    @Test
    public void addPointsTest() {
        var shape = new Shape();
        shape.addPoints(List.of(new Vector2d(0, 0), new Vector2d(1, 0), new Vector2d(2, 0)));

        var p1 = new Vector2d(0, 0);
        var p2 = new Vector2d(1, 0);
        var p3 = new Vector2d(2, 0);

        Assertions.assertEquals(3, shape.getPoints().size());
        Assertions.assertEquals(p1, shape.getPoints().get(0));
        Assertions.assertEquals(p2, shape.getPoints().get(1));
        Assertions.assertEquals(p3, shape.getPoints().get(2));
    }

    @Test
    public void createSquareShapeTest() {
        var shape = new Shape();
        shape.addPoint(new Vector2d(0, 0));
        shape.addPoint(new Vector2d(1, 0));
        shape.addPoint(new Vector2d(1, 1));
        shape.addPoint(new Vector2d(0, 1));

        Assertions.assertEquals(4, shape.getPoints().size());
    }

    @Test
    public void pointInsideTwoVertexPolygon() {
        var shape = new Shape();
        shape.addPoint(new Vector2d(0, 0));
        shape.addPoint(new Vector2d(0, 1));

        Assertions.assertFalse(shape.containsPoint(new Vector2d(0, 0)));
    }

    @Test
    public void pointInsideConvexShapeTest() {
        var shape = new Shape();
        shape.addPoint(new Vector2d(0, 0));
        shape.addPoint(new Vector2d(10, 0));
        shape.addPoint(new Vector2d(10, 10));
        shape.addPoint(new Vector2d(0, 10));

        var point = new Vector2d(5, 5);
        Assertions.assertTrue(shape.containsPoint(point));
    }

    @Test
    public void pointNotInsideConvexShapeTest() {
        var shape = new Shape();
        shape.addPoint(new Vector2d(0, 0));
        shape.addPoint(new Vector2d(10, 0));
        shape.addPoint(new Vector2d(10, 10));
        shape.addPoint(new Vector2d(0, 10));

        var p1 = new Vector2d(15, 5);
        var p2 = new Vector2d(-150, 13);

        Assertions.assertFalse(shape.containsPoint(p1));
        Assertions.assertFalse(shape.containsPoint(p2));
    }

    @Test
    public void pointNotInsideNotConvexShapeTest() {
        var shape = new Shape();

        // U shape
        shape.addPoints(List.of(
                new Vector2d(0, 0),
                new Vector2d(30, 0),
                new Vector2d(30, 30),
                new Vector2d(20, 30),
                new Vector2d(20, 10),
                new Vector2d(10, 10),
                new Vector2d(10, 30),
                new Vector2d(0, 30)
        ));

        List<Vector2d> points = List.of(
                new Vector2d(-150, 10),
                new Vector2d(0, -10),
                new Vector2d(15, 15),
                new Vector2d(15, 150),
                new Vector2d(150, 10)
        );

        points.forEach(p -> Assertions.assertFalse(shape.containsPoint(p)));
    }

    @Test
    public void pointInsideNonConvexShape() {
        var shape = new Shape();

        // U shape
        shape.addPoints(List.of(
                new Vector2d(0, 0),
                new Vector2d(30, 0),
                new Vector2d(30, 30),
                new Vector2d(20, 30),
                new Vector2d(20, 10),
                new Vector2d(10, 10),
                new Vector2d(10, 30),
                new Vector2d(0, 30)
        ));

        var points = List.of(
                new Vector2d(0, 0),
                new Vector2d(5, 5),
                new Vector2d(25, 5),
                new Vector2d(5, 25),
                new Vector2d(25, 25),
                new Vector2d(15, 5),
                new Vector2d(30, 30)
        );

        points.forEach(p -> Assertions.assertTrue(shape.containsPoint(p)));
    }
}

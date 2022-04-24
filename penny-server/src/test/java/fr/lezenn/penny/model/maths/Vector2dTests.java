package fr.lezenn.penny.model.maths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Vector2dTests {

    private static final double DELTA = 0.00001;

    @Test
    public void nullVectorTest() {
        var vector = new Vector2d();

        Assertions.assertEquals(0, vector.getX(), DELTA);
        Assertions.assertEquals(0, vector.getY(), DELTA);
    }

    @Test
    public void vectorCreationTest() {
        var vector = new Vector2d(9, 18);

        Assertions.assertEquals(9, vector.getX(), DELTA);
        Assertions.assertEquals(18, vector.getY(), DELTA);
    }

    @Test
    public void addValueToBothComponentsTest() {
        var vector = new Vector2d();
        vector.add(15.23);

        Assertions.assertEquals(15.23, vector.getX(), DELTA);
        Assertions.assertEquals(15.23, vector.getY(), DELTA);
    }

    @Test
    public void addVectorToVectorTest() {
        var v1 = new Vector2d();
        var v2 = new Vector2d(1, 5);
        v1.add(v2);

        Assertions.assertEquals(1, v1.getX(), DELTA);
        Assertions.assertEquals(5, v1.getY(), DELTA);
    }

    @Test
    public void subValueToBothComponentsTest() {
        var vector = new Vector2d();
        vector.sub(3.33);

        Assertions.assertEquals(-3.33, vector.getX(), DELTA);
        Assertions.assertEquals(-3.33, vector.getY(), DELTA);
    }

    @Test
    public void subVectorToVectorTest() {
        var v1 = new Vector2d();
        var v2 = new Vector2d(1, 5);
        v1.sub(v2);

        Assertions.assertEquals(-1, v1.getX(), DELTA);
        Assertions.assertEquals(-5, v1.getY(), DELTA);
    }

    @Test
    public void multiplyVectorByValueTest() {
        var vector = new Vector2d(1, 3);
        vector.multiply(150);

        Assertions.assertEquals(150, vector.getX(), DELTA);
        Assertions.assertEquals(450, vector.getY(), DELTA);
    }

    @Test
    public void vectorLengthTest() {
        var vector = new Vector2d(1, 1);
        final var len = vector.length();

        Assertions.assertEquals(Math.sqrt(2), len, DELTA);
    }

    @Test
    public void vectorLengthOnNegativeCoordinates() {
        var vector = new Vector2d(0, -15.5);
        Assertions.assertEquals(15.5, vector.length(), DELTA);
    }

    @Test
    public void dotProductTest() {
        var v1 = new Vector2d(0, 1);
        var v2 = new Vector2d(1, 0);

        Assertions.assertEquals(
                v1.getX() * v2.getX() + v1.getY() * v2.getY(),
                v1.dot(v2),
                DELTA
        );
    }

    @Test
    public void rightAngleBetweenVectorsTest() {
        var v1 = new Vector2d(0, 1);
        var v2 = new Vector2d(1, 0);
        var angle = v1.angleBetween(v2);

        Assertions.assertEquals(Math.PI / 2, angle, DELTA);
    }

    @Test
    public void nullAngleBetweenVectorsTest() {
        var v1 = new Vector2d(0, 1);
        var v2 = new Vector2d(0, 1);
        var angle = v1.angleBetween(v2);

        Assertions.assertEquals(0, angle, DELTA);
    }

    @Test
    public void rotateAngle90Deg() {
        var vector = new Vector2d(1, 0);
        vector.rotateDeg(90);

        Assertions.assertEquals(0, vector.getX(), DELTA);
        Assertions.assertEquals(1, vector.getY(), DELTA);
    }

    @Test
    public void rotateAngleMinus90Deg() {
        var vector = new Vector2d(1, 0);
        vector.rotateDeg(-90);

        Assertions.assertEquals(0, vector.getX(), DELTA);
        Assertions.assertEquals(-1, vector.getY(), DELTA);
    }

    @Test
    public void rotateAngle90Rad() {
        var vector = new Vector2d(1, 0);
        vector.rotateRad(Math.PI / 2);

        Assertions.assertEquals(0, vector.getX(), DELTA);
        Assertions.assertEquals(1, vector.getY(), DELTA);
    }

    @Test
    public void rotateAngleMinus90Rad() {
        var vector = new Vector2d(1, 0);
        vector.rotateRad(-Math.PI / 2);

        Assertions.assertEquals(0, vector.getX(), DELTA);
        Assertions.assertEquals(-1, vector.getY(), DELTA);
    }

    @Test
    public void vectorDistanceTest() {
        var v1 = new Vector2d();
        var v2 = new Vector2d(15, 0);

        Assertions.assertEquals(15.0, v1.distance(v2), DELTA);
        Assertions.assertEquals(15.0, v2.distance(v1), DELTA);
    }
}

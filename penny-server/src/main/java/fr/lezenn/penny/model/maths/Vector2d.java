package fr.lezenn.penny.model.maths;

import java.util.Objects;

/**
 * Vector of two double components
 */
public class Vector2d {

    public static final Vector2d UP = new Vector2d(0, 1);
    public static final Vector2d LEFT = new Vector2d(1, 0);
    public static final Vector2d DOWN = new Vector2d(0, -1);
    public static final Vector2d RIGHT = new Vector2d(-1, 0);

    private double x;
    private double y;

    /**
     * Full constructor
     * @param x X component
     * @param y Y component
     */
    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Origin constructor.
     * Creates a Vector2d(0, 0)
     */
    public Vector2d() {
        this(0.0, 0.0);
    }

    /**
     * Add two vectors by adding their respective components
     * @param vector Vector to add
     */
    public void add(Vector2d vector) {
        this.x += vector.x;
        this.y += vector.y;
    }

    /**
     * Add a value to both vector's components
     * @param value Value to add to both components
     */
    public void add(double value) {
        this.x += value;
        this.y += value;
    }

    /**
     * Subtracts two vectors by their components
     * @param vector Vector to subtract
     */
    public void sub(Vector2d vector) {
        this.x -= vector.x;
        this.y -= vector.y;
    }

    /**
     * Subtracts a value from both vector's components
     * @param value Value to subtract to both components
     */
    public void sub(double value) {
        this.add(-value);
    }

    /**
     * Multiply a vector's components by a given value.
     * @param value Value to multiply both vector's components
     */
    public void multiply(double value) {
        this.x *= value;
        this.y *= value;
    }

    /**
     * Computes the magnitude (or length) of a vector
     * @return Magnitude as double
     */
    public double length() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    /**
     * Computes the dot (or scalar) product of two vectors
     * @param other Other vector to compute with
     * @return Dot product of the two vectors
     */
    public double dot(Vector2d other) {
        return this.x * other.x + this.y * other.y;
    }

    /**
     * Returns the angle between two vectors, in rad
     * @param other Other vector to compute angle with
     * @return Angle in rad
     */
    public double angleBetween(Vector2d other) {
        return Math.acos((this.dot(other)));
    }

    /**
     * Rotates the vector from the given angle.
     * @param angle Angle in degree
     */
    public void rotateDeg(double angle) {
        angle = angle * (Math.PI / 180.0);
        this.rotateRad(angle);
    }

    /**
     * Rotates the vector from the given angle.
     * @param angle Angle in radian
     */
    public void rotateRad(double angle) {
        var x = Math.cos(angle) * this.x - Math.sin(angle) * this.y;
        this.y = Math.sin(angle) * this.x + Math.cos(angle) * this.y;
        this.x = x;
    }

    /**
     * Computes the distance between two Vector2d assimiled as points in a plan
     * @param other Other vector (or point)
     * @return The distance between the two points
     */
    public double distance(Vector2d other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return Double.compare(vector2d.x, x) == 0 && Double.compare(vector2d.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

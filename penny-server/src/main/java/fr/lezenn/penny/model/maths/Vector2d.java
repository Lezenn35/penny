package fr.lezenn.penny.model.maths;

/**
 * Vector of two double components
 */
public class Vector2d {

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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

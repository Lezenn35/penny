package fr.lezenn.penny.model.player;

import fr.lezenn.penny.model.color.Color;
import fr.lezenn.penny.model.maths.Vector2d;
import fr.lezenn.penny.model.shape.Shape;

import java.util.Objects;

public class Player {

    public static double PLAYER_SPEED = 1.0;

    private final String name;
    private final Color color;
    private Vector2d position;
    private Vector2d orientation;

    private final Shape shape;

    public Player(String name, Color color, Vector2d position, Vector2d orientation) {
        this.name = name;
        this.color = color;
        this.orientation = orientation;
        this.position = position;
        this.shape = new Shape();
    }

    /**
     * Moves the player toward the orientation it has, with the PLAYER_SPEED.
     *
     * It mutates the position attribute of the Player.
     */
    public void move() {
        this.move(PLAYER_SPEED);
    }

    public void move(double factor) {
        var addedPos = new Vector2d(this.orientation.getX(), this.orientation.getY());
        addedPos.multiply(factor);
        this.position.add(addedPos);
    }

    /**
     * Rotates the player orientation of a given angle.
     * @param angle Angle to rotate the player with, in rad.
     */
    public void rotate(double angle) {

    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    public Vector2d getOrientation() {
        return orientation;
    }

    public void setOrientation(Vector2d orientation) {
        this.orientation = orientation;
    }

    public Shape getShape() {
        return shape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(color, player.color) && Objects.equals(position, player.position) && Objects.equals(orientation, player.orientation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, position, orientation);
    }
}

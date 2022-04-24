package fr.lezenn.penny.model.world;

import fr.lezenn.penny.model.maths.Vector2d;

/**
 * Game world map representation
 */
public class WorldMap {

    private final double size;
    private final Vector2d center;

    public WorldMap(double size) {
        this.size = size;
        this.center = new Vector2d();
    }

    /**
     * Get the center vector of the map.
     * @return
     */
    public Vector2d getCenter() {
        return this.center;
    }

    /**
     * Checks if a point is inside the world map
     * @param position Position of the point
     * @return True if the point is inside the map, else returns False
     */
    public boolean isInMap(Vector2d position) {
        var center = this.getCenter();
        return position.distance(center) <= size;
    }

    public double getSize() {
        return this.size;
    }
}

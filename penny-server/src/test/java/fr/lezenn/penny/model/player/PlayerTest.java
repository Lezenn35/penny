package fr.lezenn.penny.model.player;

import fr.lezenn.penny.model.color.Color;
import fr.lezenn.penny.model.maths.Vector2d;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void playerCreation() {
        var player = new Player(
                "John",
                new Color(100, 100, 100),
                new Vector2d(0, 0),
                Vector2d.UP
        );

        Assertions.assertEquals("John", player.getName());
        Assertions.assertEquals(new Color(100, 100, 100), player.getColor());
        Assertions.assertEquals(Vector2d.UP, player.getOrientation());
        Assertions.assertEquals(new Vector2d(0, 0), player.getPosition());
    }

    @Test
    public void playerMoveUpTest() {
        var player = new Player(
                "John",
                new Color(100, 100, 100),
                new Vector2d(0, 0),
                Vector2d.UP
        );

        player.move();

        Assertions.assertEquals(Vector2d.UP, player.getOrientation());
        Assertions.assertEquals(new Vector2d(0, 1), player.getPosition());
    }

    @Test
    public void playerMoveUpDownTest() {
        var player = new Player(
                "John",
                new Color(100, 100, 100),
                new Vector2d(0, 0),
                Vector2d.UP
        );

        player.move();

        player.setOrientation(Vector2d.DOWN);

        player.move();

        Assertions.assertEquals(Vector2d.DOWN, player.getOrientation());
        Assertions.assertEquals(new Vector2d(0, 0), player.getPosition());
    }

    @Test
    public void playerMoveHighSpeed() {
        var player = new Player(
                "John",
                new Color(100, 100, 100),
                new Vector2d(0, 0),
                Vector2d.UP
        );

        player.move(15);

        Assertions.assertEquals(new Vector2d(0, 15), player.getPosition());
    }
}

package fr.lezenn.penny.model.color;

import org.junit.jupiter.api.Test;

public class ColorTests {

    @Test
    public void createRedColorTest() {
        var color = new Color(255, 0, 0);
        assert color.getRed() == 255;
        assert color.getBlue() == 0;
        assert color.getGreen() == 0;
    }

}

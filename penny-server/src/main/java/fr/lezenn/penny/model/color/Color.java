package fr.lezenn.penny.model.color;

/**
 * Color representation and computation
 */
public class Color {

    private int red;
    private int blue;
    private int green;

    /**
     * Convert a color object into a html color code
     * @param color Color object to convert
     * @return HTML color code of format: #XXXXXX
     */
    public static String convertToHTMLString(Color color) {
        String sb = '#' +
                Integer.toHexString(color.red) +
                Integer.toHexString(color.blue) +
                Integer.toHexString(color.green);
        return sb;
    }

    /**
     * Convert a HTML color code into a Color object
     * @param colorCode Color code to convert
     * @return A Color object from the color code
     * @throws ColorConversionException In case the given color code do not matches the hex format of a color.
     */
    public static Color convertToColor(String colorCode) throws ColorConversionException {
        if (!colorCode.matches("(#[0-9A-F]{6})|(#[0-9A-F]{3})")) {
            throw new ColorConversionException("Failed to convert color code: " + colorCode + "\n\tinto Color object.");
        }

        colorCode = colorCode.substring(1);
        int[] numbers = new int[3];
        if (colorCode.length() == 6) {
            numbers[0] = Integer.parseInt(colorCode.substring(0, 1), 16);
            numbers[1] = Integer.parseInt(colorCode.substring(2, 3), 16);
            numbers[2] = Integer.parseInt(colorCode.substring(4, 5), 16);
        } else {
            numbers[0] = Integer.parseInt("" + colorCode.charAt(0), 16);
            numbers[1] = Integer.parseInt("" + colorCode.charAt(1), 16);
            numbers[2] = Integer.parseInt("" + colorCode.charAt(2), 16);
        }

        return new Color(numbers[0], numbers[1], numbers[2]);
    }

    /**
     * Constructor
     * @param red Red component
     * @param blue Blue component
     * @param green Green component
     */
    public Color(int red, int blue, int green) throws InvalidColorArgumentException {
        if (red < 0 || blue < 0 || green < 0) {
            throw new InvalidColorArgumentException("Color components cannot be negative.");
        }

        if (red > 255 || blue > 255 || green > 255) {
            throw new InvalidColorArgumentException("Color components should be strictly inferior to 256");
        }

        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    /**
     * Darken a color.
     * @param amount Number that defines the amount to remove for each color component.
     * @return A new color, darker than the instance.
     */
    public Color darker(int amount) {
        int nred, nblue, ngreen;

        nred = this.red - amount;
        nblue = this.blue - amount;
        ngreen = this.green - amount;

        if (nred < 0) nred = 0;
        if (nblue < 0) nblue = 0;
        if (ngreen < 0) ngreen = 0;

        return new Color(nred, nblue, ngreen);
    }

    public int getRed() {
        return red;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }
}

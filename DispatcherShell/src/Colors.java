import java.awt.Color;

public class Colors implements IColors {
	private static IColors instance;
	private Color[] sampleColors;

	private Colors() {
		sampleColors = new Color[] { Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green,
				Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow };
	}

	public static IColors getInstance() {
		if (instance == null)
			instance = new Colors();
		return instance;
	}

	@Override
	public Color getColor(int uniqueId) {
		int color1 = (uniqueId / 13) % 13;
		int color2 = uniqueId % (13 - color1);
		Color newColor = ColorSum(sampleColors[color1], sampleColors[color2]);
		return newColor;
	}

	private Color ColorSum(Color color1, Color color2) {
		int red = (color1.getRed() + color2.getRed()) % 255;
		int green = (color1.getGreen() + color2.getGreen()) % 255;
		int blue = (color1.getBlue() + color2.getBlue()) % 255;
		return new Color(red, green, blue);
	}
}
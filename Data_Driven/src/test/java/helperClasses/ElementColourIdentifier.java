package helperClasses;

import org.openqa.selenium.support.Color;

public class ElementColourIdentifier {
	public String returncolorHexVal(String color)
	{
		String hexColor = Color.fromString(color).asHex();
		return hexColor;
	}
}

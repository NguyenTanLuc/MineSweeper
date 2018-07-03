package view;

public class FactoryMethodIcon {
	Icon icon;
	public Icon createIcon(String titel) {
		if (titel.equals("DisplayClassic")) {
			return icon = new  IconDisplay1();
		} else {
			return icon =new IconDisplay2();
		}

	}
}

package view;

public class AbtractFactory {

	public AbtractFactory() {
	}

	public static Icon createIcon(String titel) {
		if (titel.equals("DisplayClassic")) {
			return new IconDisplay1();
		} else {
			return new IconDisplay2();
		}
	}

	public static Dialog creatDiaLog(String tyle) {
		if (tyle.equals("DialogWin")) {
			return new DialogWin();

		}
		if (tyle.equals("DialogLose")) {
			return new DialogLose();

		}
		if (tyle.equals("DialogAbout")) {
			return new DialogAbout();
		}
		if (tyle.equals("ChangDisPlay")) {
			return new DialogChangeDisplay();

		}
		return null;

	}

}

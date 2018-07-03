package view;

public class FactoryMethodDialog {
	Dialog dialog;
	
	public Dialog creatDiaLog(String tyle) {
		if (tyle.equals("DialogWin")) {
			return dialog= new DialogWin();
		}
		if (tyle.equals("DialogLose")) {
			return dialog=new DialogLose();
		}
		if (tyle.equals("DialogAbout")) {
			return dialog =new  DialogAbout();
		}
		if (tyle.equals("PlayWin")) {
			return dialog = new  DialogTextPlayer();

		}
		return null;

	}

}

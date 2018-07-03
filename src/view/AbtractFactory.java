package view;

public class AbtractFactory {

	private FactoryMethodDialog dialog;
	private FactoryMethodIcon icon;

	public AbtractFactory(FactoryMethodDialog dialog, FactoryMethodIcon icon) {
		this.dialog = dialog;
		this.icon = icon;
	}

	public Icon createIcon(String titel) {
		return icon.createIcon(titel);

	}

	public Dialog creatDiaLog(String tyle) {
		return dialog.creatDiaLog(tyle);

	}

}

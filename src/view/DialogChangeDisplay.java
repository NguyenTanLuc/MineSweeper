package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class DialogChangeDisplay implements Dialog{
	public DialogChangeDisplay() {
		Alert chang = new Alert(AlertType.CONFIRMATION);
		chang.setTitle("Set Display Game");
		chang.setHeaderText("Select a display like it");
		
		ButtonType change1 = new ButtonType("Classic");
		ButtonType change2 = new ButtonType("Techonory");
		
		chang.getButtonTypes().clear();
		chang.getButtonTypes().addAll(change1,change2);
		chang.showAndWait();
	}
	
	

}

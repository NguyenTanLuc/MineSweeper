package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DialogLose implements Dialog{
	public DialogLose (){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("OOps");
		alert.setHeaderText("Game Over");
		alert.setContentText("BUMMMMMMMMMMMMMMMM Game Over");
		alert.showAndWait();
		
	}

}

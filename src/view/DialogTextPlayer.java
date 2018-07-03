package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Player;
import model.SavePlayerWin;

public class DialogTextPlayer implements Dialog {
	SavePlayerWin playerWin ;

	public DialogTextPlayer () {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Player Win Game");
		a.setHeaderText("Playr Win");
		if (Player.list.size() !=0) {
			 playerWin = new SavePlayerWin();
			a.setContentText(playerWin.getString());
		}else {
			a.setContentText("Gia Đình Tin Bạn Sẽ Win");
		}
		
		a.showAndWait();
	}


	public static DialogTextPlayer label;


	public static DialogTextPlayer newInstance() {
		if (label == null) {
			label = new DialogTextPlayer();
		}
		return label;
	}

}

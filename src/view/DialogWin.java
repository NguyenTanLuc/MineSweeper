package view;

import java.util.Optional;

import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Player;

public class DialogWin implements view.Dialog {

	public DialogWin() {
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setTitle("Congratulation");
		dialog.setHeaderText("Wowwwwwwwwwwwwwwwww You Win");
		dialog.setResizable(true);

		Label label1 = new Label("Name: ");
		TextField text1 = new TextField();

		GridPane grid = new GridPane();
		grid.add(label1, 1, 1);
		grid.add(text1, 2, 1);
//		grid.add(label2, 1, 2);
//		grid.add(text2, 2, 2);
		dialog.getDialogPane().setContent(grid);

		ButtonType buttonTypeOk = new ButtonType("Okay", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
		Optional<ButtonType> result = dialog.showAndWait();
		if (result.get() == ButtonType.OK) {
			Player player = new Player(text1.getText(),"");
			Player.list.add(player);

		}

	}


}

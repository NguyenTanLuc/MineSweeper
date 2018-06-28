package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public interface Observer {

	void update(int i, int j, Button[][] cell);

	void update(Button[][] cell);
}

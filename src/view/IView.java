package view;

import controller.Observer;
import javafx.scene.control.Button;

public interface IView extends Observer {

	void start(String[] args);

	Button[][] getCell();


}

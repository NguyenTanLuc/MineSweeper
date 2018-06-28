package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public interface Subject {
	void removeOb(Observer ob);

	void addOb(Observer ob);

	void notifyy(int i , int j,Button[][] cell);

}

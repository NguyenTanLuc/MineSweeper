package model;

import java.util.TimerTask;

import controller.Controller;
import javafx.application.Platform;
import javafx.scene.control.Labeled;

public class TaskTimer extends TimerTask {
	Labeled labeled;
	boolean stop;
	boolean ketThuc;

	public TaskTimer(Labeled labeled) {
		this.labeled = labeled;
		this.labeled.setText("0");
	}

	@Override
	public void run() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				if (stop && !ketThuc) {
					ketThuc = true;
					stop = true;
				} else {
					if (!ketThuc)
						as();
				}
			}
		});
	}

	public void as() {
		String x = (Integer.parseInt(labeled.getText()) + 1) + "";
		labeled.setText(x);
		if (x.equals("0"))
			stop = true;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public boolean isStop() {
		return stop;
	}

	Controller controller;

	public void setController(Controller controller) {
		this.controller = controller;
	}
}

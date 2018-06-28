package model;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class LabelTimer extends Text{
	boolean stop = true;
	int min =0;
	int secon =0;
	public LabelTimer(Text text) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (stop) {
						Thread.sleep(1000);
						secon++;
						text.setText(min+"  :  "+secon);
						if (secon ==60) {
							secon =0;
							 min++;
							
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		t.start();
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	

}


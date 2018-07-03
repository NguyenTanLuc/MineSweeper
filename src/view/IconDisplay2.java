package view;

import java.io.InputStream;

import extension.Ultis;
import javafx.scene.image.Image;

public class IconDisplay2 implements Icon {
	String link;
	int x,y;
	public IconDisplay2() {
		this.link = "/icon3";
		if(Board.level ==  Ultis.EASY) {
			this.x = 45;
			this.y = 45;
		}else if(Board.level ==  Ultis.NORMAL) {
			this.x = 25;
			this.y = 25;
		}else {
			this.x = 18;
			this.y = 18;
		}
	}

	@Override
	public Image getNumber0() {
		InputStream iconNewg = this.getClass().getResourceAsStream(link + "/00.png");
		Image i = new Image(iconNewg, x, y, true, true);

		return i;
	}

	@Override
	public Image getNumber1() {
		InputStream iconNewg = this.getClass().getResourceAsStream(link + "/01.png");
		Image i = new Image(iconNewg, x, y, true, true);

		return i;
	}

	@Override
	public Image getNumber2() {
		InputStream iconNewg = this.getClass().getResourceAsStream(link + "/02.png");
		Image i = new Image(iconNewg, x, y, false, false);

		return i;
	}

	@Override
	public Image getNumber3() {
		InputStream iconNewg = this.getClass().getResourceAsStream(link + "/03.png");
		Image i = new Image(iconNewg, x, y, false, false);

		return i;
	}

	@Override
	public Image getNumber4() {
		InputStream iconNewg = this.getClass().getResourceAsStream(link + "/04.png");
		Image i = new Image(iconNewg, x, y, false, false);

		return i;
	}

	@Override
	public Image getNumber5() {
		InputStream iconNewg = this.getClass().getResourceAsStream(link + "/05.png");
		Image i = new Image(iconNewg, x, y, false, false);

		return i;
	}

	@Override
	public Image getNumber6() {
		InputStream iconNewg = this.getClass().getResourceAsStream(link + "/06.png");
		Image i = new Image(iconNewg, x, y, false, false);

		return i;
	}

	@Override
	public Image getMine() {
		InputStream iconNewg = this.getClass().getResourceAsStream(link + "/mine.png");
		Image i = new Image(iconNewg, x, y, false, false);

		return i;
	}

	@Override
	public Image getFlag() {
		InputStream iconNewg = this.getClass().getResourceAsStream(link + "/Flag.png");
		Image i = new Image(iconNewg, x, y, false, false);

		return i;
	}

}

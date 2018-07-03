package model;

public class CheckLose implements ICheck {

	public CheckLose() {
	}

	public boolean check(int i, int j,CreatMine mine, OpenCell check) {
		if (mine.getMine()[j][i] == -1) {
			if (check.getCheck()[j][i] == true) {
				return true;

			}
		}
		return false;
	}

}

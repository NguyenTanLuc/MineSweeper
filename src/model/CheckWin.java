package model;

public class CheckWin implements ICheck {

	public CheckWin() {
	}

	public boolean check(int i, int j, CreatMine mine, OpenCell check) {
		for (i = 0; i < mine.getMine().length; i++) {
			for (j = 0; j < mine.getMine().length; j++) {
				if (mine.getMine()[j][i] != -1) {
					if (check.getCheck()[j][i] != true) {
						return false;

					}

				}
				if (check.isLose() == true) {
					return false;

				}

			}
		}
		return true;

	}

}

package model;

public class CheckWin implements ICheck {
	public CreatMine mine;
	public Open check;

	public CheckWin(CreatMine mine, Open check) {
		this.mine = mine;
		this.check = check;
	}

	public boolean check(int i, int j) {
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

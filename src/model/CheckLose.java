package model;

public class CheckLose implements ICheck {
	private CreatMine mine;
	private Open check;

	public CheckLose(CreatMine mine, Open check) {
		this.mine = mine;
		this.check = check;
	}

	public boolean check(int i, int j) {
		if (mine.getMine()[j][i] == -1) {
			if (check.getCheck()[j][i] == true) {
				return true;

			}
		}
		return false;
	}

}

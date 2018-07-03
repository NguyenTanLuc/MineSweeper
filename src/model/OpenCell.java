package model;

import java.awt.Point;
import java.util.Queue;

public class OpenCell {
	CreatMine board;
	boolean[][] check;
	boolean lose;
	boolean win;
	int[][] a;
	private ICheck icheckOver;

	public OpenCell(CreatMine mine) {
		this.board = mine;
		a = board.getMine();
		check = new boolean[a.length][a[0].length];
	}

	public boolean[][] getCheck() {
		return check;
	}

	public void openCell(int i, int j, Queue<Point> queue) {

		for (int k = i - 1; k < i + 2; k++) {
			for (int l = j - 1; l < j + 2; l++) {
				if (k >= 0 && l >= 0 && k < a.length && l < a[i].length) {
					if (a[i][j] == 0) {
						if (check[k][l] == false) {
							check[k][l] = true;
							queue.add(new Point(k, l));

						}
					}

				}

			}
		}

	}

	public boolean check(int i, int j) {
		if (a[j][i] == -1 && check[j][i] == true) {
			icheckOver = new CheckLose();
			lose = icheckOver.check(i, j,board,this);

		} else {
			icheckOver = new CheckWin();
			win = icheckOver.check(i, j,board,this);
		}
		return true;
	}

	public void spreadCell(IModel mine, Queue<Point> a) {
		if (a.isEmpty()) {
			return;
		}
		Point point = a.poll();
		openCell(point.x, point.y, a);
		spreadCell(mine, a);

	}

	public boolean isLose() {
		return lose;
	}

	public boolean isWin() {
		return win;
	}

}
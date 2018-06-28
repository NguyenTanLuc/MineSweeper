package model;

import java.awt.Point;
import java.util.Queue;

public class Open {
	CreatMine board;
	boolean[][] check;
	boolean lose;
	boolean win;
	int[][] a;
	private ICheck icheckOver;

	public Open(CreatMine mine) {
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

	public boolean check (int i , int j) {
		if (a[j][i] == -1 && check[j][i]== true) {
			icheckOver = new CheckLose(board, this);
			lose = icheckOver.check(i, j);
			
		}else {
			icheckOver = new CheckWin(board, this);
			win = icheckOver.check(i, j);
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

	private void printCheck() {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(check[i][j] + "\t");
			}
			System.out.println();
		}
	}

	// public static void main(String[] args) {
	// CreatMine creatMine = new CreatMine(10, 10, 20);
	// Open action = new Open(creatMine);
	// creatMine.in();
	// Queue<Point> points = new LinkedList<>();
	// lb: for (int i = 0; i < creatMine.getMine().length; i++) {
	// for (int j = 0; j < creatMine.getMine().length; j++) {
	// if (creatMine.getMine()[i][j] == 0) {
	// points.add(new Point(i, j));
	// break lb;
	// }
	// }
	//
	// }
	// action.spreadCell(creatMine, points);
	// action.printCheck();
	//
	// }

	
}
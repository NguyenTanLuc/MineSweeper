package model;

import java.awt.Point;
import java.util.Queue;
import java.util.Random;

public class CreatMine {
	private int size;
	private int size2;
	private int boom;
	private int[][] Mine;

	public CreatMine(SizeBoard sizeBoard) {
		this.size = sizeBoard.getHight();
		this.size2 = sizeBoard.getWieght();
		this.boom = sizeBoard.getBoom();
		this.Mine = new int[size][size2];
		setMine();
		setNumber();
	}
	public void setSize(int size) {
		this.size = size;
		this.size2 = size;
	}

	public void setMine() {
		Random rd = new Random();
		int countMine = 0;
		while (countMine < boom) {
			int i = rd.nextInt(size);
			int j = rd.nextInt(size2);
			if (this.Mine[i][j] != -1) {
				this.Mine[i][j] = -1;
				countMine++;

			}
		}

	}

	public void setNumber() {
		for (int i = 0; i < Mine.length; i++) {
			for (int j = 0; j < Mine[0].length; j++) {
				for (int k = i - 1; k < i + 2; k++) {
					for (int l = j - 1; l < j + 2; l++) {
						if (this.Mine[i][j] != -1) {
							if (k >= 0 && l >= 0 && k < size && l < size2) {
								if (this.Mine[k][l] == -1) {
									this.Mine[i][j]++;
								}
							}
						}
					}

				}

			}

		}

	}

	public void in() {
		for (int i = 0; i < Mine.length; i++) {
			for (int j = 0; j < Mine.length; j++) {
				System.out.print(Mine[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public int getSize() {
		return size;
	}

	public int getSize2() {
		return size2;
	}

	public int getBoom() {
		return boom;
	}

	public int[][] getMine() {
		return this.Mine;
	}

	// public static void main(String[] args) {
	// CreatMine a = new CreatMine(10, 10, 20);
	// a.in();
	//
	// }


	public boolean isLose() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isWin() {
		// TODO Auto-generated method stub
		return false;
	}

}

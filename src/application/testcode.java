package application;

public class testcode {
	public static int[][] test(int[][] Mine) {
		for (int i = 0; i < Mine.length; i++) {
			for (int j = 0; j < Mine[0].length; j++) {
				for (int k = i - 1; k < i + 2; k++) {
					for (int l = j - 1; l < j + 2; l++) {
						if (Mine[i][j] != -1) {
							if (k >= 0 && l >= 0 && k < Mine.length && l < Mine.length) {
								if (Mine[k][l] == -1) {

									Mine[i][j]++;
								}
							}
						}

					}

				}

			}
		}
		return Mine;

	}

	public static void inman(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j]+ "\t");
			}
			System.out.println();

		}
	}

	public static void main(String[] args) {
		int[][] a = new int[5][5];
		a[0][0] = -1;
		a[0][1] = -1;
		;
		a[3][4] = -1;
		a[3][3] = -1;
		a[4][1] = -1;
		a[4][2] = -1;
		a[4][4] = -1;
		inman(test(a));

	}
}
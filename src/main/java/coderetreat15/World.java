package coderetreat15;

public class World {
	int matrix[][];

	public World(int[][] matrix) {
		this.matrix = matrix;
	}

	public int getNeigbor(int row, int column) {
		int count = 0;
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = column - 1; j <= column + 1; j++) {
				if (isOutOfWorld(i, j) || isSameCell(i, j, row, column)) {
					continue;
				}
				if (isAlive(i, j))
					count++;
			}
		}
		return count;
	}

	private boolean isAlive(int i, int j) {
		return matrix[i][j] == 1;
	}

	private boolean isSameCell(int i, int j, int row, int column) {
		return i == row && j == column;
	}

	private boolean isOutOfWorld(int row, int col) {
		return row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[row].length - 1;
	}

	public int[][] next() {
		int[][] next = new int[matrix.length][matrix.length];
		for (int i=0; i<matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int neighbor = getNeigbor(i, j);
				if (neighbor < 2 || neighbor > 3) {
					next[i][j] = 0;
				} else if (neighbor == 3) {
					next[i][j] = 1;
				} else {
					next[i][j] = matrix[i][j];
				}
			}
		}
		return next;
	}

}

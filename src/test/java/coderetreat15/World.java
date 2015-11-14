package coderetreat15;

public class World {

	private int[][] matrix;
	
	public World(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public boolean isDead(final int row, final int column) {
		return matrix[row][column] == 0;
	}

	public int countNeighbor(int row, int column) {
		int neighbor = 0;
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = column - 1; j <= column + 1; j++) {
				if (isOutOfMatrix(i, j) || isSameCell(i, j, row, column)) {
					continue;
				}
				if (isAlive(i, j)) {
					neighbor++;
				}
			}
		}
		return neighbor;
	}

	private boolean isAlive(int i, int j) {
		return !isDead(i, j);
	}

	private boolean isSameCell(int i, int j, int row, int column) {
		return i == row && j == column;
	}

	private boolean isOutOfMatrix(int row, int column) {
		return row < 0 || column < 0 || row > matrix.length || column > matrix[row].length;
	}

	public int[][] nextWorld() {
		int[][] next = new int[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int count = countNeighbor(i, j);
				if (count < 2 || count > 3) {
					next[i][j] = 0;
					continue;
				} 
				
			}
		}
		return next;
	}

}

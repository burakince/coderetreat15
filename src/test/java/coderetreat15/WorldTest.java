package coderetreat15;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorldTest {

	@Test
	public void shouldReturnNeigbors() throws Exception {
		int[][] matrix = { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
		World world = new World(matrix);
		int row = 0;
		int column = 0;
		assertEquals(2, world.getNeigbor(row, column));
	}

	@Test
	public void shouldReturnNextWorld() throws Exception {
		int[][] matrix = { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
		int[][] expacted = { { 0, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 } };

		World world = new World(matrix);
		assertAllEquals(expacted, world.next());
	}

	private void assertAllEquals(int[][] expacted, int[][] next) {
		for (int i = 0; i < expacted.length; i++) {
			assertEquals(expacted[i], next[i]);
		}
	}

}

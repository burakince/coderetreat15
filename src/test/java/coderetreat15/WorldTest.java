package coderetreat15;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorldTest {

	private static final int COLUMN = 1;
	private static final int ROW = 0;
	private World world;

	@Test
	public void whenHasNeighborShouldCellDead() throws Exception {
		int[][] matrix = new int[3][3];
		world = new World(matrix);
		assertTrue(world.isDead(ROW, COLUMN));
	}
	
	@Test
	public void shouldReturnNeighbor() throws Exception {
		int[][] matrix = {{0, 0, 0}, {1, 0, 1}, {0, 1, 0}};
		world = new World(matrix);
		assertEquals(2, world.countNeighbor(ROW, COLUMN));
	}

	@Test
	public void shouldReturnNextWorld() throws Exception {
		int[][] matrix = {{0, 0, 0}, {1, 0, 1}, {0, 1, 0}};
		world = new World(matrix);
		int[][] expected = {{0, 0, 0}, {0, 1, 0}, {0, 1, 0}};
		assertAllEquals(expected, world.nextWorld());
	}

	private void assertAllEquals(int[][] expected, int[][] nextWorld) {
		for (int i=0; i<expected.length; i++) {
			assertEquals(expected[i], nextWorld[i]);
		}
	}
	
}

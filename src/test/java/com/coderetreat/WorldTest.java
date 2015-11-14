package com.coderetreat;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WorldTest {

	private World world;

	@Before
	public void setup() {
		int[][] matrix = new int[3][3];
		matrix[0][1] = 1;
		matrix[1][1] = 1;
		matrix[2][1] = 1;
		world = new World(matrix);
	}

	@Test
	public void when_has_1_neighbor_should_cell_dead() {
		assertTrue(world.isDead(0, 1));
	}

	@Test
	public void when_has_not_any_neighbor_should_cell_dead() throws Exception {
		int[][] matrix = new int[3][3];
		world = new World(matrix);
		assertTrue(world.isDead(0, 1));
	}

	@Test
	public void when_has_3_neighbors_should_cell_alive() throws Exception {
		assertFalse(world.isDead(1, 0));
	}
}

package org.jpacman.test.framework.model;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.jpacman.framework.model.Board;
import org.jpacman.framework.model.Direction;
import org.jpacman.framework.model.Tile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Test the Board.tileAt method by means of a series of test cases with
 * Parameterized data.
 *
 * @author Arie van Deursen, TU Delft, Feb 10, 2012
 */
@RunWith(Parameterized.class)
public class BoardTileAtTest {
	/**
	 * Test.
	 *
	 * @author Saeed
	 */
	private int startx, starty;
	/**
	 * Test.
	 *
	 * @author Saeed
	 */
	private Direction dir;
	/**
	 * Test.
	 *
	 * @author Saeed
	 */
	private int nextx, nexty;
	/**
	 * Test.
	 *
	 * @author Saeed
	 */
	private Board board;
	/**
	 * Test.
	 *
	 * @author Saeed
	 */
	private static final int WIDTH = 10;
	/**
	 * Test.
	 *
	 * @author Saeed
	 */
	private static final int HEIGHT = 20;
	/**
	 * @param x Test.
	 * @param y Test.
	 * @param d Test.
	 * @param nx Test.
	 * @param ny Test.
	 *
	 * @author Saeed
	 */
	public BoardTileAtTest(final int x, final int y, final Direction d,
			final int nx, final int ny) {
		startx = x;
		starty = y;
		dir = d;
		nextx = nx;
		nexty = ny;
		board = new Board(WIDTH, HEIGHT);
	}

	/**
	 * Test.
	 */
	@Test
	public void testTileAtDirection() {
		Tile source = board.tileAt(startx, starty);
		Tile actual = board.tileAtDirection(source, dir);
		Tile desired = board.tileAt(nextx, nexty);
		assertEquals(desired, actual);
	}

	/**
	 * Test.
	 *
	 * @return Test.
	 */
	@Parameters
	public static Collection<Object[]> data() {
		final int v1 = 3, v2 = 2;
		Object[][] values = new Object[][] {
				// x-axis boundaries, y random inpoints
				// left boundary
				{2, 2, Direction.UP, 2, 1 },
				{2, 2, Direction.DOWN, 2, v1},
				{2, 2, Direction.LEFT, 1, 2 },
				{2, 2, Direction.RIGHT, v1, v2},
				// worm holes
				{0, 2, Direction.LEFT, WIDTH - 1, 2 },
				{WIDTH - 1, 2, Direction.RIGHT, 0, 2 },
				{2, 0, Direction.UP, 2, HEIGHT - 1 },
				{2, HEIGHT - 1, Direction.DOWN, 2, 0 } };
		return Arrays.asList(values);
	}

}

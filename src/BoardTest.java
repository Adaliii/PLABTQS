import static org.junit.Assert.*;

import org.junit.Test;



public class BoardTest {
	@Test
	public void testBoard() {
		Board board = new Board();
		for(int i = 0; i<10;i++) {
			for(int j=0;j<10;j++) {
				assertEquals(board.getBoard()[i][j], Board.cell.water);
			}
		}
		
	}
	@Test
	public void testConvertLetter() {
		Board board = new Board();
		String lletra = "A1";
		int[] pos = new int[2];
		pos[0]=0;
		pos[1]=0;
		assertArrayEquals(board.convertStringToPosition(lletra), pos);
	}
	
	@Test
	public void testGetSetDimention() {
		Board board = new Board();
		board.setDimention(3);
		assertEquals(board.getDimention(), 3);
	}
	
	@Test
	public void testVerticalInsertBoat() {
		Board board = new Board();
		String lletra = "B1";
		boolean orientation = false;
		int length = 3;
	    	board.insertBoat(lletra, orientation, length);
	    	assertEquals(board.getBoard()[1][0], Board.cell.boat); // B1
	    	assertEquals(board.getBoard()[2][0], Board.cell.boat); // C1
	   	 assertEquals(board.getBoard()[3][0], Board.cell.boat); // D1
	}
	
	@Test
	public void testHorizontalInsertBoat() {
		Board board = new Board();
	    board.insertBoat("B1", true, 3); // insert in B1 a lenght 3 horizontal boat
	    assertEquals(board.getBoard()[1][0], Board.cell.boat); // B1
	    assertEquals(board.getBoard()[1][1], Board.cell.boat); // B2
	    assertEquals(board.getBoard()[1][2], Board.cell.boat); // B3
	}
	
	@Test
	public void testMakeMoveMiss() {
		Board board = new Board();
		board.insertBoat("B1", true, 3);
		assertEquals(board.makeMoveHit("A1"), false);
		assertEquals(board.getBoard()[0][0], Board.cell.miss);
	}
	
	@Test
	public void testMakeMoveHit() {
		Board board = new Board();
		board.insertBoat("B1", false, 3);
		board.makeMoveHit("B1");
		assertEquals(board.getBoard()[1][0], Board.cell.hit);
	}

}

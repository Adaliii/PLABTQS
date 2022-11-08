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
	

}

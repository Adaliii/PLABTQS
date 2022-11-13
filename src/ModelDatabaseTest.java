import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class ModelDatabaseTest {

	@Test
	public void testConnect() throws IOException {
		//Reads file data
		ModelDatabase DB = new ModelDatabase("./TestRanking.txt");
		assertTrue(DB.connect());
		
		
		//creates new file of unexistent file
		File deleter = new File("./TestRanking.txt");
		deleter.delete();
		ModelDatabase DB2 = new ModelDatabase("./TestRanking.txt");
		assertTrue(DB2.connect());
		
	}
	  
	@Test 
	public void testModifyRanking() throws IOException {
		Player winner = new Player("Juan", new Board());
		ModelDatabase DB = new ModelDatabase("./TestRanking.txt");
		DB.connect();
		assertTrue(DB.modifyRanking(winner));
		Player winner2 = new Player("Lionel", new Board());
		assertTrue(DB.modifyRanking(winner2));
		assertTrue(DB.modifyRanking(winner2));
	}
	
	@Test
	public void testDisconnect() throws IOException {
		ModelDatabase DB = new ModelDatabase("./TestRanking.txt");
		DB.connect();
		assertTrue(DB.disconnect());
	}

}

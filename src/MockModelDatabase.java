import java.io.IOException;
import java.util.TreeMap;

public class MockModelDatabase extends ModelDatabase {
	public MockModelDatabase(String fileName) {
		super(fileName);
	}

	public String name = null;
	@Override 
	public boolean connect() throws IOException {
		return true;
	}
	
	@Override
	public boolean modifyRanking(Player p) throws IOException {
		name = p.getName();
		return true;
	}
	 
	@Override
	public TreeMap<String, Integer> getRanking(){
		TreeMap<String, Integer> mockRank = new TreeMap<String, Integer>();
		
		mockRank.put(name, 1);
		
		return mockRank;
	}
}

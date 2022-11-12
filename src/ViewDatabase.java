import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Collections;
public class ViewDatabase {
	public void showRanking(TreeMap<String, Integer> ranking) {
		TreeMap<String, Integer> rank = new TreeMap<String, Integer> (Collections.reverseOrder());
		System.out.println("Ranking actual:");
		System.out.println("(Nom, Wins)");
		for(Entry<String, Integer> entry : ranking.entrySet()) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
	}
}

import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
public class ViewDatabase {
	public void showRanking(TreeMap<String, Integer> ranking) {
		TreeMap<String, Integer> rank = new TreeMap<String, Integer> (Collections.reverseOrder());
		System.out.println("Ranking actual:");
		System.out.println("(Nom, Wins)");
		SortedSet<Entry<String, Integer>> entries = ModelDatabase.entriesSortedByValues(ranking);
		int size = entries.size(); 
		String[] keys = new String[size];
		int[] values = new int[size];
		int j = 0;
		for(Entry<String, Integer> entry : entries) {
			values[j] = entry.getValue();
			keys[j] = entry.getKey();
			j++;
		}
		for(int i = 0; i < size; i++) {
			System.out.println(keys[size-i-1] + ", " + values[size-i-1]);
		}
	}
} 

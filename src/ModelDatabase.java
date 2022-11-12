import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.io.BufferedReader;


public class ModelDatabase {
	
	private String fileName = "./Ranking.txt";
	public TreeMap<String, Integer> ranking = new TreeMap<String,Integer>();
	
	public ModelDatabase() {
		//takes default values
	}
	
	public ModelDatabase(String fileName){
		this.fileName = fileName;
	}
	
	public TreeMap<String, Integer> getRanking(){
		return ranking;
	}
	
	//Sorts entries of a Map by value instead of by key (from minor to major)
	static <K,V extends Comparable<? super V>>
	SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
	        new Comparator<Map.Entry<K,V>>() {
	            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
	                int res = e1.getValue().compareTo(e2.getValue());
	                return res != 0 ? res : 1;
	            }
	        }
	    );
	    sortedEntries.addAll(map.entrySet());
	    return sortedEntries;
	}
	
	//"Connects" to database (reads file content or creates new file if fileName does not exist)
	public boolean connect() throws IOException {
		
		File file = new File(fileName);
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
			//Only done if ranking previously existed
            String line;
            while ((line = br.readLine()) != null) {
                String name = line.split("\t")[0];
                int wins = Integer.valueOf(line.split("\t")[1]);
                ranking.put(name, wins);    
            }
        } catch (IOException e) {
        	file.createNewFile();
        }
		
		
		return true;
	}
	
	//Updates Ranking and updates the file containing the ranking
	public boolean modifyRanking(Player p) throws IOException {
		/*
		 * Manipular fileContent i actualitzar el arxiu de text
		 */
		FileWriter fw;
		File txt = new File(fileName);
		txt.delete();
		txt = new File(fileName);
		txt.createNewFile();
		fw = new FileWriter(txt, false);
		 
		
		String content = ""; 
		if(!ranking.containsKey(p.getName())) {
			ranking.put(p.getName(), 1);
		}
		else {
			ranking.put(p.getName(), ranking.get(p.getName()) +1 );
		}
		
		SortedSet<Entry<String, Integer>> entries = entriesSortedByValues(ranking);
		ranking.clear();
		
		for (Entry<String, Integer> entry : entries) {
			ranking.put( entry.getKey(), entry.getValue());
			content = content + entry.getKey() + "\t" + entry.getValue() + "\n";
		}
		fw.write(content);
		fw.close();
		return true;
		
	}
	
	//disconnects from "database"
	public boolean disconnect() {
		return true;
	}
}

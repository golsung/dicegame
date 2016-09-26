package insang.hansung.dicegame;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Scores implements Serializable {
	private ArrayList<Entry> scores;
	
		public Scores() {
			scores = new ArrayList<Entry>();
		}

	public ArrayList<Entry> getScores() {
		return scores;
	}

	public void addScore(Entry score) {
		scores.add(score);
	}

	public Entry getEntry(String playerName) {
		Iterator<Entry> it = scores.iterator();
		Entry entry;
		while (it.hasNext()) {
			entry = it.next();
			if (entry.getName().equals(playerName)) return entry;
		}
		entry = new Entry(playerName, 0, 0, 0);
		addScore(entry);
		return entry;
	}

	public List getList() {
		final List list = new List();
		Iterator<Entry> it = scores.iterator();
		Entry entry;
		while (it.hasNext()) {
			entry = it.next();
			list.add( entry.getName()+ ":"+entry.getWin()+" wins "+entry.getLose()+" loses "+entry.getDraw()+" draws ");
		}

		return list;
	}

}

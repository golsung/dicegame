package insang.hansung.dao;

import insang.hansung.dicegame.Scores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ScoreDAO  {
	static String filename="score2.dat";
	public static void save(Scores scores) throws Exception {
		FileOutputStream ostream = new FileOutputStream(filename);
		ObjectOutputStream p = new ObjectOutputStream(ostream);
		p.writeObject(scores); 
		p.flush();
		ostream.close();
	}
	public static Scores  load() throws Exception  {
		FileInputStream istream;
		
		try {
			istream = new FileInputStream(filename);
			ObjectInputStream q = new ObjectInputStream(istream);
			Scores scr = (Scores)q.readObject();
			istream.close();
			return scr;
		}
		catch (FileNotFoundException e) {
			File scoreFile = new File("score2.dat");
		}
		return null; 
	}
}

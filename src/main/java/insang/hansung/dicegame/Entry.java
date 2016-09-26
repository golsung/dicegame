package insang.hansung.dicegame;

import java.io.Serializable;

public class Entry implements Serializable {
	private String name;
	private int win;
	private int lose;
	private int draw;
	
	public Entry(String playerName, int w, int l, int d) {
		this.name = playerName;
		this.win = w;
		this.lose = l;
		this.draw = d;
	}
	public Entry() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	
}

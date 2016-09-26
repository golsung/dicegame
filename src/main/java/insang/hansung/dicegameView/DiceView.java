package insang.hansung.dicegameView;

import insang.hansung.dicegame.DiceGame;
import insang.hansung.dicegame.Entry;
import insang.hansung.dicegame.Scores;
import insang.hansung.dicegame.WinningStatus;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class DiceView extends Frame {
	private TextField dice1;
	private TextField dice2;
	private Label cell1;
	private Label cell2;
	private DiceGame dicegame;
	
	Panel p1, p2;
	
	public DiceView(final String playerName, final DiceGame dicegame) {
		super("Dice View");
		this.dicegame = dicegame;
		dice1 = new TextField(5);
		dice2 = new TextField(5);
		cell1 = new Label();
		cell2 = new Label();
		
		p1 = new Panel();
		p2 = new Panel();
		
		final Button rollBut = new Button("Roll");
		p1.add(rollBut);
		Button cancelBut = new Button("Exit");
		setLayout(new FlowLayout());
		p1.add(new Label(playerName+" face value"));
		p1.add(dice1);
		p1.add(new Label("AlphaDice face value"));
		p1.add(dice2);
		p1.add(rollBut);
		p1.add(cancelBut);
		
		p2.setLayout(new GridLayout(2,2));
		p2.add(new Label(playerName));
		p2.add(cell1 );
		p2.add(new Label("AlphaDice"));
		p2.add(cell2);
	
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.EAST);
		add(p2, BorderLayout.WEST);
		
		rollBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {			
				WinningStatus ws = dicegame.roll();
				dice1.setText(String.valueOf(dicegame.getFaceValue1()));
				dice2.setText(String.valueOf(dicegame.getFaceValue2()));
				if (ws == WinningStatus.NotYet) {
					cell1.setText(String.valueOf(dicegame.getCurCellPos1()));
					cell2.setText(String.valueOf(dicegame.getCurCellPos2()));
				}
				else {
					String message;
					Scores scores = dicegame.load();
					Entry entry;
					if (scores == null ) {
						scores = new Scores();
						entry = new Entry(playerName, 0, 0, 0);
						scores.addScore(entry);
					}
					
					entry = scores.getEntry(playerName);
					
				
					if (ws == WinningStatus.Draw) { 
						entry.setDraw(entry.getDraw()+1);
						message = "Draw";
					}
					else if (ws == WinningStatus.Player) { 
						entry.setWin(entry.getWin()+1);
						message = playerName+" wins";
					}
					else  { 
						entry.setLose(entry.getLose()+1);
						message = "AlphaDice wins";
					}
					
					dicegame.save(scores);
			
					new ResultView(message, entry);
					setVisible(false);
					dispose();
					
				}
			}
			
		});
		
		cancelBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
			
		});
		
		setSize(600, 100);
		setVisible(true);
		
	}

}

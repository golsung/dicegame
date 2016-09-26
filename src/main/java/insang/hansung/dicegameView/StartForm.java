package insang.hansung.dicegameView;

import insang.hansung.dicegame.DiceGame;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartForm extends Frame {	
	TextField nametf;
	String name;
	DiceGame dicegame;
	
	Panel p1;
	Panel p2;
	
	public StartForm(String title) {
		super(title);
		Button configBut = new Button("Configure");
		Button playBut = new Button("Play");

		Button exitBut = new Button("Exit");
		
		p1 = new Panel();
		p2 = new Panel();
		
		nametf = new TextField(20);
		
		setLayout(new FlowLayout());
	
		p1.add(nametf);
		p1.add(playBut);
		
		add(p1);
		
		p2.add(configBut);

		p2.add(exitBut);
		
		add(p2);
		
		playBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (dicegame == null) dicegame = new DiceGame();
				name = nametf.getText();
				new DiceView(name, dicegame);	
				setVisible(false);
				dispose();
			}
			
		});
		
		
		exitBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);		
			}
			
		});
		
		setSize(300, 150);
		setVisible(true);
	}

}

package insang.hansung.dicegameView;

import insang.hansung.dicegame.DiceGame;
import insang.hansung.dicegame.Entry;
import insang.hansung.dicegame.WinningStatus;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultView extends Frame {
	private Label message;
	
	public ResultView(final String msg, final Entry entry) {
		super("Result View");

		message = new Label(msg);
		Button scorebut = new Button("Score");
		Button cancelbut = new Button("Exit");
		setLayout(new FlowLayout());
		add(message);
		add(scorebut);
		add(cancelbut);
		
		message.setText(msg);
		
		scorebut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new ScoreView();

			}

		});

		cancelbut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
			
		});
		
		setSize(500, 100);
		setVisible(true);
		
	}

}

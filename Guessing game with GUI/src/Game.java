import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame
{
	JLabel title = new JLabel() ;
	JLabel lower = new JLabel();
	JLabel and = new JLabel();
	JLabel upper = new JLabel();
	JLabel message = new JLabel();
	JTextField answer = new JTextField(30);
	JButton guess = new JButton("Guess");
	JButton restart = new JButton("Restart");
	
	GameLogic g = new GameLogic();
	
	void restart()
	{
		g = new GameLogic();
		title.setText("You have to guess a number between");
		lower.setText("1");
		and.setText("&");
		upper.setText("100");
		message.setText("Enter your guess");
		g.begin();
		restart.setVisible(false);
	}

	Game()
	{			
		title.setText("You have to guess a number between");
		lower.setText("1");
		and.setText("&");
		upper.setText("100");
		message.setText("Enter your guess");
		
		add(title);
		add(lower);
		add(and);
		add(upper);
		add(message);
		add(answer);
		add(guess);
		add(restart);
		
		guess.addActionListener(new ButtonClick());
		restart.addActionListener(new ButtonClick());
		setLayout(new FlowLayout());
		setSize(355, 350);
		setVisible(true);
		restart.setVisible(false);
		g.begin();
	}
	
	public class ButtonClick implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand() == "Guess")
			{
				int input = Integer.parseInt(answer.getText());
				message.setText(g.checkInput(input));
				lower.setText(Integer.toString(g.lower));
				upper.setText(Integer.toString(g.upper));
				if(message.getText().contains("right"))
				{
					restart.setVisible(true);
				}	
			}
			else if(e.getActionCommand() == "Restart")
			{
				restart();
			}
			answer.setText("");
			
			
		}

	}
	
}

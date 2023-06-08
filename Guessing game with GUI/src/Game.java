import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame
{
	JPanel mainPanel;
	JPanel titlePanel ;
	JPanel playPanel ;
	JPanel messagePanel;
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
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		titlePanel = new JPanel (new FlowLayout());
		playPanel = new JPanel();
		messagePanel = new JPanel();

		title.setText("You have to guess a number between");
		lower.setText("1");
		and.setText("&");
		upper.setText("100");
		message.setText("Enter your guess");
		
		titlePanel.add(title);
		titlePanel.add(lower);
		titlePanel.add(and);
		titlePanel.add(upper);
		
		playPanel.add(answer);
		playPanel.add(guess);
		playPanel.add(restart);
		
		messagePanel.add(message);
		
		titlePanel.setMaximumSize(new Dimension(700, 100));
		messagePanel.setMaximumSize(new Dimension(700, 100));
		
		Font myFont = new Font("Arial", Font.BOLD, 30);
		
		title.setFont(myFont);
		lower.setFont(myFont);
		and.setFont(myFont);
		upper.setFont(myFont);
		message.setFont(myFont);
		answer.setFont(myFont);
		guess.setFont(myFont);
		restart.setFont(myFont);
		
		guess.addActionListener(new ButtonClick());
		restart.addActionListener(new ButtonClick());

		mainPanel.add(Box.createVerticalGlue()); 
		mainPanel.add(titlePanel);
		mainPanel.add(messagePanel);
		mainPanel.add(playPanel);
		mainPanel.add(Box.createVerticalGlue());
	
		getContentPane().add(mainPanel).setBackground(Color.lightGray);
		
		mainPanel.setBackground(Color.PINK);
		titlePanel.setBackground(Color.PINK);
		messagePanel.setBackground(Color.PINK);
		playPanel.setBackground(Color.PINK);
		
		guess.setBackground(Color.BLACK);
		guess.setForeground(Color.PINK);
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

package app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Rockpaperscissor implements ActionListener{
	JFrame frame;
	JButton rockbutton,paperbutton,scissorbutton;
	JLabel computerscorelabel,playerscorelabel;
    JLabel computerchoice;
	int playerscore= 0,computerscore = 0;
	Random random = new Random();
	Font myFont = new Font("Times new Roman",Font.BOLD,25);
	String[] choices = {"Rock", "Paper", "Scissors"};
	
	Rockpaperscissor() {
		frame = new JFrame ("Rock Paper Scissor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 590);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
	 rockbutton = new JButton("Rock");
	 paperbutton = new JButton("Paper");
	 scissorbutton = new JButton("Scissor");
	 
	 computerscorelabel = new JLabel("computer : 0");
	 computerchoice = new JLabel("");
	 playerscorelabel = new JLabel("player : 0");
	 
	 rockbutton.setFont(myFont);
	 paperbutton.setFont(myFont);
	 scissorbutton.setFont(myFont);
	 computerscorelabel.setFont(myFont);
	 playerscorelabel.setFont(myFont);
	 computerchoice.setFont(myFont);
	 
	 rockbutton.addActionListener(this);
	 paperbutton.addActionListener(this);
	 scissorbutton.addActionListener(this);
	 
	 computerscorelabel.setBounds(0, 43,450,30);
	 computerchoice.setBounds(175, 118, 98, 81);
	 playerscorelabel.setBounds(0,317,450,30);
	 rockbutton.setBounds(40, 387, 105,81);
	 paperbutton.setBounds(165, 387, 105, 81);
	 scissorbutton.setBounds(290, 387, 105, 81);
	 
	 computerscorelabel.setHorizontalAlignment(SwingConstants.CENTER);
	 computerchoice.setHorizontalAlignment(SwingConstants.CENTER);
	 playerscorelabel.setHorizontalAlignment(SwingConstants.CENTER);
	 
	 computerchoice.setBorder(BorderFactory.createLineBorder(Color.black));
	 
	 
	 frame.add(playerscorelabel);
	 frame.add(computerscorelabel);
	 frame.add(rockbutton);
	 frame.add(paperbutton);
	 frame.add(scissorbutton);
	 frame.add(computerchoice);
	 
	 frame.setVisible(true);
	}
	 
	public static void main(String[] args) {
		new Rockpaperscissor();
	}
	private void showDialog(String message) {
		final JDialog resultDialog = new JDialog(frame, "Result", true);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel, BorderLayout.CENTER);

        JButton tryAgainButton = new JButton("Try Again?");
        tryAgainButton.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 computerchoice.setText("?");
                 resultDialog.dispose();
             }
         });
         resultDialog.add(tryAgainButton, BorderLayout.SOUTH);

         resultDialog.pack();
         resultDialog.setLocationRelativeTo(frame);
         resultDialog.setVisible(true);
     }
	 public String getComputerChoice() {
	        return choices[random.nextInt(choices.length)];
	    }

	    public String playRockPaperScissors(String playerChoice) {
	        String computerChoice = getComputerChoice();
	        String result;

	        if (computerChoice.equals(playerChoice)) {
	            result = "Draw";
	        } else if (computerChoice.equals("Rock") && playerChoice.equals("Paper")
	                || computerChoice.equals("Paper") && playerChoice.equals("Scissors")
	                || computerChoice.equals("Scissors") && playerChoice.equals("Rock")) {
	            result = "Player Wins";
	            playerscore++;
	        } else {
	            result = "Computer Wins";
	            computerscore++;
	        }

	        computerchoice.setText(computerChoice);
	        return result;
	    }
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String playerChoice = e.getActionCommand();
        String result = playRockPaperScissors(playerChoice);

        computerscorelabel.setText("Computer: " + computerscore);
        playerscorelabel.setText("Player: " + playerscore);

        showDialog(result);
    }
		
	}

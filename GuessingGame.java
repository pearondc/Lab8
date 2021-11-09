import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class GuessingGame implements ActionListener {
  JTextField userGuess;
  JButton guessButton;
  JButton playAgain;
  JLabel jlabGuess, jlabHighLow, jlabLastGuess;
  Random r = new Random();
  int randNum;

  GuessingGame() {
    randNum = r.nextInt(100) + 1;
    
    JFrame frame = new JFrame("GuessingGame");
    frame.setLayout(new FlowLayout());
    frame.setSize(240,120);
    
    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF"); 

    guessButton = new JButton("Guess");
    playAgain = new JButton("Play Again");

    userGuess.addActionListener(this);
    guessButton.addActionListener(this);
    playAgain.addActionListener(this);

    jlabGuess = new JLabel ("Enter your guess:");
    jlabHighLow = new JLabel("");
    jlabLastGuess = new JLabel("");

    frame.add(jlabGuess);
    frame.add(userGuess);
    frame.add(guessButton);
    frame.add(jlabHighLow);
    frame.add(jlabLastGuess);
    frame.add(playAgain);

    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Guess")) {
      int guess = Integer.parseInt(userGuess.getText());
      if(guess < randNum){
        jlabHighLow.setText("Too low!");
        jlabLastGuess.setText("Last guess was: " + guess);
      }
      else if(guess > randNum) {
        jlabHighLow.setText("Too high!");
        jlabLastGuess.setText("Last guess was: " + guess);
      }
      else if(guess == randNum) {
        jlabHighLow.setText("You got it!");
        jlabLastGuess.setText("Last guess was: " + guess);
      }
    }

    else if(ae.getActionCommand().equals("Play Again")) {
      randNum = r.nextInt(100) + 1;
      jlabGuess.setText("Enter your guess:");
      jlabHighLow.setText("");
      jlabLastGuess.setText("");
      userGuess.setText("");
    }

    else {
      jlabHighLow.setText("Your pressed Enter. Please press the Guess Button.");
    }
  }
}
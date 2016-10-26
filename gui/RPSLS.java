/**
 * Created by Wina Gen Sotto on October 24, 2016.
 * IDK SA ALIGNMENT HUHUHUHU
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class RPSLS extends Frame {
   private Panel choices;
   private Label lblYourChoice = new Label("Your Choice:", Label.LEFT);
   private Label lblPlayerScore;
   private Label lblCompScore;
   private TextArea txtResults;
   private Button btnPlay;
   private TextField txtPlayer;
   private TextField txtComp;
   private CheckboxGroup choice = new CheckboxGroup();
   private Checkbox rock = new Checkbox("Rock", choice, true);
   private Checkbox paper = new Checkbox("Paper", choice, true);
   private Checkbox scissors = new Checkbox("Scissors", choice, true);
   private Checkbox lizard = new Checkbox("Lizard", choice, true);
   private Checkbox spock = new Checkbox("Spock", choice, true);
   private static Dialog winner;
   private int playerScore = 0;
   private int compScore = 0;
   private Random rand = new Random();

   public RPSLS() {
      setLayout(new FlowLayout());
      setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
      });

      choices = new Panel();
      choices.setLayout(new FlowLayout(FlowLayout.LEFT));
      choices.setSize(20, 20);
      choices.setLocation(0, 0);

      lblYourChoice.setAlignment(Label.LEFT);

      choices.add(lblYourChoice);
      choices.add(rock);
      choices.add(paper);
      choices.add(scissors);
      choices.add(lizard);
      choices.add(spock);
      add(choices);

      txtResults = new TextArea("Results:\n", 10, 30);
      txtResults.setEditable(false);
      txtResults.setLocation(0, 50);
      add(txtResults);

      lblPlayerScore = new Label("Player's Score");
      lblPlayerScore.setAlignment(Label.LEFT);
      lblCompScore = new Label("Computer's Score");
      lblCompScore.setAlignment(Label.LEFT);
      btnPlay = new Button("RockPaperScissorsLizardSpock!");
      btnPlay.addActionListener(new MyActionListener());
      txtPlayer = new TextField("", 30);
      txtComp = new TextField("", 30);
      txtPlayer.setEditable(false);
      txtComp.setEditable(false);

      add(btnPlay);
      add(lblPlayerScore);
      add(txtPlayer);
      add(lblCompScore);
      add(txtComp);

      setTitle("RockPaperScissorsLizardSpock!");
      setSize(400, 500);
      setVisible(true);
   }

   class MyActionListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         int randComp = randInt(1, 5);
         Checkbox playerChoice = choice.getSelectedCheckbox();
         Checkbox compChoice;
         boolean playerWin = false;
         boolean draw = false;

         switch (randComp) { // computer's random choices
            case 1: {
               compChoice = rock;
               if (playerChoice.getLabel() == "Lizard" || playerChoice.getLabel() == "Scissors") { // daog
                  compScore++;
               } else if (playerChoice.getLabel() == "Spock" || playerChoice.getLabel() == "Paper") { // pildi
                  playerScore++;
                  playerWin = true;
               } else {
                  draw = true;
               }
               break;
            }
            case 2: {
               compChoice = paper;
               if (playerChoice.getLabel() == "Rock" || playerChoice.getLabel() == "Spock") {
                  compScore++;
               } else if (playerChoice.getLabel() == "Lizard" || playerChoice.getLabel() == "Scissors") {
                  playerScore++;
                  playerWin = true;
               } else {
                  draw = true;
               }
               break;
            }
            case 3: {
               compChoice = scissors;
               if (playerChoice.getLabel() == "Lizard" || playerChoice.getLabel() == "Paper") {
                  compScore++;
               } else if (playerChoice.getLabel() == "Spock" || playerChoice.getLabel() == "Rock") {
                  playerScore++;
                  playerWin = true;
               } else {
                  draw = true;
               }
               break;
            }
            case 4: {
               compChoice = lizard;
               if (playerChoice.getLabel() == "Spock" || playerChoice.getLabel() == "Paper") {
                  compScore++;
               } else if (playerChoice.getLabel() == "Rock" || playerChoice.getLabel() == "Scissors") {
                  playerScore++;
                  playerWin = true;
               } else {
                  draw = true;
               }
               break;
            }
            default: {
               compChoice = spock;
               if (playerChoice.getLabel() == "Rock" || playerChoice.getLabel() == "Scissors") {
                  compScore++;
               } else if (playerChoice.getLabel() == "Lizard" || playerChoice.getLabel() == "Paper") {
                  playerScore++;
                  playerWin = true;
               } else {
                  draw = true;
               }
            }
         }

         txtPlayer.setText("" + playerScore);
         txtComp.setText("" + compScore);
         txtResults.append("Player chose " + playerChoice.getLabel() + "\nComputer chose " + compChoice.getLabel());

         if (draw) {
            txtResults.append("\n\nIT'S A DRAW!\n\n\n");
         } else if (playerWin) {
            txtResults.append("\n\nYOU WON THIS ROUND!\n\n\n");
         } else {
            txtResults.append("\n\nCOMPUTER WON THIS ROUND!\n\n\n");
         }

         if (playerScore == 5 || compScore == 5) {
            String win;

            if (playerScore == 5) {
               win = "You won.";
            } else {
               win = "Computer won.";
            }

            Frame extra = new Frame();
            winner = new Dialog(extra, "Game Over!");
            winner.setLayout(new FlowLayout());
            winner.setSize(20, 30);
            winner.add(new Label(win, Label.CENTER));

            Button btnReplay = new Button("OK");
            btnReplay.addActionListener (new MyActionListener() {
               public void actionPerformed( ActionEvent e ) {
                  winner.setVisible(false);
                  setVisible(false);
                  new RPSLS();
               }
            });

            winner.add("South", btnReplay);
            winner.addWindowListener(new WindowAdapter() {
               public void windowClosing(WindowEvent windowEvent){
                  RPSLS.winner.setVisible(false);
               }
            });

            winner.pack();
            winner.setVisible(true);
         }
      }
   }

   public int randInt(int min, int max) {
      return rand.nextInt((max - min) + 1) + min;
   }

   public static void main(String[] args) {
      new RPSLS();
   }
}

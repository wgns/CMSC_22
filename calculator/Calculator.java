import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;

/**
 * Last modified by Wina Gen Sotto on November 2 2016.
 * AHHHHHH idk ;_;
 */

public class Calculator extends JPanel {
   private JTextArea txtDisplay = new JTextArea(2, 10);
   private JButton btnEquals = new JButton("=");
   private JButton btnAdd = new JButton("+");
   private JButton btnSubtract = new JButton("-");
   private JButton btnMultiply = new JButton("*");
   private JButton btnDivide = new JButton("/");
   private JButton btnClear = new JButton("C");
   private JButton btnZero = new JButton("0");
   private JButton btnOne = new JButton("1");
   private JButton btnTwo = new JButton("2");
   private JButton btnThree = new JButton("3");
   private JButton btnFour = new JButton("4");
   private JButton btnFive = new JButton("5");
   private JButton btnSix = new JButton("6");
   private JButton btnSeven = new JButton("7");
   private JButton btnEight = new JButton("8");
   private JButton btnNine = new JButton("9");
   private JButton btnPosiNega = new JButton();
   private JButton btnPercent = new JButton();
   private JButton btnPoint = new JButton(".");
   private boolean wasEquals = false;
   boolean prevIsNum = false;
   boolean error = false;
   private BigDecimal ans = new BigDecimal(0);
   private BigDecimal term = new BigDecimal(0);
   private char operation;
   private String tempTerm = new String();

   public Calculator() {
      JPanel buttons = new JPanel(new GridLayout(5, 4, 2, 2));
      JButton btnBlank = new JButton();

      buttons.setPreferredSize(new Dimension(282, 350));
      buttons.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

      btnClear.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnClear.addActionListener(new MyActionListener());
      buttons.add(btnClear);
      buttons.add(btnPosiNega);
      buttons.add(btnPercent);
      btnDivide.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnDivide.addActionListener(new MyActionListener());
      buttons.add(btnDivide);
      btnSeven.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnSeven.addActionListener(new MyActionListener());
      buttons.add(btnSeven);
      btnEight.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnEight.addActionListener(new MyActionListener());
      buttons.add(btnEight);
      btnNine.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnNine.addActionListener(new MyActionListener());
      buttons.add(btnNine);
      btnMultiply.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnMultiply.addActionListener(new MyActionListener());
      buttons.add(btnMultiply);
      btnFour.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnFour.addActionListener(new MyActionListener());
      buttons.add(btnFour);
      btnFive.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnFive.addActionListener(new MyActionListener());
      buttons.add(btnFive);
      btnSix.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnSix.addActionListener(new MyActionListener());
      buttons.add(btnSix);
      btnSubtract.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnSubtract.addActionListener(new MyActionListener());
      buttons.add(btnSubtract);
      btnOne.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnOne.addActionListener(new MyActionListener());
      buttons.add(btnOne);
      btnTwo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnTwo.addActionListener(new MyActionListener());
      buttons.add(btnTwo);
      btnThree.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnThree.addActionListener(new MyActionListener());
      buttons.add(btnThree);
      btnAdd.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnAdd.addActionListener(new MyActionListener());
      buttons.add(btnAdd);
      buttons.add(btnBlank);
      btnZero.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnZero.addActionListener(new MyActionListener());
      buttons.add(btnZero);
      btnPoint.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnPoint.addActionListener(new MyActionListener());
      buttons.add(btnPoint);
      btnEquals.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      btnEquals.addActionListener(new MyActionListener());
      buttons.add(btnEquals);

      txtDisplay.setEditable(false);
      txtDisplay.setFont(new Font("Century Gothic", Font.PLAIN, 30));

      setLayout(new FlowLayout());
      add(txtDisplay);
      add(buttons);
   }

   class MyActionListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         String btnText = ((JButton) e.getSource()).getText();

         if (wasEquals) {
            txtDisplay.setText(null);
            wasEquals = false;
            prevIsNum = false;
            error = false;
            ans = new BigDecimal(0);
            term = new BigDecimal(0);
         }

         switch (btnText) {
            case "+": {
               txtDisplay.append(btnText);
               operation = btnText.charAt(0);
               if (!prevIsNum) {
                  error = true;
               } else {
                  prevIsNum = false;
                  term = new BigDecimal(tempTerm);
               }
               break;
            } case "-": {
               txtDisplay.append(btnText);
               operation = btnText.charAt(0);
               if (!prevIsNum) {
                  error = true;
               } else {
                  prevIsNum = false;
                  term = new BigDecimal(tempTerm);
               }
               break;
            } case "/": {
               txtDisplay.append(btnText);
               operation = btnText.charAt(0);
               if (!prevIsNum) {
                  error = true;
               } else {
                  prevIsNum = false;
                  term = new BigDecimal(tempTerm);
               }
               break;
            } case "*": {
               txtDisplay.append(btnText);
               operation = btnText.charAt(0);
               if (!prevIsNum) {
                  error = true;
               } else {
                  prevIsNum = false;
                  term = new BigDecimal(tempTerm);
               }
               break;
            } case "=": {
               if (error) {
                  txtDisplay.append(" = ERROR");
               } else {
                  switch (operation) {
                     case '+': {
                        ans = term.add(new BigDecimal(tempTerm));
                        break;
                     } case '-': {
                        ans = term.subtract(new BigDecimal(tempTerm));
                        break;
                     } case '*': {
                        ans = term.multiply(new BigDecimal(tempTerm));
                        break;
                     } case '/': {
                        ans = term.divide(new BigDecimal(tempTerm));
                        break;
                     } default: {
                        ans = term;
                     }
                  }

                  txtDisplay.append(" = " + ans);
               }
               wasEquals = true;
               break;
            } case "C": {
               txtDisplay.setText(null);
               wasEquals = true;
               break;
            } default: { // numbers & decimal point
               txtDisplay.append(btnText);
               tempTerm += btnText;
               prevIsNum = true;
            }
         }
      }
   }

   public static void main(String[] args) throws InterruptedException {
      JFrame frame = new JFrame("Calculator");
      frame.add(new Calculator());
      frame.setSize(315, 480);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}

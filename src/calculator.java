


// Java program to create a simple calculator
// with basic +, -, /, * using java swing elements


//imports to improve functionality, added Math, BigDecimal, RoundingMode during last update
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;

class calculator extends JFrame implements ActionListener {
    // Create the frame
    static JFrame frame;

    // Create a textfield
    static JTextField field;

    // Create a storage space for operators
    String string0, string1, string2;

    // The default constructor
    calculator() {
        string0 = string1 = string2 = "";
    }

    // Main
    public static void main(String args[]) {
        // Create a frame
        frame = new JFrame("calculator");

        try {
            // Set the look and feel (UI)
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Create an object of the class
        calculator c = new calculator();

        // Create a textfield
        field = new JTextField(16);

        // Make textfield uneditable
        field.setEditable(false);

        // Creation of number buttons and operators
        JButton button0, button1, button2, button3, button4, button5, button6, button7,
                button8, button9, buttonAdd, buttonSubtract, buttonDivide, buttonMultiply,
                buttonDot, buttonClear, buttonEquals, buttonSquare, buttonSquareRoot;

        // Number buttons
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        // Equals button
        buttonEquals = new JButton("=");

        // Operator Buttons
        buttonAdd = new JButton("+");
        buttonSubtract = new JButton("-");
        buttonDivide = new JButton("/");
        buttonMultiply = new JButton("*");
        buttonClear = new JButton("C");
        buttonSquare = new JButton("Sq");
        buttonSquareRoot = new JButton("SqRt");

        // Dot button
        buttonDot = new JButton(".");

        // Panel
        JPanel p = new JPanel();

        // Action listeners
        buttonMultiply.addActionListener(c);
        buttonDivide.addActionListener(c);
        buttonSubtract.addActionListener(c);
        buttonAdd.addActionListener(c);
        button9.addActionListener(c);
        button8.addActionListener(c);
        button7.addActionListener(c);
        button6.addActionListener(c);
        button5.addActionListener(c);
        button4.addActionListener(c);
        button3.addActionListener(c);
        button2.addActionListener(c);
        button1.addActionListener(c);
        button0.addActionListener(c);
        buttonDot.addActionListener(c);
        buttonClear.addActionListener(c);
        buttonEquals.addActionListener(c);
        buttonSquare.addActionListener(c);
        buttonSquareRoot.addActionListener(c);

        // Add the elements to the panel
        p.add(field);
        p.add(buttonAdd);
        p.add(button1);
        p.add(button2);
        p.add(button3);
        p.add(buttonSubtract);
        p.add(button4);
        p.add(button5);
        p.add(button6);
        p.add(buttonMultiply);
        p.add(button7);
        p.add(button8);
        p.add(button9);
        p.add(buttonDivide);
        p.add(buttonDot);
        p.add(button0);
        p.add(buttonClear);
        p.add(buttonEquals);
        p.add(buttonSquare);
        p.add(buttonSquareRoot);

        // Set the background color of the panel (I chose red)
        p.setBackground(Color.black);

        // Add the panel to the frame
        frame.add(p);

        frame.setSize(325, 2);
        frame.show();
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        // Check if the value is a number
        if ((action.charAt(0) >= '0' && action.charAt(0) <= '9') || action.charAt(0) == '.') {
            // If operand present and to second number
            if (!string1.equals(""))
                string2 = string2 + action;
            else
                string0 = string0 + action;

            // Set text value
            field.setText(string0 + string1 + string2);
        } else if (action.charAt(0) == 'C') {

            string0 = string1 = string2 = "";

            // Set text value
            field.setText(string0 + string1 + string2);
        } else if (action.charAt(0) == '=') {


            double answer;

            // Store text value in first
            if (string1.equals("+"))
                answer = (Double.parseDouble(string0) + Double.parseDouble(string2));
            else if (string1.equals("-"))
                answer = (Double.parseDouble(string0) - Double.parseDouble(string2));
            else if (string1.equals("Sq"))
                answer = (Double.parseDouble(string0) * Double.parseDouble(string0));
            else if (string1.equals("SqRt"))
                answer = Math.sqrt(Double.parseDouble(string0));
            else if (string1.equals("/"))
                answer = (Double.parseDouble(string0) / Double.parseDouble(string2));
            else
                answer = (Double.parseDouble(string0) * Double.parseDouble(string2));


            //round to two decimal places to improve output
            answer = round(answer, 2);

            // set the value of text
            field.setText(string0 + string1 + string2 + "=" + answer);

            // convert value to string
            string0 = Double.toString(answer);

            string1 = string2 = "";
        } else {
            // Check to see if there was no operand
            if (string1.equals("") || string2.equals(""))
                string1 = action;
                // If there was, then evaluate
            else {


                double answer;

                // Store the value
                if (string1.equals("+"))
                    answer = (Double.parseDouble(string0) + Double.parseDouble(string2));
                else if (string1.equals("-"))
                    answer = (Double.parseDouble(string0) - Double.parseDouble(string2));
                else if (string1.equals("Sq"))
                    answer = (Double.parseDouble(string0) * Double.parseDouble(string0));
                else if (string1.equals("SqRt"))
                    answer = Math.sqrt(Double.parseDouble(string0));
                else if (string1.equals("/"))
                    answer = (Double.parseDouble(string0) / Double.parseDouble(string2));
                else
                    answer = (Double.parseDouble(string0) * Double.parseDouble(string2));


               //round to two decimal places for more concise output
                answer = round(answer,2);

                // Convert to string
                string0 = Double.toString(answer);

                // Place the operator
                string1 = action;

                // Make the operand blank
                string2 = "";
            }

            // Set the text value
            field.setText(string0 + string1 + string2);
        }
    }

//Method to utilize big decimal for rounding to two decimal places
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}





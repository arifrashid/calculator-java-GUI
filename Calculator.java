/*
 * CSCI 185 Spring 2021
 * Group Members: Jonathan Bachan, Tanvi Patel, Arif Rashid
 * Date: May 13 2021
 * CSCI 185 Homework 3: Create Your Own Java GUI Program
 */

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DecimalFormat;

public class Calculator extends JFrame implements ActionListener {

    JTextArea textArea;
    JTextField textField;
    JLabel label;
    JPanel Buttons;
    JButton[] NumsButtons = new JButton[10];    //Number Buttons
    JButton[] func_Buttons = new JButton[10];   //Function Buttons

    //instance variables
    String str;
    String operator;
    double a = 0;
    double b = 0;
    double c = 0;

    DecimalFormat df = new DecimalFormat("#.########");

    public Calculator()
    {
        setLayout(null);
        setTitle("Calculator");
        setResizable(false);
        setSize(350,530);
        getContentPane().setBackground(new Color(255,255,255));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //text area 
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN,38));
        textArea.setBackground(new Color(255,255,255));
        textArea.setBounds(7,100,320,60);
        textArea.setForeground(new Color(52,52,52));
        textArea.setEditable(true);
        textArea.setBorder(new LineBorder(new Color(255,255,255)));

        //text field
        textField = new JTextField();
        textField.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,20));
        textField.setBackground(new Color(255,255,255));
        textField.setBounds(7,60,320,30);
        textField.setForeground(new Color(52,52,52));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setBorder(new LineBorder(new Color(255,255,255)));

        // label for previous calculation
        label = new JLabel();
        label.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,20));
        label.setBackground(new Color(255,255,255));
        label.setBounds(7,30,320,30);
        label.setForeground(new Color(52,52,52));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setBorder(new LineBorder(new Color(255,255,255)));
        label.setText("Previous Calculation");

        //function buttons declaration

        func_Buttons[0] = new JButton("C");       //clear
        func_Buttons[1] = new JButton("Del");     //backspace
        func_Buttons[2] = new JButton("(-)");     //negative
        func_Buttons[3] = new JButton("/");       //divide
        func_Buttons[4] = new JButton("x");       //multiply
        func_Buttons[5] = new JButton("-");       //minus
        func_Buttons[6] = new JButton("+");       //plus
        func_Buttons[7] = new JButton("=");       //equals
        func_Buttons[8] = new JButton(".");       //decimal
        func_Buttons[9] = new JButton("%");       //modulus

        //num buttons
        for(int i = 0; i< 10 ; i++)
        {
            NumsButtons[i] = new JButton(String.valueOf(i));
            NumsButtons[i].setFont(new Font("Arial Rounded MT Bold", Font.PLAIN,18));
            NumsButtons[i].setFocusPainted(false);
            NumsButtons[i].setBackground(new Color(37,34,36));
            NumsButtons[i].setForeground(new Color(233,236,239));
            NumsButtons[i].setFocusPainted(false);
            NumsButtons[i].addActionListener(this);
            NumsButtons[i].setBorder(new LineBorder(new Color(27,36,34)));
        }

        //function buttons intialization        
        for(int i = 0; i< 10 ; i++)
        {
            func_Buttons[i].setFont(new Font("Arial Rounded MT Bold", Font.PLAIN,18));
            func_Buttons[i].setFocusPainted(false);
            func_Buttons[i].setBackground(new Color(37,36,34));
            func_Buttons[i].setForeground(new Color(233,236,239));
            func_Buttons[i].setFocusPainted(false);
            func_Buttons[i].addActionListener(this);
            func_Buttons[i].setBorder(new LineBorder(new Color(37,36,34)));
        }

        func_Buttons[3].setBackground(new Color(64,61,57));
        func_Buttons[4].setBackground(new Color(64,61,57));
        func_Buttons[5].setBackground(new Color(64,61,57));
        func_Buttons[6].setBackground(new Color(64,61,57));


        func_Buttons[3].setBorder(new LineBorder(new Color(64,61,57)));
        func_Buttons[4].setBorder(new LineBorder(new Color(64,61,57)));
        func_Buttons[5].setBorder(new LineBorder(new Color(64,61,57)));
        func_Buttons[6].setBorder(new LineBorder(new Color(64,61,57)));


        func_Buttons[7].setBackground(new Color(235,94,40));
        func_Buttons[7].setBorder(new LineBorder(new Color(235,94,40)));

        //panel

        Buttons = new JPanel();
        Buttons.setBackground(new Color(33,37,41));
        Buttons.setBounds(0,180,335,362);
        Buttons.setLayout(new GridLayout(6,4));

        //adding buttons

        Buttons.add(func_Buttons[0]); //Clear Button
        Buttons.add(func_Buttons[1]); //Del Button
        Buttons.add(func_Buttons[2]); // Negative Button
        Buttons.add(func_Buttons[3]); //Divide Button

        Buttons.add(NumsButtons[7]);// Number 7
        Buttons.add(NumsButtons[8]);// Number 8
        Buttons.add(NumsButtons[9]);// Number 9
        Buttons.add(func_Buttons[4]);// Multiply Button

        Buttons.add(NumsButtons[4]);// Number 4
        Buttons.add(NumsButtons[5]);// Number 5
        Buttons.add(NumsButtons[6]);// Number 6
        Buttons.add(func_Buttons[5]);// Subtract Button

        Buttons.add(NumsButtons[1]);     //1
        Buttons.add(NumsButtons[2]);     //2
        Buttons.add(NumsButtons[3]);     //3
        Buttons.add(func_Buttons[6]);    //plus

        Buttons.add(func_Buttons[9]);    //modulus
        Buttons.add(NumsButtons[0]);     //0
        Buttons.add(func_Buttons[8]);    //decimal
        Buttons.add(func_Buttons[7]);    //equals

        //add components 
        add(Buttons);
        add(textArea);
        add(textField);
        add(label);
        setVisible(true);

    }

    
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i = 0; i<10;i++)
        {   //number button
            if(e.getSource() == NumsButtons[i]){
                textArea.setText(textArea.getText().concat(String.valueOf(i)));
            }
        }
        //decimal buttton
        if(e.getSource() == func_Buttons[8]){
            textArea.setText(textArea.getText().concat("."));
        }

        //clear button
        if(e.getSource() == func_Buttons[0]){
            textArea.setText("");
            textField.setText("");
            a = 0;
            b = 0;
            c = 0;
        }

        //delete button
        if(e.getSource() == func_Buttons[1]){
            int del = textArea.getText().length() -1;
            textArea.setText(textArea.getText().substring(0,del));
        }

        //negative button
        if(e.getSource() == func_Buttons[2]){
            double negativeSign = (Double.parseDouble(textArea.getText())) * -1;

            if(negativeSign % 1 ==0)
            {
                int negativeint = (int) Double.parseDouble(String.valueOf(negativeSign));
                textArea.setText("" + negativeint);
            }
            else
            {
                textArea.setText("" + negativeSign);
            }
        }

        //DIVIDE
        if(e.getSource() == func_Buttons[3]){
            a = Double.parseDouble(textArea.getText());
            textField.setText(textArea.getText().concat("/"));

            operator = "divide";
            textArea.setText("");
        }

        //MULTIPLY
        if(e.getSource() == func_Buttons[4])
        {
            a = Double.parseDouble(textArea.getText());
            textField.setText(textArea.getText().concat("*"));

            operator = "multiply";
            textArea.setText("");
        }

        //SUBTRACTION
        if(e.getSource() == func_Buttons[5])
        {
            a = Double.parseDouble(textArea.getText());
            textField.setText(textArea.getText().concat("-"));

            operator="subtract";
            textArea.setText("");
        }

        //ADDITION

        if(e.getSource() == func_Buttons[6])
        {
            a = Double.parseDouble(textArea.getText());
            textField.setText(textArea.getText().concat("+"));

            operator="addition";
            textArea.setText("");
        }

        //modulus button
        if(e.getSource() == func_Buttons[9])
        {
            a = Double.parseDouble(textArea.getText());
            textField.setText(textArea.getText().concat("%"));

            operator="modulus";
            textArea.setText("");
        }
        //equals button
        if(e.getSource() == func_Buttons[7])
        {
            b = Double.parseDouble(textArea.getText());
            if(b%2 == 0)
            {
                textField.setText(textField.getText().concat(String.valueOf((int)b)));
            }
            else
            {
                textField.setText(textField.getText().concat(String.valueOf(b)));
            }
            switch(operator) {
                case "addition":
                    c = a + b;
                    break;

                case "subtract":
                    c = a - b;
                    break;

                case "multiply":
                    c = b * a;
                    break;

                case "divide":
                    if (b == 0) {
                        textArea.setText("Error");
                        c = a / b;
                    } else {
                        c = a / b;
                    }
                    break;

                case "modulus":
                    c = a % b;
                    break;
            }
            //detecting decimal numbers
            if(c%1 == 0)
            {
                int d = (int) Double.parseDouble(String.valueOf(c));
                textArea.setText("" +d);
                a = d;
            }
            else
            {
                textArea.setText(df.format(c));
                a = c;
            }
        }

    }
}


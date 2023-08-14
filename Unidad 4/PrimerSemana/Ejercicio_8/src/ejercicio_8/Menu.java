package ejercicio_8;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu  extends JFrame implements ActionListener{
    
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;
    private JPanel panel;

    private String num1, num2, operator;
    
    public Menu() {
        setTitle("Ejercicio 8");
        setSize(300, 400);
        setLayout(null);

        textField = new JTextField();
        textField.setBounds(30, 30, 240, 30);
        add(textField);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        operatorButtons = new JButton[]{addButton, subButton, mulButton, divButton, eqButton, clrButton};

        for (int i = 0; i < 6; i++) {
            operatorButtons[i].addActionListener(this);
            operatorButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
        }

        panel = new JPanel();
        panel.setBounds(30, 80, 240, 250);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[9]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[7]);
        panel.add(addButton);

        panel.add(numberButtons[6]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[4]);
        panel.add(subButton);

        panel.add(numberButtons[3]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[1]);
        panel.add(mulButton);

        panel.add(clrButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            textField.setText(textField.getText() + command);
        } else if (command.charAt(0) == 'C') {
            textField.setText("");
        } else if (command.charAt(0) == '=') {
            num2 = textField.getText();
            double result = calculate(Double.parseDouble(num1), Double.parseDouble(num2), operator);
            textField.setText(String.valueOf(result));
        } else {
            num1 = textField.getText();
            operator = command;
            textField.setText("");
        }
    }

    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    return Double.NaN; // Handle division by zero
                }
                return num1 / num2;
            default:
                return 0;
        }
    }
}


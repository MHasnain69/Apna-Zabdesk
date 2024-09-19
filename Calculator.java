import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Roboto", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;



    Calculator() {

        frame = new JFrame("Stylish Calculator");
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420, 600);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.black);

        
        frame.setLocationRelativeTo(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 70);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setBackground(Color.black);
        textfield.setForeground(Color.WHITE);
        textfield.setHorizontalAlignment(SwingConstants.RIGHT);
        textfield.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        
        for (JButton button : functionButtons) {
            button.addActionListener(this);
            button.setFont(myFont);
            button.setFocusable(false);
            button.setBackground(Color.decode("#E74C3C"));
            button.setForeground(Color.WHITE);
            button.setBorder(BorderFactory.createLineBorder(Color.decode("#C0392B"), 2));
        }

        
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.decode("#34495E"));
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.decode("#2C3E50"), 2));
        }

        


        negButton.setBounds(50, 500, 100, 50);
        delButton.setBounds(150, 500, 100, 50);
        clrButton.setBounds(250, 500, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 400);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(Color.BLACK);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(addButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);

        addKeyboardShortcuts();
    }

    private void addKeyboardShortcuts() {
        frame.setFocusable(true);
        frame.requestFocusInWindow();

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                switch (key) {
                    case KeyEvent.VK_0:
                    case KeyEvent.VK_NUMPAD0:
                        numberButtons[0].doClick();
                        break;
                    case KeyEvent.VK_1:
                    case KeyEvent.VK_NUMPAD1:
                        numberButtons[1].doClick();
                        break;
                    case KeyEvent.VK_2:
                    case KeyEvent.VK_NUMPAD2:
                        numberButtons[2].doClick();
                        break;
                    case KeyEvent.VK_3:
                    case KeyEvent.VK_NUMPAD3:
                        numberButtons[3].doClick();
                        break;
                    case KeyEvent.VK_4:
                    case KeyEvent.VK_NUMPAD4:
                        numberButtons[4].doClick();
                        break;
                    case KeyEvent.VK_5:
                    case KeyEvent.VK_NUMPAD5:
                        numberButtons[5].doClick();
                        break;
                    case KeyEvent.VK_6:
                    case KeyEvent.VK_NUMPAD6:
                        numberButtons[6].doClick();
                        break;
                    case KeyEvent.VK_7:
                    case KeyEvent.VK_NUMPAD7:
                        numberButtons[7].doClick();
                        break;
                    case KeyEvent.VK_8:
                    case KeyEvent.VK_NUMPAD8:
                        numberButtons[8].doClick();
                        break;
                    case KeyEvent.VK_9:
                    case KeyEvent.VK_NUMPAD9:
                        numberButtons[9].doClick();
                        break;
                    case KeyEvent.VK_ADD:
                    case KeyEvent.VK_PLUS:
                        addButton.doClick();
                        break;
                    case KeyEvent.VK_SUBTRACT:
                    case KeyEvent.VK_MINUS:
                        subButton.doClick();
                        break;
                    case KeyEvent.VK_MULTIPLY:
                        mulButton.doClick();
                        break;
                    case KeyEvent.VK_DIVIDE:
                    case KeyEvent.VK_SLASH:
                        divButton.doClick();
                        break;
                    case KeyEvent.VK_DECIMAL:
                    case KeyEvent.VK_PERIOD:
                    case KeyEvent.VK_COMMA:
                        decButton.doClick();
                        break;
                    case KeyEvent.VK_ENTER:
                    case KeyEvent.VK_EQUALS:
                        equButton.doClick();
                        break;
                    case KeyEvent.VK_BACK_SPACE:
                        delButton.doClick();
                        break;
                    case KeyEvent.VK_C:
                        clrButton.doClick();
                        break;
                    case KeyEvent.VK_N:
                        negButton.doClick();
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText() + i);
            }
        }

        if (e.getSource() == decButton) {
            if (!textfield.getText().contains(".")) {
                textfield.setText(textfield.getText() + ".");
            }
        }

        if (e.getSource() == addButton) {
            handleOperation('+');
        }

        if (e.getSource() == subButton) {
            handleOperation('-');
        }

        if (e.getSource() == mulButton) {
            handleOperation('*');
        }

        if (e.getSource() == divButton) {
            handleOperation('/');
        }

        if (e.getSource() == equButton) {
            try {
                num2 = Double.parseDouble(textfield.getText());

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            textfield.setText("Error");
                            return;
                        }
                        result = num1 / num2;
                        break;
                }
                textfield.setText(String.valueOf(result));
                num1 = result;
            } catch (Exception ex) {
                textfield.setText("Error");
            }
        }

        if (e.getSource() == clrButton) {
            textfield.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
            operator = '\0';
        }

        if (e.getSource() == delButton) {
            String currentText = textfield.getText();
            if (currentText.length() > 0) {
                textfield.setText(currentText.substring(0, currentText.length() - 1));
            }
        }

        if (e.getSource() == negButton) {
            try {
                double temp = Double.parseDouble(textfield.getText());
                temp *= -1;
                textfield.setText(String.valueOf(temp));
            } catch (Exception ex) {
                
            }
        }
    }

    private void handleOperation(char operation) {
        num1 = Double.parseDouble(textfield.getText());
        operator = operation;
        textfield.setText("");
    }
}

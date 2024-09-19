import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class TicTacToeVisual implements ActionListener {
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn;
    String player1Name;
    String player2Name;

    TicTacToeVisual() {
        player1Name = JOptionPane.showInputDialog("Enter Player 1's name (X):");
        player2Name = JOptionPane.showInputDialog("Enter Player 2's name (O):");

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(30, 30, 30));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(50, 50, 50));
        textfield.setForeground(new Color(0, 255, 127));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        textfield.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(0, 255, 127)));

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);
        titlePanel.add(textfield, BorderLayout.CENTER);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(50, 50, 50));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].setBackground(new Color(30, 30, 30));
            buttons[i].setForeground(new Color(255, 255, 255));
            buttons[i].setBorder(BorderFactory.createLineBorder(new Color(0, 255, 127), 4));
            buttons[i].addActionListener(this);
            buttons[i].setOpaque(true);
        }

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1Turn) {
                    if (buttons[i].getText().isEmpty()) {
                        buttons[i].setForeground(new Color(255, 69, 0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        textfield.setText(player2Name + "'s turn (O)");
                        check();
                    }
                } else {
                    if (buttons[i].getText().isEmpty()) {
                        buttons[i].setForeground(new Color(30, 144, 255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        textfield.setText(player1Name + "'s turn (X)");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (new Random().nextInt(2) == 0) {
            player1Turn = true;
            textfield.setText(player1Name + "'s turn (X)");
        } else {
            player1Turn = false;
            textfield.setText(player2Name + "'s turn (O)");
        }
    }

    public void check() {
        if (checkCombo(0, 1, 2, "X"))
        return;
        if (checkCombo(3, 4, 5, "X")) return;
        if (checkCombo(6, 7, 8, "X")) return;
        if (checkCombo(0, 3, 6, "X")) return;
        
        if (checkCombo(1, 4, 7, "X")) return;
        if (checkCombo(2, 5, 8, "X")) return;
        if (checkCombo(0, 4, 8, "X")) return;
        if (checkCombo(2, 4, 6, "X")) return;
        if (checkCombo(0, 1, 2, "O")) return;
        if (checkCombo(3, 4, 5, "O")) return;
        if (checkCombo(6, 7, 8, "O")) return;
        if (checkCombo(0, 3, 6, "O")) return;
        if (checkCombo(1, 4, 7, "O")) return;
        if (checkCombo(2, 5, 8, "O")) return;
        if (checkCombo(0, 4, 8, "O")) return;
        if (checkCombo(2, 4, 6, "O")) return;

        boolean draw = true;
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                draw = false;
                break;
            }
        }
        if (draw) {
            displayMessage("It's a draw!");
        }
    }

    public boolean checkCombo(int a, int b, int c, String symbol) {
        if (buttons[a].getText().equals(symbol) && buttons[b].getText().equals(symbol) && buttons[c].getText().equals(symbol)) {
            win(a, b, c, symbol);
            return true;
        }
        return false;
    }

    public void win(int a, int b, int c, String symbol) {
        buttons[a].setBackground(new Color(50, 205, 50));
        buttons[b].setBackground(new Color(50, 205, 50));
        buttons[c].setBackground(new Color(50, 205, 50));

        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        String winnerMessage = symbol.equals("X") ? player1Name + " (X) wins!" : player2Name + " (O) wins!";
        displayMessage(winnerMessage);
    }

    public void displayMessage(String message) {
        frame.getContentPane().removeAll();
        frame.repaint();

        JPanel congratsPanel = new JPanel();
        congratsPanel.setBackground(Color.BLACK);
        congratsPanel.setLayout(new GridBagLayout());

        JLabel congratsLabel = new JLabel(message);
        congratsLabel.setFont(new Font("Ink Free", Font.BOLD, 60));
        congratsLabel.setForeground(new Color(255, 215, 0));
        JButton replayButton = new JButton("Exit Game");
        replayButton.setFont(new Font("Ink Free", Font.BOLD, 40));
        replayButton.setBackground(new Color(0, 255, 127));
        replayButton.setForeground(Color.WHITE);
        replayButton.addActionListener(e -> restartGame());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 20, 0);
        congratsPanel.add(congratsLabel, gbc);

        gbc.gridy++;
        congratsPanel.add(replayButton, gbc);
        frame.add(congratsPanel, BorderLayout.CENTER);
        frame.revalidate();
    }

    public void restartGame() {
        frame.setVisible(false); 
    }
}

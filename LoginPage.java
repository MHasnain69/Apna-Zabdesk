/*
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class MyFrame2 implements ActionListener {
    String regNo;
    JButton buttonLogin = new JButton("Login");
    JTextField UserBox = new JTextField();
    JPasswordField PassBox = new JPasswordField();
    JButton buttonForPass = new JButton("Forgot Password");
    JProgressBar jProgressBar = new JProgressBar();
    JComboBox<String> jComboBox;
    boolean userTyped = false;
    boolean passTyped = false;
    int temp = 0;



    public MyFrame2() {
        JFrame jFrame = new JFrame("Apna ZABDESK");
        jFrame.setSize(500, 550);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);

        // Load and resize image
        ImageIcon imageIcon = new ImageIcon("Logo.png");
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        ImageIcon readyIcon = new ImageIcon(resizedImage);

        // Add logo
        JLabel jlabel = new JLabel(readyIcon);
        jlabel.setBounds(140, 4, 200, 80);
        jFrame.add(jlabel);
        jFrame.setIconImage(readyIcon.getImage());

        // Add title label
        JLabel label = new JLabel("Login Page", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        label.setBackground(new Color(12, 84, 163));
        label.setOpaque(true);
        label.setBounds(0, 90, 500, 50);
        jFrame.add(label);

        // User ID panel
        JPanel jPanelWhite = new JPanel();
        jPanelWhite.setBackground(Color.GRAY);
        jPanelWhite.setBounds(90, 180, 300, 40);
        JLabel jlabelUserID = new JLabel("User ID");
        jlabelUserID.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jlabelUserID.setForeground(Color.WHITE);
        jPanelWhite.add(jlabelUserID);
        jFrame.add(jPanelWhite);

        // User ID input
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        UserBox.setBounds(90, 230, 300, 40);
        UserBox.setBackground(Color.WHITE);
        UserBox.setBorder(border);
        UserBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jFrame.add(UserBox);

        // Add DocumentListener to UserBox
        UserBox.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateProgressBarForUserBox();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateProgressBarForUserBox();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateProgressBarForUserBox();
            }

            private void updateProgressBarForUserBox() {
                if (!userTyped) {
                    userTyped = true;
                    temp += 25;
                    jProgressBar.setValue(temp);
                    jProgressBar.setString("User ID Started");
                }
            }
        });

        // Password panel
        JPanel jPanelPass = new JPanel();
        jPanelPass.setBackground(Color.GRAY);
        jPanelPass.setBounds(90, 290, 300, 40);
        JLabel jLabelPass = new JLabel("Password");
        jLabelPass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jLabelPass.setForeground(Color.WHITE);
        jPanelPass.add(jLabelPass);
        jFrame.add(jPanelPass);

        // Password input
        PassBox.setBounds(90, 340, 300, 40);
        PassBox.setBackground(Color.WHITE);
        PassBox.setBorder(border);
        PassBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        PassBox.setEchoChar('●');
        jFrame.add(PassBox);

        // Add DocumentListener to PassBox
        PassBox.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateProgressBarForPassBox();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateProgressBarForPassBox();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateProgressBarForPassBox();
            }

            private void updateProgressBarForPassBox() {
                if (!passTyped) {
                    passTyped = true;
                    temp += 25;
                    jProgressBar.setValue(temp);
                    jProgressBar.setString("Password Started");
                }
            }
        });

        // Login button
        buttonLogin.setBounds(90, 440, 120, 30);
        buttonLogin.setBackground(new Color(12, 84, 163));
        buttonLogin.setForeground(Color.WHITE);
        buttonLogin.setFocusable(false);
        buttonLogin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        buttonLogin.addActionListener(this);
        jFrame.add(buttonLogin);

        // Forgot Password button
        buttonForPass.setBounds(220, 440, 170, 30);
        buttonForPass.setBackground(new Color(12, 84, 163));
        buttonForPass.setForeground(Color.WHITE);
        buttonForPass.setFocusable(false);
        buttonForPass.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        buttonForPass.addActionListener(e -> JOptionPane.showMessageDialog(jFrame, "Toh Yaad Kar keh aa "));
        jFrame.add(buttonForPass);

        // Campus label
        JLabel jLabel2 = new JLabel("Campus");
        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 15));
        jLabel2.setForeground(Color.GRAY);
        jLabel2.setBounds(90, 382, 300, 30);
        jFrame.add(jLabel2);

        // Campus combo box
        String[] Campus = {"Dubai", "Karachi", "Larkana", "Islamabad"};
        jComboBox = new JComboBox<>(Campus);
        jComboBox.setBounds(90, 410, 300, 20);
        jComboBox.addActionListener(this);
        jFrame.add(jComboBox);

        // Progress Bar
        jProgressBar.setBounds(0, 493, 500, 20);
        jProgressBar.setValue(0);
        jProgressBar.setStringPainted(true);
        jProgressBar.setFont(new Font("Segoe UI", Font.BOLD, 15));
        jProgressBar.setForeground(new Color(12, 84, 163));
        jProgressBar.setBackground(Color.lightGray);

        jFrame.add(jProgressBar);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogin) {
            System.out.println("Login Successful!");
            System.out.println("User ID: " + UserBox.getText());
            System.out.println("Password: " + new String(PassBox.getPassword()));
            regNo = UserBox.getText();

            if (temp >= 75) {
                jProgressBar.setValue(100);
                jProgressBar.setString("Login Successful");
            }

        } else if (e.getSource() == jComboBox) {
            if (temp < 75) {
                temp += 25;
            }
            jProgressBar.setValue(temp);
            jProgressBar.setString("Campus Selected");
        } else if (e.getSource() == buttonForPass) {
            JOptionPane.showMessageDialog(null, "Toh Yaad Kar Keh Aaa", "Error Message", JOptionPane.INFORMATION_MESSAGE, null);
        }



    }




    public String getRegNo(){
        return regNo;

    }
}
*/

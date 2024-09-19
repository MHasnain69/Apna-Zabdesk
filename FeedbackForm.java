import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import javax.imageio.ImageIO;

class FeedbackForm extends JFrame {
    int likes;
    int disLikes;
    public FeedbackForm(String Name) {
        
        setTitle("Feedback Form");
        setSize(500, 350); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 

        JLabel questionLabel = new JLabel("How would you rate the product you received?");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setBounds(50, 20, 400, 30);

        JButton goodButton = new JButton("Good, I'm satisfied");
        goodButton.setBounds(30, 60, 200, 40); 
        JButton badButton = new JButton("Bad, I'm unsatisfied");
        badButton.setBounds(250, 60, 200, 40); 


        customizeButton(goodButton, Color.WHITE, Color.BLACK);
        customizeButton(badButton, Color.WHITE, Color.BLACK);

           addHoverEffect(goodButton, new Color(19, 136, 8), Color.WHITE); 
        addHoverEffect(badButton, new Color(128,0,0), Color.WHITE); 

        JTextArea commentArea = new JTextArea(5, 30);
        commentArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);
        commentArea.setBounds(40, 140, 400, 90); 

        JLabel commentLabel = new JLabel("Add a comment about the quality of product you received (optional):");
        commentLabel.setBounds(50, 110, 400, 30); 

        
        ImageIcon thankyouIcon = resizeIcon("thankyou.jpg", 100, 100);
        ImageIcon sorryIcon = resizeIcon("sorry.jpg", 100, 100);
        
    
        goodButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thank you for your feedback!", null, JOptionPane.INFORMATION_MESSAGE, thankyouIcon);
                File file = new File("Feedback.txt");
        String filePath = file.getAbsolutePath();
        
         

try {
            Scanner scanner = new Scanner(file);
            for(int i = 0; i < 2;i++){
                String str = scanner.nextLine();
                String[] temp = str.split(" ");
                if (i == 0) {
                    likes = Integer.parseInt(temp[1]);    
                }
                if (i == 1) {
                    disLikes = Integer.parseInt(temp[1]);
                }
                
                
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        likes += 1;

        String allComments = "";
        
                try {
                    Scanner scanner = new Scanner(file);
                    for(int i = 1; scanner.hasNextLine();i++){
                        String str = scanner.nextLine();
                        
                        if (i > 3) {
                            allComments = allComments + "\n" + str;
                        }
                        
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }




        String toWrite = "Likes " + Integer.toString(likes) + "\nDislikes " + Integer.toString(disLikes) + "\n" + allComments;


        try {
            FileWriter fileWriter = new FileWriter("Feedback.txt");
            fileWriter.write(toWrite);
            fileWriter.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    
            }
        });

        badButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thank you for your feedback!", null, JOptionPane.INFORMATION_MESSAGE, sorryIcon);
            
                File file = new File("Feedback.txt");
                String filePath = file.getAbsolutePath();
                
                 
        
        try {
                    Scanner scanner = new Scanner(file);
                    for(int i = 0; i < 2;i++){
                        String str = scanner.nextLine();
                        String[] temp = str.split(" ");
                        if (i == 0) {
                            likes = Integer.parseInt(temp[1]);    
                        }
                        if (i == 1) {
                            disLikes = Integer.parseInt(temp[1]);
                        }
                        
                        
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                disLikes += 1;
        
                                
                String allComments = "";
        
                try {
                    Scanner scanner = new Scanner(file);
                    for(int i = 1; scanner.hasNextLine();i++){
                        String str = scanner.nextLine();
                        
                        if (i > 3) {
                            allComments = allComments + "\n" + str ;
                        }
                        
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                String toWrite = "Likes " + Integer.toString(likes) + "\nDislikes " + Integer.toString(disLikes) + "\n" + allComments ;


                try {
                    FileWriter fileWriter = new FileWriter("Feedback.txt");
                    fileWriter.write(toWrite);
                    fileWriter.close();
                } catch (IOException e1) {
                    
                    e1.printStackTrace();
                }
        
            
            }
        });

        
        JButton submitButton = new JButton("Submit");
        
        submitButton.setBounds(190, 250, 100, 40);
        submitButton.setBackground(Color.gray);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setOpaque(true);
        submitButton.setBorderPainted(false);

        
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                JOptionPane.showMessageDialog(null, "Feedback submitted successfully!", "Submission", JOptionPane.INFORMATION_MESSAGE);
            
                String comments =  commentArea.getText();

                String toAppened =  "\n" + comments + "  By " + Name; 

            
                File file = new File("Feedback.txt");
                String filePath = file.getAbsolutePath();
                
                try {
            Files.write(Paths.get(filePath), toAppened.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException exc) {
            throw new RuntimeException(exc);
            }
                dispose();
            
            }
        });

        
        add(questionLabel);
        add(goodButton);
        add(badButton);
        add(commentLabel); 
        add(commentArea);
        add(submitButton); 

        
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        
        setVisible(true);
    }

    

    private void customizeButton(JButton button, Color bgColor, Color fgColor) {
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

    private void addHoverEffect(JButton button, Color hoverBgColor, Color hoverFgColor) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverBgColor);
                button.setForeground(hoverFgColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
            }
        });
    }

    private ImageIcon resizeIcon(String path, int width, int height) {
        try {
            BufferedImage img = ImageIO.read(getClass().getResource(path));
            Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImg);
        } catch (IOException e) {
            e.printStackTrace();
            return new ImageIcon();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FeedbackForm("Muhammad Hasnain");
            }
        });
    }
}

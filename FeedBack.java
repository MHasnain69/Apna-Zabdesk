// import java.awt.TextField;
// import java.io.File;
// import java.io.FileWriter;

// import javax.swing.JButton;
// import javax.swing.JFrame;









// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// class FeedbackForm extends JFrame {
//     public FeedbackForm() {
//         // Set up the frame
//         setTitle("Feedback Form");
//         setSize(400, 300);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         // Create components
//         JLabel questionLabel = new JLabel("How would you rate the support you received?");
//         JButton goodButton = new JButton("Good, I'm satisfied");
//         JButton badButton = new JButton("Bad, I'm unsatisfied");
//         JTextArea commentArea = new JTextArea(5, 30);
//         commentArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));

//         // Add action listeners for buttons
//         goodButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 JOptionPane.showMessageDialog(null, "Thank you for your feedback!");
//             }
//         });

//         badButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 JOptionPane.showMessageDialog(null, "Thank you for your feedback!");
//             }
//         });

//         // Arrange components in the frame
//         setLayout(new BorderLayout());
//         JPanel topPanel = new JPanel();
//         topPanel.add(questionLabel);

//         JPanel middlePanel = new JPanel();
//         middlePanel.add(goodButton);
//         middlePanel.add(badButton);

//         JPanel bottomPanel = new JPanel();
//         bottomPanel.add(new JLabel("Add a comment about the quality of support you received (optional):"));









//         bottomPanel.add(commentArea);

//         add(topPanel, BorderLayout.NORTH);
//         add(middlePanel, BorderLayout.CENTER);
//         add(bottomPanel, BorderLayout.SOUTH);

//         // Make the frame visible
//         setVisible(true);
//     }








//         add(topPanel, BorderLayout.NORTH);
//         add(middlePanel, BorderLayout.CENTER);
//         add(bottomPanel, BorderLayout.SOUTH);

    
// }







// public class FeedBack {
//     public static void main(String[] args) {
//         File file = new File("Feedback.txt");
//         String filePath = "C:\\Users\\hasna\\OneDrive\\Documents\\Java\\Apna ZABDESK Project\\Feedback.txt";
        
//         SwingUtilities.invokeLater(new Runnable() {
//             public void run() {
//                 new FeedbackForm();
//             }
//         });















//         // try (FileWriter writer = new FileWriter(filePath, true)){
//         //     writer.write("Hi Hasnain");    
//         // } catch (Exception e) {
//         //     // TODO: handle exception
//         // }



























//     }   
    
// }

























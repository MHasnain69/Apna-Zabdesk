import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class AcademicCalender extends JFrame {
    public AcademicCalender() {
        
        setTitle("SZABIST Academic Calendar Fall 2024");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon originalIcon = new ImageIcon("AcademicCalender.jpg");

        if (originalIcon.getIconWidth() == -1 || originalIcon.getIconHeight() == -1) {
        
            System.out.println("Failed to load the image. Using default size.");
            setSize(500, 400);  
        } else {
            
            int scaledWidth = 900;  
            int scaledHeight = 600; 
            Image scaledImage = originalIcon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            
            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5)); 

            
            add(imageLabel, BorderLayout.CENTER);
            setSize(scaledWidth + 10, scaledHeight + 10);
        }
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainCalender.AcademicCalender();
    }
}

class MainCalender {
    public static void AcademicCalender() {
        SwingUtilities.invokeLater(() -> {
            AcademicCalender frame = new AcademicCalender();
            
            
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                         
                }
            });
        });
    }
}
